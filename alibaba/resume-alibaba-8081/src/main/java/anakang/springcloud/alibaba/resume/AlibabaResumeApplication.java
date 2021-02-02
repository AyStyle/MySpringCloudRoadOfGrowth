package anakang.springcloud.alibaba.resume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2021-01-31
 */
@SpringBootApplication
@EnableDiscoveryClient
@EntityScan("ankang.springcloud.alibaba.resume.pojo")
public class AlibabaResumeApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlibabaResumeApplication.class , args);
    }

}
