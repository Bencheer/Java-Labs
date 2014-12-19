package main;

import criptlib.GetCriptData;
import criptlib.RD;
import criptlib.RK;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by CM on 19.12.2014.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException, UnsupportedEncodingException {
        String [] data = {"sdf,gl,kdf\\0", "11sd,sdfsd\\0", "2133,4253,425\\0"};
        String [] key = {"111,22,333\\0", "1sdf,sd1\\0", "1sdf3sdf45,34f,dh23\\0"};
        String [] outC = {};

        GetCriptData gcd = new GetCriptData(data, key, outC);
    }
}
