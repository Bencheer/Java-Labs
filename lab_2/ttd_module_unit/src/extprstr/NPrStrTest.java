package extprstr;

import exceptionsprstr.ExceptionOfExistsFile;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class NPrStrTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

   @Test
    public void OutPutMatToOut() throws InterruptedException {
        Map<Integer, String> a = new HashMap<Integer, String>();
        a.put(1, "1");
        a.put(2, "2");
        a.put(3, "3");
        a.put(4, "4");
        a.put(5, "5");
        a.put(6, "6");

        // вывод мапы в поток
       NPrStr out = new NPrStr(outContent);

       out.OutPutMap(a);

       assertNotNull(out.toString()); // проверка на неNULL
        assertEquals(a.toString(), outContent.toString());
       out.close();
    }

    @Test
    public void FormatPrStr() {
        NPrStr out = new NPrStr(outContent);
        String s = "Yo!";
        out.format("%s", s);

        assertEquals(s.toString(), outContent.toString());
        out.close();
    }

    @Test
    public void AppendPrStr() {
        NPrStr out = new NPrStr(outContent);
        String ss = "aaa";
        out.append("aaa");
        assertEquals(ss.toString(), outContent.toString());
    }

}