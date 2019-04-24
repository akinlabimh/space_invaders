/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorprogram3;

import java.io.FileInputStream;
import java.util.Random;
import javafx.scene.image.Image;

/**
 *
 * @author akin
 */
public class SpaceShip extends GameObject {
    private Image one;
    private Image two;
    private Image three;
    
    public SpaceShip() {
    //Read in the entire sprite sheet from disk.
        try {           
            Image image = new Image(new FileInputStream("spaceship.jpg"));
            one = new Image(new FileInputStream("100.png"));
            two = new Image(new FileInputStream("200.png"));
            three = new Image(new FileInputStream("300.png"));
            this.setImage(image);
        } catch (java.io.FileNotFoundException ex) {
            System.err.println(ex.getMessage());
            System.exit(-1);
        }
        
        //setParentWidth(getActionPane().getPrefWidth());
        //setParentHeight(actionPane.getPrefHeight());

        this.setScaleX(0.5);
        this.setScaleY(0.5);
        
        //this.setDirection(180);
        
        //this.setX(530);
        //this.setY(25);
        
        this.setSpeed(1);
        this.setVisible(false);
    }

    @Override
    public void Move() {
        double newX = this.getX() + getSpeed() * Math.cos(Math.toRadians(getDirection()));
        this.setX( newX );
        //this.setY(-25);
        System.out.println(this.getY());
    }
    
    public boolean hitbox(Projectile p) {
        boolean lol = false;
        double ex = p.getX();
        double why = p.getY();
        if (ex >= this.getX() && ex <= this.getX() + 150) {
            if (why > this.getY() && why < this.getY() + 75) {
               System.out.println(this.getY());
               System.out.println(why);
               System.out.println(this.getY()+75);
               lol = true; 
            } else {
               lol = false;
            }
        } else {
            lol = false;
        }
        //System.out.println("");
        //ex = 0;
        //why = 0;
        return lol;
    }
    
    public int setRandomPointValue() {
        Random r = new Random();
        int i = r.nextInt(3);
        i++;
        i*=100;       
        
        return i;
    }
    
    public void setPosition() {
        Random r = new Random();
        int i = r.nextInt(2);
        
        if (i == 1) {
            this.setDirection(180);
            this.setX(getParentWidth() + 530);
            this.setY(getParentHeight() - 25);
        } else {
            this.setDirection(0);
        }
    }

    /**
     * @return the one
     */
    public Image getOne() {
        return one;
    }

    /**
     * @param one the one to set
     */
    public void setOne(Image one) {
        this.one = one;
    }

    /**
     * @return the two
     */
    public Image getTwo() {
        return two;
    }

    /**
     * @param two the two to set
     */
    public void setTwo(Image two) {
        this.two = two;
    }

    /**
     * @return the three
     */
    public Image getThree() {
        return three;
    }

    /**
     * @param three the three to set
     */
    public void setThree(Image three) {
        this.three = three;
    }
    
}
