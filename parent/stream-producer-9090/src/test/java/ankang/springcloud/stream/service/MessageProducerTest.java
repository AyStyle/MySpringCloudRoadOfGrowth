package ankang.springcloud.stream.service;

import ankang.springcloud.stream.StreamProducerApplication;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootTest(classes = StreamProducerApplication.class)
@ExtendWith(SpringExtension.class)
class MessageProducerTest {

    @Autowired
    private MessageProducer messageProducer;

    @SneakyThrows
    @Test
    void testSendMessage() {
        while (true) {
            final String content = "this is producer，current time：" + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            System.out.println(content);
            messageProducer.sendMessage(content);

            Thread.sleep(1000);
        }
    }

}