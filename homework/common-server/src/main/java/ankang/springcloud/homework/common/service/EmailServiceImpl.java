package ankang.springcloud.homework.common.service;

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
@PropertySource(name = "apacheEmailConfig.properties", value = "classpath:*")
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
     * @param subject 邮件主题
     * @param msg     邮件信息
     * @param from    邮件发送人
     * @param to      邮件接收人
     * @throws EmailException
     */
    @Override
    public void sendWithSMTP(String subject , String msg , String from , String[] to) throws EmailException {
        Email email = new SimpleEmail();
        setSmtpEmail(email);

        email.setFrom(from);
        email.setSubject(subject);
        email.setMsg(msg);
        email.addTo(to);

        email.send();
    }

    /**
     * SMTP邮件通用配置
     *
     * @param email
     */
    private void setSmtpEmail(Email email) {
        email.setHostName(smtpHostname);
        email.setSmtpPort(smtpPort);
        email.setAuthentication(username , password);
        email.setSSLOnConnect(isSSLEnabled);
    }

}
