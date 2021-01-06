package ankang.springcloud.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2021-01-06
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableTurbine
public class HystrixTurbineApplication9001 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixTurbineApplication9001.class , args);
    }

}
