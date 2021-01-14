package ankang.springcloud.homework.user.service;

import ankang.springcloud.homework.common.pojo.Token;
import ankang.springcloud.homework.common.service.TokenService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2021-01-14
 */
@FeignClient(
        name = "common-server",
        fallback = ankang.springcloud.homework.common.service.TokenServiceImpl.class,
        path = "/token"
)
public interface TokenServiceImpl extends TokenService {

    /**
     * 创建token
     *
     * @return
     */
    @GetMapping("/create")
    @ResponseBody
    Token create();

    /**
     * 校验token
     *
     * @param token
     * @return 校验成功返回true，否则返回false
     */

    @PostMapping("/check")
    boolean check(@RequestBody Token token);

}
