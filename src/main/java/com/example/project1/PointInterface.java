package com.example.project1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class PointInterface  {

    @FXML
    private Label label= new Label();
    @FXML
    private TextField name=new TextField();
    @FXML
    private TextField phoneNumber=new TextField();
    @FXML
    private TextField points =new TextField();
    @FXML
    private TextField ski =new TextField();
    @FXML

    private TextField skiBoot=new TextField();
    @FXML
    private TextField snowboard=new TextField();
    @FXML
    private TextField snowboardBoot =new TextField();
    @FXML
    protected void addPass()
    {


        Utility util= new Utility();
        int[][] mat=util.readStock("stock.txt");
        EquipmentStock stock= new EquipmentStock(mat[3],mat[1],mat[7],mat[5],mat[0],mat[6],mat[4]);
        if (util.isInFille(phoneNumber .getText(),"baza.txt"))
        {
            label.setText("Phone is used");
        }
        else if(name.getText().isEmpty()||phoneNumber.getText().isEmpty()||points.getText().isEmpty())
        {
            label.setText("All fields need to be full");
        }
        else
        {
            try
            {
                int bSk;
                if (skiBoot.getText().isEmpty())
                        bSk = 0;
                else
                        bSk = Integer.parseInt(skiBoot.getText());
                int bSn;
                if (snowboardBoot.getText().isEmpty())
                    bSn = 0;
                else
                    bSn = Integer.parseInt(snowboardBoot.getText());
                int sk;
                if (ski.getText().isEmpty())
                    sk = 0;
                else
                    sk = Integer.parseInt(ski.getText());
                int sn;
                if (snowboard.getText().isEmpty())
                    sn = 0;
                else
                    sn = Integer.parseInt(snowboard.getText());
                if(!stock.borrowSkiBoots(bSk)&&bSk!=0)
                {
                    label.setText("Ski boots not on stock ");
                }
                else if(!stock.borrowSki(sk)&&sk!=0)
                {
                    label.setText("Ski not on stock ");
                }
                else if(!stock.borrowSnowboardBoots(bSn)&&bSn!=0)
                {
                    label.setText("Snowboard boots not on stock ");
                }
                else if (!stock.borrowSnowboard(sn)&&sn!=0)
                {
                    label.setText("Snowboard not on stock ");

                }
                else {
                    PointPass pass = new PointPass(name.getText(), phoneNumber.getText(), LocalDate.now(), Integer.parseInt(points.getText()), bSn, bSk, sn, sk);
                    pass.printPass();
                    pass.printInFille("baza.txt");
                    label.setText("All good that will be " + pass.price);
                }
            }
            catch (Exception e)
            {
                label.setText("Need to be numbers");

            }
            stock.printStock();

        }
    }
    @FXML
    protected void goHome(ActionEvent event)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Stage stage= (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }
}
