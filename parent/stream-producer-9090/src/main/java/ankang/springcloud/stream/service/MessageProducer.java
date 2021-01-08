package ankang.springcloud.stream.service;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2021-01-08
 */
public interface MessageProducer {

    void sendMessage(String content);

}
