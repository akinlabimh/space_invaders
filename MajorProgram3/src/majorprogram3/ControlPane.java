/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorprogram3;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

/**
 *
 * @author akin
 */
public class ControlPane extends HBox {
    private HBox lol;
    private Button start;
    private Button restart;
    private Button exit;
    
    public ControlPane(GamePane g) {
        HBox lol = new HBox(10);
        Button start = new Button("START");
        Button restart = new Button("RESTART");
        Button exit = new Button("EXIT");
        
        start.setPrefSize(80, 10);
        restart.setPrefSize(80, 10);
        exit.setPrefSize(80, 10);
        
        this.getChildren().addAll(start, restart, exit);
        this.setAlignment(Pos.CENTER);
        
        start.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent e) {
                g.getCmdCenter().setVisible(true);
                g.getCmdCenter().getProjectile().setVisible(true);
                g.getSpaceShip().setVisible(true);
                g.getGameTimer().start();
            }
        });
        
        restart.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent e) {
                
            }
        });
        
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent e) {
                System.exit(-1);
            }
        });
    }

    /**
     * @return the lol
     */
    public HBox getLol() {
        return lol;
    }

    /**
     * @param lol the lol to set
     */
    public void setLol(HBox lol) {
        this.lol = lol;
    }

    /**
     * @return the start
     */
    public Button getStart() {
        return start;
    }

    /**
     * @param start the start to set
     */
    public void setStart(Button start) {
        this.start = start;
    }

    /**
     * @return the restart
     */
    public Button getRestart() {
        return restart;
    }

    /**
     * @param restart the restart to set
     */
    public void setRestart(Button restart) {
        this.restart = restart;
    }

    /**
     * @return the exit
     */
    public Button getExit() {
        return exit;
    }

    /**
     * @param exit the exit to set
     */
    public void setExit(Button exit) {
        this.exit = exit;
    }
}
