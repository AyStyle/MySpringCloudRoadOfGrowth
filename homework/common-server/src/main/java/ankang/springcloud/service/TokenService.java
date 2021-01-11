package ankang.springcloud.service;

import ankang.springcloud.pojo.Token;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2021-01-11
 */
public interface TokenService {

    /**
     * 创建token
     *
     * @return
     */
    Token create();

    /**
     * 校验token
     *
     * @param token
     * @return 校验成功返回true，否则返回false
     */
    boolean check(Token token);
}
