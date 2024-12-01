package org.app;

import org.app.init.MessageDrivenApp;

public class Main {
    public static void main(String[] args) {
        MessageDrivenApp messageDrivenApp = new MessageDrivenApp();
        messageDrivenApp.init();
    }
}