/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorprogram3;

import java.io.FileInputStream;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author akin
 */
public class GMO extends GameObject {
    
    public GMO(ActionPane actionPane) {
        try {           
            Image image = new Image(new FileInputStream("/Users/akin/COMP167/major-program-3-akinmh/game_over.png"));
            this.setImage(image);
        } catch (java.io.FileNotFoundException ex) {
            System.err.println(ex.getMessage());
            System.exit(-1);
        }
        
        this.setScaleX(0.5);
        this.setScaleY(0.5);

        //Set the viewport for this ImageView object (CmdCenter in this case).
        //this.setViewport(viewportRect);

        //Set the width and height of the containing pane so that you will know when you
        //have moved the CmdCenter to the edge of the screen.        
        setParentWidth(actionPane.getPrefWidth());
        setParentHeight(actionPane.getPrefHeight());

        //Give an initial location to the CmdCenter
        this.setX(getParentWidth() /2 - 80);
        this.setY(getParentHeight() /2);
    }

    @Override
    public void Move() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
