package ankang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2020-12-30
 */
@SpringBootApplication
public class AutoDeliverApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutoDeliverApplication.class , args);
    }


    // 使用RestTemplate模板对象进行远程调用
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
