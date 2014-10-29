package sample;

import javax.servlet.http.HttpServlet;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by CM on 29.10.2014.
 */

public class Time extends HttpServlet{
    public static String getTime() {
        Date d1 = new Date();
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/YYYY HH:mm a");
        String formattedDate = df.format(d1);

        return formattedDate;
    }


}
