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
import java.util.Random;
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
        spaceShip = new SpaceShip();
        //cmdCenter.setProjectile(p);
        actionPane.getChildren().add(cmdCenter);
        actionPane.getChildren().add(spaceShip);
        p = new Projectile();
        cmdCenter.setProjectile(p);
        p.setVisible(false);
        //spaceShip.setVisible(true);
        //actionPane.getChildren().add(p);
        //actionPane.getChildren().add(p)
        KeyListener keyListener = new KeyListener();
        this.setOnKeyPressed(keyListener);
        gameTimer.start();
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
                p.setVisible(true);
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

        private boolean wait = false;
        private long spawnTime;
        Random lol = new Random();
        private long previous = 0;
        private long previouss = 0;
        public void handle(long now) {
            if (now - previous >= 500000L) {
                cmdCenter.fireProjectile();
                previous = now;
                if (cmdCenter.getProjectile().getY() < -15) {
                    play();
                }
                
            }
            if (previouss == 0) {
                previouss = now;
            }
            if (now - previouss >= 25000000L && spaceShip.isVisible()) {
                spaceShip.Move();
                if (spaceShip.hitbox(cmdCenter.getProjectile()) == true) {
                    spaceShip.setVisible(false);
                    cmdCenter.getProjectile().setVisible(false);
                }
                //spaceShip.Move();
                //spaceShip.Move();
                previous = now;
            } 
            if(!wait) {
                long rand = lol.nextInt(20);
                if (rand < 6) {
                    rand = 5;
                }
                //System.out.println(rand);
                spawnTime = (long) (now + (rand + 5) * Math.pow(10,9));
                wait = true;
            }
            if (wait && now >= spawnTime) {
                int directionChooser = lol.nextInt(2);
                spaceShip.setVisible(true);
                //int direction;
                
                switch (directionChooser) {
                    case 1:
                        spaceShip.setDirection(180);
                        spaceShip.setX(spaceShip.getParentWidth() + 530);
                        spaceShip.setY(spaceShip.getParentHeight() - 25);
                        //System.out.println(180);
                        //spaceShip.setX(550);
                        //pause();
                        break;
                    default:
                        spaceShip.setDirection(0);
                        spaceShip.setX(spaceShip.getParentWidth() - 120);
                        spaceShip.setY(spaceShip.getParentHeight() - 25);
                        //System.out.println(0);
                        //spaceShip.setX(0);
                        break;
                }
                
                wait = false;
            }
               
        }
        
        
    }
    
    public void freezeThenStop() {
        double t = 0;
        for (int i = 1; i < 1000; i++) {
            t++;
            System.out.println(t);
            if (t == 999) {
                actionPane.getChildren().remove(spaceShip);
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
    
    public int scramble() {
        Random r = new Random();
        int i = r.nextInt(5);
        return i;
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
    
    public void spawnShip() {
        
    }

}
