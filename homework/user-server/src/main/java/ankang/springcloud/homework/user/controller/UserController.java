package ankang.springcloud.homework.user.controller;

import ankang.springcloud.homework.common.pojo.IdentifyingCode;
import ankang.springcloud.homework.user.exception.UserAccountOrPasswordException;
import ankang.springcloud.homework.user.exception.UserException;
import ankang.springcloud.homework.user.exception.UserExistsException;
import ankang.springcloud.homework.user.pojo.User;
import ankang.springcloud.homework.user.pojo.UserIdentifyingForm;
import ankang.springcloud.homework.user.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2021-01-12
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 注册用户
     *
     * @param form 用户与验证码表单
     * @throws UserExistsException 如果注册的用户已存在，则引发该异常
     */
    @PostMapping("/register")
    public String register(UserIdentifyingForm form) throws UserException {
        userService.register(form.getUser(), form.getCode());
    }


    /**
     * 用户登录
     *
     * @param user 用户
     * @param code 验证码
     * @throws UserAccountOrPasswordException 如果用户名与密码不匹配引发该异常
     */
    public void login(User user , IdentifyingCode code) throws UserException;


}
