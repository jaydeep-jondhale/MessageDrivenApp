package org.app.init;

import org.app.consumer.MessageConsumer;
import org.app.producer.MessageProducer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;


public class MessageDrivenApp {
    private static final int DEFAULT_CAPACITY = 10;

    private final BlockingQueue<String> messageQueue = new LinkedBlockingQueue<>(DEFAULT_CAPACITY);
    private final AtomicInteger successfulMessages = new AtomicInteger(0);
    private final AtomicInteger failedMessages = new AtomicInteger(0);


    public void init() {
        MessageDrivenApp messageDrivenApp = new MessageDrivenApp();

        // creating two threads
        // produer and consumer
        Thread producer = new Thread(new MessageProducer(messageQueue), "ProducerThread");
        Thread consumer = new Thread(new MessageConsumer(messageQueue, successfulMessages, failedMessages), "ConsumerThread");

        producer.start();
        consumer.start();


        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {

            System.out.println("ERROR :: " + e.getMessage());
        }

        logDetails();

    }


    private void logDetails() {
        System.out.println("Logging Details :");
        System.out.println("Total successful messages: " + successfulMessages.get());
        System.out.println("Total failed messages: " + failedMessages.get());
    }


}
