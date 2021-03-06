package ankang.springcloud.oauth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;
import java.util.Collections;

/**
 * 该配置类主要处理用户名和密码的校验
 *
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2021-01-27
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private DataSource dataSource;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    /**
     * 注册一个认证管理器对象到容器
     *
     * @return
     * @throws Exception
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * 处理用户名和密码验证
     * 1. 客户端传递username和password参数到认证服务器
     * 2. 一般来说，username和password会存储在数据库中的用户表中
     * 3. 根据用户表中数据，验证当前传递过来的用户信息合法性
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 在这个方法中就可以去关联数据库了

        // 当前我们先把用户信息配置在内存中
        // 实例化一个用户对象，相当于数据库中的一条用户记录
//        final UserDetails user = new User("admin" , "admin123" , Collections.emptyList());
//
//        auth.inMemoryAuthentication()
//                .withUser(user).passwordEncoder(passwordEncoder);

        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder);

    }


}
