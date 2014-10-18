package main;

import org.junit.Test;
import resh.Resh;

import static org.junit.Assert.*;

public class MainTest extends Main {
    @Test
    public void checkParametrs() {
        Resh test1 = new Resh(1, 3, 2);
        int k = 0;
        if (test1.a != 0) {
            k++;
        } else {
            fail();
        }

        if (test1.tmp_descr > 0) {
            k++;
        } else {
            fail();
        }

        if (k == 2) {
            assertEquals(-1.0, test1.x1, test1.x1);
        }
    }
}