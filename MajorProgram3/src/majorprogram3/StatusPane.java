/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorprogram3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

/**
 *
 * @author akin
 */
public class StatusPane extends Pane {
    private int points;
    Image zero;
    
    public StatusPane() {
        points = 0;
        try {
            zero = new Image(new FileInputStream("100.png"));
        } catch (FileNotFoundException lmao) {
            System.err.println("This shouldnt be happening");
            System.exit(-1);
        }
        this.setWidth(270);
        this.setHeight(200);
    }
    
    public void setPoints(int pts) {
        this.points = pts;
    }
    
    public int getPoints() {
        return points;
    }
    
    public void displayPoints() {
        System.out.println(points);
    }
}
