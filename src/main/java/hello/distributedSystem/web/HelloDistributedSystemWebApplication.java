package hello.distributedSystem.web;

import hello.distributedSystem.common.queue.ActiveMQConfig;
import hello.distributedSystem.common.redis.RedisConfig;
import hello.distributedSystem.common.redis.RedisService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @Author: Colin
 * @Date: 2018/10/27 22:23
 */
@SpringBootApplication
@Import({ActiveMQConfig.class,RedisConfig.class,RedisService.class})
public class HelloDistributedSystemWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloDistributedSystemWebApplication.class, args);
	}
}
