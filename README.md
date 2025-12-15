# TithiFinderApp

A Java desktop application to calculate Hindu Tithi (lunar day) based on the user's date of birth.

---

## 📌 Project Overview

TithiFinderApp is a Java Swing–based desktop application that helps users find their birth Tithi according to the Hindu lunar calendar.  
This project demonstrates Java core concepts, Swing GUI development, JSON data handling, and MySQL database connectivity.

---

## 🛠 Technologies Used

### Programming Language
- **Java SE 8+**

### GUI Framework
- **Java Swing**

### Libraries
- **Gson** – JSON parsing
- **JCalendar** – Date picker component
- **MySQL Connector/J** – JDBC driver

### Database
- **MySQL**

---

## 📁 Project Structure


TithiFinderApp/
├── MainFrame.java
├── MarvellousLogin.java
├── TithiDBManager.java
├── TithiFinder.java
├── TithiFinderFrame.java
├── TithiResult.java
├── tithi-data-december-2001.json
└── README.md

---

## ✨ Features

- Calculate Hindu Tithi based on date of birth
- Calendar-based date selection
- Stores user details in MySQL database
- Input validation and error handling
- Simple and clean desktop UI

---

## ▶ How to Compile and Run

### Compilation
```cmd
javac *.java

java MarvellousLogin

Database Setup

CREATE DATABASE tithi_finder;
USE tithi_finder;

CREATE TABLE tithidata (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    dob DATE NOT NULL,
    tithi VARCHAR(255) NOT NULL,
    day VARCHAR(20) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
