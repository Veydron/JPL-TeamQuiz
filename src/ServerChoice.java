package ch.ffhs.semester2.jpl.projectgame;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ServerChoice extends Application {

  public void start(Stage primaryStage) {
    // Erstellen der Buttons
    Button button1 = new Button("Server");
    Button button2 = new Button("Client");

    // Anpassen der Größe und Farbe der Buttons
    button1.setPrefWidth(200);
    button1.setPrefHeight(150);
    button1.setStyle(
        "-fx-border-width: 5px; -fx-border-color: #00008B; -fx-background-color: "
            + "#6495ED; -fx-font-size: 2em;");
    button1.setOnMouseEntered(
        e ->
            button1.setStyle(
                "-fx-border-width: 7px; -fx-border-color: "
                    + "#00008B; -fx-background-color: #ADD8E6; -fx-font-size: 2em;"));
    button1.setOnMouseExited(
        e ->
            button1.setStyle(
                "-fx-border-width: 5px; -fx-border-color: "
                    + "#00008B; -fx-background-color: #6495ED; -fx-font-size: 2em;"));

    button2.setPrefWidth(200);
    button2.setPrefHeight(150);
    button2.setStyle(
        "-fx-border-width: 5px; -fx-border-color: #00008B; -fx-background-color: "
            + "#6495ED; -fx-font-size: 2em;");
    button2.setOnAction(this::processButtonPress2);
    button2.setOnMouseEntered(
        e ->
            button2.setStyle(
                "-fx-border-width: 7px; -fx-border-color: "
                    + "#00008B; -fx-background-color: #ADD8E6; -fx-font-size: 2em;"));
    button2.setOnMouseExited(
        e ->
            button2.setStyle(
                "-fx-border-width: 5px; -fx-border-color: "
                    + "#00008B; -fx-background-color: #6495ED; -fx-font-size: 2em;"));
    button2.setOnMouseClicked(
        e ->
            button2.setStyle(
                "-fx-border-width: 5px; -fx-border-color: "
                    + "#00008B; -fx-background-color: #6495ED; -fx-font-size: 2em;"));

    // Erstellen einer horizontalen Box und Hinzufügen der Buttons
    HBox hbox = new HBox(100);
    hbox.getChildren().addAll(button1, button2);
    hbox.setAlignment(Pos.CENTER);

    // Erstellen der Szene und Hinzufügen der Box
    Scene scene = new Scene(hbox, 700, 500, Color.BLANCHEDALMOND);

    // Setzen des Titels des Fensters
    primaryStage.setTitle("Server-Wahl");

    // Setzen der Szene des Fensters und Anzeigen des Fensters
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private void processButtonPress2(ActionEvent event) {
    Stage primaryStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    primaryStage.close();

    // Create an instance of QuizWindow
   NameSelector nameSelector = new NameSelector();

    // Call the start method of QuizWindow to show the new window
    nameSelector.start(new Stage());
  }

  public static void main(String[] args) {
    launch(args);
  }
}
