# Bank Management System

A comprehensive Java-based Automated Teller Machine (ATM) application with Swing GUI that provides complete banking functionality including user registration, login, and various banking transactions.

---

## Features

### Core Banking Operations

* **User Authentication**: Secure login system with card number and PIN validation
* **Account Registration**: Multi-step signup process with personal, professional, and account details
* **Deposit**: Add funds to user account
* **Withdraw**: Cash withdrawal with balance validation
* **Fast Cash**: Quick withdrawal options for predefined amounts
* **Balance Enquiry**: Check current account balance
* **Mini Statement**: View recent transaction history
* **PIN Change**: Secure PIN update functionality

---

### User Interface

* Modern Swing-based GUI with intuitive design
* ATM-style interface with background images
* Form validation and error handling
* Responsive button interactions

---

## Database Schema

The system uses MySQL with the following tables:

### `signup`

Stores personal information of users:

* formno
* name
* father_name
* dob
* gender
* email
* marital
* address
* city
* pincode
* state

---

### `signuptwo`

Stores professional and demographic details:

* formno
* religion
* category
* income
* education
* occupation
* pan
* adhaar
* seniorcitizen
* existingaccount

---

### `signupthree`

Stores account-related information:

* formno
* accountType
* cardnumber
* pin
* facility

---

### `login`

Authentication credentials:

* formno
* cardnumber
* pin

---

### `bank`

Transaction records:

* pin
* date
* type
* amount

---

## Project Structure

```text
BankManagementSystem/
├── src/bank/management/system/
│   ├── Login.java              # Main login interface
│   ├── SignupOne.java          # Personal details registration
│   ├── SignupTwo.java          # Professional details
│   ├── SignupThree.java        # Account setup
│   ├── Transactions.java        # Main transaction menu
│   ├── Deposit.java            # Deposit functionality
│   ├── Withdraw.java           # Withdrawal functionality
│   ├── FastCash.java           # Quick cash options
│   ├── BalanceEnquery.java     # Balance checking
│   ├── MiniStatement.java      # Transaction history
│   ├── PinChange.java          # PIN management
│   └── Con.java                # Database connection
├── lib/                        # External libraries
├── icons/                      # UI icons and images
└── mysql_file.sql              # Database setup script
```

---

## Prerequisites

* Java 8 or higher
* MySQL Database Server
* JDBC Driver for MySQL
* Swing library (included with JDK)

---

## Installation

### Setup Database

```bash
mysql -u root -p < mysql_file.sql
```

### Compile the Project

```bash
javac -cp ".:lib/*" src/bank/management/system/*.java
```

### Run the Application

```bash
java -cp ".:lib/*" bank.management.system.Login
```

---

## Usage

1. **New Users**: Click "SIGN UP" on the login screen and complete the three-step registration process
2. **Existing Users**: Enter your card number and PIN to access banking services
3. **Transactions**: Select from the available options in the main transaction menu

---

## Security Features

* PIN-based authentication
* Form validation for user inputs
* Secure database connection handling
* Transaction logging and auditing

---

## Technical Details

* **Language**: Java
* **GUI Framework**: Swing
* **Database**: MySQL
* **Architecture**: MVC pattern with separate classes for different functionalities
* **Connection**: JDBC for database operations

---

## Dependencies

* MySQL Connector/J (JDBC Driver)
* JCalendar (for date selection in signup forms)

---

## Notes

* Ensure MySQL server is running before starting the application
* Default database name: `BankManagementSystem`
* Card numbers are generated automatically during signup
* All transactions are logged with timestamps

---

## Author

Bank Management System - A complete ATM simulation application
