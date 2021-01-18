package ankang.springcloud.homework.common.pojo;

import lombok.Data;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2021-01-12
 */
@Data
public class EmailMessage {

    private String subject;
    private String msg;
    private String[] to;

}
