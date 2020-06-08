package cloud.eureka.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class EurekaServer {
	private static final Logger logger = LoggerFactory.getLogger(EurekaServer.class);
	public static void main(String[] args) {
		new SpringApplicationBuilder(EurekaServer.class).web(WebApplicationType.SERVLET).run(args);
		logger.error("接口执行监听");
	}
}
