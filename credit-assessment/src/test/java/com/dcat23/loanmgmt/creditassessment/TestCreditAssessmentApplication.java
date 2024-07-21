package com.dcat23.loanmgmt.creditassessment;

import org.springframework.boot.SpringApplication;

public class TestCreditAssessmentApplication {

    public static void main(String[] args) {
        SpringApplication.from(CreditAssessmentApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
