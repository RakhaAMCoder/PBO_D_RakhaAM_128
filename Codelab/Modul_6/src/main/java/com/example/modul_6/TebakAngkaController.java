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
        // Dipanggil saat FXML selesai dimuat
        resetGame();
    }

    private void resetGame() {
        Random random = new Random();
        randomNumber = random.nextInt(100) + 1; // Angka acak dari 1 sampai 100
        attempts = 0;

        feedbackLabel.setText(""); // Kosongkan feedback
        feedbackLabel.getStyleClass().removeAll("feedback-correct", "feedback-too-big", "feedback-too-small"); // Hapus styling sebelumnya
        guessTextField.setText(""); // Kosongkan input
        attemptsLabel.setText("Jumlah percobaan: 0"); // Reset jumlah percobaan

        guessTextField.setDisable(false); // Aktifkan input
        guessButton.setDisable(false); // Aktifkan tombol tebak
        playAgainButton.setVisible(false); // Sembunyikan tombol "Main Lagi"

        System.out.println("Angka rahasia (untuk debugging): " + randomNumber); // Untuk debugging
    }

    @FXML
    private void handleCobaTebak() {
        String guessText = guessTextField.getText();
        feedbackLabel.setText(""); // Bersihkan feedback sebelumnya
        feedbackLabel.getStyleClass().removeAll("feedback-correct", "feedback-too-big", "feedback-too-small");

        if (guessText.isEmpty()) {
            feedbackLabel.setText("Masukkan angka!");
            feedbackLabel.getStyleClass().add("feedback-too-big"); // Bisa pakai styling error
            return;
        }

        int userGuess;
        try {
            userGuess = Integer.parseInt(guessText);
            if (userGuess < 1 || userGuess > 100) {
                feedbackLabel.setText("Angka harus antara 1-100!");
                feedbackLabel.getStyleClass().add("feedback-too-big"); // Bisa pakai styling error
                return;
            }
        } catch (NumberFormatException e) {
            feedbackLabel.setText("Input bukan angka!");
            feedbackLabel.getStyleClass().add("feedback-too-big"); // Bisa pakai styling error
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
            guessTextField.setDisable(true); // Nonaktifkan input
            guessButton.setDisable(true); // Nonaktifkan tombol tebak
            playAgainButton.setVisible(true); // Tampilkan tombol "Main Lagi"
        }
    }

    @FXML
    private void handleMainLagi() {
        resetGame();
    }
}