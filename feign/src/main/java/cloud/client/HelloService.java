package cloud.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

//fallback:指定服务降级的处理类 value:服务名不区分大小写
@FeignClient(value = "test-client", fallback = HelloServiceFallback.class)
public interface HelloService {

	@RequestMapping("/hello")
	String hello();
}
