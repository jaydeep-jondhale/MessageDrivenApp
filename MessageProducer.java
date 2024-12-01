package org.app.producer;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.BlockingQueue;

@RequiredArgsConstructor
public class MessageProducer implements Runnable {
    private final BlockingQueue<String> queue;

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                // producing 10 messages
                String message = "This is ";
                if (i % 3 == 0) {
                    message += "ERROR message";
                } else {
                    message += "Message";
                }
                // Add message to the queue
                queue.put(message);
                System.out.println("Produced: " + message);
                Thread.sleep(100); // Simulate time taken to produce
            }
            // // End signal to stop processing
            queue.put("END");
        } catch (InterruptedException e) {
            System.err.println(" Error: " + e.getMessage());
        }
    }
}
