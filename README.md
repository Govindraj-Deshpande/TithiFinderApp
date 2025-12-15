# TithiFinderApp
Java desktop application to calculate Hindu Tithi based on birth date


# TithiFinderApp
The TithiFinderApp is a desktop application developed in Java that helps users find their birth tithi (Hindu lunar day) based on their date of birth. The project demonstrates proficiency in Java Swing GUI programming, JSON data handling, and MySQL database integration.

## Technologies Used

### Programming Language
- **Java SE 8+**: Core programming language for the application
- **Java Swing**: GUI framework for creating the desktop interface

### Libraries and Dependencies
- **Gson 2.8.6**: JSON parsing and manipulation library
- **JCalendar 1.4**: Date picker component for user-friendly date selection
- **MySQL Connector/J 9.4.0**: JDBC driver for MySQL database connectivity
- **JSON-java 20210307**: Additional JSON processing support

### Database
- **MySQL**: Relational database management system for storing user data

### Development Tools
- **Command Line Interface (CLI)**: For compilation and execution
- **Text Editor/IDE**: For code development


## Project Structure

```
TithiFinderApp/
├── backend/
│   ├── data/
│   │   └── tithi-data-december-2001.json
│   ├── TithiDBManager.java
│   ├── TithiFinder.java
│   └── TithiResult.java
├── frontend/
│   ├── MainFrame.java
│   ├── MarvellousLogin.java
│   └── TithiFinderFrame.java
├── lib/
│   ├── gson-2.8.6.jar
│   ├── jcalendar-1.4.jar
│   ├── json-20210307.jar
│   └── mysql-connector-j-9.4.0.jar
├── hindu_calendar.py
├── json-20240303.jar
├── mysql-connector-j-9.4.0.jar
├── tithi-data.json
└── tithi-dataset.json
```


## Problems Solved

### 1. Hindu Calendar Integration
- **Problem**: Users need to know their birth tithi according to the Hindu lunar calendar for religious and cultural purposes
- **Solution**: Implemented a JSON-based data lookup system that maps Gregorian calendar dates to corresponding Hindu tithis

### 2. User-Friendly Date Selection
- **Problem**: Manual date entry is error-prone and inconvenient
- **Solution**: Integrated JCalendar component for intuitive date picking with proper formatting (dd-MM-yyyy)

### 3. Data Persistence
- **Problem**: Need to store user queries for future reference and analysis
- **Solution**: Implemented MySQL database integration to store user names, birth dates, corresponding tithis, and day of the week

### 4. Input Validation and Error Handling
- **Problem**: Invalid user inputs can crash the application
- **Solution**: Added comprehensive validation for empty fields and graceful error handling with user-friendly messages

### 5. Modular Architecture
- **Problem**: Monolithic code is difficult to maintain and extend
- **Solution**: Separated concerns into backend (data processing) and frontend (user interface) packages



•	To compile:
text
javac -cp "lib/*" backend/*.java frontend/*.java
•	To run:
text
java -cp "lib/*;." frontend.TithiFinderFrame
On Windows use ; between entries; on macOS/Linux use :. The . ensures your own classes are found.
For Database  in Xammp shell
mysql -u root
MariaDB [(none)]> SHOW DATABASES;
MariaDB [(none)]> USE tithi_finder;
Database changed
MariaDB [tithi_finder]> SELECT * FROM tithidata;
MariaDB [tithi_finder]>




## Compilation and Execution Commands

### Directory Setup
```cmd
cd "C:\Users\HP\Desktop\TithiProject\TithiFinderApp"
```

### Compilation Command
```cmd
javac -cp ".;lib\gson-2.8.6.jar;lib\mysql-connector-j-9.4.0.jar;lib\json-20210307.jar;lib\jcalendar-1.4.jar" backend\*.java frontend\*.java
```

### Execution Command
```cmd
java -cp ".;lib\gson-2.8.6.jar;lib\mysql-connector-j-9.4.0.jar;lib\json-20210307.jar;lib\jcalendar-1.4.jar" frontend.MarvellousLogin
```


## Database Configuration

### MySQL Database Setup
```sql
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
```
