package moimcalander

import (
	"database/sql"
	"encoding/json"
	"net/http"

	"github.com/gorilla/mux"
)

// Calander : 모임-캘린더 객체
type Calander struct {
	CalanderSID       int    `json:"calander_sid"`
	MoimLink          string `json:"moim_link"`
	CalanderName      string `json:"calander_name"`
	CalanderStartDate string `json:"calander_startDate"`
	CalanderEndDate   string `json:"calander_endDate"`
	CalanderRepeat    bool   `json:"calander_repeat"`
}

// ResponseBody : response 객체
type ResponseBody struct {
	Result     []Calander `json:"result"`
	IsSuccess  bool       `json:"isSuccess"`
	StatusCode int        `json:"code"`
	Message    string     `json:"message"`
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

// GetCalander : 모임 캘린더 일정 조회
func GetCalander(w http.ResponseWriter, r *http.Request) {
	// HEADER
	w.Header().Set("Content-Type", "application/json")
	params := mux.Vars(r)

	// Open DB
	db, err := openDB()
	errorCheck(err)
	defer db.Close()

	// SELECT
	res, err := db.Query(`	SELECT *
							FROM moim_calander
							WHERE moim_link = '` + params["link"] + "';")
	errorCheck(err)
	defer db.Close()

	var calanders []Calander
	var obj Calander
	for res.Next() {
		err = res.Scan(&obj.CalanderSID,
			&obj.MoimLink,
			&obj.CalanderName,
			&obj.CalanderStartDate,
			&obj.CalanderEndDate,
			&obj.CalanderRepeat)
		errorCheck(err)
		calanders = append(calanders, obj)
	}

	respBody := ResponseBody{
		Result:     calanders,
		IsSuccess:  true,
		StatusCode: http.StatusOK,
		Message:    "성공",
	}
	json.NewEncoder(w).Encode(respBody)
}

// AddCalander : POST calander
func AddCalander(w http.ResponseWriter, r *http.Request) {
	// HEADER
	w.Header().Set("Content-Type", "application/json")

	// 객체 생성
	var obj Calander
	_ = json.NewDecoder(r.Body).Decode(&obj)

	// open DB
	db, err := openDB()
	errorCheck(err)
	defer db.Close()

	// INSERT
	_, err = db.Exec("INSERT INTO moim_calander VALUES(NULL,?,?,?,?,?)", obj.MoimLink, obj.CalanderName, obj.CalanderStartDate, obj.CalanderEndDate, obj.CalanderRepeat)

	// BODY RESPONSE
	var resArray []Calander
	resArray = append(resArray, obj)
	respObj := ResponseBody{
		Result:     resArray,
		IsSuccess:  true,
		StatusCode: http.StatusOK,
		Message:    "성공",
	}
	json.NewEncoder(w).Encode(respObj)
}

// DeleteCalander : DELETE calander
func DeleteCalander(w http.ResponseWriter, r *http.Request) {
	// HEADER
	w.Header().Set("Content-Type", "application/json")
	params := mux.Vars(r)

	// Open DB
	db, err := openDB()
	errorCheck(err)
	defer db.Close()

	var obj Calander
	// SELECT
	res, err := db.Query(`	SELECT * FROM moim_calander
							WHERE calander_sid = '` + params["sid"] + "';")

	for res.Next() {
		err = res.Scan(&obj.CalanderSID,
			&obj.MoimLink,
			&obj.CalanderName,
			&obj.CalanderStartDate,
			&obj.CalanderEndDate,
			&obj.CalanderRepeat)
		errorCheck(err)
	}

	// DELETE
	_, err = db.Exec(` DELETE FROM moim_calander
						WHERE calander_sid = '` + params["sid"] + "';")

	// 오류
	var respObj ResponseBody
	if obj.CalanderStartDate == "" {
		respObj = ResponseBody{
			IsSuccess:  false,
			StatusCode: http.StatusBadRequest,
			Message:    "실패",
		}
	} else {
		var resArray []Calander
		resArray = append(resArray, obj)
		respObj = ResponseBody{
			Result:     resArray,
			IsSuccess:  true,
			StatusCode: http.StatusOK,
			Message:    "성공",
		}
	}

	json.NewEncoder(w).Encode(respObj)
}
