package exceptionIsVNotSet;

/**
 * Created by CM on 26.09.2014.
 */
public class NotSetV extends Exception{
    public NotSetV() {
        super("Граф ациклический!");
    }

    public NotSetV(String s) {
        super(s);
    }
}
