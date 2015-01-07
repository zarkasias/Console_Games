/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package flipgame;

/**
 *
 * @author jasonx
 */
public class Card {
    public boolean show = false;
    public int value = 0;
    
    Card(int val){
        this.value = val;
    }
    
    public void show(){
        this.show = true;
    }
    
    public void hide(){
        this.show = false;
    }
}
