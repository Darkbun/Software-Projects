# Spring Boot Calculator API

A simple RESTful Calculator API built using **Spring Boot**.
This project demonstrates how to create REST endpoints for performing basic arithmetic operations such as addition, subtraction, multiplication, and division.

---

## Features

* REST API based calculator
* Supports four basic operations:

  * Addition
  * Subtraction
  * Multiplication
  * Division
* Error handling for division by zero
* Structured JSON response
* Logging using **SLF4J**
* Clean layered architecture (Controller → Service → DTO)

---

## Tech Stack

* Java
* Spring Boot
* Maven
* Lombok
* REST API
* SLF4J Logging

---

## Project Structure

```
SpringCalculator
│
├── controller
│   └── CalculatorController.java
│
├── service
│   └── CalculatorService.java
│
├── dto
│   └── CalculationResponse.java
│
└── SbCalculatorApplication.java
```

---

## API Endpoints

### 1. Add Numbers

```
GET /calculator/add?a=10&b=5
```

Response:

```json
{
  "a": 10,
  "b": 5,
  "operation": "add",
  "result": 15,
  "status": "success",
  "error": null
}
```

---

### 2. Subtract Numbers

```
GET /calculator/subtract?a=10&b=5
```

---

### 3. Multiply Numbers

```
GET /calculator/multiply?a=10&b=5
```

---

### 4. Divide Numbers

```
GET /calculator/divide?a=10&b=5
```

If division by zero occurs:

```json
{
  "status": "error",
  "error": "Cannot divide by zero"
}
```

---

## How to Run

1. Clone the repository

```
git clone https://github.com/Darkbun/Software-Projects.git
```

2. Navigate to the project

```
cd SpringCalculator
```

3. Run the application

```
mvn spring-boot:run
```

4. Open browser or Postman and call the API

Example:

```
http://localhost:8080/calculator/add?a=5&b=2
```

---

## Learning Outcome

This project helped me learn:

* Building REST APIs using Spring Boot
* Controller-Service architecture
* Creating structured API responses
* Error handling in APIs
* Logging using SLF4J
