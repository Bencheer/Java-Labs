package exceptionsprstr;

import java.io.File;

/**
 * Created by CM on 27.09.2014.
 */
public class ExceptionOfExistsFile extends Exception {
    public boolean CheckFileExist(String path) {
        if ((new File(path)).exists()) {
            return true;
        } else {
            return false;
        }
    }

    public ExceptionOfExistsFile() {
        super("Файл не существует!");
    }

    public ExceptionOfExistsFile(boolean f) {
        if (!f) {
            new ExceptionOfExistsFile();
        }
    }
}
