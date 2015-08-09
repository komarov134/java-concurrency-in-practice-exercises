package ru.neron.education.javaconcurrencyinpractiseexercises;

import java.util.concurrent.*;

/**
 * Created by neron on 09.08.15.
 */
public class Main {

    public static void main(String... args) {
        Mutable mutable = new Mutable();

        for (int i = 0; i < 100; i++) {
            new Thread(() -> mutable.a = 1).start();
            new Thread(() -> mutable.a = 2).start();
        }

        System.out.println(mutable.a);
    }
}
