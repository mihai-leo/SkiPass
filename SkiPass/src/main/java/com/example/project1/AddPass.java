package com.example.project1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AddPass {
    private Stage stage;
    @FXML
    protected void openDayInterface(ActionEvent event)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("day-interface.fxml"));
        stage= (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        // stage.setTitle("Heo!");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void openHourInterface(ActionEvent event)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hour-interface.fxml"));
        stage= (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        // stage.setTitle("Heo!");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void openPointInterface(ActionEvent event)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("point-interface.fxml"));
        stage= (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        // stage.setTitle("Heo!");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void goHome(ActionEvent event)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        stage= (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }
}
