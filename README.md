# 🩺 Heart Rate Monitor API
## A Spring Boot REST API for Monitoring Patient Heart Rates

---

## 📌 Table of Contents
- [📌 Introduction](#-introduction)
- [🚀 Features](#-features)
- [⚙️ Tech Stack](#️-tech-stack)
- [🛠️ Setup & Installation](#️-setup--installation)
- [📌 Assumptions & Design Decisions](#-assumptions--design-decisions)
- [📌 API Documentation](#-api-documentation)
- [📚 Additional Information](#-additional-information)

---

## 📌 Introduction
This project is a **Spring Boot REST API** that monitors **patient heart rates**. The system allows:
- **User registration & login** (basic authentication without security protocols).
- **Managing patients** (adding and retrieving patient records).
- **Tracking heart rate records** (adding and retrieving heart rate readings).

---

## 🚀 Features
✔️ **User Management** → Register & login users.  
✔️ **Patient Management** → Add & retrieve patient details.  
✔️ **Heart Rate Monitoring** → Record & fetch heart rate data.  
✔️ **H2 Database Support** → In-memory database for quick testing.  
✔️ **Swagger API Documentation** → Interactive API documentation.  

---

## ⚙️ Tech Stack
| Technology       | Description                         |
|-----------------|-------------------------------------|
| **Java 17**      | Backend language                   |
| **Spring Boot**  | REST API framework                 |
| **Spring Data JPA** | ORM for database interactions    |
| **H2 Database**  | In-memory DB for testing           |
| **Lombok**       | Reduces boilerplate code           |
| **Maven**        | Dependency management              |
| **Swagger UI**   | API documentation and testing      |

---

## 🛠️ Setup & Installation

### 1️⃣ Prerequisites
- **Java 17+** → Install from [Oracle JDK](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)  
- **Maven** → Install from [Apache Maven](https://maven.apache.org/download.cgi)  
- **Postman** → (Recommended) for API testing  

### 2️⃣ Clone the Repository
```sh
git clone https://github.com/YOUR_USERNAME/HeartRateMonitor-API.git
cd HeartRateMonitor-API
```
### 3️⃣ Build & Run the Application

```sh
mvn clean package
mvn spring-boot:run
```

### 4️⃣ Access API

- **Base URL:** [`http://localhost:8080`](http://localhost:8080)
- **Swagger API Docs:** [`http://localhost:8080/swagger-ui.html`](http://localhost:8080/swagger-ui.html)
- **H2 Database Console:** [`http://localhost:8080/h2-console`](http://localhost:8080/h2-console)
  - **JDBC URL:** `jdbc:h2:mem:pulsemonitor`
  - **Username:** `sa`
  - **Password:** *(leave empty)*

---

## 📌 Assumptions & Design Decisions

1. **No authentication framework used** → Basic email & password validation only.
2. **H2 in-memory database** → Quick testing without external DB setup.
3. **Database Relationships:**
   - A **User** can manage **multiple Patients**.
   - A **Patient** can have **multiple Heart Rate Records**.
4. **Cascading Deletes** → If a Patient is deleted, their heart rate records are also removed.
5. **Swagger UI integrated** → For easy API testing.

---

# 📌 API Documentation

## 1️⃣ User APIs

| Method | Endpoint         | Description     | Example Request Body |
|--------|-----------------|-----------------|----------------------|
| **POST**  | `/users/register`  | Register a user  | `{ "email": "test@example.com", "password": "pass123" }` |
| **POST**  | `/users/login`  | Login user  | `{ "email": "test@example.com", "password": "pass123" }` |


## 2️⃣ Patient APIs

| Method | Endpoint         | Description         | Example Request Body |
|--------|-----------------|---------------------|----------------------|
| **POST**  | `/patients/add`  | Add a new patient  | `{ "name": "John Doe", "age": 30 }` |
| **GET**   | `/patients/all`  | Retrieve all patients | No Body |


## 3️⃣ Heart Rate APIs

| Method | Endpoint                | Description                     | Example Request Body |
|--------|-------------------------|---------------------------------|----------------------|
| **POST**  | `/heart-rate/add`       | Add heart rate for a patient  | `{ "patient": { "id": 1 }, "heartRate": 72 }` |
| **GET**   | `/heart-rate/patient/{id}` | Retrieve heart rate records for a patient | No Body |

---

## 🟩 Additional Information

### 📌 Database Schema

| Entity  | Relationship             | Description  |
|---------|--------------------------|-------------|
| **User → Patient** | **One-to-Many (1:N)** | A user (doctor/nurse) can manage multiple patients. |
| **Patient → Heart Rate Record** | **One-to-Many (1:N)** | A patient has multiple heart rate readings over time. |


### 📌 Sample Database Records

#### 🗂 `users` Table

| id  | email             | password  |
|-----|------------------|-----------|
| 1   | doctor@email.com | pass123   |

#### 🗂 `patients` Table

| id  | name       | age | user_id |
|-----|-----------|-----|---------|
| 1   | John Doe  | 30  | 1       |
| 2   | Alice Smith | 28  | 1       |

#### 🗂 `heart_rate_records` Table

| id  | patient_id | heart_rate | timestamp           |
|-----|-----------|-----------|---------------------|
| 1   | 1         | 72        | 2025-02-18 08:51:17 |
| 2   | 1         | 80        | 2025-02-18 08:55:30 |
| 3   | 2         | 75        | 2025-02-18 09:00:00 |


### 📌 How to View Data in H2 Console

1. Start the Spring Boot application.
2. Open [`http://localhost:8080/h2-console`](http://localhost:8080/h2-console)
3. Use these credentials:
   - **JDBC URL:** `jdbc:h2:mem:pulsemonitor`
   - **Username:** `sa`
   - **Password:** *(leave empty)*
4. Click **Connect** → Run queries like:

```sql
SELECT * FROM USERS;
SELECT * FROM PATIENTS;
SELECT * FROM HEART_RATE_RECORDS;
```

---
