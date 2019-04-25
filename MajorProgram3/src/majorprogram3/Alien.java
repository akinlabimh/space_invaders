/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorprogram3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;

/**
 *
 * @author akin
 */
public class Alien extends Invader {
    private int alienType;
    private Rectangle2D[] viewPortRects;
    private int currentImage;
    private ActionPane actionPane;
    
    public Alien(ActionPane actionPane, Image sprite, int type) {
        alienType = type;
        viewPortRects = new Rectangle2D[2];
        this.actionPane = actionPane;
        //try {
            //sprite = new Image(new FileInputStream("/Users/akin/COMP167/major-program-3-akinmh/type1.jpg"));
            this.setImage(sprite);
            
//            if (alienType == 1) {
//                sprite = new Image(new FileInputStream("/Users/akin/COMP167/major-program-3-akinmh/type1.jpg"));
//                this.setImage(sprite);
//            } else if (alienType == 2) {
//                sprite = new Image(new FileInputStream("/Users/akin/COMP167/major-program-3-akinmh/type2.jpg"));
//                this.setImage(sprite);
//            } else {
//                sprite = new Image(new FileInputStream("/Users/akin/COMP167/major-program-3-akinmh/type3.jpg"));
//                this.setImage(sprite);
//            }
//        } catch(FileNotFoundException ex) {
//            System.err.println(ex.getMessage());
//            System.exit(-1);
//        }
        
        this.setScaleX(2);
        this.setScaleY(2);
        this.setSpeed(1);
        actionPane.getChildren().add(this);
    }
    
    @Override
    public void Move() {
        double newX = this.getX() + getSpeed() * Math.cos(Math.toRadians(getDirection()));
        this.setX( newX );
      
    }

    /**
     * @return the alienType
     */
    public int getAlienType() {
        return alienType;
    }

    /**
     * @param alienType the alienType to set
     */
    public void setAlienType(int alienType) {
        this.alienType = alienType;
    }

    /**
     * @return the viewPortRects
     */
    public Rectangle2D[] getViewPortRects() {
        return viewPortRects;
    }

    /**
     * @param viewPortRects the viewPortRects to set
     */
    public void setViewPortRects(Rectangle2D[] viewPortRects) {
        this.viewPortRects = viewPortRects;
    }

    /**
     * @return the currentImage
     */
    public int getCurrentImage() {
        return currentImage;
    }

    /**
     * @param currentImage the currentImage to set
     */
    public void setCurrentImage(int currentImage) {
        this.currentImage = currentImage;
    }

    /**
     * @return the actionPane
     */
    public ActionPane getActionPane() {
        return actionPane;
    }

    /**
     * @param actionPane the actionPane to set
     */
    public void setActionPane(ActionPane actionPane) {
        this.actionPane = actionPane;
    }
}
