package com.example.modul_6;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.Random;

public class TebakAngkaController {

    @FXML
    private Label feedbackLabel;
    @FXML
    private TextField guessTextField;
    @FXML
    private Button guessButton;
    @FXML
    private Label attemptsLabel;
    @FXML
    private Button playAgainButton;

    private int randomNumber;
    private int attempts;

    @FXML
    public void initialize() {
        resetGame();
    }

    private void resetGame() {
        Random random = new Random();
        randomNumber = random.nextInt(100) + 1;
        attempts = 0;

        feedbackLabel.setText("");
        feedbackLabel.getStyleClass().removeAll("feedback-correct", "feedback-too-big", "feedback-too-small");
        guessTextField.setText("");
        attemptsLabel.setText("Jumlah percobaan: 0");

        guessTextField.setDisable(false);
        guessButton.setDisable(false);
        playAgainButton.setVisible(false);

        System.out.println("Angka rahasia (untuk debugging): " + randomNumber);
    }

    @FXML
    private void handleCobaTebak() {
        String guessText = guessTextField.getText();
        feedbackLabel.setText("");
        feedbackLabel.getStyleClass().removeAll("feedback-correct", "feedback-too-big", "feedback-too-small");

        if (guessText.isEmpty()) {
            feedbackLabel.setText("Masukkan angka!");
            feedbackLabel.getStyleClass().add("feedback-too-big");
            return;
        }

        int userGuess;
        try {
            userGuess = Integer.parseInt(guessText);
            if (userGuess < 1 || userGuess > 100) {
                feedbackLabel.setText("Angka harus antara 1-100!");
                feedbackLabel.getStyleClass().add("feedback-too-big");
                return;
            }
        } catch (NumberFormatException e) {
            feedbackLabel.setText("Input harus angka!");
            feedbackLabel.getStyleClass().add("feedback-too-big");
            return;
        }

        attempts++;
        attemptsLabel.setText("Jumlah percobaan: " + attempts);

        if (userGuess < randomNumber) {
            feedbackLabel.setText("▼ Terlalu kecil!");
            feedbackLabel.getStyleClass().add("feedback-too-small");
        } else if (userGuess > randomNumber) {
            feedbackLabel.setText("▲ Terlalu besar!");
            feedbackLabel.getStyleClass().add("feedback-too-big");
        } else {
            feedbackLabel.setText("✓ Tebakan benar!");
            feedbackLabel.getStyleClass().add("feedback-correct");
            guessTextField.setDisable(true);
            guessButton.setDisable(true);
            playAgainButton.setVisible(true);
        }
    }

    @FXML
    private void handleMainLagi() {
        resetGame();
    }
}