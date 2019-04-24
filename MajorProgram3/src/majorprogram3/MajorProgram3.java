/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorprogram3;

import java.awt.event.KeyEvent;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author akin
 */
public class MajorProgram3 extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        //ActionPane ap = new ActionPane();
        
        
        
        GamePane g = new GamePane();
        
        g.setStyle("-fx-background-color: #000000;");
        
        
        Scene s = new Scene(g, 550, 630);
        
        //s.setOnKeyPressed(new EventHandler<KeyEvent>());
        
        primaryStage.setTitle("lol");
        primaryStage.setScene(s);
        primaryStage.show();
        
        g.requestFocus();
    }
}
