package ankang.springcloud.stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2021-01-08
 */
@SpringBootApplication
@EnableDiscoveryClient
public class StreamProducerApplication {

    public static void main(String[] args){
        SpringApplication.run(StreamProducerApplication.class, args);
    }

}
