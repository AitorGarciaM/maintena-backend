# 🚀 Maintena Backend

<p align="center">
  <b>A robust and secure REST API developed with Spring Boot and PostgreSQL for maintenance management.</b>
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-25-orange?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java">
  <img src="https://img.shields.io/badge/Spring_Boot-4.1.2-brightgreen?style=for-the-badge&logo=springboot&logoColor=white" alt="Spring Boot">
  <img src="https://img.shields.io/badge/PostgreSQL-18-blue?style=for-the-badge&logo=postgresql&logoColor=white" alt="PostgreSQL">
</p>

---

## 📌 Table of Contents
- [About The Project](#-about-the-project)
- [Technologies](#-technologies)
- [Previous Requirements](#-previous-requirements)
- [Environment Setup (.env)](#-environment-setup-env)
- [Installation and Implementation](#-installation-and-implementation)
- [Author](#-author)

---

## 💡 About The Project

**Maintena Backend** is the core of Maintena service platform, designed following the best practices of clear architecture, secure injection of dependencies and strictly isolated management of credentials by means of environment variables.

---

## 🛠️ Technologies

* **Language:** Java 25
* **Framework:** Spring Boot 4.1.2 (Spring Data JPA, Web)
* **Data Base:** PostgreSQL 18
* **Source control:** Git / GitHub

---

## ⚙️ Previous Requirements

Make sure you have installed in your system:
- [Java Development Kit (JDK) 25](https://jdk.java.net/)
- [Maven](https://maven.apache.org/)
- [PostgreSQL 18](https://www.postgresql.org/)

---

## 🔐 Environment Setup (.env)

For security reasons, the database credentials are not included in the repository. You must create a `.env` file at the project root based on this format:

```env
DB_USERNAME=your_postgres_user
DB_PASSWORD=your_postgres_password
```

## 🚀 Installation and Implementation
Follow these steps to get the project up on your local machine:
1. Clone the repository:
```Bash
git clone [https://github.com/AitorGarciaM/maintena-backend.git](https://github.com/AitorGarciaM/maintena-backend.git)
cd maintena-backend
```
2. Create your .env file in the root directory of the project with your PostgreSQL credentials.
3. Run the application using Maven:
```Bash
mvn spring-boot:run
```
The API will start by default on port 8080 and will automatically connect to your local database.

## 👤 Author
- Aitor Garcia Miñana - Fullstack Developer - [Github of AitorGarciaM](https://github.com/AitorGarciaM)
