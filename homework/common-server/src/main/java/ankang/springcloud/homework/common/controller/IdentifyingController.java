package ankang.springcloud.homework.common.controller;

import ankang.springcloud.homework.common.pojo.IdentifyingCode;
import ankang.springcloud.homework.common.service.IdentifyingCodeService;
import org.springframework.web.bind.annotation.*;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2021-01-12
 */
@RestController
@RequestMapping("/identifyingCode")
public class IdentifyingController {

    private final IdentifyingCodeService identifyingCodeService;

    public IdentifyingController(IdentifyingCodeService identifyingCodeService) {
        this.identifyingCodeService = identifyingCodeService;
    }

    /**
     * 创建一个验证码
     *
     * @return
     */
    @GetMapping("/create")
    public IdentifyingCode create() {
        return identifyingCodeService.create();
    }

    /**
     * 校验验证码是否正确
     *
     * @param code
     * @return 正确true，错误false
     */
    @PostMapping("/check")
    boolean check(@RequestBody IdentifyingCode code) {
        return identifyingCodeService.check(code);
    }

}
