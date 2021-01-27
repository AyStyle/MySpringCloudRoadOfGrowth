package ankang.springcloud.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2021-01-27
 */
@Configuration
@EnableResourceServer // 开启资源服务器功能
@EnableWebSecurity  // 开启web访问安全
public class ResourceConfig extends ResourceServerConfigurerAdapter {

    /**
     * 该方法用于定义资源服务器向远程认证服务器发起请求，进行token校验等
     *
     * @param resources
     * @throws Exception
     */
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        super.configure(resources);

        // 定义token服务对象（token校验就靠token服务对象）
        final RemoteTokenServices tokenServices = new RemoteTokenServices();

        // 校验端点/接口设置
        tokenServices.setCheckTokenEndpointUrl("http://localhost:9999/oauth/check_token");

        // 携带客户端id和客户端密码
        tokenServices.setClientId("client_lagou");
        tokenServices.setClientSecret("abcdefg");

        resources.tokenServices(tokenServices);
        resources.resourceId("autodeliver");
    }

    /**
     * 场景：一个服务中可能有很多资源（API接口）
     * 某些API接口，需要先认证后访问，有的是直接访问
     * <p>
     * 此处就是对于不同的API进行配置
     *
     * @param http
     * @throws Exception
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
//        super.configure(http);

        // 设置session创建策略
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .and()
                .authorizeRequests()
                // 其他请求通过
                .antMatchers("/autodeliver/**").authenticated()
                // 以autodeliver开头的必须进行验证
                .anyRequest().permitAll();
    }
}