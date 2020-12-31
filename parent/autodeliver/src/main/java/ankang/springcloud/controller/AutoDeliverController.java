package ankang.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2020-12-30
 */
@RestController
@RequestMapping("/autodeliver")
public class AutoDeliverController {

    private final RestTemplate restTemplate;

    public AutoDeliverController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/checkState/{userId}")
    public Integer findResumeOpenState(@PathVariable Long userId) {
        // 调用远程服务 -> 简历微服务接口 RestTemplate -> JdbcTemplate
        // 以前httpclient封装好多内容进行远程调用
        final Integer resumeOpenState = restTemplate.getForObject("http://localhost:8080/resume/openstate/" + userId , Integer.class);

        return resumeOpenState;
    }

}
