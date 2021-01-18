package ankang.springcloud.homework.user.aspect.aspect;

import ankang.springcloud.homework.common.pojo.IdentifyingCode;
import ankang.springcloud.homework.common.service.IdentifyingCodeService;
import ankang.springcloud.homework.user.exception.UserException;
import ankang.springcloud.homework.user.pojo.User;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2021-01-17
 */
@Aspect
public class UserServiceAspect {

    private final IdentifyingCodeService identifyingCodeService;

    public UserServiceAspect(IdentifyingCodeService identifyingCodeService) {
        this.identifyingCodeService = identifyingCodeService;
    }

    @Before(value = "execution(* ankang.springcloud.homework.user.service.UserServiceImpl.*(user,code))", argNames = "user,code")
    public void check(User user , IdentifyingCode code) throws UserException {
        if (!identifyingCodeService.check(code)) {
            throw new UserException("验证码不正确");
        }
    }

}
