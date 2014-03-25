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
public class GameBasic  implements Serializable{

    /**
     * @param args the command line arguments
     */

    // TODO code application logic here
     List<Item> itemList = new ArrayList<>();

    {
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
        System.out.println("One time to generate this 81 cards!");

        for (int i = 1; i <= 81; i++) {
            System.out.println("set"+i+".png, "+itemList.get(i));
        }

        //  System.out.println("isSet? " + SetRule.IsSet(itemList.get(1), itemList.get(1), itemList.get(1)));
    }

    public String getInfo(int x){
        return itemList.get(x).toString();
    }
    
    public String getResult(int a, int b, int c){
       if ( SetRule.IsSet(itemList.get(a), itemList.get(b), itemList.get(c))){
           return "SET!";
       }else{
           return "---";
       }
        
        
      //  return itemList.get(x).toString();
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
