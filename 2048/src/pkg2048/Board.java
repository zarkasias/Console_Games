/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkg2048;

import java.util.Random;

/**
 *
 * @author jasonx
 */
public class Board {
    public int[][] board = new int[4][4];
    final int target = 2048;
    int tiles = 0;
    int steps = 0;
    boolean moved = false;
    
    Board(){
        numGenerator();
        numGenerator();
    }
    
    private void numGenerator(){
        Random rdm = new Random();
        int i = rdm.nextInt(4);
        int j = rdm.nextInt(4);
        int num = rdm.nextInt(100);
        while(board[i][j] != 0){
            i = rdm.nextInt(4);
            j = rdm.nextInt(4);
        }            
        if(num > 80) board[i][j] = 4;
        else board[i][j] = 2;
        this.tiles++;
    }
    
    
    public void printBoard(){
        for(int i=0;i<4;i++){
            System.out.print('\n');
            for(int j=0;j<4;j++) System.out.print(board[i][j] + " ");
        }
        System.out.print('\n');
    }
    
    public void move(String input){
        switch(input){
            case "w": moveUp();
                break;
            case "a": moveLeft();
                break;
            case "s": moveDown();
                break;
            case "d": moveRight();
                break;
            default: break;
        }
        if(moved){
            this.steps++;
            moved = false;
            numGenerator();
            if(this.tiles == 16) this.isLost();
        }
    }
    
    private void moveUp(){
        int k = 0;
        for(int j=0;j<4;j++){
            for(int i=1;i<4;i++){
                if(board[i][j] != 0){
                    int place = board[k][j];
                    if(place == 0){
                        moved = true;
                        board[k][j] = board[i][j];
                        board[i][j] = 0;
                    }else{
                        if(place == board[i][j]){
                            moved = true;
                            tiles--;
                            board[k][j] *= 2;
                            isFinish(board[k][j]);
                            k++;
                            board[i][j] = 0;
                        }else{
                            k++;
                            if(k != i){
                                moved = true;
                                board[k][j] = board[i][j];
                                board[i][j] = 0;
                            }
                        }
                    }
                }
            }
            k = 0;
        }
    }
    
    private void moveDown(){
        int k = 3;
        for(int j=0;j<4;j++){
            for(int i=2;i>=0;i--){
                if(board[i][j] != 0){
                    int place = board[k][j];
                    if(place == 0){
                        moved = true;
                        board[k][j] = board[i][j];
                        board[i][j] = 0;
                    }else{
                        if(place == board[i][j]){
                            moved = true;
                            tiles--;
                            board[k][j] *= 2;
                            isFinish(board[k][j]);
                            k--;
                            board[i][j] = 0;
                        }else{
                            k--;
                            if(k != i){
                                moved = true;
                                board[k][j] = board[i][j];
                                board[i][j] = 0;
                            }
                        }
                    }
                }
            }
            k = 3;
        }
    }
    private void moveLeft(){
        int k = 0;
        for(int i=0;i<4;i++){
            for(int j=1;j<4;j++){
                if(board[i][j] != 0){
                    int place = board[i][k];
                    if(place == 0){
                        moved = true;
                        board[i][k] = board[i][j];
                        board[i][j] = 0;
                    }else{
                        if(place == board[i][j]){
                            moved = true;
                            tiles--;
                            board[i][k] *= 2;
                            isFinish(board[i][k]);
                            k++;
                            board[i][j] = 0;
                        }else{
                            k++;
                            if( k != j){
                                moved = true;
                                board[i][k] = board[i][j];
                                board[i][j] = 0;
                            }
                        }
                    }
                }
            }
            k = 0;
        }
    }
    private void moveRight(){
        int k = 3;
        for(int i=0;i<4;i++){
            for(int j=2;j>=0;j--){
                if(board[i][j] != 0){
                    int place = board[i][k];
                    if(place == 0){
                        moved = true;
                        board[i][k] = board[i][j];
                        board[i][j] = 0;
                    }else{
                        if(place == board[i][j]){
                            moved = true;
                            tiles--;
                            board[i][k] *= 2;
                            isFinish(board[i][k]);
                            k--;
                            board[i][j] = 0;
                        }else{
                            k--;
                            if(k != j){
                                moved = true;
                                board[i][k] = board[i][j];
                                board[i][j] = 0;
                            }
                        }
                    }
                }
            }
            k = 3;
        }
    }
    
    private void isFinish(int i){
        if(i==target){
            System.out.println("Congrates! Steps: " + (this.steps+1));
            System.exit(0);
        }
    }
    
    private void isLost(){
        int prev = 0;
        boolean lost = true;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(i==0 && j==0) prev = board[i][j];
                else{
                    if(board[i][j] == prev) lost = false;
                    break;
                }
            }
        }
        if(lost){
            for(int j=0;j<4;j++){
                for(int i=0;i<4;i++){
                    if(i==0 && j==0) prev = board[i][j];
                    else{
                        if(board[i][j] == prev) lost = false;
                        break;
                    }
                }
            }
            if(lost){
                System.out.println("Game Over!");
                System.exit(0); 
            }
        }
    }
}
