package cloud.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
	@Autowired
	HelloService helloService;

	@RequestMapping("/hello")
	public String helloConsumer() {
		long start = System.currentTimeMillis();
		String result =  helloService.hello();
		long end = System.currentTimeMillis();
		logger.info("SpendTime:{}", end - start);
		return result;
	}

}
