package com.dcat23.loanmgmt.processing;

import org.springframework.boot.SpringApplication;

public class TestProcessingApplication {

    public static void main(String[] args) {
        SpringApplication.from(ProcessingApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
