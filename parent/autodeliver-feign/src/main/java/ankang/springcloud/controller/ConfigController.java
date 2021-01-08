package ankang.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2021-01-08
 */
@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigController {

    @Value("${ankang.name}")
    private String name;
    @Value("${ankang.age}")
    private Integer age;

    @Value("${ankang.gender}")
    private String gender;

    @GetMapping("/view")
    public String view() {
        return String.format("===> name: %s, age: %d, gender: %s" , name , age , gender);
    }


}
