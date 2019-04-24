/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorprogram3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;

/**
 *
 * @author akin
 */
public class TheHord {

    Alien[][] aliens;
    double direction;
    double lastDirection;
    int numLiving;
    boolean atEdge;
    ActionPane actionPane;
    Image alienSprites;
    Image sprite;
    Image sprite2;        
    Image sprite3;
    
    public TheHord() {
        aliens = new Alien[5][11];
        actionPane = new ActionPane();
        try {
            sprite = new Image(new FileInputStream("/Users/akin/COMP167/major-program-3-akinmh/type1.jpg"));
            sprite2 = new Image(new FileInputStream("/Users/akin/COMP167/major-program-3-akinmh/type2.jpg"));
            sprite3 = new Image(new FileInputStream("/Users/akin/COMP167/major-program-3-akinmh/type3.jpg"));
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
            System.exit(-1);
        }
        
//        this.setHgap(20);
//        this.setVgap(10);
//        this.setPadding(new Insets(80, 10, 10, 10));
        double yCoord = 90;
        double tRow = 63;
        
        

        
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < aliens[i].length; j++) {
                Alien a = new Alien(actionPane, sprite3 , 3);
                aliens[i][j] = a;
                a.setDirection(0);
                a.setSpeed(1);
                a.setX(tRow);
                a.setY(yCoord);
                tRow += 40;
                //yCoord +=10;
                //this.add(a, j, i);
            }
            yCoord +=50;
        }
        for (int i = 0; i < 2; i++) {
            double mRow = 63;
            for (int j = 0; j < aliens[i].length; j++) {
                Alien a = new Alien(actionPane, sprite2 , 2);
                aliens[i+1][j] = a;
                a.setDirection(0);
                a.setSpeed(1);
                a.setX(mRow);
                a.setY(yCoord);
                mRow += 40;
                //yCoord +=10;
                //this.add(a, j, i+2);
            }
            yCoord += 50;
        }

        for (int i = 0; i < 2; i++) {
        double bRow = 63;
            for (int j = 0; j < aliens[i].length; j++) {
                Alien a = new Alien(actionPane, sprite , 1);
                aliens[i+3][j] = a;
                a.setDirection(0);
                a.setSpeed(1);
                a.setX(bRow);
                a.setY(yCoord);
                bRow += 40;
                //yCoord +=10;
                //this.add(a, j, i+4);
                GameUtility g = new GameUtility();
            }
            yCoord +=50;
        }

        

//            }
    }
    
    public int alientsGetLength() {
        return aliens.length;
    }
    
    public int alientsGetWidth(int i) {
        return aliens[i].length;
    }
    
    public boolean isThere() {
        boolean x = false;
        for (int i = 0; i < aliens.length; i++) {
            for (int j = 0; j < aliens[i].length; j++) {
                Alien a = getAlien(i, j);
                if (a.isVisible()) {
                    x = true;
                    break;
                }
            }
        }
        return x;
    }

    public void Move() {
        for (int i = 0; i < aliens.length; i++) {
            for (int j = 0; j < aliens[i].length; j++) {
                Alien a = getAlien(i, j);
                double newX = a.getX() + a.getSpeed() * Math.cos(Math.toRadians(a.getDirection()));
                a.setX(newX);
//                if (a.getX() >= 600) {
//                    
//                }
            }
        }
    }

    public void initTheHord(ActionPane actionPane) {
        for (int i = 0; i < aliens.length; i++) {
            for (int j = 0; j < aliens[i].length; j++) {
                Alien a = getAlien(i, j);
                actionPane.getChildren().add(a);
            }
        }
    }

    public void resetTheHord() {
        
    }

    public void changeDirection() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < aliens[i].length; j++) {
                Alien a = getAlien(i, j);
                if (a.getDirection() == 0) {
                    a.setDirection(180);
                    a.Move();
                } else if (a.getDirection() == 180) {
                    a.setDirection(0);
                    a.Move();
                }
            }
        }
    }

    public Alien getAlien(int i, int j) {
        return aliens[i][j];
    }
}
