package com.guessinggame;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import static javafx.scene.paint.Color.GREEN;
import static javafx.scene.paint.Color.RED;

public class Controller implements Initializable {
    @FXML
    private Pane shake_pane , pane1;
    @FXML
    private Label output_label, random_label, countLabel, label1;
    @FXML
    private TextField guess_tField;
    private String guessNum, randomNum;
    private int count = 0, digits;
    private boolean flag = true;
    Check_Number checkNumber = new Check_Number();

    public void btnAction(ActionEvent event) {
        Button button = (Button) event.getSource();
        guess_tField.setText(guess_tField.getText() + button.getText());
    }

    public void cbtnAction(ActionEvent event) {
        guess_tField.setText("");
    }

    public void okbtnAction(ActionEvent event) {
        submit();
    }
    public void okKeyPress(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER || event.getCode() == KeyCode.SPACE) {
            System.out.println("OK PRESSED");
            submit();
        }
    }

    public void restartbtnAction(ActionEvent event) {
        count = GameData.getInstance().getTimes();
        guess_tField.setText("");
        random_label.setText("");
        output_label.setText("");
        label1.setText("");
        flag = true;
        for (int i = 0; i < digits; i++) {
            random_label.setText(random_label.getText() + "*");
        }
        countLabel.setText(String.valueOf(count));
        randomNum = generateRandomNum(GameData.getInstance().getRandomDigits());
        System.out.println("Random : " + randomNum);
    }

    public void homebtnAction(ActionEvent event) throws IOException {
        new ChangePage().changePage(event, "home_page.fxml");
    }

    public String generateRandomNum(int digits) {
        System.out.println("digits : " + digits);
        int max = (int) (Math.pow(10, digits) - 1);
        int random = (int) (1 + Math.random() * max);
        String.format("%04d", random);
        return String.format("%0" + digits + "d", random);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        digits = GameData.getInstance().getRandomDigits();
        for (int i = 0; i < digits; i++) {
            random_label.setText(random_label.getText() + "*");
        }
        count = GameData.getInstance().getTimes();
        countLabel.setText(String.valueOf(count));
        randomNum = generateRandomNum(digits);
        System.out.println("Random number : " + randomNum);
    }

    public void showAlert(String text) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText(text);
        alert.showAndWait();
    }

    public void shakePane(Pane pane) {
        TranslateTransition t = new TranslateTransition(Duration.millis(100), pane);
        t.setFromX(0);
        t.setByX(10);
        t.setCycleCount(6);
        t.setAutoReverse(true);
        t.play();
    }

    public void submit() {
        if (count > 0 && flag) {
            count--;
            countLabel.setText(String.valueOf(count));
            shakePane(pane1);
            guessNum = guess_tField.getText().trim();

            System.out.println("random number : " + randomNum);
            System.out.println("guess number : " + guessNum);
            System.out.println("count : " + count);

            try {
                Integer.parseInt(guessNum);
                if (randomNum.length() == guessNum.length()) {
                    if (randomNum.equals(guessNum)) {
                        flag = false;
                    }
                    String output = checkNumber.checkNum(randomNum, guessNum);
                    output_label.setText(output);
                    shakePane(shake_pane);
                } else {
                    showAlert("Guess Number must be : " + GameData.getInstance().getRandomDigits() + " digits");
                }
            } catch (NumberFormatException e) {
                showAlert("Invalid Input");
            }

        }
        if (count == 0 || flag == false) {
            random_label.setText(randomNum);
            countLabel.setText(String.valueOf(count));
            if (flag) {
                label1.setText("You lose the game");
                label1.setTextFill(RED);
            } else{
                label1.setTextFill(GREEN);
                label1.setText("You Win");
            }

        }
    }
}