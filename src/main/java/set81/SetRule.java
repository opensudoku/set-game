/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package set81;

/**
 *
 * @author mark
 */
public class SetRule {

    private static boolean isAllSame(int a, int b, int c) {
//        System.out.println("isAllSame "+a+b+c);
        if ((a == b) && (b == c)) { // no need to check c==a 
            return true;
        }
        return false;
    }

    private static boolean isAllDifferent(int a, int b, int c) {
        if ((a != b) && (b != c) && (c != a)) {
            return true;
        }
        return false;
    }

    private static boolean isOk(int a, int b, int c) {
        if (isAllSame(a, b, c)) {
            return true;
        }
        if (isAllDifferent(a, b, c)) {
            return true;
        }
        return false;
    }

    public static boolean IsSet(Item t1, Item t2, Item t3) {
        if (!isOk(t1.getValue(), t2.getValue(), t3.getValue())) {
            return false;
        }

        if (!isOk(t1.getColor(), t2.getColor(), t3.getColor())) {
            return false;
        }
        if (!isOk(t1.getShape(), t2.getShape(), t3.getShape())) {
            return false;
        }

        if (!isOk(t1.getStyle(), t2.getStyle(), t3.getStyle())) {
            return false;
        }

        return true;
    }
}
