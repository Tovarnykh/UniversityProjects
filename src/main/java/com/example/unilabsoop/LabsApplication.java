package com.example.unilabsoop;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class LabsApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LabsApplication.class.getResource("loginscreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 533);
        stage.getIcons().add(new Image("https://nuft.edu.ua/assets/images/pro-universitet/symvolika/loga-nuft.jpg"));
        stage.setTitle("Tovarnykh_KH-2-4_LABS");
        stage.setScene(scene);
        stage.show();}
    public static void main(String[] args) {
        launch();

    }
}