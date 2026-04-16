# 🚀 Java Selenium Automation Framework

This repository contains a Selenium WebDriver automation framework built using Java. The project is designed using best practices like Page Object Model (POM), reusable utilities, and reporting.

---

## 📌 Project Overview

- Automated UI testing using Selenium WebDriver
- Written in Java
- Managed using Maven
- Follows Page Object Model (POM)
- Includes reusable utility classes
- Generates execution reports

---

## 🗂️ Project Structure

```

CRAWLEE_ASSIGNMENT
│
├── src
│   ├── main
│   │   ├── java
│   │   └── resources
│   │
│   └── test
│       ├── java
│       │   ├── generic
│       │   │   ├── BaseTest.java
│       │   │   ├── CustomListener.java
│       │   │   ├── Flib.java
│       │   │   ├── IAutoConstant.java
│       │   │   └── WebDriverCommonLib.java
│       │   │
│       │   ├── pagepackage
│       │   │   └── Crawlee.java
│       │   │
│       │   └── testpackage
│       │
│       └── resources
│
├── data
│   └── config.properties
│
├── test-output
│   └── ExtentReport.html
│
└── pom.xml

```

---

## ⚙️ Technologies Used

- Java
- Selenium WebDriver
- TestNG
- Maven
- Extent Reports

---

## 🧩 Key Components

### BaseTest
Handles browser setup and teardown and initializes WebDriver and initializes reports

### WebDriverCommonLib
Contains reusable Selenium utility methods like waits, actions, and dropdown handling.

### Flib (File Library)
Used to read data from configuration files.

### IAutoConstant
Stores constants like file paths and timeouts.

### Page Classes
Implements Page Object Model (POM). Example: Crawlee.java

### CustomListener
Captures test execution logs and integrates with Extent Reports.

---

## ▶️ How to Run the Project

### Prerequisites
- Java (JDK 8 or higher)
- Maven installed
- IDE (VS Code)

### Steps

1. Clone the repository:
```

git clone [https://github.com/1808Nisha/CrawleeAssignment.git](https://github.com/1808Nisha/CrawleeAssignment)

```

2. Navigate to the project folder:
```

cd your-repo-name

```

3. Install dependencies:
```

mvn clean install

```

4. Run tests:
```

mvn test

```

---

## 📊 Test Reports

After execution, the test report is generated at:

```

/test-output/ExtentReport.html

```

Open this file in a browser to view detailed test results.

---

## 🔧 Configuration

Update the `config.properties` file in the `data` folder:

```

browser=chrome
url= https://crawlee.dev/blog/crawlee-v3-16

```

---

## ✅ Features

- Scalable framework design
- Reusable components
- Easy configuration management
- Detailed reporting
- Clean and maintainable code

## 👤 Author

Nisha Sharma 
https://github.com/1808Nisha/CrawleeAssignment
