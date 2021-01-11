package ankang.springcloud.dao;

import ankang.springcloud.pojo.IdentifyingCode;
import org.springframework.data.repository.CrudRepository;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2021-01-11
 */
public interface IdentifyingCodeDao extends CrudRepository<IdentifyingCode, String> {
}
