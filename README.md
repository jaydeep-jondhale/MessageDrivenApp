# Producer-Consumer Application

## Description

This is a simple message-driven application implemented in core Java to simulate a producer-consumer scenario using a message queue. The application tracks and logs the total number of messages processed successfully and those that encountered errors.

The project includes unit tests to verify both success and failure scenarios.

---

## Features

- **Producer-Consumer Pattern**: Implements producer and consumer threads communicating via a thread-safe queue (`LinkedBlockingQueue`).
- **Error Handling**: Simulates error conditions for demonstration purposes.
- **Logging**: Tracks and logs the count of successful and failed message processing.
- **Unit Testing**: Includes test cases for both successful and failed message processing.

---

## Prerequisites

- **Java Development Kit (JDK)**: Version 8 or later.
- **Build Tool**:  Maven
- **JUnit **: For executing test cases.

---

## Instructions

### 1. Open Application in any IDE (e.g., IntelliJ IDEA, Ecl) 

Open main class and run:

View Output : 
The application logs the following to the console:

Produced messages by the producer.
Consumed messages and error simulation in the consumer.
Details of total successful and failed messages.

### Run Unit Tests
```bash
mvn test
```


