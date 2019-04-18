/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorprogram3;

import javafx.scene.layout.Pane;

/**
 *
 * @author akin
 */
public class ActionPane extends Pane {
    Projectile p;
    CmdCenter c;
    SpaceShip s;
    TheHord h;
    
    public ActionPane() {
        this.setWidth(550);
        this.setHeight(600);
//        CmdCenter c = new CmdCenter(this);
//        this.getChildren().add(c);
    }
}
