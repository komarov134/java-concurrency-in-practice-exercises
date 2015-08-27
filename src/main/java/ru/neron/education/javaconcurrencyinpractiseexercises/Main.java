package ru.neron.education.javaconcurrencyinpractiseexercises;

import java.util.concurrent.*;

/**
 * Created by neron on 09.08.15.
 */
public class Main {

    int x = 0;
    int y = 0;

    public Main(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public static void main(String... args) {
        Main point = new Main(0, 0);

        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                int x = point.getX();
                int y = point.getY();
                if (x != y) {
                    System.err.printf("O_o %d %d \n", x, y);
                }
            }
        }).start();

        for (int i = 0; i < 2_000; i++) {
            for (int j = 0; j < 100; j++) {
                point.setX(j);
                point.setY(j);
            }
        }
    }
}
