package ch.ffhs.semester2.jpl.projectgame;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class NameSelector extends Application {

  private static String name;
  private TextField nameInput;


  public void start(Stage primaryStage){
    Text greeting = new Text("Bitte geben Sie hier Ihren Namen ein!");
    greeting.setFont(Font.font("Cascadia", FontWeight.BOLD, 16));

    Label label1 = new Label("Name:");
    label1.setFont(Font.font("Cascadia", FontWeight.BOLD, 16));
    nameInput = new TextField ();
    HBox hbox = new HBox();
    hbox.getChildren().addAll(label1, nameInput);
    hbox.setSpacing(20);
    hbox.setAlignment(Pos.CENTER);

    Button confirmButton = new Button("Bestätigen");
    confirmButton.setPrefHeight(40);
    confirmButton.setPrefWidth(120);
    confirmButton.setOnAction(this::processButtonPress);
    VBox vbox = new VBox();
    vbox.getChildren().addAll(greeting, hbox, confirmButton);
    vbox.setSpacing(60);
    vbox.setAlignment(Pos.CENTER);

    Scene scene = new Scene(vbox, 700, 500, Color.BLANCHEDALMOND);
    primaryStage.setTitle("Namenswahl");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private void processButtonPress(ActionEvent event) {
    Stage primaryStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    primaryStage.close();

    getPlayerName();
  }

  private void getPlayerName() {
    name = nameInput.getText();

    // Create an instance of QuizWindow
    WaitingLobby waitingLobby = new WaitingLobby();

    // Call the start method of QuizWindow to show the new window
    waitingLobby.start(new Stage());
  }

  public static String getName(){
    return name;
  }

  public void setName(String name){
    this.name = name;
  }
}
