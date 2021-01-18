package ankang.springcloud.homework.user.service;

import ankang.springcloud.homework.common.pojo.IdentifyingCode;
import ankang.springcloud.homework.common.service.IdentifyingCodeService;
import ankang.springcloud.homework.common.service.IdentifyingCodeServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2021-01-12
 */
@FeignClient(
        name = "common-server",
        contextId = "IdentifyingCodeServiceImpl",
        fallback = IdentifyingCodeServiceFallback.class,
        path = "/identifyingCode"
)
public interface IdentifyingCodeServiceImpl extends IdentifyingCodeService {

    /**
     * 创建一个验证码
     *
     * @return
     */
    @GetMapping("/create")
    IdentifyingCode create();

    /**
     * 校验验证码是否正确
     *
     * @param code
     * @return 正确true，错误false
     */
    @PostMapping("/check")
    boolean check(IdentifyingCode code);

}
