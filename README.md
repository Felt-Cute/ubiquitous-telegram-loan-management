<a id="readme-top"></a>
[![GitHub Stars][stars-shield]][stars-url]
[![GitHub Issues][issues-shield]][issues-url]
[![Current Version][version-shield]][repo-url]
[![Live Demo][live-demo-shield]][live-demo-url]


<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/felt-cute/ubiquitous-telegram-loan-management">
    <img src="logo.svg" alt="Logo" width="80" height="80">
  </a>

  <h3 align="center">Ubiquitous Telegram Loan Management</h3>

  <p align="center">
    Loan Management System designed to handle the end-to-end process of loan management.
    <br />
    <a href="https://github.com/felt-cute/ubiquitous-telegram-loan-management"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/felt-cute/ubiquitous-telegram-loan-management">View Demo</a>
    ·
    <a href="https://github.com/felt-cute/ubiquitous-telegram-loan-management/issues/new?labels=bug&template=bug-report---.md">Report Bug</a>
    ·
    <a href="https://github.com/felt-cute/ubiquitous-telegram-loan-management/issues/new?labels=enhancement&template=feature-request---.md">Request Feature</a>
  </p>
</div>

<details>
  <summary>Table of Contents</summary>
  <ol>
    <li><a href="#about-the-project">Overview</a></li>
    <li><a href="#technical-stack">Tech Stack</a></li>
    <li><a href="#setup">Setup</a></li>
    <li><a href="#modules">Modules</a></li>
    <li><a href="#api-reference">API Reference</a></li>
    <li><a href="#database-schema">Database Schema</a></li>
    <li><a href="#implementation-steps">Implementation Steps</a></li>
    <li><a href="#additional-considerations">Additional Considerations</a></li>
    <li><a href="#contact">Contact</a></li>

  </ol>
</details>

---

<!-- Overview -->
## Overview


The Loan Management System web app designed to handle the end-to-end
process of loan management, from user registration and loan application
to loan processing and repayment.

By leveraging a microservices architecture, the system ensures
scalability, maintainability, and flexibility.

Each component of the system is developed as an independent
microservice, allowing for individual scaling and deployment.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

---

## Technical Stack

### Frontend
- **Framework**: React building a dynamic user interface.
- **State Management**: Redux or Context API for managing application state.

### Backend
- **Framework**: Spring Boot for the backend RESTful API.
- **Database**: PostgreSQL for storing user data, resources, and discussions.

### Hosting and Deployment
- **Cloud Provider**: AWS, for hosting the application.
- **Containerization**: Docker for containerizing the application for easier deployment and scalability.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

---

<!-- Setup -->
## Setup

Copy environment variables to the [.env](.env) file

```bash
cp .env.example .env
```

`DATABASE_HOST`
`DATABASE_PORT`
`DATABASE_NAME`
`DATABASE_PASSWORD`
`DATABASE_USER`

Start the services

```bash
docker compose up -d
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

---

<!-- Modules -->
## Modules

- [Customers Service](customers/README.md)
- [Loan Application Service](application/README.md)
- [Loan Processing Service](processing/README.md)
- [Loan Disbursement Service](disbursements/README.md)
- [Loan Officer Service](officers/README.md)
- [Credit Assessment Service](credit-assessment/README.md)
- [Payment Service](payments/README.md)
- [Notification Service](notifications/README.md)
- [Document Management Service](documents/README.md)
- [API Gateway](apigw/README.md)
- [Discovery Service](discovery/README.md)
- [Config Server](config/README.md)

<p align="right">(<a href="#readme-top">back to top</a>)</p>

---

<!-- API Reference -->

## [API Reference](http://localhost:8080/actuator/gateway/routes)

### [Loan Application Service](http://localhost:8181/swagger-ui.html)
- `POST /api/applications`
- `GET /api/applications/{id}`
- `GET /api/applications/customer/{userId}`
- `PUT /api/applications/{id} (admin)`
- `DELETE /api/applications/{id} (admin)`
- `POST /api/products (admin)`
- `GET /api/products`
- `GET /api/products/{id}`
- `PUT /api/products/{id} (admin)`
- `DELETE /api/products/{id} (admin)`
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
### [Document Management Service](http://localhost:8187/swagger-ui.html)
- `POST /api/documents`
- `GET /api/documents/{id}`
- `GET /api/documents/application/{applicationId}`
- `GET /api/documents/loan/{loanId}`
- `DELETE /api/documents/{id} (admin)`
- `PUT /api/documents/{id}/verify (admin)`
### [Notification Service](http://localhost:8186/swagger-ui.html)
- `POST /api/notifications`
- `GET /api/notifications/customer/{customerId}`
- `PUT /api/notifications/{id}/read`
- `DELETE /api/notifications/{id} (admin)`
### [Loan Disbursement Service](http://localhost:8188/swagger-ui.html)
- `POST /api/disbursements/{loanId}/disburse`
- `GET /api/disbursements/{id}`
- `GET /api/disbursements/loan/{loanId}`
- `PUT /api/disbursements/{id}?status={status} (admin)`
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
### [Loan Officer Service](http://localhost:8189/swagger-ui.html)
- `POST /api/officers`
- `GET /api/officers/{id}`
- `PUT /api/officers/{id}`
- `DELETE /api/officers/{id} (admin)`
<p align="right">(<a href="#readme-top">back to top</a>)</p>

---

<!-- Database Schema -->

## Database Schema


### [Loans](processing%2Fsrc%2Fmain%2Fjava%2Fcom%2Fdcat23%2Floanmgmt%2Fprocessing%2Fmodel%2FLoan.java)
- `loan_id` (Primary Key)
- `customer_id` (Foreign Key to Customers table)
- `loan_amount`
- `interest_rate`
- `loan_term`
- `start_date`
- `end_date`
- `status`
### [Customers](customers%2Fsrc%2Fmain%2Fjava%2Fcom%2Fdcat23%2Floanmgmt%2Fcustomers%2Fmodel%2FCustomer.java)
- `customer_id` (Primary Key)
- `first_name`
- `last_name`
- `email`
- `phone_number`
- `address`
### [Loan Products](application%2Fsrc%2Fmain%2Fjava%2Fcom%2Fdcat23%2Floanmgmt%2Fapplication%2Fmodel%2FLoanProduct.java)
- `id` (Primary Key)
- `product_name`
- `interest_rate`
- `min_amount`
- `max_amount`
- `min_term`
- `max_term`
### [Loan Applications](application%2Fsrc%2Fmain%2Fjava%2Fcom%2Fdcat23%2Floanmgmt%2Fapplication%2Fmodel%2FLoanApplication.java)
- `id` (Primary Key)
- `amount`
- `term`
- `status`
- `loan_product_id` (Foreign Key to Loan Product)
- `customer_id`
- `application_date`
### [Payment Schedules](processing%2Fsrc%2Fmain%2Fjava%2Fcom%2Fdcat23%2Floanmgmt%2Fprocessing%2Fmodel%2FPaymentSchedule.java)
- `schedule_id` (Primary Key)
- `loan_id` (Foreign Key to Loans table)
- `payment_date`
- `payment_amount`
- `principal_amount`
- `interest_amount`
- `status`
### [Transactions](payments%2Fsrc%2Fmain%2Fjava%2Fcom%2Fdcat23%2Floanmgmt%2Fpayments%2Fmodel%2FTransaction.java)
- `transaction_id` (Primary Key)
- `loan_id` (Foreign Key to Loans table)
- `amount`
- `transaction_date`
- `transaction_type`
### [Documents](documents%2Fsrc%2Fmain%2Fjava%2Fcom%2Fdcat23%2Floanmgmt%2Fdocuments%2Fmodel%2FDocument.java)
- `document_id` (Primary Key)
- `loan_id` (Foreign Key to Loans table)
- `document_type`
- `file_name`
- `upload_date`
### [Loan Officers](officers%2Fsrc%2Fmain%2Fjava%2Fcom%2Fdcat23%2Floanmgmt%2Fofficers%2Fmodel%2FLoanOfficer.java)
- `officer_id` (Primary Key)
- `first_name`
- `last_name`
- `email`
- `phone_number`
### [Loan History](processing%2Fsrc%2Fmain%2Fjava%2Fcom%2Fdcat23%2Floanmgmt%2Fprocessing%2Fmodel%2FLoanHistory.java)
- `history_id` (Primary Key)
- `loan_id` (Foreign Key to Loans table)
- `action_type`
- `action_date`
- `performed_by` (Foreign Key to Loan Officers table)


<p align="right">(<a href="#readme-top">back to top</a>)</p>

---

<!-- Implementation Steps -->

## Implementation Steps

1. **Define Requirements and Scope**
    - [] Gather detailed requirements from stakeholders
    - [] Identify types of loans, user roles, reporting needs, and compliance requirements
2. **Choose Technology Stack**
    - [x] Select Spring Boot for backend framework
    - [x] Choose a database (e.g., PostgreSQL, MySQL)
    - [] Select a frontend framework (e.g., React, Angular)
3. **Design Database Schema**
    - [x] Create tables for loans, customers, loan products, payment schedules, transactions, documents, loan officers, and loan history
    - [] Ensure proper normalization and relationships between tables
4. **Implement User Authentication and Authorization**
    - [] Set up Spring Security for authentication
    - [] Implement role-based access control (e.g., admin, loan officer, borrower)
5. **Develop Core Microservices**
    - [x] Implement Loan Application Service
    - [] Create Customer Service
    - [] Develop Credit Assessment Service
    - [] Build Loan Processing Service
    - [] Implement Document Management Service
    - [] Create Notification Service
    - [] Develop Loan Disbursement Service
    - [] Implement Loan Servicing Service
6. **Implement RESTful APIs**
    - [x] Design and develop endpoints for each microservice
    - [x] Use Spring MVC for creating controllers
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


<p align="right">(<a href="#readme-top">back to top</a>)</p>

---

<!-- Additional Considerations -->
## Additional Considerations

- [] Implement logging and monitoring using ELK stack or Prometheus/Grafana
- [] Use distributed tracing with Zipkin or Jaeger
- [] Implement CI/CD pipeline using Jenkins or GitLab CI
- [x] Use Swagger or SpringFox for API documentation
- [] Implement data validation and error handling across all services


<p align="right">(<a href="#readme-top">back to top</a>)</p>

---

<!-- CONTACT -->
## Contact

Devin Catuns - <a href="mailto:devincatuns1@gmail.com">devincatuns1@gmail.com</a>

[![LinkedIn][linkedin-shield]][linkedin-url]
[![portfolio][porfolio-shield]][portfolio-url]

[Ubiquitous Telegram Loan Management][repo-url]


<p align="right">(<a href="#readme-top">back to top</a>)</p>

---
## Buy me a coffee

Whether you use this project, have learned something from it, or just like it, please consider supporting it by buying me a coffee, so I can dedicate more time on open-source projects like this :)

<a href="https://www.buymeacoffee.com/devincatunj" target="_blank"><img src="https://www.buymeacoffee.com/assets/img/custom_images/orange_img.png" alt="Buy Me A Coffee" style="height: auto !important;width: auto !important;" ></a>


<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[version-shield]: https://img.shields.io/badge/version-0.0.1-green.svg?style=for-the-badge
[contributors-shield]: https://img.shields.io/github/contributors/felt-cute/ubiquitous-telegram-loan-management.svg?style=for-the-badge&logo=github
[contributors-url]: https://github.com/felt-cute/ubiquitous-telegram-loan-management/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/felt-cute/ubiquitous-telegram-loan-management.svg?style=for-the-badge
[forks-url]: https://github.com/felt-cute/ubiquitous-telegram-loan-management/network/members
[stars-shield]: https://img.shields.io/github/stars/felt-cute/ubiquitous-telegram-loan-management.svg?style=for-the-badge&&logo=github
[stars-url]: https://github.com/felt-cute/ubiquitous-telegram-loan-management/stargazers
[issues-shield]: https://img.shields.io/github/issues/felt-cute/ubiquitous-telegram-loan-management.svg?style=for-the-badge
[issues-url]: https://github.com/felt-cute/ubiquitous-telegram-loan-management/issues
[license-shield]: https://img.shields.io/github/license/felt-cute/ubiquitous-telegram-loan-management.svg?style=for-the-badge
[license-url]: https://github.com/felt-cute/ubiquitous-telegram-loan-management/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=0A66C2
[linkedin-url]: https://www.linkedin.com/in/devin-catuns/
[live-demo-shield]: https://img.shields.io/badge/demo-offline-red.svg?style=for-the-badge
[live-demo-url]: https://filn.vercel.app
[repo-url]: https://github.com/felt-cute/ubiquitous-telegram-loan-management
[porfolio-shield]: https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white
[portfolio-url]: https://dcat23.vercel.app/

