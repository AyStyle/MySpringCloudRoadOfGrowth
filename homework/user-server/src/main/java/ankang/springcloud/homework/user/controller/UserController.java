package ankang.springcloud.homework.user.controller;

import ankang.springcloud.homework.common.service.TokenService;
import ankang.springcloud.homework.user.exception.UserException;
import ankang.springcloud.homework.user.pojo.UserIdentifyingForm;
import ankang.springcloud.homework.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2021-01-12
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private static final String HOME_URL = "/home";
    private static final String LOGIN_URL = "/user/login";
    private static final String REGISTER_URL = "/user/register";

    private final UserService userService;
    private final TokenService tokenService;

    public UserController(UserService userService , TokenService tokenService) {
        this.userService = userService;
        this.tokenService = tokenService;
    }

    /**
     * 注册用户
     *
     * @param form 用户与验证码表单
     * @return 注册成功跳到登录页面登录，出错跳到当前页面
     */
    @PostMapping("/register")
    public String register(UserIdentifyingForm form , HttpSession session) {
        try {
            final String codeId = (String) session.getAttribute("code_id");
            form.getCode().setId(codeId);

            userService.register(form.getUser() , form.getCode());

            return "redirect:" + LOGIN_URL;
        } catch (UserException e) {
            return "forward:" + REGISTER_URL;
        }
    }


    /**
     * 用户登录
     *
     * @param form     用户和验证码
     * @param response 响应
     * @return 登录成功跳到首页，出错跳到当前页面
     */
    @PostMapping("/login")
    public String login(UserIdentifyingForm form , HttpServletResponse response , HttpSession session) {
        try {
            final String codeId = (String) session.getAttribute("code_id");
            form.getCode().setId(codeId);

            userService.login(form.getUser() , form.getCode());

            final Cookie token = new Cookie("token" , tokenService.create().getId());
            response.addCookie(token);

            return "redirect:" + HOME_URL;
        } catch (UserException e) {
            return "forward:" + LOGIN_URL;
        }
    }

}
