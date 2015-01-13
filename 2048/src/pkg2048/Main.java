/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// add a game over 
package pkg2048;

import java.util.Scanner;

/**
 *
 * @author jasonx
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Board b = new Board();
        b.printBoard();
        System.out.println("Game On!(q = quit)");
        help();
        Scanner reader = new Scanner(System.in);
        String input = reader.next();
        while(!input.equals("q")){
            if(input.equals("h")) help();
            b.move(input);
            b.printBoard();
            input = reader.next();
        }
    }
    public static void help(){
        System.out.println("w = Up, a = Left, s = Down, d = Right");
    }
}
