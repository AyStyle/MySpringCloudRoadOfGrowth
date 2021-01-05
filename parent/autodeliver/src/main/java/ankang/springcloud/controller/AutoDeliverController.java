package ankang.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2020-12-30
 */
@RestController
@RequestMapping("/autodeliver")
public class AutoDeliverController {

    private final RestTemplate restTemplate;
    private final DiscoveryClient discoveryClient;

    public AutoDeliverController(RestTemplate restTemplate , DiscoveryClient discoveryClient) {
        this.restTemplate = restTemplate;
        this.discoveryClient = discoveryClient;
    }

    /**
     * 使用RestTemplate调用Resume接口
     *
     * @param userId
     * @return
     */
//    @GetMapping("/checkState/{userId}")
//    public Integer findResumeOpenState(@PathVariable Long userId) {
//        // 调用远程服务 -> 简历微服务接口 RestTemplate -> JdbcTemplate
//        // 以前httpclient封装好多内容进行远程调用
//        final Integer resumeOpenState = restTemplate.getForObject("http://localhost:8080/resume/openstate/" + userId , Integer.class);
//
//        return resumeOpenState;
//    }

    /**
     * 从Eureka中获取服务注册信息的改造
     *
     * @param userId
     * @return
     */
//    @GetMapping("/checkState/{userId}")
//    public Integer findResumeOpenState(@PathVariable Long userId) {
//        // 从Eureka Server中获取服务实例信息
//        System.out.println("从Eureka Server中获取Resume服务信息，并提供相应的服务。。。");
//        // 1. 从Eureka Server中获取Resume服务实例信息（使用EurekaClient对象）
//        final List<ServiceInstance> resume = discoveryClient.getInstances("Resume");
//
//        // 2. 如果有多个实例，选择一个使用（负载均衡的过程）
//        final ServiceInstance serviceInstance = resume.get(0);
//
//        // 3. 从元数据信息中获取IP port等
//        final String host = serviceInstance.getHost();
//        final int port = serviceInstance.getPort();
//        final String key1 = serviceInstance.getMetadata().get("key1");
//        final String key2 = serviceInstance.getMetadata().get("key2");
//        System.out.println(String.format("Resume服务元数据host：%s，port：%d，key1：%s，key2：%s" , host , port , key1 , key2));
//
//        final String url = String.format("http://%s:%d/resume/openstate/%d" , host , port , userId);
//
//        // 调用远程服务 -> 简历微服务接口 RestTemplate -> JdbcTemplate
//        // 以前httpclient封装好多内容进行远程调用
//        final Integer resumeOpenState = restTemplate.getForObject(url , Integer.class);
//
//        return resumeOpenState;
//    }

    /**
     * 使用Ribbon负载均衡来调用Resume接口
     * 使用@HystrixCommand commandProperties提供熔断功能
     * 使用@HystrixCommand fallbackMethod提供降级功能
     * 使用@HystrixCommand threadPoolKey提供资源隔离（舱壁模式）功能
     * <p>
     * 1. 服务提供者处理超时，熔断，返回错误信息
     * 2. 有可能服务提供者出现异常直接抛出异常信息
     * 以上信息，都会返回到消费者这里，很多时候消费者服务不希望把收到异常/错误信息再抛到它的上游去
     * 用户微服务 ->  注册微服务 -> 优惠券微服务
     * 1.登记注册
     * 2.分发优惠券（不是核心步骤），这里如果调用优惠券微服务返回了异常信息或者是熔断后的错误信息，这些信息如果抛给了用户很不友好
     *
     * @param userId
     * @return
     */
    @HystrixCommand(
            // 线程池唯一标识，如果有相同的标识，则线程池不共用
            threadPoolKey = "findResumeOpenState",
            // 线程池细节属性
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "10") ,
                    @HystrixProperty(name = "maxQueueSize", value = "10")
            },
            fallbackMethod = "findResumeOpenStateDefault",
            commandProperties = {
                    // 超时请求配置
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "200"),
                    // 断路器统计请求时间窗口
                    @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "8000"),
                    // 断路器时间窗口内达到的最小的请求量
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "2"),
                    // 断路器时间窗口内错误请求占比（百分比）
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
                    // 断路器间隔多长时间，确认一下服务是否恢复
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "3"),
            })
    @GetMapping("/checkState/{userId}")
    public Integer findResumeOpenState(@PathVariable Long userId) {
        // 格式：http://服务名/path
        final String url = String.format("http://resume/resume/openstate/%d" , userId);
        final Integer resumeOpenState = restTemplate.getForObject(url , Integer.class);

        return resumeOpenState;
    }

    /**
     * 定义服务降级方法，返回预设默认值
     * 注意：该方法形参和返回值与原始方法保持一致
     */
    private Integer findResumeOpenStateDefault(Long UserId) {
        return -1;
    }

}
