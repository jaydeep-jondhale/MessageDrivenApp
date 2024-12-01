import org.app.consumer.MessageConsumer;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageDrivenAppTest {

    @Test
    public void testApp() throws InterruptedException{
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        AtomicInteger successfulMessages = new AtomicInteger(0);
        AtomicInteger failedMessages = new AtomicInteger(0);

        queue.put("Message-1");
        queue.put("Message-2");
        queue.put("ERROR MESSAGE");
        queue.put("END");

        MessageConsumer consumer = new MessageConsumer(queue, successfulMessages, failedMessages);
        Thread consumerThread = new Thread(consumer);
        consumerThread.start();
        consumerThread.join();

        assertEquals(2, successfulMessages.get());
        assertEquals(1, failedMessages.get());
    }
}
