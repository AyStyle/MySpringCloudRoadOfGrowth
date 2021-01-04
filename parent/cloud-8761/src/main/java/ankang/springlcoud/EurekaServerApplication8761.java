package ankang.springlcoud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2021-01-02
 */
@SpringBootApplication
// 声明当前项目为Eureka服务
@EnableEurekaServer
public class EurekaServerApplication8761 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication8761.class , args);
    }

}
