package me.djamelkorei.springbootsecuritybasicauth;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SpringBootSecurityBasicAuthApplicationTests {

	private final String USERNAME = "admin";
	private final String PASSWORD = "123";
	private final String WRONG_PASSWORD = "bvfsdg";

	@Autowired
	TestRestTemplate template;

	@Test
	public void accessPrivateResourceSuccess() throws Exception {
		ResponseEntity<String> response = template.withBasicAuth(USERNAME, PASSWORD)
				.getForEntity("/secured", String.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	public void accessPrivateResourceFaildGivingWrongPassword() throws Exception {
		ResponseEntity<String> response = template.withBasicAuth(USERNAME, WRONG_PASSWORD)
				.getForEntity("/secured", String.class);

		assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
	}

}
