package ankang.springcloud.homework.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.session.data.redis.RedisIndexedSessionRepository;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2021-01-17
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableRedisHttpSession
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class , args);
    }

    @Bean
    public RedisIndexedSessionRepository createRedisIndexedSessionRepository() {
        final RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        return new RedisIndexedSessionRepository(redisTemplate);
    }

}
