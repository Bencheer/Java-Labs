package criptlib;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.SynchronousQueue;

public class RD implements Runnable {
    private SynchronousQueue<String> st;
    private Thread read;
    private String data = "";
    private String keyForD = "";
    private String cript = "";

    public RD(SynchronousQueue<String> st, String data, String keyForD) throws InterruptedException, UnsupportedEncodingException {
        this.st = st;
        this.data = readData(data);
        this.keyForD = readKey(keyForD);
        this.cript = criptString();
        read = new Thread(this);
        read.start();
    }

    private String readData(String data) throws InterruptedException {
        if (data.length() == 0) {
            return null;
        }

        char[] d = data.toCharArray();
        int k = 0;
        for (int i = 0; i < d.length; i++) {
            if (i != d.length - 1) {
                if (d[i] == '\\' && d[i + 1] == '0') {
                    k = i;
                    break;
                }
            }
        }

        if (k == 0) {
            return null;
        } else {
            this.data = data.substring(0, k);
        }
        return  this.data;
    }

    private String readKey(String key) throws InterruptedException {
        if (key.length() == 0) {
            return null;
        }

        char[] k = key.toCharArray();
        int m = 0;
        for (int i = 0; i < k.length; i++) {
            if (i != k.length - 1) {
                if (k[i] == '\\' && k[i + 1] == '0') {
                    m = i;
                    break;
                }
            }
        }

        if (m == 0) {
            return null;
        } else {
            this.keyForD = key.substring(0, m);
        }
        return  this.keyForD;
    }

    private String criptString() throws UnsupportedEncodingException {
        String tmpCript = "";

        String [] data = this.data.split(",");
        String [] key = this.keyForD.split(",");

        int maxLength = 0;
        if (data.length > key.length) {
            maxLength = data.length;
        } else {
            maxLength = key.length;
        }

        for (int j = 0; j < maxLength; j++) {
            int len = 0;

            if (data[j].length() > key[j].length()) {
                len = key[j].length();
                data[j] = data[j].substring(0, len);
            } else {
                len = data[j].length();
                key[j] = key[j].substring(0, len);
            }

            byte [] outC = new byte[len];

            for (int i = 0; i < len; i++) {
                byte[] d = data[j].getBytes();
                byte[] k = key[j].getBytes();

                outC[i] = (byte) (d[i]^k[i]);
            }

            tmpCript += new String(outC, "UTF-8") + ",";
        }

        this.cript = tmpCript;
        return this.cript;
    }

    public void run() {
        Thread th = Thread.currentThread();
        while (cript == null) {}
        try {
            st.put(this.cript);
            cript = null;
        } catch (InterruptedException ie) {}
          catch (IllegalMonitorStateException ex) {}
    }

    public void stop() {
        this.read = null;
    }
}
