/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package flipgame;

import java.util.Scanner;

/**
 *
 * @author jasonx
 */
public class FlipGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Board b = new Board(15,3);
        b.printBoard();
        b.game();
        System.out.println("Game On!(q = quit)");
        help();
        Scanner reader = new Scanner(System.in);
        String input = reader.next();
        while(!input.equals("q")){
            int index = Integer.parseInt(input);
            b.flip(index);
            if(b.count == b.cards.length){
                System.out.println("Congrats!");
                break;
            }
            input = reader.next();
        }
    }
    
    public static void help(){
        System.out.println("Type the index to flip an element, find all matches to win");
    }
}
