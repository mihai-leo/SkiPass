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

public class DeletePass {
    @FXML
    private Label label= new Label();
    @FXML
    private TextField phone=new TextField();
    @FXML
    protected void deletePass()
    {
        Utility util=new Utility();
        if(!phone.getText().isEmpty())
        {
            if (util.isInFille(phone.getText(),"baza.txt"))
            {
                int[][] mat=util.readStock("stock.txt");
                EquipmentStock stock= new EquipmentStock(mat[3],mat[1],mat[7],mat[5],mat[0],mat[6],mat[4]);
                SkiPass pass;
               String string = new String();
               string=   util.removeFromFile(phone.getText(),"baza.txt");
               if(util.wordInString("PointPass",string)) {
                    pass = new PointPass();
                   pass = util.stringToPointPass(string);
                   ((PointPass)pass).printPass();
               }else if(util.wordInString("HourPass",string))
               {
                   pass = new HourPass();
                   pass = util.stringToHourPass(string);
                   ((HourPass)pass).printPass();
               }
               else {
                    pass = new DayPass();
                   pass = util.stringToDayPass(string);
                   ((DayPass)pass).printPass();
               }
               label.setText("has to return:\n"+pass.bootSki+" ski boots\n"+pass.Ski+" ski\n"+pass.bootSnowboard+" snowboard boots\n"+pass.Snowboard+" snowboard\n");
                stock.returnSki(pass.Ski);
                stock.returnSnowboard(pass.Snowboard);
                stock.returnSnowboardBoots(pass.bootSnowboard);
                stock.returnSkiBoots(pass.bootSki);
                stock.printStock();
               System.out.println("removed");
            }
            else {
                label.setText("Phone not register");
            }
        }else
        {
            label.setText("Need to add phone");
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
