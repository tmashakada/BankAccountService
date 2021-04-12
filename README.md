### Customer

| HTTP Verb  | URL | Description |
| ------------- | ------------- | ------------- |
|POST |http://localhost:9092/bankaccountservice/api/customer                |Creates a new Customer
| GET  |http://localhost:9092/bankaccountservice/api/customer/{customerId}        |
| GET  |http://localhost:9092/bankaccountservice/api/customers  |

### Account


| HTTP Verb  | URL | Description |
| ------------- | ------------- | ------------- |
|POST | http://localhost:9092/bankaccountservice/api/account |Creates a new Customer
| GET  | http://localhost:9092/bankaccountservice/api/accounts |
| GET  |http://localhost:9092/bankaccountservice/api/accounts/{accountype}  |
| GET  |http://localhost:9092/bankaccountservice/api/account/{accountnumber}  |
| GET  |http://localhost:9092/bankaccountservice/api/accountbalance/{accountnumber}  |


### Transaction

| HTTP Verb  | URL | Description |
| ------------- | ------------- | ------------- |
|POST |http://localhost:9092/bankaccountservice/api/deposit/{accountnumber} |Creates a new Customer
| POST  |http://localhost:9092/bankaccountservice/api/withdraw/{accountnumber}  |
| POST  |http://localhost:9092/bankaccountservice/api/transfer/{accounnumberfrom}  |
| GET    | http://localhost:9092/bankaccountservice/api/transactionhistory |
| GET    | http://localhost:9092/bankaccountservice/api/transactionhistory/{startdate}/{enddate}|
