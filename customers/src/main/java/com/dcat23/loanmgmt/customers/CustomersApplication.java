package com.dcat23.loanmgmt.customers;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@OpenAPIDefinition(
        info = @Info(
                title = "Customers Application REST API Documentation",
                description = "Manages customer-related information such as personal details, contact information, etc.",
                version = "v1",
                contact = @Contact(
                        name = "Devin Catuns",
                        email = "contact@dcat23.vercel.app",
                        url = "https://dcat23.vercel.app"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.apache.org/licenses/LICENSE-2.0"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Loan management documentation",
                url = "https://dcat23.vercel.app/swagger-ui.html"
        ))
@SpringBootApplication
public class CustomersApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomersApplication.class, args);
    }

}
