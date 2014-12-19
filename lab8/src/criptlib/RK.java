package criptlib;

import java.util.concurrent.SynchronousQueue;

public class RK implements Runnable {

    private SynchronousQueue<String> st;
    private Thread key;

    public RK(SynchronousQueue<String> st) throws InterruptedException {
        this.st = st;
        key = new Thread(this);
        key.start();
    }

    public void run() {
        int t = 0;
        Thread th = Thread.currentThread();

        try {
            while (key == th) {
                System.out.println("GOT:" + st.take());
            }
        } catch (InterruptedException ie) {}
    }

    public void stop() {
        this.key = null;
    }
}
