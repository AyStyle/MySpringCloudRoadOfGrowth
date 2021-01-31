package ankang.springcloud.oauth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.jwt.crypto.sign.MacSigner;
import org.springframework.security.oauth2.config.annotation.builders.JdbcClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import javax.sql.DataSource;


/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2021-01-26
 */

@Configuration
@EnableAuthorizationServer
public class OAuth2ServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private DataSource dataSource;
    /**
     * 签名秘钥
     */
    private String signingKey = "ankang94NB";

    /**
     * 认证服务器安全配置
     * <p>
     * 认证服务器最终是以api接口的方式对外提供服务（检验合法性并生成令牌、校验令牌等）
     * 那么以api接口方式对外的话，就涉及到接口的访问权限，我们需要在这里进行必要的配置
     *
     * @param security
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        super.configure(security);

        // 打开endpoint访问接口的开关，这样的话后期我们就能够访问该接口
        security
                // 允许客户端表单认证
                .allowFormAuthenticationForClients()
                // 开启端口/oauth/token_key的访问权限，默认：拒绝
                .tokenKeyAccess("permitAll()")
                // 开启端口/oauth/check_token的访问权限，默认：拒绝
                .checkTokenAccess("permitAll()");
    }

    /**
     * 客户端详情配置
     * 例如：client_id，secret
     * <p>
     * 当前服务端就如同腾讯平台，拉勾网作为客户端需要腾讯平台进行登录授权认证，
     * 提前到腾讯平台注册，腾讯平台会给拉勾网颁发client_id等必要参数，表明客户端是谁
     *
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        super.configure(clients);

        // 客户端信息存储在什么地方，可以是内存，可以是数据库
        // 客户端信息在内存存储
//        clients.inMemory()
//                // 添加一个client配置，指定client_id
//                .withClient("client_lagou")
//                // 指定client的密码
//                .secret("abcdefg")
//                // 指定客户端能访问资源id的清单，此处的资源id是需要在具体的资源服务器上也配置一下
//                .resourceIds("autodeliver")
//                // 令牌颁发模式/认证类型，可以配置多个，但不一定都用，具体使用哪种方式颁发，需要客户端调用的时候传递参数指定
//                .authorizedGrantTypes("password" , "refresh_token")
//                // 客户端的权限范围
//                .scopes("all");

        // 客户端信息在JDBC中存储
        clients.jdbc(dataSource);

    }

    /**
     * 配置token令牌管理相关
     * <p>
     * 认证服务器是玩token的，那么这里配置token令牌管理相关（token此时就是一个字符串，
     * 当下的token需要在服务器端存储，那么存储在哪？都是在这里配置的）
     *
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        super.configure(endpoints);


        endpoints
                // 指定token的存储方式
                .tokenStore(buildTokenStore())
                // token服务的描述，可以认为是token生成细节的描述，比如有效时间多少等
                .tokenServices(buildTokenServices())
                // 指定认证管理器
                .authenticationManager(authenticationManager)
                // 接受的请求方式配置
                .allowedTokenEndpointRequestMethods(HttpMethod.GET , HttpMethod.POST);
    }

    /**
     * 构建一个tokenStore
     *
     * @return
     */
    private TokenStore buildTokenStore() {
//        return new InMemoryTokenStore();

        return new JwtTokenStore(buildTokenConverter());
    }

    /**
     * 构造token converter
     *
     * @return
     */
    private JwtAccessTokenConverter buildTokenConverter() {
        // 构造JWT token转换器
        final JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(signingKey); // 签名秘钥
        converter.setVerifier(new MacSigner(signingKey)); // 验证时使用的秘钥
        converter.setAccessTokenConverter();


        return converter;
    }

    /**
     * 该方法用户获取一个token服务对象（该对象描述了token的有效期等信息）
     *
     * @return
     */
    private AuthorizationServerTokenServices buildTokenServices() {
        final DefaultTokenServices tokenServices = new DefaultTokenServices();

        // 开启token刷新
        tokenServices.setSupportRefreshToken(true);
        tokenServices.setTokenStore(buildTokenStore());
        // 设置token有效时长
        tokenServices.setAccessTokenValiditySeconds(20);
        tokenServices.setRefreshTokenValiditySeconds(30);

        // 设置jwt token转换器
        tokenServices.setTokenEnhancer(buildTokenConverter());

        return tokenServices;
    }

}
