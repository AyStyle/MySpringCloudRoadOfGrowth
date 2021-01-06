package ankang.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2020-12-30
 */
@SpringBootApplication
@EnableDiscoveryClient
// @EnableHystrix // 开启Hystrix功能（使用@EnableCircuitBreaker）
@EnableCircuitBreaker // 开启熔断器功能
// @SpringCloudApplication = @SpringBootApplication + @EnableDiscoveryClient + @EnableCircuitBreaker
public class AutoDeliverApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutoDeliverApplication.class , args);
    }


    // 使用RestTemplate模板对象进行远程调用
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * 在被监控的微服务中注册一个servlet，后期我们就是通过访问这个servlet来获取该服务的Hystrix监控数据
     * 前提：被监控的微服务需要引入springboot的actuator
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean getServlet() {
        final HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        final ServletRegistrationBean registrationBean = new ServletRegistrationBean<>(streamServlet);

        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/actuator/hystrix.stream");
        registrationBean.setName("AutoDeliverHystrixMetricsStreamServlet");

        return registrationBean;
    }
}
