package person;

import Unit.UnitCorrectAge;
import WrongAgeValueException.WrongAgeValueException;

import java.util.Scanner;

/**
 * Created by CM on 13.09.2014.
 */
public class Person {
    public Integer age;
    public String name;
    public Person(String name, Integer a) {
        try {
            if (a > 18) {
                setAge(a);
                System.out.println("Name: " + name + " Age: " + age);
            } else {
                throw new WrongAgeValueException("No! Age < 18!");
            }
            System.out.println("----------------------------------------------");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setAge(Integer age) {
            this.age = age;
    }
}
