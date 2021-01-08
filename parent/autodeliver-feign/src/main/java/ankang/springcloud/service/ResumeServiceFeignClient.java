package ankang.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2021-01-06
 */
@FeignClient(
        // 指定服务名称，服务名称是注册中心的服务名称
        name = "resume",
        // 指定服务降级类，降级类必须实现这个接口，并成为Spring容器中的一个bean
        fallback = ResumeServiceFeignClientDefault.class,
        path = "/resume"
)
// @RequestMapping("/resume") // 当FeignClient的fallback有服务降级，那么这个注解的内容应该放到FeignClient的path参数中，否则异常
public interface ResumeServiceFeignClient {

    /**
     * Feign会自动瓶装url，并发起请求
     *
     * @param userId
     * @return
     */
    @GetMapping("/openstate/{userId}")
    Integer findDefaultResumeState(@PathVariable("userId") Long userId);

}
