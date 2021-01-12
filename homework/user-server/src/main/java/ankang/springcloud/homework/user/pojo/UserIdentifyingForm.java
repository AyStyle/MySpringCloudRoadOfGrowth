package ankang.springcloud.homework.user.pojo;

import ankang.springcloud.homework.common.pojo.IdentifyingCode;
import lombok.Data;

/**
 * 用户认证表单
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2021-01-12
 */
@Data
public class UserIdentifyingForm {

    private User user;
    private IdentifyingCode code;

}
