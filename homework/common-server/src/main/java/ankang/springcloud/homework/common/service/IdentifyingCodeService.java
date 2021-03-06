package ankang.springcloud.homework.common.service;

import ankang.springcloud.homework.common.pojo.IdentifyingCode;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2021-01-11
 */
public interface IdentifyingCodeService {

    /**
     * 创建一个验证码
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
