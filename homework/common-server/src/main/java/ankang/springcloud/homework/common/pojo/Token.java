package ankang.springcloud.homework.common.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2021-01-11
 */
@RedisHash(value = "token",timeToLive = 7200)
@Data
public class Token {

    @Id
    private String id;
    private String token;

}
