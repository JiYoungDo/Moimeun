package moimcustomer

import (
	"database/sql"
	"encoding/json"
	"net/http"

	"github.com/gorilla/mux"
)

// ResponseBody : 응답 body 정보
type ResponseBody struct {
	Result     []string `json:"results"`
	Count      int      `json:"count"`
	IsSuccess  bool     `json:"isSuccess"`
	StatusCode int      `json:"code"`
	Message    string   `json:"message"`
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

// GetCustomers : 모임에 참가한 회원들 조회
func GetCustomers(w http.ResponseWriter, r *http.Request) {
	// HEADER
	w.Header().Set("Content-Type", "application/json")
	params := mux.Vars(r)

	// Open DB
	db, err := openDB()
	errorCheck(err)
	defer db.Close()

	// SELECT Query
	res, err := db.Query(`	SELECT customer_id
							FROM moim_customer
							WHERE moim_link = '` + params["link"] + "';")
	errorCheck(err)
	defer res.Close()

	var customers []string
	var tmp string
	for res.Next() {
		err = res.Scan(&tmp)
		customers = append(customers, tmp)
		errorCheck(err)
	}

	respBody := ResponseBody{
		Result:     customers,
		Count:      len(customers),
		IsSuccess:  true,
		StatusCode: http.StatusOK,
		Message:    "성공",
	}

	json.NewEncoder(w).Encode(respBody)
}

// GetMoims : 회원이 참여한 모임들 조회
func GetMoims(w http.ResponseWriter, r *http.Request) {
	// HEADER
	w.Header().Set("Content-Type", "application/json")
	params := mux.Vars(r)

	// Open DB
	db, err := openDB()
	errorCheck(err)
	defer db.Close()

	// SELECT Query
	res, err := db.Query(`	SELECT moim_link
							FROM moim_customer
							WHERE customer_id = '` + params["id"] + "';")
	errorCheck(err)
	defer res.Close()

	var moims []string
	var tmp string
	for res.Next() {
		err = res.Scan(&tmp)
		moims = append(moims, tmp)
		errorCheck(err)
	}

	respBody := ResponseBody{
		Result:     moims,
		Count:      len(moims),
		IsSuccess:  true,
		StatusCode: http.StatusOK,
		Message:    "성공",
	}

	json.NewEncoder(w).Encode(respBody)

}
