package ankang.springcloud.homework.common.service;

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
     * @param subject 邮件主题
     * @param msg     邮件信息
     * @param from    邮件发送人
     * @param to      邮件接收人
     * @throws EmailException 邮件发送失败异常
     */
    void sendWithSMTP(String subject , String msg , String from , String[] to) throws EmailException;

}
