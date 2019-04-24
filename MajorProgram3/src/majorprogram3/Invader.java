/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorprogram3;

import java.util.Random;

/**
 *
 * @author akin
 */
public class Invader extends GameObject {
    int points;
    
    public int setRandomPointValue() {
        Random r = new Random();
        int i = r.nextInt(3);
        i++;
        i*=100;       
        
        return i;
    }

    @Override
    public void Move() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
