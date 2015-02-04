/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package flipgame;

import java.util.Random;

/**
 *
 * @author jasonx
 */
public class Board {
    Card[] cards;
    Card[] matches; //cards have the same val
    int cur = 0; //index pointer in matches
    int count = 0;
    
    
    Board(int num,int match){
        generateBoard(num,match);
        this.matches = new Card[match];
    }
    
    public void generateBoard(int num,int match){
        if(num % match != 0){
            System.out.print("NOT VALID NUM/MATCH PAIR");
            return;
        }
        this.cards = new Card[num];
        for(int i=0;i<num;i++){
            this.cards[i] = new Card(i/match);
        }
        shuffle();
    }
    
    public void shuffle(){
        Random rnd = new Random();
        for(int i=cards.length-1;i>0;i--){
            int index = rnd.nextInt(i+1);
            if(index != i){
                Card temp = cards[index];
                cards[index] = cards[i];
                cards[i] = temp;
            }
        }
    }
    
    public void printBoard(){
        for(Card card : cards){
            System.out.print(card.value + " ");
        }
        System.out.print('\n');
    }
    
    public void game(){
        for(Card card : cards){
            if(!card.show) System.out.print("X ");
            else System.out.print(card.value + " ");
        }
        System.out.print('\n');
    }
    
    public void flip(int index){
        if(index >= cards.length) return;
        Card c = cards[index];
        Card prev;
        if(cur == 0) prev = c;
        else prev = matches[cur-1];
        if(!c.show){
            c.show();
            game();
            matches[cur++] = c;
            if(c.value != prev.value){
                for(int i=0;i<cur;i++) matches[i].hide();
                game();
                cur = 0;
                return;
            }
            if(cur == matches.length){
                cur = 0;
                count += matches.length;
            }
        }
    }
}
