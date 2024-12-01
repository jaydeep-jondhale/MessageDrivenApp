package org.app.consumer;

import lombok.RequiredArgsConstructor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Message consumer
 * -- listens to the queue and processes messages
 * -- here we are using blocking queue -
 * -- a realtime we can use a message broker like(Kafka,ActiveMQ,RabbitMQ etc) for MessageDrivenApplication
 */

@RequiredArgsConstructor
public class MessageConsumer implements Runnable{

    private final BlockingQueue<String> queue;
    private final AtomicInteger successfulMessages;
    private final AtomicInteger failedMessages;

    @Override
    public void run() {
        try {
            while (true){ // continue listen to queue
                // get Message from queue
                String message = queue.take();
                // if message  is END then stopping listener
                if ("END".equals(message)) break;

                if (processMessage(message)) {
                    // after processing if successfully processed then audit to success
                    successfulMessages.incrementAndGet();
                } else {
                    // after processing if failed in processing then audit to fail
                    failedMessages.incrementAndGet();
                }

            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean processMessage(String message) {
        // call actual service here to  perform operations on message
        // and save to database
        System.out.println("Consumed: " + message);
        return !message.contains("ERROR"); // failed for message containing 5
    }
}
