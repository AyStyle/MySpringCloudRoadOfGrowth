package ankang.springcloud.homework.user.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2021-01-12
 */
@Aspect
@Component
public class UserAspect {

    @Pointcut("execution(* ankang.springcloud.homework.user.service.UserService.register)")
    public void check() {
    }


}
