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
public class Item {
    private int id;//1 to 81
    private int value;//1,2,3
    private int color;//1=Red, 2=Purple, 3=Green
    private int shape;//1=Diamond, 2=    , 3=Wave
    private int style;//1=Empty, 2=     , 3=

    public int getValue() {
        return value;
    }

    public int getColor() {
        return color;
    }

    public int getShape() {
        return shape;
    }

    public int getStyle() {
        return style;
    }
 
    
    private String[] colorStr={"","红色","紫色","绿色"};
    private String[] shapeStr={"","菱形","椭圆","波浪"};
    private String[] styleStr={"","空心","条纹","实心"};

    public Item(int id,int value, int color, int shape, int style) {
        this.id = id;
        this.value = value;
        this.color = color;
        this.shape = shape;
        this.style = style;
    }
    
    public String toStringDebug(){
        return "["+id+"]"+color+shape+style+"-"+value+" "
                +colorStr[this.color]
                +shapeStr[this.shape]
                +styleStr[this.style]
                +value;
    }
    
       
    public String toString(){
        return colorStr[this.color]+"/"
                +shapeStr[this.shape]+"/"
                +styleStr[this.style]+"/"
                +value;
    }
}
