package ankang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2021-01-02
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication8762 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication8762.class , args);
    }

}
