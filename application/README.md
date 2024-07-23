# Loan Applications Service

Handles the creation and management of loan applications and loan products.

## [API Reference](http://localhost:8181/swagger-ui.html)
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

## Database Schema
### [Products](application%2Fsrc%2Fmain%2Fjava%2Fcom%2Fdcat23%2Floanmgmt%2Fapplication%2Fmodel%2FLoanProduct.java)
- `id` (Primary Key)
- `product_name`
- `interest_rate`
- `min_amount`
- `max_amount`
- `min_term`
- `max_term`
### [Applications](src%2Fmain%2Fjava%2Fcom%2Fdcat23%2Floanmgmt%2Fapplication%2Fmodel%2FLoanApplication.java)
- `id` (Primary Key)
- `amount`
- `term`
- `status`
- `loan_product_id` (Foreign Key to Loan Product)
- `customer_id`
- `application_date`