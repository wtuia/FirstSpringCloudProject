package cloud.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * feign Hystrix的fallback实现
 *
 * feign对Hystrix的@HystrixCommand命令进行包装，无法直接使用该命令
 * 通过继承service为每个方法指定相应的降级逻辑
 */
@Component
public class HelloServiceFallback implements HelloService{
	private static final Logger logger = LoggerFactory.getLogger(HelloServiceFallback.class);
	@Override
	public String hello() {
		logger.warn("feign fallback 被调用");
		return "hello Fallback";
	}
}
