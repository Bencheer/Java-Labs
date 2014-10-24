package checknull;

import exceptionIsVNotSet.NotSetV;

/**
 * Created by CM on 26.09.2014.
 */
public class CheckNullMatr {
    public CheckNullMatr(int a[][]) {
        int kol = 0;
        for (int i=0;i<a.length;i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] == 0) {
                    kol++;
                }
            }
        }
        try {
            if (kol == a.length * a[0].length) {
                // добавить вершину
                System.out.println("Вершина добавлена!");
            } else {
                // выкинуть исключение
                throw new NotSetV("Невозможно добавить вершину, образуется цикл!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
