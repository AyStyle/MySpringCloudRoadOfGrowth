package ankang.springcloud.service;

import org.springframework.stereotype.Service;

/**
 * 服务降级策略
 *
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2021-01-06
 */
@Service
public class ResumeServiceFeignClientDefault implements ResumeServiceFeignClient {
    @Override
    public Integer findDefaultResumeState(Long userId) {
        return -6;
    }
}
