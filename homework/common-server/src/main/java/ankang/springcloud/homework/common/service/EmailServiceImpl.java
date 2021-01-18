package ankang.springcloud.homework.common.service;

import ankang.springcloud.homework.common.pojo.EmailMessage;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2021-01-11
 */
@Service
@PropertySource("classpath:apacheEmailConfig.properties")
public class EmailServiceImpl implements EmailService {

    @Value("${smtp.hostname}")
    private String smtpHostname;

    @Value("${smtp.port}")
    private int smtpPort;

    @Value("${smtp.username}")
    private String username;

    @Value("${smtp.password}")
    private String password;

    @Value("${smtp.isSSLEnable}")
    private boolean isSSLEnabled;

    /**
     * 使用SMTP协议发送邮件
     *
     * @param msg 邮件信息
     * @throws EmailException
     */
    @Override
    public void sendWithSMTP(EmailMessage msg) throws EmailException {
        Email email = new SimpleEmail();
        setSmtpEmail(email);

        email.setSubject(msg.getSubject());
        email.setMsg(msg.getMsg());
        email.addTo(msg.getTo());

        email.send();
    }

    /**
     * SMTP邮件通用配置
     *
     * @param email
     */
    private void setSmtpEmail(Email email) throws EmailException {
        email.setHostName(smtpHostname);
        email.setSmtpPort(smtpPort);
        email.setAuthentication(username , password);
        email.setFrom(username);
        email.setSSLOnConnect(isSSLEnabled);
    }

}
