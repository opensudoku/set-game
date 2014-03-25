/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package set81;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 *
 * @author mark
 */
@Named
@Singleton
public class SetByMark implements Serializable {

    /**
     * @param args the command line arguments
     */
    // TODO code application logic here
    static List<Card> cards = new ArrayList<>();
    static int timer;
    {
        timer=0;
        int id = 0;
        cards.add(new Card(0, 0, 0, 0, 0));
        for (int p2 = 1; p2 <= 3; p2++) {
            for (int p3 = 1; p3 <= 3; p3++) {
                for (int p4 = 1; p4 <= 3; p4++) {
                    for (int p1 = 1; p1 <= 3; p1++) {
                        //itemList.add(new Item(1,1,1,1,1));
                        cards.add(new Card(++id, p1, p2, p3, p4));

                    }
                }
            }
        }
        // for( <Item> x: item){
        System.out.println("One time to generate this 81 cards!");

        for (int i = 1; i <= 81; i++) {
            System.out.println("set" + i + ".png, " + cards.get(i));
        }

        //  System.out.println("isSet? " + SetRule.IsSet(cards.get(1), cards.get(1), cards.get(1)));
    }
    
    
    private List<Integer> randomSetList;
    private List<Integer> goodSetList;
    private Util util = new Util();

    
    public void incCounter(){
        timer++;
    }
    public String getCounter(){
        return "counter="+timer;
    }
    public void doRandomCardNumberList() {
        Util util = new Util();
        randomSetList = util.getThreeItemIndexList();
    }

    public List<Integer> getRandomCardNumberList() {
        return randomSetList;
    }

    public void doGoodSet() {
        //   while (true) {

        for (int i = 0; i < 1000; i++) {
            goodSetList = util.getThreeItemIndexList();

            if (SetRule.IsGoodSet(goodSetList)) {
                System.out.println(this.getCounter()+ ", good set " + goodSetList);
                break;
            } else {
//                System.out.println("bad set " + goodSetList + " , " + i);

            }
        }
        //       return;
        //    if (SetRule.IsGoodSet(goodSetList)) {
        //        return;
        //   }
        //   }
    }

    public List<Integer> getGoodSet() {
        return goodSetList;
    }

    public String getInfo(int x) {
        return cards.get(x).toString();
    }

    public int getGoodSetCardA() {
        return goodSetList.get(0);
    }
public int getGoodSetCardB() {
        return goodSetList.get(1);
    }
public int getGoodSetCardC() {
        return goodSetList.get(2);
    }

    
    public String getGoodSetCard(int x) {
        return goodSetList.get(0).toString()+"/"+goodSetList.get(1).toString()+"/"+goodSetList.get(2).toString();
    }

    public String getResult(int a, int b, int c) {
        if (SetRule.IsSet(cards.get(a), cards.get(b), cards.get(c))) {
            return "SET!";
        } else {
            return "---";
        }

        //  return cards.get(x).toString();
    }

    public boolean training(List<Integer> list) {
        return training(list.get(0), list.get(1), list.get(2));
    }

    public boolean training(int a, int b, int c) {
        System.out.println(cards.get(a));
        System.out.println(cards.get(b));
        System.out.println(cards.get(c));

        boolean result = SetRule.IsSet(cards.get(a), cards.get(b), cards.get(c));
        System.out.println("Is it Set? " + result);
        System.out.println();
        return result;

    }

    static class SetRule {

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

        public static boolean IsGoodSet(List<Integer> x) {

            Card t1 = cards.get(x.get(0));
            Card t2 = cards.get(x.get(1));
            Card t3 = cards.get(x.get(2));
            return IsSet(t1, t2, t3);

        }

        public static boolean IsSet(Card t1, Card t2, Card t3) {
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

    private class Util implements Serializable {

        private List<Integer> randon3Cards;

        public void doRandom() {
            randon3Cards = getThreeItemIndexList();

        }

        public String getDebug() {
            return randon3Cards.get(0) + "/" + randon3Cards.get(0) + "/" + randon3Cards.get(0);
        }

        public List<Integer> getRandomCardNumberList() {
            return getThreeItemIndexList();
        }

        public String getSomething() {
            List<Integer> list = get3RandomItemIndex();
            return list.get(0) + "/" + list.get(1) + "/" + list.get(2);
        }

        public List<Integer> getGoodSetIndexList() {
            List<Integer> x = getThreeItemIndexList();

            return x;

        }

        public List<Integer> getThreeItemIndexList() {
            List<Integer> threeItemIndex = new ArrayList<>();

            Random rnd = new Random();
            int a = 0;
            int b = 0;
            int c = 0;

//        int minIndex = 50;
//        int maxIndex = 50;
//        for (int i = 0; i <= 1000; i++) {
//            a = 1 + rnd.nextInt(81);
//            if (a < minIndex) {
//                minIndex = a;
//            }
//            if (a > maxIndex) {
//                maxIndex = a;
//            }
//            System.out.println(a + " ");
//        }
//        System.out.println("Min Index=" + minIndex);
//        System.out.println("Max Index=" + maxIndex);
            do {
                a = 1 + rnd.nextInt(81);
                b = 1 + rnd.nextInt(81);
                c = 1 + rnd.nextInt(81);

            } while (a == b || b == c || c == a);
            threeItemIndex.add(a);
            threeItemIndex.add(b);
            threeItemIndex.add(c);

            return threeItemIndex;
        }

        public List<Integer> get3RandomItemIndex() {
            List<Integer> threeItemIndex = new ArrayList<>();

            Random rnd = new Random();
            int a = 0;
            int b = 0;
            int c = 0;

//        int minIndex = 50;
//        int maxIndex = 50;
//        for (int i = 0; i <= 1000; i++) {
//            a = 1 + rnd.nextInt(81);
//            if (a < minIndex) {
//                minIndex = a;
//            }
//            if (a > maxIndex) {
//                maxIndex = a;
//            }
//            System.out.println(a + " ");
//        }
//        System.out.println("Min Index=" + minIndex);
//        System.out.println("Max Index=" + maxIndex);
            do {
                a = 1 + rnd.nextInt(81);
                b = 1 + rnd.nextInt(81);
                c = 1 + rnd.nextInt(81);

            } while (a == b || b == c || c == a);
            threeItemIndex.add(a);
            threeItemIndex.add(b);
            threeItemIndex.add(c);

            return threeItemIndex;
        }
    }
}
