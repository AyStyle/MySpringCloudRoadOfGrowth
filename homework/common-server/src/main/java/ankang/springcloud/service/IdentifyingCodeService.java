package ankang.springcloud.service;

import ankang.springcloud.pojo.IdentifyingCode;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2021-01-11
 */
public interface IdentifyingCodeService {

    /**
     * 创建一个验证码与用户邮箱绑定
     *
     * @return
     */
    IdentifyingCode create();

    /**
     * 校验验证码是否正确
     *
     * @param code
     * @return 正确true，错误false
     */
    boolean check(IdentifyingCode code);
}
