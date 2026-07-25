# Cloud Notes Application

A full-stack notes application built using **Spring Boot**, **PostgreSQL**, **Docker**, and **Render**. The application allows users to create an account, securely log in, and manage their personal notes through a simple web interface.

This project was developed to gain hands-on experience with backend development, RESTful API design, database integration, Docker containerization, and cloud deployment. It demonstrates the complete software development lifecycle, from designing the application architecture to deploying it as a live web application.

---

## 🚀 Live Demo

**Live Application:**  
https://rest-api-project-2-krwf.onrender.com/login.html

> **Note:** This application is hosted on Render's free tier. If the application has been inactive for some time, the first request may take 30–60 seconds while the server wakes up.

---

## ✨ Features

- User registration and authentication
- Create and view personal notes
- Persistent data storage using PostgreSQL
- RESTful backend APIs
- Responsive web interface
- Cloud deployment using Docker and Render

---

## 🛠 Technologies Used

### Backend
- Java 21
- Spring Boot
- Spring Data JPA
- REST API

### Database
- PostgreSQL

### Frontend
- HTML
- CSS
- JavaScript
- jQuery

### Deployment & Tools
- Docker
- Render
- Git
- GitHub

---

## 🏗 Project Architecture

```
Browser
      │
      ▼
HTML / CSS / JavaScript / jQuery
      │
      ▼
Spring Boot REST API
      │
      ▼
Spring Data JPA
      │
      ▼
PostgreSQL Database
```

---

## 📡 REST API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/register` | Register a new user |
| POST | `/login` | Authenticate a user |
| POST | `/notes` | Create a new note |
| GET | `/notes/{userId}` | Retrieve all notes for a user |

---

## 📌 Project Highlights

- Developed a RESTful backend using Spring Boot.
- Designed database entities and relationships using Spring Data JPA.
- Implemented user authentication and persistent note management.
- Connected the application to a managed PostgreSQL database.
- Dockerized the application for consistent deployment.
- Deployed the application on Render using environment-based configuration.
- Used Git and GitHub for version control and automatic deployment.

---

## 💻 Running the Project Locally

### 1. Clone the repository

```bash
git clone <repository-url>
```

### 2. Configure the database

Create a PostgreSQL database and configure the following environment variables:

```text
SPRING_DATASOURCE_URL
SPRING_DATASOURCE_USERNAME
SPRING_DATASOURCE_PASSWORD
```

### 3. Run the application

Using Maven Wrapper:

```bash
./mvnw spring-boot:run
```

Or using Maven:

```bash
mvn spring-boot:run
```

Open your browser and navigate to:

```
http://localhost:8080/login.html
```

---

## 📷 Screenshots

Add screenshots here, such as:

- Login Page
- Registration Page
- Notes Dashboard
- Notes List

---

## 🔮 Future Improvements

- Password hashing using BCrypt
- JWT-based authentication
- Edit and delete notes
- Search and filtering
- Pagination
- User profile management
- Improved user interface and user experience

---

## 📄 License

This project was developed for learning and portfolio purposes.
