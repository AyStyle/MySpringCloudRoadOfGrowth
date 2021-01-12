package ankang.springcloud.homework.common.controller;

import ankang.springcloud.homework.common.pojo.Token;
import ankang.springcloud.homework.common.service.TokenService;
import org.springframework.web.bind.annotation.*;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2021-01-12
 */
@RestController
@RequestMapping("/token")
public class TokenController {

    private final TokenService tokenService;

    public TokenController(TokenService tokenService) {
        this.tokenService = tokenService;
    }


    /**
     * 创建token
     *
     * @return
     */
    @GetMapping("/create")
    public Token create() {
        return tokenService.create();
    }

    /**
     * 校验token
     *
     * @param token
     * @return 校验成功返回true，否则返回false
     */
    @PostMapping("/check")
    public boolean check(@RequestBody Token token) {
        return tokenService.check(token);
    }

}
