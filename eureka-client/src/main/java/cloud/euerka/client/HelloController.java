package cloud.euerka.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;


@RestController
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class HelloController {
	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

	@Autowired
	private ServiceInstance serviceInstance;

	@RequestMapping("/hello")
	public String hello() {
		// 模拟超时 Hystrix的超时时间为1000，随机模拟超时
		int sleepTime = new Random().nextInt(2000);
		logger.info("sleepTime:{}", sleepTime);
		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			logger.error("",e);
		}
		logger.info("host:{}, serverId:{}", serviceInstance.getHost(), serviceInstance.getServiceId());
		return "hello! " + serviceInstance.getUri() +","+
				serviceInstance.getPort()+ "," +serviceInstance.getServiceId();
	}

	public static void main(String[] args) {
		new SpringApplicationBuilder(HelloController.class).run(args);
	}
}
