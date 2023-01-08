package sample;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.fxml.FXMLLoader.load;
import static sample.Main.*;

public class Controller implements EventHandler<ActionEvent>{
    Stage hi;
    @FXML
    private Button singleplayer;
    @FXML
    private Button ex;

    public void handle(ActionEvent event) {
        try {
            startgame();
        } catch (Exception e) {
            e.printStackTrace();
        }
    };
    public void handle2(ActionEvent event) {
        try {
            exit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    };
    public void switchScene1(ActionEvent event) {
        try {
            homescreendikhjaebas(hi);
        }
        catch (Exception e) {
        e.printStackTrace();
        }
    };
}

//    private ImageView lesgo;
//
//

//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        Main m = new Main();
//        try {
//            m.startgame();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    public void initialize(URL arg0, ResourceBundle arg1) {
//        // translate
//        lesgo.toFront();
//        TranslateTransition translate = new TranslateTransition();
//        translate.setNode(lesgo);
//        translate.setDuration(Duration.millis(500));
//        translate.setCycleCount(TranslateTransition.INDEFINITE);
//        translate.setByY(50);
//        translate.setAutoReverse(true);
//        translate.play();
//    }
//    private EventHandler<KeyEvent> keyListener = new EventHandler<KeyEvent>() {
//        @Override
//        public void handle(KeyEvent event) {
//            if(event.getCode() == KeyCode.SPACE ) {
//                    TranslateTransition translate = new TranslateTransition();
//                    translate.setNode(lesgo);
//                    translate.setDuration(Duration.millis(100));
//                    translate.setByX(50);
//                    translate.setAutoReverse(false);
//                    translate.play();
//            }
//            event.consume();
//        }
//    };

