/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorprogram3;

import java.io.FileInputStream;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;

/**
 *
 * @author akin
 */
public class CmdCenter extends GameObject {
    private Projectile projectile = new Projectile();
    private ActionPane a;
    
    public CmdCenter(ActionPane actionPane) {
        //projectile = new Projectile(actionPane);
        

        //Read in the entire sprite sheet from disk.
        try {           
            Image image = new Image(new FileInputStream("/Users/akin/COMP167/major-program-3-akinmh/spritesheet.jpg"));
            this.setImage(image);
        } catch (java.io.FileNotFoundException ex) {
            System.err.println(ex.getMessage());
            System.exit(-1);
        }

        //Specify which portion of the sprite sheet you want displayed. by giving the (x,y)  
        //location of the top-left corner and the width and the height.
        //Rectangle2D viewportRect = new Rectangle2D(217, 16, 21, 15);
        Rectangle2D viewportRect = new Rectangle2D(220, 180, 23, 20);

        //As a matter of preference, I scaled the image to make it appear larger.
        this.setScaleX(1.5);
        this.setScaleY(1.5);

        //Set the viewport for this ImageView object (CmdCenter in this case).
        this.setViewport(viewportRect);

        //Set the width and height of the containing pane so that you will know when you
        //have moved the CmdCenter to the edge of the screen.        
        setParentWidth(actionPane.getPrefWidth());
        setParentHeight(actionPane.getPrefHeight());

        //Give an initial location to the CmdCenter
        this.setX(getParentWidth() /2 + 261);
        this.setY(getParentHeight() + 576);
        
        this.setSpeed(8);
    }

    @Override
    public void Move() {
        //System.out.println(getX());
        double newX = this.getX() + getSpeed() * Math.cos(Math.toRadians(getDirection()));
       // double newY = this.getY() + getSpeed() * Math.sin(Math.toRadians(getDirection())) ;
       if (newX >= 516.5) {
           this.setX(516.50);
       } else if (newX <= 12.5) {
           this.setX(12.5);
       } else {
       
       this.setX( newX );
       }
       //System.out.println(getX());
       // this.setY( newY );
    }

    /**
     * @return the projectile
     */
    public Projectile getProjectile() {
        return projectile;
    }

    /**
     * @param projectile the projectile to set
     */
    public void setProjectile(Projectile projectile) {
        this.projectile = projectile;
    }
    
    public void fireProjectile() {
        
        projectile.setSpeed(3);
        projectile.setDirection(270);
        projectile.Move();
    }
}
