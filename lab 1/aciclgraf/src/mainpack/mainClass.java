package mainpack;

import checknull.CheckNullMatr;
import chekciclingraf.CheckCicle;

/**
 * Created by CM on 26.09.2014.
 */
public class mainClass {
    public static void main(String[] args) {
        int arr[][] = new int[][]{  {0, 1, 1, 1, 0, 1, 0},
                                    {0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 1},
                                    {0, 0, 0, 0, 0, 1, 1},
                                    {0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0},
                                 };


//        int kSort = 0;
//        for (int i=0;i<arr.length;i++){
//            int k = 0;
//            int k1 = 0;
//            int nomStr = 0;
//            int nomStolb = 0;
//            for (int j=0;j<arr[0].length;j++) {
//                // если есть строка == 0
//                boolean f = (arr[i][j] == 0);
//                if (f) {
//                    k++;
//                    if (k == arr.length) {
//                        nomStr = i;
//                        System.out.println("str " + nomStr);
//                    }
//                }
//
//                // если в столбце все ноли
//                boolean t = arr[j][i] == 0;
//                if (t) {
//                    k1++;
//                    if (k1 == arr.length) {
//                        nomStolb = i;
//                        System.out.println("stolb " + nomStolb);
//                        for (int g = 0; g < arr.length; g++) {
//                            arr[nomStolb][g] = 0;
//                        }
//                    }
//                }
//            }
//            if (k == arr.length) {
//                for (int c = 0; c < arr[0].length; c++)
//                arr[nomStr][c] = 0;
//            }
//        }

        // проверить матрицу на нулевость
//        int kol = 0;
//        for (int i=0;i<arr.length;i++) {
//            for (int j = 0; j < arr[0].length; j++) {
//                if (arr[i][j] == 0) {
//                    kol++;
//                }
//            }
//        }
//        try {
//            if (kol == arr.length * arr[0].length) {
//                // добавить вершину
//                System.out.println("Вершина добавлена!");
//            } else {
//                // выкинуть исключение
//                new NotSetV("Невозможно добавить вершину, образуется цикл!");
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//
//        for (int i=0;i<arr.length;i++) {
//            for (int j = 0; j < arr[0].length; j++) {
//                System.out.print(arr[i][j]);
//            }
//            System.out.println();
//        }

        new CheckCicle(arr);
        new CheckNullMatr(arr);
    }
}
