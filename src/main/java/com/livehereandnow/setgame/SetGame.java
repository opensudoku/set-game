/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livehereandnow.setgame;

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
public class SetGame implements Serializable {

    /**
     * @param args the command line arguments
     */
    static int counter;
    static List<Card> cards = new ArrayList<>();

    {
        counter = 0;
        for (int color = 0; color <= 2; color++) {
            for (int shape = 0; shape <= 2; shape++) {
                for (int style = 0; style <= 2; style++) {
                    for (int value = 0; value <= 2; value++) {
                        cards.add(new Card(color, shape, style, value));
                    }
                }
            }
        }

        System.out.println("One time to generate this 81 cards!");

        for (int i = 0; i < 81; i++) {
            System.out.println("img" + i + ".png, " + cards.get(i));
        }

        //  System.out.println("isSet? " + SetRule.isGoodSet(cards.get(1), cards.get(1), cards.get(1)));
    }

    private List<Integer> randomSetList;
    private List<Card> goodSet; // 3 cards are good SET
//    private List<Integer> goodSet; // 3 cards are good SET
   // private List<Integer> goodSet;
    
    private Util util = new Util();

    public void incCounter() {
        counter++;
    }

    public String getCounter() {
        return "counter=" + counter;
    }

    public void doRandomCardNumberList() {
        Util util = new Util();
        randomSetList = util.getThreeCardsIndex();
    }

    public List<Integer> getRandomCardNumberList() {
        return randomSetList;
    }

    public void doGoodSet() {
        //   while (true) {

        for (int i = 0; i < 1000; i++) {
        //    goodSet = util.getThreeCardsIndex();
            goodSet=util.getThreeCards();

            if (SetRule.isGoodSet(goodSet)) {
                System.out.println(this.getCounter() + ", good set " + goodSet);
                break;
            } else {
                System.out.println("bad set " + goodSet + " , " + i);

            }
        }
        //       return;
        //    if (SetRule.IsGoodSet(goodSet)) {
        //        return;
        //   }
        //   }
    }

    public List<Card> getGoodSet() {
        return goodSet;
    }

    public String getInfo(int x) {
        return cards.get(x).toString();
    }

    public int getGoodSetCardA() {
        return goodSet.get(0).hashCode();
    }

    public int getGoodSetCardB() {
        return goodSet.get(1).hashCode();
    }

    public int getGoodSetCardC() {
        return goodSet.get(2).hashCode();
    }

    public String getGoodSetCard(int x) {
        return goodSet.get(0).toString() + "/" + goodSet.get(1).toString() + "/" + goodSet.get(2).toString();
    }

    public String getResult(int a, int b, int c) {
        if (SetRule.IsGoodSet(cards.get(a), cards.get(b), cards.get(c))) {
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

        boolean result = SetRule.IsGoodSet(cards.get(a), cards.get(b), cards.get(c));
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

        private static boolean isAllSameOrAllDifferent(int a, int b, int c) {
            if (isAllSame(a, b, c)) {
                return true;
            }
            if (isAllDifferent(a, b, c)) {
                return true;
            }
            return false;
        }

//        public static boolean IsGoodSet(List<Integer> x) {
//
//            Card t1 = cards.get(x.get(0));
//            Card t2 = cards.get(x.get(1));
//            Card t3 = cards.get(x.get(2));
//            return isGoodSet(t1, t2, t3);
//
//        }

        public static boolean isGoodSet(List<Card> cardx3) {
            
            return IsGoodSet(cardx3.get(0),cardx3.get(1),cardx3.get(2));
        }
        
        public static boolean IsGoodSet(Card t1, Card t2, Card t3) {
            if (!isAllSameOrAllDifferent(t1.getValue(), t2.getValue(), t3.getValue())) {
                return false;
            }

            if (!isAllSameOrAllDifferent(t1.getColor(), t2.getColor(), t3.getColor())) {
                return false;
            }
            if (!isAllSameOrAllDifferent(t1.getShape(), t2.getShape(), t3.getShape())) {
                return false;
            }

            if (!isAllSameOrAllDifferent(t1.getStyle(), t2.getStyle(), t3.getStyle())) {
                return false;
            }

            return true;
        }
    }

    private class Util implements Serializable {

        private List<Integer> randon3Cards;

        public void doRandom() {
            randon3Cards = getThreeCardsIndex();

        }

        public String getDebug() {
            return randon3Cards.get(0) + "/" + randon3Cards.get(0) + "/" + randon3Cards.get(0);
        }

        public List<Integer> getRandomCardNumberList() {
            return getThreeCardsIndex();
        }

        public List<Integer> getGoodSetIndexList() {
            List<Integer> x = getThreeCardsIndex();

            return x;

        }

        public List<Card> getThreeCards() {
            List<Card> cardx3 = new ArrayList<>();
            List<Integer> cardsIndex = getThreeCardsIndex();
            cardx3.add(cards.get(cardsIndex.get(0)));
            cardx3.add(cards.get(cardsIndex.get(1)));
            cardx3.add(cards.get(cardsIndex.get(2)));

            return cardx3;

        }

        public List<Integer> getThreeCardsIndex() {
            List<Integer> threeItemIndex = new ArrayList<>();

            Random rnd = new Random();
            int a = 0;
            int b = 0;
            int c = 0;
            do {
                a = rnd.nextInt(81);
                b = rnd.nextInt(81);
                c = rnd.nextInt(81);

            } while (a == b || b == c || c == a);
            threeItemIndex.add(a);
            threeItemIndex.add(b);
            threeItemIndex.add(c);

            return threeItemIndex;
        }

    }
}
