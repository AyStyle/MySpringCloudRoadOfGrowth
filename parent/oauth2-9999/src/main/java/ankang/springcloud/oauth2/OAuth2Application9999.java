package ankang.springcloud.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2021-01-26
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OAuth2Application9999 {

    public static void main(String[] args) {
        SpringApplication.run(OAuth2Application9999.class , args);
    }

}
