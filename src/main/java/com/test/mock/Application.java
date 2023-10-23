package com.test.mock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
@RestController
public class Application {

	/**
	 * Точка входа в приложение.
	 * @param args массив аргументов командной строки
	 */
	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}

	/**
	 * Получает данные клиента на основе входного объекта RequestData.
	 * Заменяет значения inn и accountId на символы "*", чтобы скрыть их.
	 * Возвращает объект ClientData со скрытыми данными и сообщением приветствия.
	 */
	@RequestMapping(value = "/personal", method = RequestMethod.POST)
	public ClientData getClientData(@RequestBody RequestData request) {
		ClientData clientData = new ClientData();
		clientData.setClientInn(request.getInn());
		clientData.setClientAccountId(request.getAccountId());
		clientData.hideData();
		clientData.setMessage("Здравствуйте, Ваши данные получены");
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

	@RequestMapping(value = "/generate", method = RequestMethod.GET)
	public DataGenerator dataGenerate() {
		DataGenerator dataGenerator = new DataGenerator();
		dataGenerator.generateRandomData();
		return dataGenerator;
	}
}