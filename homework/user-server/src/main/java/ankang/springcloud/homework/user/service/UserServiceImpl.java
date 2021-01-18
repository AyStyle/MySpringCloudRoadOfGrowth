package ankang.springcloud.homework.user.service;

import ankang.springcloud.homework.common.pojo.IdentifyingCode;
import ankang.springcloud.homework.user.dao.UserDao;
import ankang.springcloud.homework.user.exception.UserAccountOrPasswordException;
import ankang.springcloud.homework.user.exception.UserException;
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


    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void register(User user , IdentifyingCode code) throws UserException {
        final User exampleUser = new User();
        exampleUser.setEmail(user.getEmail());

        final Example<User> example = Example.of(exampleUser);

        if (userDao.exists(example)) {
            throw new UserExistsException();
        }

        userDao.save(user);
    }

    @Override
    public void login(User user , IdentifyingCode code) throws UserException {
        final Example<User> of = Example.of(user);

        if (!userDao.exists(of)) {
            throw new UserAccountOrPasswordException();
        }
    }

}
