package ankang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2021-01-06
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients // 开启Feign功能
public class AutoDeliverFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutoDeliverFeignApplication.class , args);
    }

}
