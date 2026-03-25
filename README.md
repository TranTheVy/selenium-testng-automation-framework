# Selenium-testng-automation-framework
Selenium TestNG Automation Framework
Overview

This project is a Selenium Automation Testing Framework built using Java, TestNG, and Maven.
It demonstrates common automation testing practices used in real QA projects such as Page Object Model, Data Driven Testing, Parallel Execution, and Reporting.

The framework is designed to be scalable, maintainable, and easy to extend for UI automation testing.

Technologies Used:
Java
Selenium WebDriver
TestNG
Maven
Apache POI (Excel Data Driven Testing)
Extent Reports
WebDriverManager

Page Object Model (POM)
Test logic and page locators are separated into Page classes to improve maintainability.

Data Driven Testing
Test data is stored in Excel files and loaded dynamically using Apache POI.

Parallel Test Execution
Tests can run in parallel using TestNG to reduce execution time.

Retry Analyzer
Automatically reruns failed tests to handle flaky tests.

Screenshot on Failure
Screenshots are captured automatically when a test fails.

Test Reporting
Test results are generated using Extent Report with logs and screenshots.

Project Structure
Selenium-framework
│
├── src
│   ├── main
│   │   └── java
│   │       └── automation
│   │           ├── base
│   │           │   └── BaseTest.java
│   │           │
│   │           ├── pages
│   │           │   └── LoginPage.java
│   │           │
│   │           ├── utils
│   │           │   ├── WaitUtils.java
│   │           │   ├── ExcelUtils.java
│   │           │   ├── ConfigReader.java
│   │           │   └── RetryAnalyzer.java
│   │
│   └── test
│       └── java
│           └── automation
│               ├── tests
│               │   └── LoginTest.java
│               │
│               └── listener
│                   └── TestListener.java
│
├── src/main/resources
│   ├── config.properties
│   └── login-data.xlsx
│
├── testng.xml
├── pom.xml
└── README.md

Test Scenario Example
Example login test using Data Provider:
| Username | Password             | Expected Result  |
| -------- | -------------------- | ---------------- |
| tomsmith | SuperSecretPassword! | Login Success    |
| wrong    | wrong                | Invalid Username |
| tomsmith | wrong                | Invalid Password |

Running the Tests
Clone the repository:
  git clone https://github.com/TranTheVy/selenium-testng-automation-framework.git
Run tests using Maven:
  mvn test
Or run the TestNG suite:
  testng.xml

Test Report
After execution, reports can be found in: test-output/
Extent report example:extend-report.html
This report includes:
  Test execution results
  Logs
  Screenshots for failed tests

Future Improvements
Possible enhancements for this framework:
  Selenium Grid support
  Docker test execution
  CI/CD integration
  Allure reporting
  API testing integration

Author
Tran The Vy
Automation QA / Software Tester

Contact
GitHub:
https://github.com/TranTheVy
