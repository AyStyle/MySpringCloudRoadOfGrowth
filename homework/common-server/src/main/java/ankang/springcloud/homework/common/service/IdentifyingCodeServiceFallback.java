package ankang.springcloud.homework.common.service;

import ankang.springcloud.homework.common.pojo.IdentifyingCode;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2021-01-12
 */
public class IdentifyingCodeServiceFallback implements IdentifyingCodeService{
    @Override
    public IdentifyingCode create() {
        return new IdentifyingCode();
    }

    @Override
    public boolean check(IdentifyingCode code) {
        return false;
    }
}
