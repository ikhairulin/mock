package com.test.mock;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import utils.ClientData;
import utils.DataGenerator;
import utils.RequestData;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class Application {
	/**
	 * Точка входа в приложение.
	 *
	 * @param args массив аргументов командной строки
	 */
	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}

	/**
	 * Получает данные клиента на основе входного объекта RequestData.
	 * Заменяет при помощи методов класса ClientData часть символов в полученных значениях
	 * inn и accountId на символы "*", чтобы скрыть личные данные.
	 * Возвращает объект ClientData со скрытыми данными и сообщением приветствия.
	 *
	 * @param request объект класса RequestData (служит для обработки принимаемого JSON).
	 */
	@RequestMapping(value = "/personal", method = RequestMethod.POST)
	public ClientData getClientData(@RequestBody RequestData request) {
		ClientData clientData = new ClientData();
		clientData.setClientInn(request.getInn());
		clientData.setClientAccountId(request.getAccountId());
		clientData.hideData();
		clientData.setMessage("Your data has been successfully received");
		System.out.println(clientData.getMessage());
		return clientData;
	}

	/**
	 * Метод обрабатывает GET-запрос для получения данных сессии.
	 * Создает новый объект Session, устанавливает временную метку в текущее время в формате ISO_INSTANT,
	 * устанавливает служебные атрибуты success и signType и id сессии
	 * возвращает объект Session со всеми установленными атрибутами.
	 */
	@RequestMapping(value = "/info", method = RequestMethod.GET)
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

	/**
	 * Метод для получения идентификатора сессии
	 * с применением метода GET
	 * по адресу /api?id=****
	 *
	 * @param request объект HttpServletRequest, содержащий информацию о запросе
	 */
	@GetMapping(value = "/api")
	public void getSessionId(HttpServletRequest request) {
		String sessionId = request.getParameter("id");
		System.out.println("id вашей сессии = " + sessionId);
	}

	@RequestMapping(value = "/generate", method = RequestMethod.GET)

	public List<String> dataGenerate(HttpServletRequest request) {
		int genNum = Integer.parseInt(request.getParameter("num"));
		List<String> listData = new ArrayList<>();
		DataGenerator dataGenerator = new DataGenerator();
		for (int i=0;i<genNum;i++) {
			dataGenerator.generateRandomData();
			listData.add(dataGenerator.getMessage());
		}
		return listData;
	}
}