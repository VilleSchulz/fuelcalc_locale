package org.example;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class FuelCalcController extends Application {
    ResourceBundle rb;
    Locale locale;
    public Label lblDistance;
    public TextField txtDistance;
    public Label lblFuel;
    public TextField txtFuel;
    public Button btnCalculate;
    public Label lblResult;
    Double result;
    String resultString;


    @FXML

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fuelcalc.fxml"));
        Parent root = fxmlLoader.load();
        stage.setScene(new Scene(root));
        stage.show();


    }

    public void initialize() {
        locale = new Locale("en", "EN");
        setLanguage();
    }


    public void onENClick(ActionEvent actionEvent) {
        locale = new Locale("en", "EN");
        setLanguage();


    }

    public void onFRClick(ActionEvent actionEvent) {
        locale = new Locale("fr", "FR");
        setLanguage();
    }

    public void onJPClick(ActionEvent actionEvent) {
        locale = new Locale("ja", "JP");
        setLanguage();
    }

    public void onIRClick(ActionEvent actionEvent) {
        locale = new Locale("fa", "IR");
        setLanguage();
    }



    public void setLanguage(){
        rb = ResourceBundle.getBundle("messages", locale);
        lblDistance.setText(rb.getString("distance.label"));
        lblFuel.setText(rb.getString("fuel.label"));
        btnCalculate.setText(rb.getString("calculate.button"));
        if(result!=null){
          resultString  = MessageFormat.format(rb.getString("result.label"), result);

        }
        else{
            resultString = "Result here";

        }
        lblResult.setText(resultString);

    }

    public void onCalculateClick(ActionEvent actionEvent) {

        String distance = txtDistance.getText();
        String fuel = txtFuel.getText();

        try{
            double distanceDouble = Double.parseDouble(distance);
            double fuelDouble = Double.parseDouble(fuel);
            result = distanceDouble/fuelDouble;
        }
        catch(NumberFormatException e){
            lblResult.setText(rb.getString("invalid.input"));
            return;
        }

        String resultString = MessageFormat.format(rb.getString("result.label"), result);
        lblResult.setText(resultString);

    }
}
