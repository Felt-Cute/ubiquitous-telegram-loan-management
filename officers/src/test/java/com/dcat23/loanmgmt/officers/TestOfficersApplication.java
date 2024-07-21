package com.dcat23.loanmgmt.officers;

import org.springframework.boot.SpringApplication;

public class TestOfficersApplication {

    public static void main(String[] args) {
        SpringApplication.from(OfficersApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
