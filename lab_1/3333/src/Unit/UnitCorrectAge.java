package Unit;

import People.People;
import org.junit.Test;
import person.Person;

/**
 * Created by CM on 13.09.2014.
 */
public class UnitCorrectAge {
    void checkValue(Integer a) {
        if (a > 18) {
            System.out.println("Test Success!  This age > 18!");
        } else {
            System.out.println("Test UNsuccess! This age < 18!");
        }
    }

    public UnitCorrectAge(Integer a) {
        System.out.println("Simple test: ");
        checkValue(a);
        System.out.println("JUnit test: ");
        ttTest(a);
    }

    @Test
    public void ttTest(Integer a) {
        if (a > 18) {
            System.out.println("Test Success!  This age > 18!");
        } else {
            System.out.println("Test UNsuccess! This age < 18!");
        }
    }
}
