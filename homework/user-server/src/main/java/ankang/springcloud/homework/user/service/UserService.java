package ankang.springcloud.homework.user.service;

import ankang.springcloud.homework.common.pojo.IdentifyingCode;
import ankang.springcloud.homework.user.exception.UserAccountOrPasswordException;
import ankang.springcloud.homework.user.exception.UserException;
import ankang.springcloud.homework.user.exception.UserExistsException;
import ankang.springcloud.homework.user.pojo.User;

import javax.servlet.http.HttpSession;


/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2021-01-11
 */
public interface UserService {

    /**
     * 注册用户
     *
     * @param user 注册用户
     * @param code 验证码
     * @throws UserExistsException 如果注册的用户已存在，则引发该异常
     */
    void register(User user , IdentifyingCode code) throws UserException;


    /**
     * 用户登录，登录成功下发token
     *
     * @param user 用户
     * @param code 验证码
     * @throws UserAccountOrPasswordException 如果用户名与密码不匹配引发该异常
     */
    void login(User user , IdentifyingCode code) throws UserException;

}
