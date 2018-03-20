import java.util.ArrayList;
import java.util.Arrays;

/*
Author: Danielle DeLooze
Date: 3/14/2018
Purpose: class to represent a player for the game "Triple Triad" from Final Fantasy VII
 */
public class Player {
    Card[] cards;
    int score;
    int label;

    public Player(int label){
        cards = new Card[5];
        this.score = 5;
        this.label = label;
    }

    public Player(Card[] cards, int label){
        this.cards = cards;
        this.score = 5;
        this.label = label;
    }
    public int getScore() {
        return score;
    }

    public Card play_card(int index){
        Card card = cards[index];
        cards[index] = null;
        return card;
    }

    public Card get_card(int index){
        return cards[index];
    }

    public Card[] getCards() {
        return cards;
    }

    public int getLabel() {
        return label;
    }

    //print all available cards. Number displayed will be the index number
    public void print_available_card(){
        for(int i = 0; i < 5; i++){
            if(cards[i] != null) {
                System.out.println(i + ". " + cards[i].get_name() + "\t"+ Arrays.toString(cards[i].values));
            }
        }
    }

    public Player copy(){ //copy of player without reference to the original
        Player temp = new Player(this.label);
        temp.score = this.score;
        for(int i = 0; i < 5; i++){
            if(this.cards[i] != null) {
                temp.cards[i] = this.cards[i].copy();
            }
        }
        return temp;
    }
}
