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
     * @return 注册成功跳到登录页面登录，出错跳到当前页面
     */
    @PostMapping("/register")
    public String register(UserIdentifyingForm form) {
        try {
            userService.register(form.getUser() , form.getCode());
        } catch (UserException e) {
        }
    }


    /**
     * 用户登录
     *
     * @param user 用户
     * @param code 验证码
     * @return 登录成功跳到首页，出错跳到当前页面
     */
    public String login(UserIdentifyingForm form) {
        try {
            userService.login(form.getUser() , form.getCode());
        } catch (UserException e) {
        }
    };


}
