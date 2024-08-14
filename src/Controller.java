package com.guessingnumber;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private Label output_label,random_label;
    @FXML
    private TextField guess_tField;
    private String guessNum , randomNum;
    Check_Number checkNumber = new Check_Number();
    public void btnAction(ActionEvent event) {
        Button button = (Button) event.getSource();
        guess_tField.setText(guess_tField.getText() + button.getText());
    }

    public void cbtnAction(ActionEvent event) {
        guess_tField.setText("");
    }

    public void okbtnAction(ActionEvent event) {
        guessNum = guess_tField.getText().trim();
        checkNumber.checkNum(randomNum, guessNum);
    }

    public void restartbtnAction(ActionEvent event) {
        randomNum = Integer.toString(generateRandomNum());
    }

    public void homebtnAction(ActionEvent event) throws IOException {
        new ChangePage().changePage(event,"home_page.fxml");
    }

    public int generateRandomNum() {
        return (int) (1 + Math.random() * 9999);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        randomNum = String.valueOf(generateRandomNum());
    }
}