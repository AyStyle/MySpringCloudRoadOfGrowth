package ankang.springcloud.homework.common.dao;

import ankang.springcloud.homework.common.pojo.Token;
import org.springframework.data.repository.CrudRepository;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2021-01-11
 */
public interface TokenDao extends CrudRepository<Token,String> {
}
