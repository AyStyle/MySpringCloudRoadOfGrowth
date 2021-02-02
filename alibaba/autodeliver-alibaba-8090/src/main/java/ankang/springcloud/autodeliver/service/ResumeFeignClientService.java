package ankang.springcloud.autodeliver.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2021-02-02
 */
@FeignClient(
        name = "resume-alibaba-service",
        fallback = ResumeFeignClientDefault.class,
        path = "/resume"
)
public interface ResumeFeignClientService {

    @GetMapping("/openstate/{userId}")
    Integer findDefaultResumeState(@PathVariable("userId") Long userId);

}
