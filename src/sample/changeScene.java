package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import javafx.event.ActionEvent;

import java.io.IOException;

import static javafx.fxml.FXMLLoader.load;

public class changeScene {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchScene1(ActionEvent event) throws IOException {
        Parent root= load(getClass().getResource("sample.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchScene2(ActionEvent event) throws IOException {
        Parent root= load(getClass().getResource("pausemenu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
