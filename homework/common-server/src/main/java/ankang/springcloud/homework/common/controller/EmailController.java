package ankang.springcloud.homework.common.controller;

import ankang.springcloud.homework.common.pojo.EmailMessage;
import ankang.springcloud.homework.common.service.EmailService;
import org.apache.commons.mail.EmailException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2021-01-12
 */
@RestController
@RequestMapping("/email")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/smtp/simple")
    public boolean sendWithSMTP(@RequestBody EmailMessage msg) {
        try {
            emailService.sendWithSMTP(msg);
            return true;
        } catch (EmailException e) {
            return false;
        }
    }

}
