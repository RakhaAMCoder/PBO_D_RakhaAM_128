package com.example.modul_6;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TebakAngkaApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Memuat file FXML untuk tampilan UI
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TebakAngka.fxml"));
        Parent root = loader.load();

        // Mengatur scene
        Scene scene = new Scene(root, 400, 250);

        // Menghubungkan file CSS ke scene
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        // Mengatur stage (jendela aplikasi)
        primaryStage.setTitle("Tebak Angka Advance");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false); // Agar ukuran jendela tidak bisa diubah
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}