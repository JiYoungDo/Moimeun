package main

import (
	"customer"
	"customercalander"
	"fmt"
	"log"
	"moim"
	"moimcalander"
	"moimcustomer"
	"net/http"

	"github.com/gorilla/mux"
)

func main() {

	router := mux.NewRouter()

	fmt.Println("Running customerAPI...")
	router.HandleFunc("/customer/{id}", customer.GetCustomer).Methods("GET")
	router.HandleFunc("/customer", customer.AddCustomer).Methods("POST")
	router.HandleFunc("/customer/{id}", customer.DeleteCustomer).Methods("DELETE")
	router.HandleFunc("/login", customer.Login).Methods("POST")

	fmt.Println("Running moimAPI...")
	router.HandleFunc("/moim/{link}", moim.GetMoim).Methods("GET")
	router.HandleFunc("/moim", moim.AddMoim).Methods("POST")
	router.HandleFunc("/moim/{link}", moim.DeleteMoim).Methods("DELETE")
	router.HandleFunc("/join", moim.JoinMoim).Methods("POST")

	fmt.Println("Running moim_customerAPI...")
	router.HandleFunc("/customers/{link}", moimcustomer.GetCustomers).Methods("GET")
	router.HandleFunc("/moims/{id}", moimcustomer.GetMoims).Methods("GET")

	fmt.Println("Running customer_calanderAPI...")
	router.HandleFunc("/calander/{id}", customercalander.GetCalander).Methods("GET")
	router.HandleFunc("/calander", customercalander.AddCalander).Methods("POST")
	router.HandleFunc("/calander/{sid}", customercalander.DeleteCalander).Methods("DELETE")

	fmt.Println("Running moim_calanderAPI...")
	router.HandleFunc("/moim-calander/{link}", moimcalander.GetCalander).Methods("GET")
	router.HandleFunc("/moim-calander", moimcalander.AddCalander).Methods("POST")
	router.HandleFunc("/moim-calander/{sid}", moimcalander.DeleteCalander).Methods("DELETE")

	log.Fatal(http.ListenAndServe("", router))
}
