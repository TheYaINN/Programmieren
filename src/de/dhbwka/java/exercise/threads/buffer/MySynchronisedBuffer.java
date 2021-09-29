package de.dhbwka.java.exercise.threads.buffer;

import java.util.LinkedList;

public class MySynchronisedBuffer {
    private LinkedList<Integer> values = new LinkedList<>();
    private boolean empty = true;
    private boolean full = false;
    private final int MAX_SIZE = 3;

    MySynchronisedBuffer() {
    }

    public synchronized void put(int v) {
        if (!empty || full) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        values.add(v);
        this.notify();
        System.out.println("PUT: " + v);
    }

    public synchronized int get() {
        int v;
        if (empty) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        v = this.values.pop();
        if (values.size() == 0) {
            empty = true;
        }
        full = (values.size() >= MAX_SIZE) ? true : false;
        this.notify();
        System.out.println("Get: " + v);
        return v;
    }

    public static void main(String[] args) {
        MySynchronisedBuffer msb = new MySynchronisedBuffer();

        ProducerThread pt = new ProducerThread(msb);
        pt.start();

        ConsumerThread ct = new ConsumerThread(msb);
        ct.start();


    }

    static class ProducerThread extends Thread {
        MySynchronisedBuffer buf;

        public ProducerThread(MySynchronisedBuffer b) {
            this.buf = b;
        }

        public void run() {
            try {
                for (int i = 0; i < 100; i++) {
                    buf.put((int) (Math.floor(Math.random() * 6) + 1));
                    sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class ConsumerThread extends Thread {
        MySynchronisedBuffer buffer;

        public ConsumerThread(MySynchronisedBuffer b) {
            this.buffer = b;
        }

        public void run() {
            try {
                for (int i = 0; i < 100; i++) {
                    buffer.get();
                    sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
