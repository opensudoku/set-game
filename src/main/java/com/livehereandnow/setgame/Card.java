/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livehereandnow.setgame;

import set81.*;

/**
 *
 * @author mark
 */
public class Card {

    private int id;//1 to 81
    // 0000 -0
    // 0001 ->1
    // 0002 ->2
    // 0010 ->3
    // ....
    // 2221 ->79
    // 2222 ->80 2*27+2*9+2*3+2=54+18+6+2

    private final int value;//1,2,3
    private final int color;//1=Red, 2=Purple, 3=Green
    private final int shape;//1=Diamond, 2=    , 3=Wave
    private final int style;//1=Empty, 2=     , 3=

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

    private final String[] colorStr = {"红色", "紫色", "绿色"};
    private final String[] shapeStr = {"菱形", "椭圆", "波浪"};
    private final String[] styleStr = {"空心", "条纹", "实心"};
    private final String[] valueStr = {"1", "2", "3"};

    public Card(int color, int shape, int style, int value) {
        this.color = color;
        this.shape = shape;
        this.style = style;
        this.value = value;
        this.id = color * 27 + shape * 9 + style * 3 + value;
    }

    @Override
    public int hashCode(){
        return color * 27 + shape * 9 + style * 3 + value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Card other = (Card) obj;
        if (this.value != other.value) {
            return false;
        }
        if (this.color != other.color) {
            return false;
        }
        if (this.shape != other.shape) {
            return false;
        }
        if (this.style != other.style) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "["+colorStr[this.color] + "|"
                + shapeStr[this.shape] + "|"
                + styleStr[this.style] + "] "
                + valueStr[this.value];
    }
}
