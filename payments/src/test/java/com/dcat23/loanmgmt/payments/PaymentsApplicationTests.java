package com.dcat23.loanmgmt.payments;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class PaymentsApplicationTests {

	@Test
	void contextLoads() {
	}

}
