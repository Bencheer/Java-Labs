package criptlib;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.SynchronousQueue;

public class GetCriptData {
    public GetCriptData(String[] data, String[] key, String[] outC) throws UnsupportedEncodingException, InterruptedException {

        SynchronousQueue<String> st = new SynchronousQueue<String>();

        int maxLen = 0;
        if (data.length > key.length) {
            maxLen = data.length;
        } else {
            maxLen = key.length;
        }

        for (int i = 0; i < maxLen; i++) {
            RD d = new RD(st, data[i], key[i]);
            RK k = new RK(st);
            try {
                Thread.sleep(30);
            } catch (InterruptedException ie) {}
            d.stop();
            k.stop();
        }
    }
}
