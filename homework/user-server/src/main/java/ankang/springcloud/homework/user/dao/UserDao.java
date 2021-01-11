package ankang.springcloud.homework.user.dao;

import ankang.springcloud.homework.user.pojo.User;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2021-01-11
 */
public interface UserDao extends JpaRepositoryImplementation<User, Long> {

}
