package ankang.springcloud.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2021-01-06
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashBoardApplication9000 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashBoardApplication9000.class , args);
    }

}
