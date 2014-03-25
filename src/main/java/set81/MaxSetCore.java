/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package set81;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author mark
 */
public class MaxSetCore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random rnd = new Random();

        MaxSetCore maxSetCore = new MaxSetCore();

        maxSetCore.init();
        maxSetCore.training(1, 2, 3);
        maxSetCore.training(1, 2, 4);
        maxSetCore.training(1, 4, 7);

        int rndCnt=0;
        List list = GameUtil.get3RandomItemIndex();
        //  System.out.println("List=" + list);
        while (!maxSetCore.training(list)){
          System.out.println("Random try #" + (++rndCnt));
            
            list = GameUtil.get3RandomItemIndex();
        };

    }
    // TODO code application logic here
    List<Item> itemList = new ArrayList<>();

    public void init() {
        int id = 0;
        itemList.add(new Item(0, 0, 0, 0, 0));
        for (int p2 = 1; p2 <= 3; p2++) {
            for (int p3 = 1; p3 <= 3; p3++) {
                for (int p4 = 1; p4 <= 3; p4++) {
                    for (int p1 = 1; p1 <= 3; p1++) {
                        //itemList.add(new Item(1,1,1,1,1));
                        itemList.add(new Item(++id, p1, p2, p3, p4));

                    }
                }
            }
        }
        // for( <Item> x: item){
        for (int i = 1; i <= 81; i++) {
            //        System.out.println(itemList.get(i));
        }

        //  System.out.println("isSet? " + SetRule.IsSet(itemList.get(1), itemList.get(1), itemList.get(1)));
    }

    public boolean training(List<Integer> list) {
        return training(list.get(0), list.get(1), list.get(2));
    }

    public boolean training(int a, int b, int c) {
        System.out.println(itemList.get(a));
        System.out.println(itemList.get(b));
        System.out.println(itemList.get(c));

        boolean result = SetRule.IsSet(itemList.get(a), itemList.get(b), itemList.get(c));
        System.out.println("Is it Set? " + result);
        System.out.println();
        return result;

    }

}
