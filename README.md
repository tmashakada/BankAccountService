REST Endpoints
=============

The following REST endpoints are available upon deployment of the BankAccountService:

REST endpoints are secured using Basic Authentication

For Testing Piurpose

 username:admin
 
 password:admin123
 

### Customer
-------------
| HTTP Verb  | URL | Description |
| ------------- | ------------- | ------------- |
|POST |http://localhost:9092/bankaccountservice/api/customer                |Creates a new Customer Return Customer Created
| GET  |http://localhost:9092/bankaccountservice/api/customer/{customerId}        |
| GET  |http://localhost:9092/bankaccountservice/api/customers  |

### Account

-------------
| HTTP Verb  | URL | Description |
| ------------- | ------------- | ------------- |
|POST | http://localhost:9092/bankaccountservice/api/account |Creates a new Account
| GET  | http://localhost:9092/bankaccountservice/api/accounts |
| GET  |http://localhost:9092/bankaccountservice/api/accounts/{accountype}  |
| GET  |http://localhost:9092/bankaccountservice/api/account/{accountnumber}  |
| GET  |http://localhost:9092/bankaccountservice/api/accountbalance/{accountnumber}  |


### Transaction
-------------
| HTTP Verb  | URL | Description |
| ------------- | ------------- | ------------- |
|POST |http://localhost:9092/bankaccountservice/api/deposit/{accountnumber} |Deposit
| POST  |http://localhost:9092/bankaccountservice/api/withdraw/{accountnumber}  |
| POST  |http://localhost:9092/bankaccountservice/api/transfer/{accounnumberfrom}  |
| GET    | http://localhost:9092/bankaccountservice/api/transactionhistory |
| GET    | http://localhost:9092/bankaccountservice/api/transactionhistory/{startdate}/{enddate}|
