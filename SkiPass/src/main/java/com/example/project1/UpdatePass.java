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

public class UpdatePass {
    @FXML
    private Label label= new Label();
    @FXML
    private TextField phone=new TextField();
    @FXML
    private TextField extra=new TextField();
    @FXML

    protected void uptadePass()
    {
        Utility util=new Utility();
        if(!phone.getText().isEmpty()||!extra.getText().isEmpty())
        {
            try {
                int aux=Integer.parseInt(extra.getText());
            if (util.isInFille(phone.getText(),"baza.txt"))
            {
                SkiPass pass;
                String string = new String();
                string=   util.removeFromFile(phone.getText(),"baza.txt");
                if(util.wordInString("PointPass",string)) {
                    pass = new PointPass();
                    pass = util.stringToPointPass(string);
                    label.setText("Price: "+((PointPass)pass).buyPoints(aux));
                    ((PointPass)pass).printInFille("baza.txt");
                    ((PointPass)pass).printPass();
                }else if(util.wordInString("HourPass",string))
                {
                    pass = new HourPass();
                    pass = util.stringToHourPass(string);
                    label.setText("Price: "+((HourPass)pass).buyHours(aux));
                    ((HourPass)pass).printInFille("baza.txt");
                    ((HourPass)pass).printPass();
                }
                else {
                    pass=new DayPass();
                    pass=util.stringToDayPass(string);
                    ((DayPass)pass).printInFille("baza.txt");
                    label.setText("Day passes can't be extended");
                }

                System.out.println("removed");
            }
            else {
                label.setText("Phone not register");
            }
            }
            catch (Exception e)
            {
                label.setText("Extra needs to be number");
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
