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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

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
    public StatusPane s;
    private ControlPane ControlPane;
    private Label score;
    public GamePane th = this;
    private int scoree;
    
    
    public GamePane() {
        scoree = 0;
        //p = new Projectile();
        actionPane = new ActionPane();
        this.setCenter(actionPane);
        cmdCenter = new CmdCenter(getActionPane());
        spaceShip = new SpaceShip();
        spaceShip.setX(-10);
        spaceShip.setY(-25);
        //cmdCenter.setProjectile(p);
        actionPane.getChildren().add(cmdCenter);
        actionPane.getChildren().add(spaceShip);
        cmdCenter.setVisible(true);
        spaceShip.setVisible(true);
        p = new Projectile();
        cmdCenter.setProjectile(p);
        cmdCenter.getProjectile().setVisible(false);
        actionPane.getChildren().add(cmdCenter.getProjectile());
        s = new StatusPane();
        this.getChildren().add(s);
        Label prefix = new Label("Score: ");
        score = new Label("0");
        theHord = new TheHord();
        theHord.initTheHord(actionPane);
        //theHord.setVisible(true);
        
        FlowPane tp = new FlowPane();
        tp.getChildren().add(prefix);
        tp.getChildren().add(score);
        tp.setStyle("-fx-background-color: #FFFFFF;");
//        this.setTop(score);
//        ControlPane.addAll(start, restart, exit);
        //spaceShip.setVisible(true);
        //actionPane.getChildren().add(p);
        //actionPane.getChildren().add(p)
        
        //this.setOnKeyTyped(keyListener);
        //gameTimer.start();
        ControlPane = new ControlPane(this);
        //this.setBottom(ControlPane);
        FlowPane y = new FlowPane();
        Button start = new Button("START");
        Button restart = new Button("RESTART");
        Button exit = new Button("EXIT");
        
        start.setPrefSize(80, 10);
        restart.setPrefSize(80, 10);
        exit.setPrefSize(80, 10);
        
        y.getChildren().addAll(start, restart, exit);
        y.setAlignment(Pos.CENTER);
        
        start.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override 
            public void handle(MouseEvent e) {
                KeyListener keyListener = new KeyListener();
                th.setOnKeyPressed(keyListener);
                gameTimer.start();
            }
        });
        
        restart.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override 
            public void handle(MouseEvent e) {
                gameTimer.stop();
                cmdCenter.setX(cmdCenter.getParentWidth() /2 + 261);
                cmdCenter.setY(cmdCenter.getParentHeight() + 576);
                score.setText("0");
                //gameTimer.start();
            }
        });
        
        exit.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override 
            public void handle(MouseEvent e) {
                System.exit(-1);
            }
        });
        
//        KeyListener keyListener = new KeyListener();
//        th.setOnKeyPressed(keyListener);
//        gameTimer.start();
        this.setBottom(y);
        this.setTop(tp);
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
            case A:
                getCmdCenter().setDirection(180);
                getCmdCenter().Move();
                break;
            case D:
                getCmdCenter().setDirection(0);
                getCmdCenter().Move();
                break;
            case S:
                //pause();
                if (!cmdCenter.getProjectile().isVisible()) {
                    
                
                cmdCenter.getProjectile().setVisible(true);

                cmdCenter.getProjectile().setX(cmdCenter.getX() + 11);
                cmdCenter.getProjectile().setY(cmdCenter.getY() + 0);
                getCmdCenter().fireProjectile();
                }
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
        private long previousShip = 0;
        private long perviousAlien = 0;
        public void handle(long now) {
            if (now - previous >= 500000L && cmdCenter.getProjectile().isVisible()) {
                //lowercase move
                cmdCenter.getProjectile().Move();
                previous = now;
                if (cmdCenter.getProjectile().getY() < -15) {
                    cmdCenter.getProjectile().setVisible(false);
                    //play();
                }
                
            }
            if (previousShip == 0) {
                previousShip = now;
            }
            if (now - previousShip >= 25000000L && spaceShip.isVisible()) {
                spaceShip.Move();
//////////                if (spaceShip.hitbox(cmdCenter.getProjectile()) == true) {
////////////                    System.out.println(spaceShip.getX());
////////////                    System.out.println("hit");
//////////                    s.setPoints(spaceShip.setRandomPointValue());
//////////                    s.displayPoints();
//////////                    spaceShip.setVisible(false);
//////////                    cmdCenter.getProjectile().setVisible(false);
//////////                }
                //spaceShip.Move();
                //spaceShip.Move();
                GameUtility g = new GameUtility();
                boolean hit = false;
                if (cmdCenter.getProjectile().isVisible() && spaceShip.isVisible()) {
                    hit = g.detectCollision(cmdCenter.getProjectile(), spaceShip);
                }
                if (hit && (cmdCenter.getProjectile().isVisible())) {
//                    s.setPoints(spaceShip.setRandomPointValue());
//                    s.displayPoints();
                    updateScore();
                    spaceShip.setVisible(false);
                    cmdCenter.getProjectile().setVisible(false);
                }
                previous = now;
            } 
            
            
                for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 11; j++) {
                            if(now - perviousAlien >= 25000000L && theHord.getAlien(i, j).isVisible())  {
                                theHord.getAlien(i, j).setSpeed(0.5);
                                //theHord.getAlien(i, j).setDirection(0);
                                theHord.getAlien(i, j).Move();
                                
                                if (theHord.getAlien(i, j).getX() >= 600 && theHord.getAlien(i, j).isVisible()) {
                                    for (int h = 0; h < 5; h++) {
                                        for (int k = 0; k < 11; k++) {
                                            theHord.getAlien(h, k).setDirection(180);
                                            //System.out.println("ttt");
                                        }
                                    }
                                }
                                
                                if (theHord.getAlien(i, j).getX() <= 0 && theHord.getAlien(i, j).isVisible()) {
                                    for (int h = 0; h < 5; h++) {
                                        for (int k = 0; k < 11; k++) {
                                            theHord.getAlien(h, k).setDirection(0);
                                            //System.out.println("ttt");
                                        }
                                    }
                                }
                                
                                if (theHord.getAlien(i, j).getX() <= 0) {
                                    theHord.changeDirection();
                                }
                                
                                System.out.println(theHord.getAlien(i, j).getX());
                                boolean hits = false;
                                GameUtility go = new GameUtility();
                                if (cmdCenter.getProjectile().isVisible() && theHord.getAlien(i, j).isVisible()) {
                                    hits = go.detectCollision(cmdCenter.getProjectile(), theHord.getAlien(i, j));
                                } else if (cmdCenter.getProjectile().isVisible() && spaceShip.isVisible()) {
                                    cmdCenter.getProjectile().setSpeed(8);
                                    cmdCenter.getProjectile().Move();

                                }

                                if (hits && (cmdCenter.getProjectile().isVisible())) {
                                updateScore();
                                //System.out.println("hahahah");
                                theHord.getAlien(i, j).setVisible(false);
                                cmdCenter.getProjectile().setVisible(false);
                                //System.out.println(cmdCenter.getProjectile().getSpeed());
                                }
                                
                            }
                        }
                }
            
            if (perviousAlien == 0) {
                perviousAlien = now;
            }
            
                
            
            if(!wait) {
                //Change back to 20
                long rand = lol.nextInt(2);
                if (rand < 6) {
                    rand = 5;
                }
                //System.out.println(rand);
                spawnTime = (long) (now + (rand + 10) * Math.pow(10,9));
                wait = true;
            }
            if (wait && now >= spawnTime) {
                int directionChooser = lol.nextInt(2);
                //spaceShip.setVisible(true);
                //int direction;
                
                switch (directionChooser) {
                    case 1:
                        spaceShip.setVisible(true);
                        spaceShip.setDirection(180);
                        spaceShip.setX(spaceShip.getParentWidth() + 530);
                        spaceShip.setY(spaceShip.getParentHeight() - 25);
                        //System.out.println(180);
                        //spaceShip.setX(550);
                        //pause();
                        break;
                    default:
                        spaceShip.setVisible(true);
                        spaceShip.setDirection(0);
                        spaceShip.setX(spaceShip.getParentWidth() - 120);
                        spaceShip.setY(spaceShip.getParentHeight() - 25);
                        //System.out.println(0);
                        //spaceShip.setX(0);
                        break;
                }
                
                wait = false;
            }
//            if (spaceShip.getBoundsInParent().intersects(cmdCenter.getProjectile().getBoundsInParent())) {
//                spaceShip.setVisible(false);
//                cmdCenter.getProjectile().setVisible(false);
//                wait = false;
//            }  
        }
        
        
    }
    
    public void updateScore() {
        int prev = Integer.parseInt(score.getText());
        int next = prev + spaceShip.setRandomPointValue();
        score.setText(next + "");
        //System.out.println(next);
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
