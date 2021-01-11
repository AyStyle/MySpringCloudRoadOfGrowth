package ankang.springcloud.homework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2021-01-09
 */
@SpringBootApplication
@EnableEurekaServer
public class ServiceCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceCenterApplication.class , args);
    }

}
