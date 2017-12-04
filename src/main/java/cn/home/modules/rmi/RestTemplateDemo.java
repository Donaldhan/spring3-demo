package cn.home.modules.rmi;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateDemo {
	@Autowired
	private RestTemplate restTemplate;

	public <T> T execute(String url, HttpMethod method, RequestCallback requestCallback,
			ResponseExtractor<T> responseExtractor, String... urlVariables) {
		return restTemplate.execute(url, method, requestCallback, responseExtractor, urlVariables);
	}

	public String getForObject() {
		String result = restTemplate.getForObject("http://example.com/hotels/{hotel}/bookings/{booking}", String.class,
				"42", "21");
		return result;
	}

	public String getForObjectx() {
		Map<String, String> vars = Collections.singletonMap("hotel", "42");
		String result = restTemplate.getForObject("http://example.com/hotels/{hotel}/rooms/{hotel}", String.class,
				vars);
	    return result;
	}
}
