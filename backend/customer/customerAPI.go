package customer

import (
	"database/sql"
	"encoding/json"
	"io/ioutil"
	"net/http"

	// go <-> mysql
	_ "github.com/go-sql-driver/mysql"
	"github.com/gorilla/mux"
)

// Customer 정보
type Customer struct {
	CustomerID           string  `json:"customer_id"`
	CustomerPWD          string  `json:"customer_password"`
	CustomerName         string  `json:"customer_name"`
	CustomerBirth        string  `json:"customer_birth"`
	CustomerEmail        string  `json:"customer_email"`
	CustomerPenaltyPoint int     `json:"customer_penalty"`
	CustomerLevel        int     `json:"customer_level"`
	CustomerLatitude     float64 `json:"customer_latitude"`
	CustomerLongitude    float64 `json:"customer_longitude"`
	CustomerProfile      []byte  `json:"customer_profile"`
}

// ResponseBody 응답 body 정보
type ResponseBody struct {
	CustomerInfo Customer `json:"customerInfo"`
	IsSuccess    bool     `json:"isSuccess"`
	StatusCode   int      `json:"code"`
	Message      string   `json:"message"`
}

func errorCheck(err error) {
	if err != nil {
		panic(err.Error())
	}
}

func openDB() (db *sql.DB, err error) {
	db, err = sql.Open("mysql", "root:1234@tcp(127.0.0.1:3306)/db")
	return db, err
}

// GetCustomer : GET
func GetCustomer(w http.ResponseWriter, r *http.Request) {
	// HEADER
	w.Header().Set("Content-Type", "application/json")
	params := mux.Vars(r)

	// Open DB
	db, err := openDB()
	errorCheck(err)
	defer db.Close()

	// SELECT Query
	res, err := db.Query(`	SELECT *
							FROM customer
							WHERE customer_id = '` + params["id"] + "';")
	errorCheck(err)
	defer res.Close()

	// 가져온 customer 정보를 변수에 저장
	var customer Customer
	for res.Next() {
		err = res.Scan(&customer.CustomerID,
			&customer.CustomerPWD,
			&customer.CustomerName,
			&customer.CustomerBirth,
			&customer.CustomerEmail,
			&customer.CustomerPenaltyPoint,
			&customer.CustomerLevel,
			&customer.CustomerLatitude,
			&customer.CustomerLongitude,
			&customer.CustomerProfile)
		errorCheck(err)
	}

	// 오류
	var newCustomer ResponseBody
	if customer.CustomerID == "" {
		newCustomer = ResponseBody{
			IsSuccess:  false,
			StatusCode: http.StatusBadRequest,
			Message:    "실패",
		}
	} else {
		newCustomer = ResponseBody{
			CustomerInfo: customer,
			IsSuccess:    true,
			StatusCode:   http.StatusOK,
			Message:      "성공",
		}
	}

	json.NewEncoder(w).Encode(newCustomer)
}

// AddCustomer : POST
func AddCustomer(w http.ResponseWriter, r *http.Request) {
	// HEADER
	w.Header().Set("Content-Type", "application/json")

	// 객체 생성
	var customer Customer
	_ = json.NewDecoder(r.Body).Decode(&customer)

	if customer.CustomerProfile == nil {
		customer.CustomerProfile, _ = ioutil.ReadFile("./default_profile.png")
	}

	// Open DB
	db, err := openDB()
	errorCheck(err)
	defer db.Close()

	// INSERT
	_, err = db.Exec("INSERT INTO customer VALUES(?,?,?,?,?,?,?,?,?,?)",
		customer.CustomerID, customer.CustomerPWD, customer.CustomerName,
		customer.CustomerBirth, customer.CustomerEmail, customer.CustomerPenaltyPoint,
		customer.CustomerLevel, customer.CustomerLatitude, customer.CustomerLongitude,
		customer.CustomerProfile)

	var newCustomer ResponseBody

	//오류
	newCustomer = ResponseBody{
		IsSuccess:  false,
		StatusCode: http.StatusBadRequest,
		Message:    "실패",
	}
	defer func() {
		if r := recover(); r != nil {
			json.NewEncoder(w).Encode(newCustomer)
		}
	}()
	errorCheck(err)

	// BODY RESPONSE
	newCustomer = ResponseBody{
		CustomerInfo: customer,
		IsSuccess:    true,
		StatusCode:   http.StatusOK,
		Message:      "성공",
	}
	json.NewEncoder(w).Encode(newCustomer)

}

// DeleteCustomer : DELETE
func DeleteCustomer(w http.ResponseWriter, r *http.Request) {
	// HEADER
	w.Header().Set("Content-Type", "application/json")
	params := mux.Vars(r)

	// Open DB
	db, err := openDB()
	errorCheck(err)
	defer db.Close()

	// URI의 id를 통해 해당 회원 정보 SELECT
	res, err := db.Query(`	SELECT *
							FROM customer
							WHERE customer_id ='` + params["id"] + "';")
	errorCheck(err)
	defer res.Close()

	delete, err := db.Query(`DELETE FROM customer
								WHERE customer_id='` + params["id"] + "';")
	errorCheck(err)
	defer delete.Close()

	// 해당 고객 정보 customer에 저장
	var customer Customer
	for res.Next() {
		err = res.Scan(&customer.CustomerID,
			&customer.CustomerPWD,
			&customer.CustomerName,
			&customer.CustomerBirth,
			&customer.CustomerEmail,
			&customer.CustomerPenaltyPoint,
			&customer.CustomerLevel,
			&customer.CustomerLatitude,
			&customer.CustomerLongitude,
			&customer.CustomerProfile)
		errorCheck(err)
	}

	// 오류
	var newCustomer ResponseBody
	if customer.CustomerID == "" {
		newCustomer = ResponseBody{
			IsSuccess:  false,
			StatusCode: http.StatusBadRequest,
			Message:    "실패",
		}
	} else {
		newCustomer = ResponseBody{
			CustomerInfo: customer,
			IsSuccess:    true,
			StatusCode:   http.StatusOK,
			Message:      "성공",
		}
	}

	// BODY RESPONSE
	json.NewEncoder(w).Encode(newCustomer)
}

// Login : POST
func Login(w http.ResponseWriter, r *http.Request) {
	// HEADER
	w.Header().Set("Content-Type", "application/json")

	// 객체 생성
	var client Customer
	_ = json.NewDecoder(r.Body).Decode(&client)

	// Open DB
	db, err := openDB()
	errorCheck(err)
	defer db.Close()

	// SELECT Query
	res, err := db.Query(`	SELECT *
							FROM customer
							WHERE customer_id = '` + client.CustomerID + "';")
	errorCheck(err)
	defer res.Close()

	// DB에 있는 회원정보를 customer 변수에 저장
	var customer Customer
	for res.Next() {
		err = res.Scan(&customer.CustomerID,
			&customer.CustomerPWD,
			&customer.CustomerName,
			&customer.CustomerBirth,
			&customer.CustomerEmail,
			&customer.CustomerPenaltyPoint,
			&customer.CustomerLevel,
			&customer.CustomerLatitude,
			&customer.CustomerLongitude,
			&customer.CustomerProfile)
		errorCheck(err)
	}

	var newCustomer ResponseBody
	if customer.CustomerID != client.CustomerID {
		newCustomer = ResponseBody{
			IsSuccess:  false,
			StatusCode: http.StatusBadRequest,
			Message:    "아이디가 존재하지 않습니다",
		}
	} else if customer.CustomerPWD != client.CustomerPWD {
		newCustomer = ResponseBody{
			IsSuccess:  false,
			StatusCode: http.StatusBadRequest,
			Message:    "비밀번호가 일치하지 않습니다",
		}
	} else {
		newCustomer = ResponseBody{
			CustomerInfo: customer,
			IsSuccess:    true,
			StatusCode:   http.StatusOK,
			Message:      "성공",
		}
	}

	json.NewEncoder(w).Encode(newCustomer)
}
