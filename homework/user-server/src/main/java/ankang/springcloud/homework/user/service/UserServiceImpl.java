package ankang.springcloud.homework.user.service;

import ankang.springcloud.homework.common.pojo.IdentifyingCode;
import ankang.springcloud.homework.common.service.IdentifyingCodeService;
import ankang.springcloud.homework.user.dao.UserDao;
import ankang.springcloud.homework.user.exception.UserAccountOrPasswordException;
import ankang.springcloud.homework.user.exception.UserExistsException;
import ankang.springcloud.homework.user.pojo.User;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2021-01-11
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    private final IdentifyingCodeService identifyingCodeService;

    public UserServiceImpl(UserDao userDao , IdentifyingCodeService identifyingCodeService) {
        this.userDao = userDao;
        this.identifyingCodeService = identifyingCodeService;
    }

    @Override
    public void register(User user , IdentifyingCode code) throws UserExistsException {
        identifyingCodeService.check(code);


        final User exampleUser = new User();
        exampleUser.setEmail(user.getEmail());

        final Example<User> example = Example.of(exampleUser);

        if (userDao.exists(example)) {
            throw new UserExistsException();
        }

        userDao.save(user);
    }

    @Override
    public void login(User user , IdentifyingCode code) throws UserAccountOrPasswordException {
        final Example<User> of = Example.of(user);

        if (!userDao.exists(of)) {
            throw new UserAccountOrPasswordException();
        }
    }
}
