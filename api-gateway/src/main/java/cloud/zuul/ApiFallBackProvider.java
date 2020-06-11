package cloud.zuul;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Component
public class ApiFallBackProvider implements FallbackProvider {
	private static final Logger logger = LoggerFactory.getLogger(ApiFallBackProvider.class);
	@Override
	public String getRoute() {
		return "*";
	}

	@Override
	public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
		logger.warn("{} TIMEOUT", route);
		return new ClientHttpResponse() {
			@Override
			public HttpStatus getStatusCode() throws IOException {
				return HttpStatus.OK;
			}

			@Override
			public int getRawStatusCode() throws IOException {
				return 200;
			}

			@Override
			public String getStatusText() throws IOException {
				return "OK";
			}

			@Override
			public void close() {

			}

			@Override
			public InputStream getBody() throws IOException {
				return new ByteArrayInputStream((route + " TIMEOUT").getBytes());
			}

			@Override
			public HttpHeaders getHeaders() {
				HttpHeaders httpHeaders = new HttpHeaders();
				return httpHeaders;
			}
		};
	}

}
