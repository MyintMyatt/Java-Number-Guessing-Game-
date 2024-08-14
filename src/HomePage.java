package com.guessingnumber;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomePage implements Initializable {
    @FXML
    private Spinner<Integer> spinner;
    private SpinnerValueFactory<Integer> svf = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 15, 5);
    public void spinnerAction(MouseEvent mouseEvent) {
        System.out.println(spinner.getValue());
    }

    public void startbtnAction(ActionEvent event) throws IOException {
        System.out.println(spinner.getValue());
        new ChangePage().changePage(event,"guessing_num.fxml");
    }

    public void exitbtnAction(ActionEvent event) {
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        spinner.setValueFactory(svf);
    }
}

