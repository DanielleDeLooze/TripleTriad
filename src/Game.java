/*
Author: Danielle DeLooze
Date: 3/20/2018
Purpose: Class to implement and run a game of Triple Triad
 */

import java.util.Scanner;

public class Game {

    Board board;

    public Game(Player player_one, Player player_two){
        board = new Board(player_one, player_two);
    }


    public void play_game(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Would you like to play against the computer or play 2-player?");
        System.out.println("1. Play Computer");
        System.out.println("2. Play 2-player");
        int type = scan.nextInt();
        if(type == 2) {
            while (!board.is_full()) {
                board.print_board();
                System.out.println();
                System.out.println("Current Player: " + board.current_player.getLabel());
                System.out.println("Cards to Choose from: ");
                board.current_player.print_available_card();
                int index = scan.nextInt();
                Card card = board.current_player.play_card(index);
                System.out.println("Which position?");
                int[] pos = board.get_position();
                board.play_card(pos[0], pos[1], card);
            }
            System.out.println();
            board.print_board();
            System.out.println("Winner is: Player " + board.get_winner());
        }
        else if(type == 1){ //player one is computer, player 2 is human
            while(!board.is_full()){
                if(board.current_player.getLabel() == 2){
                    board.print_board();
                    System.out.println("Current Player: " + board.current_player.getLabel());
                    System.out.println("Cards to Choose from: ");
                    board.current_player.print_available_card();
                    int index = scan.nextInt();
                    Card card = board.current_player.play_card(index);
                    System.out.println("Which position?");
                    int[] pos = board.get_position();
                    board.play_card(pos[0], pos[1], card);
                }
                else{
                    computer_move();
                }
            }

        }
        else{
            System.out.println("Invalid input");
        }
    }

    public void computer_move(){
        Board temp_board = board.copy();
    }


}
