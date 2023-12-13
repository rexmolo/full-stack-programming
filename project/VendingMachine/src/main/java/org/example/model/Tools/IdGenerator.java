package org.example.model.Tools;

import java.util.concurrent.atomic.AtomicInteger;

public class IdGenerator {

//    private static AtomicInteger pid = new AtomicInteger(1);
    private static int pid;

//    public IdGenerator() {
//        pid.incrementAndGet();
//    }

    public static int genId() {
        return ++pid;
    }
}
