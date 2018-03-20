import java.util.HashSet;
import java.util.Scanner;

/*
Author: Danielle DeLooze
Date: 3/14/2018
Purpose: Class to represent the board in the game "Triple Triad" from Final Fantasy VIII. It's a 3x3 board of cards
 */
public class Board {

    Card[][] board;
    Player current_player;
    Player player_one;
    Player player_two;
    HashSet<String> rules;

    public Board(Player one, Player two){
        board = new Card[3][3];
        this.player_one = one;
        this.player_two = two;
        double random = Math.random();
        if(random > .5){
            current_player = player_one;
        }
        else{
            current_player = player_two;
        }
        rules = new HashSet<String>();
        rules.add("Open");
    }

    public Board(Board board){ //used to create a copy of a board without reference to the original
        this.board = new Card[3][3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board.board[i][j] != null) {
                    this.board[i][j] = board.board[i][j].copy();
                }
            }
        }
        this.current_player = board.current_player.copy();
        this.player_one = board.player_one.copy();
        this.player_two = board.player_two.copy();
        //this.rules = board.rules;
    }

    public Player get_next(){
        return this.current_player;
    }

    public int[] get_position(){
        boolean filled = true;
        Scanner scan = new Scanner(System.in);
        int[] pos = new int[2];
        while(filled) { //make sure the given position is actually empty
            pos[0] = scan.nextInt();
            pos[1] = scan.nextInt();
            if(board[pos[0]][pos[1]] != null){
                System.out.println("This position is already taken. Please choose a different spot");
            }
            else{
                filled = false;
            }
        }
        return pos;
    }

    /*
    if this returns 0, it means there was a draw
    return 1 if player 1 wins, return 2 if player 2 wins
     */
    public int get_winner(){
        if(player_one.getScore() < player_two.getScore()){
            return 2;
        }
        else if(player_one.getScore() > player_two.getScore()){
            return 1;
        }
        else{
            return 0;
        }
    }

    public void set_card(int i, int j, Card card){
        board[i][j] = card;
    }

    public void play_card(int i, int j, Card card){
        card.set_owner(this.current_player.label);
        board[i][j] = card;
        check_flips(i,j);
        flip_player();
    }

    /*
    Checks if adjacent cards to played one are owned by the other player. If they are, it checks to see if the current one has high enough values to flip it.
     */
    public void check_flips(int i, int j){
        //Card placed first row
        if( (i == 0) && (board[i+1][j] != null) && (opposite_owner(i+1,j))){
            if(board[i][j].bottom_value() > board[i+1][j].top_value()){
                board[i+1][j].flip_owner();
                current_player_scores();
            }
        }
        //Card placed in Second row
        if( i == 1){
            if(board[i-1][j] != null && opposite_owner(i-1,j)){
                if(board[i][j].top_value() > board[i-1][j].bottom_value()){
                    board[i-1][j].flip_owner();
                    current_player_scores();
                }
            }
            if(board[i+1][j] != null && opposite_owner(i+1,j)){
                if(board[i][j].bottom_value() > board[i+1][j].top_value()){
                    board[i+1][j].flip_owner();
                    current_player_scores();
                }
            }
        }
        //Card placed in third row
        if((i==2) && (board[i-1][j] != null) && (opposite_owner(i-1,j))){
            if(board[i][j].top_value() > board[i-1][j].bottom_value()){
                board[i-1][j].flip_owner();
                current_player_scores();
            }
        }

        //Card placed in first column
        if( (j == 0) && (board[i][j+1] != null) && (opposite_owner(i,j+1))){
            if(board[i][j].right_value() > board[i][j+1].left_value()){
                board[i][j+1].flip_owner();
                current_player_scores();
            }
        }
        //Card placed in second column
        if( j == 1){
            if(board[i][j-1] != null && opposite_owner(i,j-1)){
                if(board[i][j].left_value() > board[i][j-1].right_value()){
                    board[i][j-1].flip_owner();
                    current_player_scores();
                }
            }
            if(board[i][j+1] != null && opposite_owner(i,j+1)){
                if(board[i][j].right_value() > board[i][j+1].left_value()){
                    board[i][j+1].flip_owner();
                    current_player_scores();
                }
            }
        }
        //Card place in third column
        if((j == 2) && (board[i][j-1] != null) && (opposite_owner(i,j-1))){
            if(board[i][j].left_value() > board[i][j-1].right_value()){
                board[i][j-1].flip_owner();
                current_player_scores();
            }
        }
    }

    // Returns true if the given card's owner is not the current player (can be flipepd)
    public boolean opposite_owner(int i, int j){
        int card_owner = board[i][j].get_owner();
        if(card_owner != current_player.getLabel()){
            return true;
        }
        else{
            return false;
        }
    }

    //current player flips a card. Subtract 1 from other player, Add 1 to current player
    public void current_player_scores(){
        if(current_player.getLabel() == 1){
            player_one.score++;
            player_two.score--;
        }
        else{
            player_one.score--;
            player_two.score++;
        }
    }

    public void flip_player(){
        if(current_player.getLabel() == 1){
            current_player = player_two;
        }
        else{
            current_player = player_one;
        }
    }

    //checks if the board has a card in all positions. Doubles as terminal test
    public boolean is_full(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[i][j] == null){
                    return false;
                }
            }
        }
        return true;
    }

    //utility function for mini-max algorithm. Not sure if this will get used.
    public int utility(){
        if(player_one.getScore() > player_two.getScore()){
            return 1; //player one (ai) wins
        }
        else if(player_two.getScore() > player_one.getScore()){
            return -1; //player two (human) wins
        }
        else{
            return 0; //draw
        }
    }

    //function to copy board and values over
    public Board copy(){
        Board temp = new Board(this);
        return temp;
    }


    //print the current board with some formatting to make it more easily readable
    public void print_board(){
        System.out.println("-------------");

        System.out.print("-O:");
        printOwner(board[0][0]);
        System.out.print("-O:");
        printOwner(board[0][1]);
        System.out.print("-O:");
        printOwner(board[0][2]);
        System.out.println("-");


        System.out.print("- ");
        if (board[0][0] != null) {System.out.print(board[0][0].top_value());}
        else{ System.out.print(" ");}
        System.out.print(" - ");
        if (board[0][1] != null) {System.out.print(board[0][1].top_value());}
        else{ System.out.print(" ");}
        System.out.print(" - ");
        if (board[0][2] != null) {System.out.print(board[0][2].top_value());}
        else{ System.out.print(" ");}
        System.out.println(" -");

        System.out.print("-");
        if (board[0][0] != null) {System.out.print(board[0][0].left_value());}
        else{ System.out.print(" ");}
        System.out.print(" ");
        if (board[0][0] != null) {System.out.print(board[0][0].right_value());}
        else{ System.out.print(" ");}
        System.out.print("-");
        if (board[0][1] != null) {System.out.print(board[0][1].left_value());}
        else{ System.out.print(" ");}
        System.out.print(" ");
        if (board[0][1] != null) {System.out.print(board[0][1].right_value());}
        else{ System.out.print(" ");}
        System.out.print("-");
        if (board[0][2] != null) {System.out.print(board[0][2].left_value());}
        else{ System.out.print(" ");}
        System.out.print(" ");
        if (board[0][2] != null) {System.out.print(board[0][2].right_value());}
        else{ System.out.print(" ");}
        System.out.println("-");

        System.out.print("- ");
        if (board[0][0] != null) {System.out.print(board[0][0].bottom_value());}
        else{ System.out.print(" ");}
        System.out.print(" - ");
        if (board[0][1] != null) {System.out.print(board[0][1].bottom_value());}
        else{ System.out.print(" ");}
        System.out.print(" - ");
        if (board[0][2] != null) {System.out.print(board[0][2].bottom_value());}
        else{ System.out.print(" ");}
        System.out.println(" -");

        System.out.println("-------------");

        System.out.print("-O:");
        printOwner(board[1][0]);
        System.out.print("-O:");
        printOwner(board[1][1]);
        System.out.print("-O:");
        printOwner(board[1][2]);
        System.out.println("-");

        System.out.print("- ");
        if (board[1][0] != null) {System.out.print(board[1][0].top_value());}
        else{ System.out.print(" ");}
        System.out.print(" - ");
        if (board[1][1] != null) {System.out.print(board[1][1].top_value());}
        else{ System.out.print(" ");}
        System.out.print(" - ");
        if (board[1][2] != null) {System.out.print(board[1][2].top_value());}
        else{ System.out.print(" ");}
        System.out.println(" -");

        System.out.print("-");
        if (board[1][0] != null) {System.out.print(board[1][0].left_value());}
        else{ System.out.print(" ");}
        System.out.print(" ");
        if (board[1][0] != null) {System.out.print(board[1][0].right_value());}
        else{ System.out.print(" ");}
        System.out.print("-");
        if (board[1][1] != null) {System.out.print(board[1][1].left_value());}
        else{ System.out.print(" ");}
        System.out.print(" ");
        if (board[1][1] != null) {System.out.print(board[1][1].right_value());}
        else{ System.out.print(" ");}
        System.out.print("-");
        if (board[1][2] != null) {System.out.print(board[1][2].left_value());}
        else{ System.out.print(" ");}
        System.out.print(" ");
        if (board[1][2] != null) {System.out.print(board[1][2].right_value());}
        else{ System.out.print(" ");}
        System.out.println("-");

        System.out.print("- ");
        if (board[1][0] != null) {System.out.print(board[1][0].bottom_value());}
        else{ System.out.print(" ");}
        System.out.print(" - ");
        if (board[1][1] != null) {System.out.print(board[1][1].bottom_value());}
        else{ System.out.print(" ");}
        System.out.print(" - ");
        if (board[1][2] != null) {System.out.print(board[1][2].bottom_value());}
        else{ System.out.print(" ");}
        System.out.println(" -");

        System.out.println("-------------");

        System.out.print("-O:");
        printOwner(board[2][0]);
        System.out.print("-O:");
        printOwner(board[2][1]);
        System.out.print("-O:");
        printOwner(board[2][2]);
        System.out.println("-");

        System.out.print("- ");
        if (board[2][0] != null) {System.out.print(board[2][0].top_value());}
        else{ System.out.print(" ");}
        System.out.print(" - ");
        if (board[2][1] != null) {System.out.print(board[2][1].top_value());}
        else{ System.out.print(" ");}
        System.out.print(" - ");
        if (board[2][2] != null) {System.out.print(board[2][2].top_value());}
        else{ System.out.print(" ");}
        System.out.println(" -");

        System.out.print("-");
        if (board[2][0] != null) {System.out.print(board[2][0].left_value());}
        else{ System.out.print(" ");}
        System.out.print(" ");
        if (board[2][0] != null) {System.out.print(board[2][0].right_value());}
        else{ System.out.print(" ");}
        System.out.print("-");
        if (board[2][1] != null) {System.out.print(board[2][1].left_value());}
        else{ System.out.print(" ");}
        System.out.print(" ");
        if (board[2][1] != null) {System.out.print(board[2][1].right_value());}
        else{ System.out.print(" ");}
        System.out.print("-");
        if (board[2][2] != null) {System.out.print(board[2][2].left_value());}
        else{ System.out.print(" ");}
        System.out.print(" ");
        if (board[2][2] != null) {System.out.print(board[2][2].right_value());}
        else{ System.out.print(" ");}
        System.out.println("-");

        System.out.print("- ");
        if (board[2][0] != null) {System.out.print(board[2][0].bottom_value());}
        else{ System.out.print(" ");}
        System.out.print(" - ");
        if (board[2][1] != null) {System.out.print(board[2][1].bottom_value());}
        else{ System.out.print(" ");}
        System.out.print(" - ");
        if (board[2][2] != null) {System.out.print(board[2][2].bottom_value());}
        else{ System.out.print(" ");}
        System.out.println(" -");

        System.out.println("-------------");

        System.out.println("Player 1 Score: "+player_one.getScore());
        System.out.println("Player 2 Score: "+player_two.getScore());

    }

    //method to print the owner to a card. Seperate method to handle null case
    public void printOwner(Card card){
        if(card !=null){
            System.out.print(card.get_owner());
        }
        else{
            System.out.print(" ");
        }
    }


}
