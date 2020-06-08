package cloud.client.ribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {
	private static final Logger logger = LoggerFactory.getLogger(HelloService.class);
	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "helloFallback") // 指定断路回调方法
	public String helloService() {
		long start = System.currentTimeMillis();
		String result =  restTemplate.getForEntity("http://test-client/hello", String.class).getBody();
		long end = System.currentTimeMillis();
		logger.info("SpendTime:{}", end - start);
		return result;
	}

	public String helloFallback() {
		return "error";
	}
}
