package moim

import (
	"database/sql"
	"encoding/json"
	"net/http"

	// go <-> mysql
	_ "github.com/go-sql-driver/mysql"
	"github.com/gorilla/mux"
)

// Moim 객체
type Moim struct {
	MoimLink      string         `json:"moim_link"`
	MoimName      string         `json:"moim_name"`
	MoimPlace     string         `json:"moim_place"`
	MoimPWD       string         `json:"moim_pwd"`
	MoimSize      bool           `json:"moim_size"`
	MoimMoney     int            `json:"moim_money"`
	MoimLeader    string         `json:"moim_leader"`
	MoimTempStart sql.NullString `json:"-"`
	MoimTempEnd   sql.NullString `json:"-"`
	MoimStartDate string         `json:"moim_startDate"`
	MoimEndDate   string         `json:"moim_endDate"`
	MoimIsRepeat  bool           `json:"moim_isRepeat"`
}

// ResponseBody 응답 body 정보
type ResponseBody struct {
	MoimInfo   Moim   `json:"moimInfo"`
	IsSuccess  bool   `json:"isSuccess"`
	StatusCode int    `json:"code"`
	Message    string `json:"message"`
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

// GetMoim : GET Moim
func GetMoim(w http.ResponseWriter, r *http.Request) {

	// HEADER
	w.Header().Set("Content-Type", "application/json")
	params := mux.Vars(r)

	// Open DB
	db, err := openDB()
	errorCheck(err)
	defer db.Close()

	// SELECT Query
	res, err := db.Query(`	SELECT *
							FROM moim
							WHERE moim_link = '` + params["link"] + "';")
	errorCheck(err)
	defer res.Close()

	// 가져온 moim 정보를 변수에 저장
	var moim Moim
	for res.Next() {

		err = res.Scan(&moim.MoimLink,
			&moim.MoimName,
			&moim.MoimPlace,
			&moim.MoimPWD,
			&moim.MoimSize,
			&moim.MoimMoney,
			&moim.MoimLeader,
			&moim.MoimTempStart,
			&moim.MoimTempEnd,
			&moim.MoimIsRepeat)
		errorCheck(err)
	}

	if moim.MoimTempStart.Valid {
		moim.MoimStartDate = moim.MoimTempStart.String
	} else {
		moim.MoimStartDate = "0000-00-00 00:00:00"
	}

	if moim.MoimTempEnd.Valid {
		moim.MoimEndDate = moim.MoimTempEnd.String
	} else {
		moim.MoimEndDate = "0000-00-00 00:00:00"
	}

	// 오류
	var newMoim ResponseBody
	if moim.MoimLink == "" {
		newMoim = ResponseBody{
			IsSuccess:  false,
			StatusCode: http.StatusBadRequest,
			Message:    "실패",
		}
	} else {
		newMoim = ResponseBody{
			MoimInfo:   moim,
			IsSuccess:  true,
			StatusCode: http.StatusOK,
			Message:    "성공",
		}
	}

	json.NewEncoder(w).Encode(newMoim)
}

// AddMoim : POST moim
func AddMoim(w http.ResponseWriter, r *http.Request) {
	// HEADER
	w.Header().Set("Content-Type", "application/json")

	// 객체 생성
	var moim Moim
	_ = json.NewDecoder(r.Body).Decode(&moim)

	db, err := openDB()
	errorCheck(err)
	defer db.Close()

	if moim.MoimIsRepeat == true {
		// INSERT
		_, err = db.Exec("INSERT INTO moim VALUES(?,?,?,?,?,?,?,?,?,?)",
			moim.MoimLink, moim.MoimName, moim.MoimPlace, moim.MoimPWD, moim.MoimSize,
			moim.MoimMoney, moim.MoimLeader, moim.MoimStartDate, moim.MoimEndDate, moim.MoimIsRepeat)
	} else {
		_, err = db.Exec("INSERT INTO moim VALUES(?,?,?,?,?,?,?,null,null,?)",
			moim.MoimLink, moim.MoimName, moim.MoimPlace, moim.MoimPWD, moim.MoimSize,
			moim.MoimMoney, moim.MoimLeader, moim.MoimIsRepeat)
	}

	var newMoim ResponseBody
	// 오류
	newMoim = ResponseBody{
		IsSuccess:  false,
		StatusCode: http.StatusBadRequest,
		Message:    "실패",
	}
	defer func() {
		if r := recover(); r != nil {
			json.NewEncoder(w).Encode(newMoim)
		}
	}()
	errorCheck(err)

	// BODY RESPONSE
	newMoim = ResponseBody{
		MoimInfo:   moim,
		IsSuccess:  true,
		StatusCode: http.StatusOK,
		Message:    "성공",
	}

	// IsSuccess가 true면 moim_customer 테이블에 회원-모임 정보 저장
	if newMoim.IsSuccess {
		// INSERT
		_, err = db.Exec("INSERT INTO moim_customer VALUES(?,?)", moim.MoimLink, moim.MoimLeader)
	}
	json.NewEncoder(w).Encode(newMoim)

}

// DeleteMoim : DELETE moim
func DeleteMoim(w http.ResponseWriter, r *http.Request) {
	// HEADER
	w.Header().Set("Content-Type", "application/json")
	params := mux.Vars(r)

	// open DB
	db, err := openDB()
	errorCheck(err)
	defer db.Close()

	// URI의 link를 통해 해당 모임 SELECT
	res, err := db.Query(`	SELECT *
							FROM moim
							WHERE moim_link = '` + params["link"] + "';")
	errorCheck(err)
	defer res.Close()

	// 해당 모임을 moim에 저장
	var moim Moim
	for res.Next() {
		err = res.Scan(&moim.MoimLink,
			&moim.MoimName,
			&moim.MoimPlace,
			&moim.MoimPWD,
			&moim.MoimSize,
			&moim.MoimMoney,
			&moim.MoimLeader,
			&moim.MoimTempStart,
			&moim.MoimTempEnd,
			&moim.MoimIsRepeat)
		errorCheck(err)
	}

	if moim.MoimTempStart.Valid {
		moim.MoimStartDate = moim.MoimTempStart.String
	} else {
		moim.MoimStartDate = "0000-00-00 00:00:00"
	}

	if moim.MoimTempEnd.Valid {
		moim.MoimEndDate = moim.MoimTempEnd.String
	} else {
		moim.MoimEndDate = "0000-00-00 00:00:00"
	}

	var resBody ResponseBody
	var moimLeader map[string]string
	_ = json.NewDecoder(r.Body).Decode(&moimLeader)

	// URI의 leader를 통해 방장인지 확인 후 삭제
	if moimLeader["moim_leader"] == moim.MoimLeader { // 성공
		_, err := db.Exec(`	DELETE FROM moim_customer
											WHERE moim_link = '` + moim.MoimLink + "';")
		errorCheck(err)

		delete, err := db.Query(`DELETE FROM moim
								WHERE moim_link='` + params["link"] + "';")
		errorCheck(err)
		defer delete.Close()

		resBody = ResponseBody{
			MoimInfo:   moim,
			IsSuccess:  true,
			StatusCode: http.StatusOK,
			Message:    "성공",
		}
	} else { // 실패
		resBody = ResponseBody{
			IsSuccess:  false,
			StatusCode: http.StatusBadRequest,
			Message:    "실패",
		}
	}

	// BODY RESPONSE
	json.NewEncoder(w).Encode(resBody)

}

// Join : 모임-회원 테이블 객체
type Join struct {
	MoimLink   string `json:"moim_link"`
	CustomerID string `json:"customer_id"`
}

// JoinRes : Join 객체 아웃풋
type JoinRes struct {
	Result     Join   `json:"result"`
	IsSuccess  bool   `json:"isSuccess"`
	StatusCode int    `json:"code"`
	Message    string `json:"message"`
}

// JoinMoim : 모임에 참가
func JoinMoim(w http.ResponseWriter, r *http.Request) {

	// HEADER
	w.Header().Set("Content-Type", "application/json")

	// Open DB
	db, err := openDB()
	errorCheck(err)
	defer db.Close()

	// 객체 생성
	var input Join
	_ = json.NewDecoder(r.Body).Decode(&input)

	// INSERT
	_, err = db.Exec("INSERT INTO moim_customer VALUES(?,?)", input.MoimLink, input.CustomerID)

	var output JoinRes
	if err != nil {
		output = JoinRes{
			IsSuccess:  false,
			StatusCode: http.StatusBadRequest,
			Message:    "실패",
		}
	} else {
		output = JoinRes{
			Result:     input,
			IsSuccess:  true,
			StatusCode: http.StatusOK,
			Message:    "성공",
		}
	}

	json.NewEncoder(w).Encode(output)
}
