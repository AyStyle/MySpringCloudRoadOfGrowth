package ankang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2020-12-30
 */
@SpringBootApplication
//@EnableEurekaClient // 开启Eureka Client（Eureka独有），后面都使用@EnableDiscoveryClient代替
@EnableDiscoveryClient // 开启注册中心客户端（通用型注解，比如注册到：Eureka，Nacos等）
                       // 说明：从SpringCloud的Edgware版本开始，不需要添加@EnableDiscoveryClient也能启动，但是建议添加
public class ResumeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResumeApplication.class , args);
    }

}
