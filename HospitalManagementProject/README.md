# Hospital Management System

A comprehensive Spring Boot application for managing hospital operations including patients, doctors, appointments, and billing.

## Project Structure

```
org.example.demo
│
├── controller        → Handles HTTP requests (API layer)
├── service           → Business logic
├── repository        → Database interaction (JPA)
├── models            → Entity classes (DB tables)
├── dto               → Data Transfer Objects
├── exception         → Global exception handling
├── config            → Security / App configuration
├── util              → Helper classes
└── Main              → Main class
```

## Features

- **Patient Management**: CRUD operations for patient records
- **Doctor Management**: CRUD operations for doctor records
- **Appointment Management**: Schedule and manage appointments
- **Billing System**: Generate and manage bills
- **RESTful APIs**: Complete REST API with proper HTTP status codes
- **Exception Handling**: Global exception handling with custom error responses
- **DTO Pattern**: Separation of internal models from API responses
- **CORS Configuration**: Cross-origin resource sharing configured

## API Endpoints

### Patients
- `POST /api/v1/patient` - Create a new patient
- `GET /api/v1/patient` - Get all patients
- `GET /api/v1/patient/{id}` - Get patient by ID
- `PUT /api/v1/patient/{id}` - Update patient
- `DELETE /api/v1/patient/{id}` - Delete patient

### Doctors
- `POST /api/v1/doctor` - Create a new doctor
- `GET /api/v1/doctor` - Get all doctors
- `GET /api/v1/doctor/{id}` - Get doctor by ID
- `PUT /api/v1/doctor/{id}` - Update doctor
- `DELETE /api/v1/doctor/{id}` - Delete doctor

### Appointments
- `POST /api/v1/appointment` - Create a new appointment
- `GET /api/v1/appointment` - Get all appointments
- `GET /api/v1/appointment/{id}` - Get appointment by ID
- `PUT /api/v1/appointment/{id}` - Update appointment
- `DELETE /api/v1/appointment/{id}` - Delete appointment

### Bills
- `POST /api/v1/bill` - Create a new bill
- `GET /api/v1/bill` - Get all bills
- `GET /api/v1/bill/{id}` - Get bill by ID
- `PUT /api/v1/bill/{id}` - Update bill
- `DELETE /api/v1/bill/{id}` - Delete bill

## Technology Stack

- **Java 17**
- **Spring Boot 3.2.5**
- **Spring Data JPA**
- **MySQL Database**
- **Lombok** (for reducing boilerplate code)
- **Maven** (build tool)

## Database Schema

### Patient
- id (Long, Primary Key, Auto-increment)
- name (String)
- gender (String)
- age (int)

### Doctor
- id (Long, Primary Key, Auto-increment)
- name (String)
- speciality (String)

### Appointment
- id (Long, Primary Key, Auto-increment)
- patientId (Long, Foreign Key)
- doctorId (Long, Foreign Key)
- date (LocalDateTime in database, formatted as String "dd-MM-yyyy HH:mm:ss" in API)

### Bill
- id (Long, Primary Key, Auto-increment)
- patientId (Long, Foreign Key)
- doctorId (Long, Foreign Key)
- amount (double)
- status (String)

## Getting Started

1. **Prerequisites**:
   - Java 17 or higher
   - MySQL database
   - Maven

2. **Database Setup**:
   ```sql
   CREATE DATABASE hospital_management;
   ```

3. **Configuration**:
   Update `application.properties` with your database credentials:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/hospital_management
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   ```

4. **Run the Application**:
   ```bash
   mvn spring-boot:run
   ```

5. **Access the API**:
   The application will start on `http://localhost:8080`

## Error Handling

The application implements global exception handling with the following error responses:

- **404 Not Found**: When a resource is not found
- **400 Bad Request**: For invalid input data
- **500 Internal Server Error**: For unexpected server errors

All error responses include a descriptive message and status code.

## Development Notes

- Uses DTO pattern to separate API models from database entities
- Implements proper RESTful API design with appropriate HTTP methods
- Includes comprehensive logging for debugging
- Follows Spring Boot best practices
- Uses Lombok annotations to reduce boilerplate code

## API Examples

### Create Appointment
```json
POST /api/v1/appointment
{
    "patientId": 1,
    "doctorId": 2,
    "date": "20-03-2026 14:30:00"
}
```

**Note**: Only `dd-MM-yyyy HH:mm:ss` format is accepted for dates.

### Response
```json
{
    "id": 1,
    "patientId": 1,
    "doctorId": 2,
    "date": "20-03-2026 14:30:00"
}
```

## Future Enhancements

- Authentication and Authorization
- Input validation with Bean Validation
- Unit and Integration Tests
- API Documentation with Swagger
- Docker containerization
- Microservices architecture
