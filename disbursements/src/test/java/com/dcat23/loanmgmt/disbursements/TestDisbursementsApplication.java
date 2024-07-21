package com.dcat23.loanmgmt.disbursements;

import org.springframework.boot.SpringApplication;

public class TestDisbursementsApplication {

    public static void main(String[] args) {
        SpringApplication.from(DisbursementsApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
