# BankAccountService
Developer Assessment
There is no time limit but challenge yourself to finish in 4 hours (240 minutes)
An up-and-coming bank has approached you to create a prototypical core framework to integrate into their new API. The bank is upgrading their
systems to handle an increasing user base, and are in need of a quick front end as a proof of viability.
Due to their rapid deployment, they have completely negated any security measures, and are leaving it up to the developer to help enforce the
rules.
Your task is to create the basic functionality as defined below. (The addition of a functional UI for user-testing will be appreciated, but not
required)
Their business analyst requires the following;
Two types of account per user, ‘Savings Account’ and a ‘Current Account’
Both accounts will allow the user to ‘Deposit’, ‘Withdraw’, and ‘Transfer money’, as well as keep a log of the Transaction History
Savings Account
Opening
An account can only be opened through a minimum deposit of R1,000.00
Withdraw
The account needs to have a minimum balance of R1,000.00 at all time
Account balance must be decreased by the amount draw
Each transaction must be saved to the Transaction History
Deposit
Account balance must be increased by the amount drawn
Each transaction must be saved to the Transaction History
Current Account
Opening
No requirements
Withdraw
The account can have an overdraft limit of R100,000.00
The overdraft must be calculated as a negative number
A person cannot withdraw more than the (Current Balance + Overdraft) of the account.
eg. If the person has R50,000 in their account, they will be allowed to withdraw a maximum of R150,000
Account balance must be decreased by the amount drawn
Each transaction must be saved to the Transaction History
Deposit
Account balance must be increased by the amount drawn
Each transaction must be saved to the Transaction History
Implementation Guidelines
The bank is only interested in testing its systems. The code submitted does not have to be 100% perfect for a live environment. Please feel free
to comment on areas that you may implement in more detail in a live environment.
