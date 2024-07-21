package com.dcat23.loanmgmt.application;

import org.springframework.boot.SpringApplication;

public class TestApplication {

	public static void main(String[] args) {
		SpringApplication.from(LoanApplicationApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
