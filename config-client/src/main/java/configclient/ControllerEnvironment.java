package configclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ControllerEnvironment {

	@Autowired
	private Environment environment;

	@RequestMapping("from1")
	public String from() {
		return environment.getProperty("from");
	}
}
