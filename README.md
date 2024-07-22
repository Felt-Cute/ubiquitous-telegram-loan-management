# Ubiquitous Telegram Loan Management

[![GitHub Stars](https://img.shields.io/github/stars/felt-cute/ubiquitous-telegram-loan-management.svg)](https://github.com/felt-cute/ubiquitous-telegram-loan-management/stargazers)
[![GitHub Issues](https://img.shields.io/github/issues/felt-cute/ubiquitous-telegram-loan-management.svg)](https://github.com/felt-cute/ubiquitous-telegram-loan-management/issues)
[![Current Version](https://img.shields.io/badge/version-0.0.1-green.svg)](https://github.com/felt-cute/ubiquitous-telegram-loan-management)
[![Live Demo](https://img.shields.io/badge/demo-offline-red.svg)](https://fmhh.vercel.app)

The Loan Management System web app designed to handle the end-to-end
process of loan management, from user registration and loan application
to loan processing and repayment.

By leveraging a microservices architecture, the system ensures
scalability, maintainability, and flexibility.

Each component of the system is developed as an independent
microservice, allowing for individual scaling and deployment.

---
## Technologies
Project is created with:
* [Java 17](https://docs.oracle.com/en/java/javase/21/)
* [Spring Boot: 3.3.2](https://docs.spring.io/spring-boot/docs/current/reference/html/)

---

## Modules

- [Customers Service](customers/README.md)
- [Loan Application Service](application/README.md)
- [Loan Processing Service](processing/README.md)
- [Credit Assessment Service](credit-assessment/README.md)
- [Payment Service](payments/README.md)
- [Notification Service](notifications/README.md)
- [Document Management Service](documents/README.md)
- [API Gateway](apigw/README.md)
- [Discovery Service](discovery/README.md)
- [Config Server](config/README.md)

---

## Setup

Clone the project

```bash
  git clone https://github.com/felt-cute/ubiquitous-telegram-loan-management.git
  cd ubiquitous-telegram-loan-management
```

Copy environment variables
```bash
cp .env.example .env
```

Start the services

```bash
docker compose up -d
```
---

## API Reference
http://localhost:8080/swagger-ui.html

### [Loan Application Service](http://localhost:8181/swagger-ui.html)
- `POST /api/applications`
- `GET /api/applications/{id}`
- `GET /api/applications/customer/{userId}`
- `PUT /api/applications/{id} (admin)`
- `DELETE /api/applications/{id} (admin)`
### [Customer Service](http://localhost:8182/swagger-ui.html)
- `POST /api/customers`
- `GET /api/customers/{id}`
- `PUT /api/customers/{id}`
- `DELETE /api/customers/{id} (admin)`
- `GET /api/customers/search?name={name}`
### [Credit Assessment Service](http://localhost:8184/swagger-ui.html)
- `POST /api/credit-assessments`
- `GET /api/credit-assessments/{id}`
- `GET /api/credit-assessments/application/{applicationId}`
- `PUT /api/credit-assessments/{id} (admin)`
### [Loan Processing Service](http://localhost:8183/swagger-ui.html)
- `POST /api/loans/{applicationId}/process`
- `GET /api/loans/{id}`
- `GET /api/loans/customer/{customerId}`
- `PUT /api/loans/{id}?status={status} (admin)`
- `GET /api/loans?status={status}`
### [Document Management Service](http://localhost:8080/documents)
- `POST /api/documents`
- `GET /api/documents/{id}`
- `GET /api/documents/application/{applicationId}`
- `DELETE /api/documents/{id} (admin)`
- `PUT /api/documents/{id}/verify (admin)`
### [Notification Service](http://localhost:8080/notifications)
- `POST /api/notifications`
- `GET /api/notifications/user/{userId}`
- `PUT /api/notifications/{id}/read`
- `DELETE /api/notifications/{id} (admin)`
### [Loan Disbursement Service](http://localhost:8080/disbursements)
- `POST /api/disbursements/{loanId}/disburse`
- `GET /api/disbursements/{id}`
- `GET /api/disbursements/loan/{loanId}`
- `PUT /api/disbursements/{id}/status (admin)`
### [Loan Servicing Service](http://localhost:8080/repayments)
- `POST /api/repayments`
- `GET /api/repayments/{id}`
- `GET /api/repayments/loan/{loanId}`
- `PUT /api/repayments/{id} (admin)`
- `GET /api/loans/{loanId}/schedule`
- `PUT /api/loans/{loanId}/reschedule (admin)`
### [Payments Service](http://localhost:8185/swagger-ui.html)
- `POST /api/transactions`
- `GET /api/transactions/{id}`
- `GET /api/transactions/loan/{loanId}`
- `PUT /api/transactions/{id} (admin)`

---
## Database Schema

### Loans
- loan_id (Primary Key)
- customer_id (Foreign Key to Customers table)
- loan_amount
- interest_rate
- loan_term
- start_date
- end_date
- status (e.g., pending, approved, active, closed)
### Customers
- customer_id (Primary Key)
- first_name
- last_name
- email
- phone_number
- address
### Loan Products
- product_id (Primary Key)
- product_name
- interest_rate
- min_amount
- max_amount
- min_term
- max_term
### Payment Schedule
- schedule_id (Primary Key)
- loan_id (Foreign Key to Loans table)
- payment_date
- payment_amount
- principal_amount
- interest_amount
- status (e.g., pending, paid, overdue)
### Transactions
- transaction_id (Primary Key)
- loan_id (Foreign Key to Loans table)
- amount
- transaction_date
- transaction_type (e.g., disbursement, repayment, fee)
### Documents
- document_id (Primary Key)
- loan_id (Foreign Key to Loans table)
- document_type
- file_name
- upload_date
### Loan Officers
- officer_id (Primary Key)
- first_name
- last_name
- email
- phone_number
### Loan History
- history_id (Primary Key)
- loan_id (Foreign Key to Loans table)
- action_type (e.g., created, approved, disbursed, closed)
- action_date
- performed_by (Foreign Key to Loan Officers table)

---
## Implementation Steps

1. **Define Requirements and Scope**
   - [] Gather detailed requirements from stakeholders
   - [] Identify types of loans, user roles, reporting needs, and compliance requirements
2. **Choose Technology Stack**
   - [1] Select Spring Boot for backend framework
   - [2] Choose a database (e.g., PostgreSQL, MySQL)
   - [] Select a frontend framework (e.g., React, Angular)
3. **Design Database Schema**
   - [3] Create tables for loans, customers, loan products, payment schedules, transactions, documents, loan officers, and loan history
   - [] Ensure proper normalization and relationships between tables
4. **Implement User Authentication and Authorization**
   - [] Set up Spring Security for authentication
   - [] Implement role-based access control (e.g., admin, loan officer, borrower)
5. **Develop Core Microservices**
   - [] Implement Loan Application Service
   - [] Create Customer Service
   - [] Develop Credit Assessment Service
   - [] Build Loan Processing Service
   - [] Implement Document Management Service
   - [] Create Notification Service
   - [] Develop Loan Disbursement Service
   - [] Implement Loan Servicing Service
6. **Implement RESTful APIs**
   - [] Design and develop endpoints for each microservice
   - [] Use Spring MVC for creating controllers
7. **Integrate with External Services**
   - [] Implement integrations for credit checks, KYC verification, and payment gateways
8. **Develop Frontend Application**
   - [] Create user interfaces for loan application, management, and reporting
   - [] Implement responsive design for multiple devices
9. **Implement Data Validation and Error Handling**
   - [] Use Spring Validation for input validation
   - [] Implement global exception handling
10. **Set Up Logging and Monitoring**
    - [] Implement logging using SLF4J and Logback
    - [] Set up monitoring using tools like Prometheus and Grafana
11. **Implement Reporting and Analytics**
    - [] Develop reporting features for loan portfolio performance, delinquency rates, etc.
    - [] Create customizable dashboards for different user roles
12. **Perform Testing**
    - [] Conduct unit testing using JUnit and Mockito
    - [] Perform integration testing
    - [] Execute user acceptance testing
13. **Set Up CI/CD Pipeline**
    - [] Implement continuous integration using tools like Jenkins or GitLab CI
    - [] Set up automated deployment processes
14. **Deploy the System**
    - [] Choose a cloud platform (e.g., AWS, Azure, Google Cloud)
    - [] Set up containerization using Docker
    - [] Implement orchestration using Kubernetes
15. **Implement Security Measures**
    - [] Ensure data encryption at rest and in transit
    - [] Implement secure coding practices
    - [] Conduct regular security audits
16. **Provide Documentation and Training**
    - [] Create comprehensive API documentation using Swagger or SpringFox
    - [] Develop user manuals and training materials
17. **Set Up Maintenance and Support**
    - [] Establish processes for regular updates and patches
    - [] Implement a system for handling user support and bug reports

---
## Additional Considerations
- [] Implement logging and monitoring using ELK stack or Prometheus/Grafana
- [] Use distributed tracing with Zipkin or Jaeger
- [] Implement CI/CD pipeline using Jenkins or GitLab CI
- [] Use Swagger or SpringFox for API documentation
- [] Implement data validation and error handling across all services
---
## Environment Variables

Add the following environment variables to the [.env](.env) file

`DATABASE_HOST`
`DATABASE_PORT`
`DATABASE_NAME`
`DATABASE_PASSWORD`
`DATABASE_USER`
`SPRING_APPLICATION_NAME`
`SWAGGER_UI_PATH`
`API_DOCS_PATH`
`SERVER_PORT`

---

## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://dcatuns.vercel.app/)
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/devin-catuns/)
[![twitter](https://img.shields.io/badge/twitter-1DA1F2?style=for-the-badge&logo=twitter&logoColor=white)](https://twitter.com/)

---
## Buy me a coffee

Whether you use this project, have learned something from it, or just like it, please consider supporting it by buying me a coffee, so I can dedicate more time on open-source projects like this :)

<a href="https://www.buymeacoffee.com/devincatunj" target="_blank"><img src="https://www.buymeacoffee.com/assets/img/custom_images/orange_img.png" alt="Buy Me A Coffee" style="height: auto !important;width: auto !important;" ></a>

---

## Feedback

If you have any feedback, please reach out to us at 

<a href="mailto:devincatuns1@gmail.com">devincatuns1@gmail.com</a>


