package cloud.zuul;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class ZuulApp {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ZuulApp.class).web(WebApplicationType.SERVLET).run(args);
	}
}
