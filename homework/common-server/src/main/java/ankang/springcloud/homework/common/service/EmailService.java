package ankang.springcloud.homework.common.service;

import ankang.springcloud.homework.common.pojo.EmailMessage;
import org.apache.commons.mail.EmailException;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2021-01-11
 */
public interface EmailService {

    /**
     * 使用SMTP协议发送邮件
     *
     * @param msg      邮件信息
     * @throws EmailException 邮件发送失败异常
     */
    void sendWithSMTP(EmailMessage msg) throws EmailException;

}
