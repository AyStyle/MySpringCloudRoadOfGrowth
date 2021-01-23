package ankang.springcloud.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin2.server.internal.EnableZipkinServer;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2021-01-23
 */
@SpringBootApplication
@EnableZipkinServer
public class ZipkinApplication9411 {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinApplication9411.class , args);
    }

}
