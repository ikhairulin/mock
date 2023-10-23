package com.test.mock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
@RestController
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}

	@RequestMapping(value = "/personal", method = RequestMethod.POST)
	public ClientData getClientData() {
		ClientData clientData = new ClientData();
		clientData.collectData();
		return clientData;
	}

	@RequestMapping(value = "/data", method = RequestMethod.GET)
	public Session getSessionData() {
		Session session = new Session();
		OffsetDateTime timestamp = OffsetDateTime.now();
		String formattedTimestamp = timestamp.format(DateTimeFormatter.ISO_INSTANT);
		session.setTimestamp(formattedTimestamp);
		session.setSuccess(true);
		session.data.setSignType();
		session.data.setSessionDataRedisHashId();

		return session;

	}

	@GetMapping("/api/session")
	public void getSessionData(@RequestParam("id") String sessionId) {
		// Обработка GET запроса с параметром
		System.out.println("id вашей сессии = " + sessionId);
	}

}
