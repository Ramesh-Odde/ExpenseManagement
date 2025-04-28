# Expense Tracker REST API

## Overview:
The Expense Tracker is a RESTful backend application developed to manage personal expenses efficiently. It allows users to register, log in, and manage their financial records by adding, updating, viewing, filtering, and deleting expense entries. The system is designed to follow clean architecture practices, modular service layers, and proper REST API conventions, making it an ideal project for learning and showcasing backend development skills in Java and Spring Boot.

## Purpose:
- ➤ To simulate personal finance management using RESTful APIs.
- ➤ To practice modular backend architecture with service interfaces and JPA.
- ➤ To demonstrate skills in Spring Boot, Hibernate, and MySQL database integration.

## Technologies Used:
- ➤ Java 17
- ➤ Spring Boot (Spring Web, Spring Data JPA)
- ➤ MySQL (for expense and user data storage)
- ➤ Postman (for API testing and exploration)
- ➤ Maven (for project build and dependency management)

## Features:
- ➤ Register a new user.
- ➤ Login functionality with basic username/password check.
- ➤ Add a new expense for a user.
- ➤ Update an existing expense.
- ➤ View all expenses for a user.
- ➤ Filter expenses by category or date range.
- ➤ Delete an expense.
- ➤ Uses proper HTTP methods (`POST`, `GET`, `PUT`, `DELETE`) with meaningful status codes.
- ➤ Clean, modular codebase with interface-based service design.

## How to Run the Project Locally:

### 1. Clone the Repository
```bash
git clone https://github.com/Ramesh-Odde/ExpenseManagement.git
cd ExpenseManagement 
```
### 2. Set Up the Database  
- ➤Ensure MySQL is running on your system.  
- ➤Create a database named `expense_db`  
```bash
CREATE DATABASE expense_db;
```
- ➤Update your `src/main/resources/application.properties` file if needed
```bash
spring.datasource.url=jdbc:mysql://localhost:3306/expense_tracker
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```
## API Endpoints and Testing using Postman
### User Module:
➤ Register a new user  
  POST `/users/register`  
  Body:
```bash
{
"username": "john",
"password": "1234"
}
```

➤ Login  
  POST `/users/login`  
  Body: 
  ```bash
{
"username": "john",
"password": "1234"
}
```

### Expense Module:  
➤ Add Expense  
POST `/expenses/{userId}/add`  
Body: 
```bash
{
"title": "Groceries",
"category": "Food",
"amount": 50.5,
"date": "2025-04-28"
}
```

➤ View All Expenses  
GET `/expenses/{userId}/all`  

➤ Filter by Category  
GET `/expenses/{userId}/filter/category?category=Food`  

➤ Filter by Date Range  
GET `/expenses/{userId}/filter/date?from=2025-01-01&to=2025-04-01`  

➤ Update Expense  
PUT `/expenses/{expenseId}`  
Body: 
```bash
{
"title": "Updated",
"category": "Bills",
"amount": 80.0,
"date": "2025-04-28"
}
```

➤ Delete Expense  
DELETE `/expenses/{expenseId}`  

## Additional Points:  
- Validation: Prevents updates or deletes on non-existent records.
- Error Handling: Proper error messages returned for invalid operations (e.g., user not found, wrong password).
- Database Persistence: All expense and user data is stored and maintained in MySQL.  
## Contributions:
This project is developed primarily for self-learning and practical backend experience. 
Contributions such as adding JWT-based authentication, pagination, or expense summaries are welcome.
## Contact
📧 Email: ramesh.odde95@gmail.com    
🔗 LinkedIn: https://www.linkedin.com/in/ramesh-odde/
