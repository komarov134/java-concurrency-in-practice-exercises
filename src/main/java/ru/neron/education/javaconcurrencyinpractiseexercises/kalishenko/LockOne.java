package ru.neron.education.javaconcurrencyinpractiseexercises.kalishenko;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created by neron on 09.08.15.
 */
// assume 2 only thread
// алгоритм Петерсона
public class LockOne {
    private volatile boolean[] flag = new boolean[2];
    private volatile int victim;

    public void lock() {
        int threadId = 1; // get thread id
//        int threadId = 0; // get thread id

        flag[threadId] = true; // want
        victim = threadId;  // уступаем другому потоку
        int anotherThreadId = 1 - threadId;
        while (flag[anotherThreadId] && victim == threadId) {}
    }

    public void unlock() {
        int threadId = 1; // get thread id
//        int threadId = 0; // get thread id

        flag[threadId] = false;
    }
}
