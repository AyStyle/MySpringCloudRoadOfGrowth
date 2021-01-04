package ankang.springcloud.controller;

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
    @GetMapping("/checkState/{userId}")
    public Integer findResumeOpenState(@PathVariable Long userId) {
        // 从Eureka Server中获取服务实例信息
        System.out.println("从Eureka Server中获取Resume服务信息，并提供相应的服务。。。");
        // 1. 从Eureka Server中获取Resume服务实例信息（使用EurekaClient对象）
        final List<ServiceInstance> resume = discoveryClient.getInstances("Resume");

        // 2. 如果有多个实例，选择一个使用（负载均衡的过程）
        final ServiceInstance serviceInstance = resume.get(0);

        // 3. 从元数据信息中获取IP port等
        final String host = serviceInstance.getHost();
        final int port = serviceInstance.getPort();
        final String key1 = serviceInstance.getMetadata().get("key1");
        final String key2 = serviceInstance.getMetadata().get("key2");
        System.out.println(String.format("Resume服务元数据key1：%s，key2：%s" , key1 , key2));

        final String url = String.format("http://%s:%d/resume/openstate/%d" , host , port , userId);

        // 调用远程服务 -> 简历微服务接口 RestTemplate -> JdbcTemplate
        // 以前httpclient封装好多内容进行远程调用
        final Integer resumeOpenState = restTemplate.getForObject(url , Integer.class);

        return resumeOpenState;
    }

}
