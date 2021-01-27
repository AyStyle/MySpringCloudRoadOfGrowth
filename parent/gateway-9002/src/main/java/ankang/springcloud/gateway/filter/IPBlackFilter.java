package ankang.springcloud.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2021-01-07
 */
@Slf4j
@Component
public class IPBlackFilter implements BlackFilter {

    private static final List<String> BLACK_LIST = List.of(
//            "127.0.0.1"
    );

    /**
     * 过滤器核心方法
     *
     * @param exchange 封装了request和response上下文对象
     * @param chain    网关过滤器链，包含全局过滤器和单路过滤器
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange , GatewayFilterChain chain) {
        final ServerHttpRequest request = exchange.getRequest();
        final ServerHttpResponse response = exchange.getResponse();
        // 从request中获取客户端IP
        final String host = request.getRemoteAddress().getHostString();

        // 判断客户端ip是否在黑名单中，在则拒绝访问
        if (BLACK_LIST.contains(host)) {
            // 拒绝访问，返回
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            log.info("=====> IP: {}在黑名单，拒绝访问。" , host);

            final String data = "Request be denied !";

            final DataBuffer wrap = response.bufferFactory().wrap(data.getBytes());
            return response.writeWith(Mono.just(wrap));
        }

        log.info("=====> IP: {}，可以访问。" , host);
        // 合法请求，放行，执行后续的过滤器
        return chain.filter(exchange);
    }

    /**
     * 过滤器执行顺序，值越小，越优先执行
     *
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
