package com.guessinggame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomePage implements Initializable {
    @FXML
    private Spinner<Integer> spinner,randomSpinner;
    private SpinnerValueFactory<Integer> svf = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 15, 5);
    private SpinnerValueFactory<Integer> svf1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(4, 8, 4);


    public void startbtnAction(ActionEvent event) throws IOException {
        GameData.getInstance().setRandomDigits(randomSpinner.getValue());
        GameData.getInstance().setTimes(spinner.getValue());
        new ChangePage().changePage(event,"guessing_num.fxml");
    }

    public void exitbtnAction(ActionEvent event) {
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        spinner.setValueFactory(svf);
        randomSpinner.setValueFactory(svf1);
    }

}

