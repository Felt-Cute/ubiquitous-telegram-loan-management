package com.dcat23.loanmgmt.notifications;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info = @Info(
                title = "Notifications Application REST API Documentation",
                description = "Manages notifications sent to users regarding their loan applications and payments.",
                version = "v1",
                contact = @Contact(
                        name = "Devin Catuns",
                        email = "devincatuns1@gmail.com",
                        url = "https://github.com/dcat23"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.apache.org/licenses/LICENSE-2.0"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Loan management Github",
                url = "https://github.com/Felt-Cute/ubiquitous-telegram-loan-management"
        ))
@SpringBootApplication
public class NotificationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationsApplication.class, args);
	}

}
