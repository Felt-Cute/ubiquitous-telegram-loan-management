package com.dcat23.loanmgmt.notifications;

import org.springframework.boot.SpringApplication;

public class TestNotificationsApplication {

	public static void main(String[] args) {
		SpringApplication.from(NotificationsApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
