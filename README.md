# Amazon End-to-End E-Commerce Automation Framework

This repository contains a robust, industrial-standard automated testing framework designed to validate the end-to-end user workflows of the Amazon e-commerce platform. Built from scratch as a Fresher project, it demonstrates the implementation of clean coding practices and modular framework architecture.

## 🚀 Tech Stack & Tools
* **Language:** Java (JDK 11+)
* **Automation Tool:** Selenium WebDriver
* **Test Management:** TestNG
* **Build Tool:** Maven
* **CI/CD Integration:** Jenkins
* **Reporting:** Customized Screenshot Utilities on Failure

## 🏗️ Framework Architecture
The project follows the **Page Object Model (POM)** design pattern to enhance code reusability and maintainability. It cleanly separates the test scripts from the web element locators and page-specific actions.

### Project Structure Highlights:
* `.mvn & pom.xml`: Dependency management for Selenium, TestNG, and compiler plugins.
* `src/main/java`: Houses Page Classes containing WebElements (using optimized XPaths/ID locators) and page actions.
* `src/test/java`: Contains Test Classes mapping end-to-end user scenarios.
* `Screenshots/`: Dedicated module to capture and store visual bugs/failed test cases automatically.
* `Jenkinsfile`: Integrated build pipeline script for Continuous Integration.

## 🧪 Test Suites Included
The framework supports parallel and modular test execution through customized TestNG XML files:
1. `testng-smoke.xml`: Executes critical smoke tests (e.g., Login, Search).
2. `testng-sanity.xml`: Validates basic module-level functionality.
3. `testng-regression.xml`: Deep end-to-end validation suite covering the entire shopping cart and checkout flow.
4. `testng.xml`: Master suite for absolute execution.

## 🏃 How to Run the Project Locally

1. Clone the repository:
   ```bash
   git clone https://github.com
   ```
2. Navigate to the project directory:
   ```bash
   cd AmazonE2EAutomation
   ```
3. Run the tests using Maven:
   ```bash
   mvn clean test
   ```
