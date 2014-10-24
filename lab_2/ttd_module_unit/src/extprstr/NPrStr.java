package extprstr;

import java.io.*;
import java.util.Map;

/**
 * Created by CM on 27.09.2014.
 */
public class NPrStr extends PrintStream {

    public NPrStr(OutputStream out) {
        super(out);
    }

    public void OutPutMap(Map m)  {
        super.print(m);
    }


}
