import java.util.ArrayList;

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

    public void print_available_card(){
        for(int i = 0; i < 5; i++){
            if(cards[i] != null) {
                System.out.print(i + ". " + cards[i].get_name() + "\t[");
                for(int value: cards[i].values){
                    System.out.print(value+",");
                }
                System.out.println("]");
            }
        }
    }
}
