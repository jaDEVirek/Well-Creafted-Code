package StreamAPI;

import java.io.FileInputStream;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.function.Supplier;

public class SomeLambda {

    public static void main(String[] args) {
        final PrivilegedAction<Double> doublePrivilegedAction = () -> Math.random() * 100;
        final Supplier<Double> suppLierLambda = () -> Math.random() * 100;

        System.out.println(doublePrivilegedAction.run());
        System.out.println(suppLierLambda.get());

        ISomeValue iSomeValue = () -> 3.14;
        ISomeValue iSomeValueBody = () -> {
            int r = 1;
            for (int i = 1; i <= Math.random() * 2; i++) {
                r = i * r;
            }
            return r;
        };
        IGetAndReturn rewers = (str) -> {
            StringBuilder odtylu = new StringBuilder();
            for (int i = str.length() - 1; i >= 0; i--) {
                odtylu.append(str.charAt(i));
            }
            return odtylu.toString();
        };
        String res1 = strMetoda(String::toUpperCase, "Jakie litery?");
        System.out.println(res1);
        final String cos_dodajemy = strMetoda(rewers, "Cos dodajemy");
        System.out.println(cos_dodajemy);
        String res2 = strMetoda((str) -> {
            String odtylu = "";
            for (int i = str.length() - 1; i >= 0; i--) {
                odtylu += str.charAt(i);
            }
            return odtylu;
        }, "blok odwrocony");
        System.out.println(res2);

        final int[][] original = new int[][]{
                {1, 2, 3},
                {5, 6, 7},
                {9, 10, 11}};
        transposeMatrix(original);
        System.out.println(Arrays.deepToString(original));

        // variables in lambda
        ICounterGeneric<String> generics = (k, v) -> {
            int licznik = 0;
            for (String val : k) {
                if (val.equals(v)) licznik++;
            }
            return licznik;
        };
        final int a = generics.countInArray(new String[]{"a", "b", "c", "b", "a"}, "a");
        System.out.println(a);
        int generics2 = liczWystapienia(new Integer[]{1, 2, 3, 4, 5}, 2);
        ICounterGeneric<Integer> integer3 = SomeLambda::liczWystapienia;
        final int i = integer3.countInArray(new Integer[]{1, 5, 11, 13, 11, 2, 3, 4, 5}, 11);
        System.out.println(i);
    }

    public static String strMetoda(IGetAndReturn lambda, String s) {
        return lambda.manipulateString(s);
    }

    static <T> int liczWystapienia(T[] var, T v) {
        int licznik = 0;
        for (T t : var) {
            if (t.equals(v)) licznik++;
        }
        return licznik;
    }

    public static void transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = i + 1; j < cols; j++) {
               // System.out.println("Matrix: [" + i + "][" + j + "]");
                matrix[i][j] = matrix[i][j] + matrix[j][i];
                matrix[j][i] = matrix[i][j] - matrix[j][i];
                matrix[i][j] = matrix[i][j] - matrix[j][i];
            }
        }
    }
}


interface ISomeValue {
    // double calculateValue(double db);
    double getValue();
}

interface IGetAndReturn {
    String manipulateString(String str);
}

interface ICounterGeneric<T> {
    int countInArray(T[] arr, T obj);
}

