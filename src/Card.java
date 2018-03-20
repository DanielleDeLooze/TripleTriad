/*
Author: Danielle DeLooze
Date: 3/14/2018
Purpose: Class to represent cards in the game "Triple Triad" from Final Fantasy VIII
 */

public class Card {

    public static final int A = 10;
    String name;
    int[] values = new int[4];
    char element;
    int level;
    int owner;

    public Card(String name, int[] values, char element, int level){
        this.name = name;
        this.values = values;
        this.element = element;
        this.level = level;
    }


    /*
    0 = left value
    1 = top value
    2 = right value
    3 = bottom value
     */
    public int left_value(){
        return values[0];
    }

    public int top_value(){
        return values[1];
    }

    public int right_value(){
        return values[2];
    }

    public int bottom_value(){
        return values[3];
    }

    public String get_name(){
        return this.name;
    }

    public int[] get_values(){
        return this.values;
    }

    public char get_element(){
        return this.element;
    }

    public void set_name(String name){
        this.name = name;
    }

    public void set_values(int[] values){
        this.values = values;
    }

    public void set_element(char element){
        this.element = element;
    }

    public void set_owner(int owner){
        this.owner = owner;
    }

    public int get_owner(){
        return this.owner;
    }

    public void flip_owner(){
        if(owner == 1){
            owner = 2;
        }
        else{
            owner = 1;
        }
    }


}
