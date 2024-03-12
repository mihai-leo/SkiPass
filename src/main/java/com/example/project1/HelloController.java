package com.example.project1;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    private Stage stage;
    @FXML
    protected void openAddPass(ActionEvent event)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("add-pass.fxml"));
        stage= (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
       // stage.setTitle("Heo!");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void openUpdatePass(ActionEvent event)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("update-pass.fxml"));
        stage= (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        // stage.setTitle("Heo!");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void openDeletePass(ActionEvent event)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("delete-pass.fxml"));
        stage= (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        // stage.setTitle("Heo!");
        stage.setScene(scene);
        stage.show();
    }    @FXML
    protected void openScan(ActionEvent event)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("scan-pass.fxml"));
        stage= (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        // stage.setTitle("Heo!");
        stage.setScene(scene);
        stage.show();
    }

}