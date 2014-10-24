package chekciclingraf;

import checknull.CheckNullMatr;

/**
 * Created by CM on 26.09.2014.
 */
public class CheckCicle {
    public CheckCicle(int a[][]) {
        for (int i=0;i<a.length;i++){
            int k = 0;
            int k1 = 0;
            int nomStr = 0;
            int nomStolb = 0;
            for (int j=0;j<a[0].length;j++) {
                // если есть строка == 0
                boolean f = (a[i][j] == 0);
                if (f) {
                    k++;
                    if (k == a.length) {
                        nomStr = i;
                        System.out.print("str=" + nomStr + "; ");
                    }
                }

                // если в столбце все ноли
                boolean t = a[j][i] == 0;
                if (t) {
                    k1++;
                    if (k1 == a.length) {
                        nomStolb = i;
                        System.out.print("stolb=" + nomStolb);
                        for (int g = 0; g < a.length; g++) {
                            a[nomStolb][g] = 0;
                        }
                    }
                }
            }
            if (k == a.length) {
                for (int c = 0; c < a[0].length; c++)
                    a[nomStr][c] = 0;
            }
            System.out.println();
        }
    }
}
