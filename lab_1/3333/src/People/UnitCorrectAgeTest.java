package People;

import WrongAgeValueException.WrongAgeValueException;
import org.junit.Test;
import person.Person;

import static org.junit.Assert.*;

public class UnitCorrectAgeTest {

    @Test
    public void testCheckValue() throws Exception {
        Person onePeople = new Person("Vasa", 20);
        assertNotNull(onePeople.age);
        if (onePeople.age > 18) {
            assertEquals(onePeople.age.longValue(), 20);
        } else {
            fail("onePeople -- Test is UNsuccess! *.age < 18");
        }
    }
}