package ankang.springcloud.autodeliver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2021-02-02
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class AutoDeliverApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutoDeliverApplication.class , args);
    }

}
