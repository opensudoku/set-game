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

/**
 *
 * @author mark
 */
@Named
@SessionScoped
public class GameUtil implements Serializable{

   
    private List<Integer> randon3Cards;

    public void doRandom(){
        randon3Cards=getThreeItemIndexList();
        
        
    }

    public String getDebug(){
        return randon3Cards.get(0)+"/"+randon3Cards.get(0)+"/"+randon3Cards.get(0);
    }
    public List<Integer> getRandomCardNumberList(){
        return getThreeItemIndexList();
    }
   
    
    public String getSomething(){
       List<Integer> list= get3RandomItemIndex();
        return list.get(0)+"/"+list.get(1)+"/"+list.get(2);
    }
    
    
    public  List<Integer> getThreeItemIndexList() {
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
    
    public static List<Integer> get3RandomItemIndex() {
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
