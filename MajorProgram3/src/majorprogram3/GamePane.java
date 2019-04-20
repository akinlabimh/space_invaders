/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorprogram3;

//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author akin
 */
public class GamePane extends BorderPane  {
    private ActionPane actionPane;
    private CmdCenter cmdCenter;
    private SpaceShip spaceShip;
    private TheHord theHord;
    private GameTimer gameTimer = new GameTimer();
    private Projectile p;
    
    public GamePane() {
        p = new Projectile();
        actionPane = new ActionPane();
        this.setCenter(actionPane);
        cmdCenter = new CmdCenter(getActionPane());
        //cmdCenter.setProjectile(p);
        actionPane.getChildren().add(cmdCenter);
        //actionPane.getChildren().add(p);
        //actionPane.getChildren().add(p)
        KeyListener keyListener = new KeyListener();
        this.setOnKeyPressed(keyListener);
        //this.setOnKeyTyped(keyListener);
        //gameTimer.start();
    }
    
//    public GamePane(ActionPane actionPane) {
//        this.actionPane = actionPane;
//        this.setCenter(actionPane);
//        cmdCenter = new CmdCenter(actionPane);
//    }
    

    public class KeyListener implements EventHandler<KeyEvent> {
        @Override
        public void handle(KeyEvent e) {
        KeyCode keyCode = e.getCode();
        switch(keyCode) { 
            case LEFT:
                getCmdCenter().setDirection(180);
                getCmdCenter().Move();
                break;
            case RIGHT:
                getCmdCenter().setDirection(0);
                getCmdCenter().Move();
                break;
            case SPACE:
                pause();
                gameTimer.start();
                p = new Projectile();
                cmdCenter.setProjectile(p);
                actionPane.getChildren().add(cmdCenter.getProjectile());
                cmdCenter.getProjectile().setX(cmdCenter.getX() + 11);
                cmdCenter.getProjectile().setY(cmdCenter.getY() + 0);
                getCmdCenter().fireProjectile();
                //if (cmdCenter.getProjectile())
                //play();
                break;
        }
        
        }
    }
    
    public class KeyPaused implements EventHandler<KeyEvent> {
        @Override
        public void handle(KeyEvent e) {
            KeyCode k = e.getCode();
            switch (k) {
                case LEFT:
                    getCmdCenter().setDirection(180);
                    getCmdCenter().Move();
                    break;
                case RIGHT:
                    getCmdCenter().setDirection(0);
                    getCmdCenter().Move();
                    break;
            }
            
        }
    }
    
    
    public class GameTimer extends AnimationTimer {

        private long previous = 0;
        public void handle(long now) {
            if (previous == 0) {
                previous = now;
            } else if (now - previous >= 500000L) {
                cmdCenter.fireProjectile();
                previous = now;
                //reset();
                if (cmdCenter.getProjectile().getY() < -12) {
                    //cmdCenter.getProjectile().setX(cmdCenter.getX() + 11);
                    //cmdCenter.getProjectile().setY(cmdCenter.getY() + 10);
                    this.stop();
                    play();
                }
            }
        }
        
        
    }
    
    public void pause() {
        KeyPaused kp = new KeyPaused();
        this.setOnKeyPressed(kp);
    }
    
    public void play() {
        KeyListener kp = new KeyListener();
        this.setOnKeyPressed(kp);
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

    /**
     * @return the cmdCenter
     */
    public CmdCenter getCmdCenter() {
        return cmdCenter;
    }

    /**
     * @param cmdCenter the cmdCenter to set
     */
    public void setCmdCenter(CmdCenter cmdCenter) {
        this.cmdCenter = cmdCenter;
    }

    /**
     * @return the spaceShip
     */
    public SpaceShip getSpaceShip() {
        return spaceShip;
    }

    /**
     * @param spaceShip the spaceShip to set
     */
    public void setSpaceShip(SpaceShip spaceShip) {
        this.spaceShip = spaceShip;
    }

    /**
     * @return the theHord
     */
    public TheHord getTheHord() {
        return theHord;
    }

    /**
     * @param theHord the theHord to set
     */
    public void setTheHord(TheHord theHord) {
        this.theHord = theHord;
    }

    /**
     * @return the gameTimer
     */
    public GameTimer getGameTimer() {
        return gameTimer;
    }

    /**
     * @param gameTimer the gameTimer to set
     */
    public void setGameTimer(GameTimer gameTimer) {
        this.gameTimer = gameTimer;
    }

}
