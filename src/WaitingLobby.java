package ch.ffhs.semester2.jpl.projectgame;

import java.io.FileInputStream;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class WaitingLobby extends Application {


  public void start(Stage primaryStage){
    Text greeting = new Text("Bitte bestätigen Sie, dass Sie bereit sind!");
    greeting.setFont(Font.font("Cascadia", FontWeight.BOLD, 16));


    Label label1 = new Label("Spieler");
    label1.setFont(Font.font("Cascadia", FontWeight.BOLD, 16));

    Label playerNameLabel = new Label(NameSelector.getName()); // Get the name from NameSelector
    playerNameLabel.setFont(Font.font("Cascadia", FontWeight.BOLD, 16));

    HBox hbox = new HBox();
    hbox.getChildren().addAll(label1, playerNameLabel);
    hbox.setSpacing(20);
    hbox.setAlignment(Pos.CENTER);

    Button confirmButton = new Button("Bereit?");
    confirmButton.setPrefHeight(40);
    confirmButton.setPrefWidth(120);
    confirmButton.setOnAction(this::processButtonPress);
    VBox vbox = new VBox();
    vbox.getChildren().addAll(greeting, hbox, confirmButton);
    vbox.setSpacing(60);
    vbox.setAlignment(Pos.CENTER);

    Scene scene = new Scene(vbox, 700, 500, Color.BLANCHEDALMOND);
    primaryStage.setTitle("Lobby");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  //Muss angepasst werden!! Neues Fenster öffnen muss separiert werden von Bereit-Signal. ProcessButtonPress soll nur funktion aufrufen.
  private void processButtonPress(ActionEvent event) {
    Stage primaryStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    primaryStage.close();

    //UI-Test
    //stageCountdown();

  }


  //private void stageCountdown(int Timerzeit){
  //timerWindow.start(new Stage(Timerzeit));
  // }
}
