package ankang.springcloud.controller;

import ankang.springcloud.service.ResumeServiceFeignClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2021-01-06
 */
@RestController
@RequestMapping("/autodeliver")
public class AutoDeliverFeignController {

    private final ResumeServiceFeignClient resumeServiceFeignClient;

    public AutoDeliverFeignController(ResumeServiceFeignClient resumeServiceFeignClient) {
        this.resumeServiceFeignClient = resumeServiceFeignClient;
    }


    /**
     * @param userId
     * @return
     */
    @GetMapping("/checkState/{userId}")
    public Integer findResumeOpenState(@PathVariable Long userId) {
        return resumeServiceFeignClient.findDefaultResumeState(userId);
    }

}
