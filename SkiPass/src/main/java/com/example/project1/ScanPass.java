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

public class ScanPass {
    @FXML
    private Label label= new Label();
    @FXML
    private TextField phone=new TextField();
    @FXML

    protected void uptadePass()
    {
        Utility util=new Utility();
        if(!phone.getText().isEmpty())
        {
            if (util.isInFille(phone.getText(),"baza.txt"))
            {
                SkiPass pass;
                String string = new String();
                string=   util.removeFromFile(phone.getText(),"baza.txt");
                if(util.wordInString("PointPass",string)) {
                    pass = new PointPass();
                    pass = util.stringToPointPass(string);
                    if(((PointPass)pass).isActive())
                    {
                        ((PointPass)pass).usePoints(1);
                        label.setText("Activ\n"+((PointPass) pass).getPoints()+" points remaining");
                    }else
                    {
                        label.setText("Inactiv");
                    }
                    ((PointPass)pass).printInFille("baza.txt");
                    ((PointPass)pass).printPass();
                }else if(util.wordInString("HourPass",string))
                {
                    pass = new HourPass();
                    pass = util.stringToHourPass(string);
                    if(((HourPass)pass).isActive())
                    {

                        label.setText("Activ \n"+"Expire at"+((HourPass) pass).getTimeEnd());
                    }else
                    {
                        label.setText("Inactiv");
                    }
                    ((HourPass)pass).printInFille("baza.txt");
                    ((HourPass)pass).printPass();
                }
                else {
                    pass = new DayPass();
                    pass = util.stringToDayPass(string);
                    if(((DayPass)pass).isActive())
                    {

                        label.setText("Activ \n"+"Expire at"+((DayPass) pass).getDataEnd());
                    }else
                    {
                        label.setText("Inactiv");
                    }
                    ((DayPass)pass).printInFille("baza.txt");
                    ((DayPass)pass).printPass();
                }

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
