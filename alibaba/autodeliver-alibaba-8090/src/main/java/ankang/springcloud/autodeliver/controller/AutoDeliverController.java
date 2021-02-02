package ankang.springcloud.autodeliver.controller;

import ankang.springcloud.autodeliver.service.ResumeFeignClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2021-02-02
 */
@RestController
@RequestMapping("/autodeliver")
public class AutoDeliverController {

    private final ResumeFeignClientService resumeFeignClientService;

    public AutoDeliverController(ResumeFeignClientService resumeFeignClientService) {
        this.resumeFeignClientService = resumeFeignClientService;
    }

    /**
     * @param userId
     * @return
     */
    @GetMapping("/checkState/{userId}")
    public Integer findResumeOpenState(@PathVariable Long userId) {
        return resumeFeignClientService.findDefaultResumeState(userId);
    }


}
