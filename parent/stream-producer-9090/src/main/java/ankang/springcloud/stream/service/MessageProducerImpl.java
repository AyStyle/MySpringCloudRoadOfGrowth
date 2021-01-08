package ankang.springcloud.stream.service;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2021-01-08
 */
@EnableBinding(Source.class)
public class MessageProducerImpl implements MessageProducer {

    /**
     * 注入MessageChannel的封装对象Source
     */
    private final Source source;


    public MessageProducerImpl(Source source) {
        this.source = source;
    }

    @Override
    public void sendMessage(String content) {
        // 向Spring Cloud Stream发送消息（底层通过Binder向消息队列发送）
        // 使用通道向外发出消息（指的是Source里面的output通道）

        source.output().send(MessageBuilder.withPayload(content).build());
    }
}
