package qfx.util;

import qfx.QComponent;

import java.util.Random;

public class QMath extends QComponent {
    public final double PI = 3.14159265358979323846264338327950288;

    private static Random _rnd = new Random(System.currentTimeMillis());

    public static double random() {
        return _rnd.nextDouble();
    }

    public static int random(int min, int max) {
        return _rnd.nextInt(max + 1) % ((max + 1) - min + 1) + min;
    }

    public static double max(double a, double b) {
        return a > b ? a : b;
    }

    /**
     * use if case implement
     *
     * @param a double
     * @param b double
     * @param c double
     * @return double
     */
    public static double max(double a, double b, double c) {
        if (a >= b && a > c)
            return a;
        else if (b >= a && b > c)
            return b;
        else
            return c;
    }

    public static double max(double array[]) {
        double temp;

        if (array.length > 0)
            temp = array[0];
        else
            return 0;

        for (double d : array) {
            if (d > temp)
                temp = d;
        }

        return temp;
    }

    public static double min(double a, double b) {
        return a < b ? a : b;
    }

    /**
     * use min(double array[]) implement
     *
     * @param a double
     * @param b double
     * @param c double
     * @return double
     */
    public static double min(double a, double b, double c) {
        return min(new double[]{a, b, c});
    }

    public static double min(double array[]) {
        double temp;

        if (array.length > 0)
            temp = array[0];
        else
            return 0;

        for (double d : array) {
            if (d < temp)
                temp = d;
        }

        return temp;
    }

    /**
     * 判断质数
     *
     * @param num long
     * @return boolean
     */
    public static boolean isPrimeNumber(long num) {
        if (num == 2)
            return true;// 2特殊处理
        if (num < 2 || num % 2 == 0)
            return false;// 识别小于2的数和偶数
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) {// 识别被奇数整除
                return false;
            }
        }
        return true;
    }

    /**
     * 判断水仙花数
     *
     * @param input long
     * @return boolean
     */
    public static boolean isNarcissisticNumber(long input) {
        String str = String.valueOf(input);
        int len = str.length();
        int sum = 0;
        for (int i = 0; i < len; i++) {
            int temp = Integer.valueOf(str.substring(i, i + 1));
            sum += Math.pow(temp, len);
        }

        return (sum == input);
    }
}
