package resh;

import kvurexception.kvUrException;

/**
 * Created by CM on 13.09.2014.
 */
public class Resh {
    public int a, b, c;
    public double tmp_descr;
    public double x1, x2;
    public Resh(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.tmp_descr = this.b*this.b - 4*this.a*this.c;
        try {
            if (tmp_descr < 0) {
                new kvUrException("Вычисление не возможно! т.к. нельзя извлекать корень из отрицательного числа!");
            } else if (this.a == 0) {
                new kvUrException("Вычисление не возможно! т.к. это не квадратное уравнение!");
            } else {
                double descr = Math.sqrt(this.b * this.b - 4 * this.a * this.c);
                this.x1 = (-this.b + descr) / (2 * this.a);
                this.x2 = (-this.b - descr) / (2 * this.a);
                System.out.println("Корень 1: " + x1);
                System.out.println("Корень 2: " + x2);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
