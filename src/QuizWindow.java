package ch.ffhs.semester2.jpl.projectgame;

import java.util.Comparator;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

public class QuizWindow extends Application {

  private static final int COUNTDOWN_DURATION = 20; // in seconds
  private int countdownTime = COUNTDOWN_DURATION;
  private Timeline timeline;

  private int currentPlayerIndex = 0;
  private ObservableList<Player> players;


  private Label countdownLabel;



  public void start(Stage primaryStage) {

    String [][] quiz =
        {{"Frage 1: Im Gegensatz zum «Derby» wird der «Oxford» in der Regel ...?",
          "*A parallel- und nicht kreuzgeschnürt",
          "B nur alle drei Tage gestutzt",
          "C nur mit Eingriff von links angeboten",},
        {"Frage 2: Welchen Fehler machte Donald Trump, als er den Kansas City\n"
            + "Chiefs zum Super-Bowl-Sieg 2020 gratulierte?",
            "A Beim Anruf landete er bei einem hawaiianischen Restaurant.",
            "B Er gratulierte den Verlierern, weil er das Ergebnis nicht abwartete.",
            "C* Er dachte, der Sieger käme aus dem Bundesstaat Kansas."},
        {"Frage 3: Das schwedische Dorf Ytterby liegt auf einer kleinen Schäreninsel und\n"
            + "erhielt im 19. Jahrhundert weltweite Bekanntheit, weil ...?",
            "A* vier neuentdeckte chemische Elemente nach ihm benannt wurden",
            "B dort in Jules Vernes «Von der Erde zum Mond» die Rakete startete",
            "C der Schreibtisch für die US-Präsidenten dort gefertigt wurde"},
        {"Frage 4: Wer überprüfen möchte, ob erhitztes Öl die richtige Temperatur\n"
            + "zum Frittieren hat, kann ...?",
            "A ein Edelstahlmesser kurz in das Öl tunken",
            "B eine Kartoffel für einige Sekunden knapp über das Öl halten",
            "C* etwas Paniermehl hineinstreuen"}};

    Button answer1 = new Button(quiz[0][1]);
    Button answer2 = new Button(quiz[0][2]);
    Button answer3 = new Button(quiz[0][3]);

    answer1.setPrefWidth(600);
    answer1.setPrefHeight(100);
    answer1.setOnAction(e -> incrementPlayerPoints());

    answer2.setPrefWidth(600);
    answer2.setPrefHeight(100);
    answer2.setOnAction(e -> incrementPlayerPoints());

    answer3.setPrefWidth(600);
    answer3.setPrefHeight(100);
    answer3.setOnAction(e -> incrementPlayerPoints());

    VBox buttonBox = new VBox(5);
    buttonBox.getChildren().addAll(answer1, answer2, answer3);
    buttonBox.setAlignment(Pos.BOTTOM_CENTER);

    Rectangle rectangle = new Rectangle();

    // Setting the properties of the rectangle
    rectangle.setX(200);
    rectangle.setY(400);
    rectangle.setWidth(700);
    rectangle.setHeight(100);
    rectangle.setArcWidth(30.0);
    rectangle.setArcHeight(20.0);
    rectangle.setFill(Color.CORNFLOWERBLUE);

    // Text of question - placeholder
    Label questionText = new Label(quiz[0][0]);
    questionText.setMinWidth(Region.USE_PREF_SIZE);
    questionText.setFont(Font.font("Cascadia", FontWeight.BOLD, 20));

    // Creating stack pane to layer question on top of rectangle
    StackPane questionStackPane = new StackPane(rectangle, questionText);
    StackPane.setAlignment(questionText, Pos.CENTER);

    // [][]

    // [Player1Name], [punkte in int]
    // [Player1Name], [punkte in int]
    // [Player1Name], [punkte in int]
    // [Player1Name], [punkte in int]

    //erstelle Array


    // UI -> erstellt ein Array
    // UI -> befüllt das array mit dummy text der vom server überschrieben werrden kann Player1 0
    // UI -> hat eine funktiondie den Inhalt des Arrays auf der U I Darstellt
    // Serer -> scheibt i dn Array de Spieler namen und die Punktezahl
    //Server -> ruft dieUI Funktion auf die den Array Inhalt auf der UI Darstellt.

    // Create ranking list
    players =
        FXCollections.observableArrayList(

            new Player(NameSelector.getName(), 10),
            new Player("Player 2", 8),
            new Player("Player 3", 12),
            new Player("Player 4", 13));

    ListView<Player> rankingListView = new ListView<>();
    rankingListView.setPrefWidth(300);
    rankingListView.setPrefHeight(200); // Set preferred height
    rankingListView.setMaxHeight(200); // Set maximum height
    rankingListView.setFixedCellSize(30); // Set height of each cell

    // Sort players by points
    players.sort(Comparator.comparingInt(Player::getPoints).reversed());

    rankingListView.setItems(players);
    rankingListView.setCellFactory(
        param ->
            new ListCell<>() {
              @Override
              protected void updateItem(Player player, boolean empty) {
                super.updateItem(player, empty);
                if (empty || player == null) {
                  setText(null);
                } else {
                  setText(player.getName() + " - " + player.getPoints() + " points");
                }
              }
            });

    // Create countdown label - never used so far - integrate!!!
    Label countdownLabel = new Label("Time remaining: " + countdownTime);
    countdownLabel.setFont(Font.font("Cascadia", FontWeight.BOLD, 16));

    // Create timeline for countdown
    timeline =
        new Timeline(
            new KeyFrame(
                Duration.seconds(1),
                e -> {
                  countdownTime--;
                  if (countdownTime >= 0) {
                    countdownLabel.setText("Time remaining: " + countdownTime);
                  } else {
                    timeline.stop();
                    countdownLabel.setText("Time's up!");
                  }
                }));
    timeline.setCycleCount(COUNTDOWN_DURATION);

    // Start the countdown
    timeline.play();


    // Setting up and formatting rootVbox
    VBox rootVbox = new VBox(50);
    rootVbox.getChildren().addAll(countdownLabel, rankingListView, questionStackPane, buttonBox);
    rootVbox.setAlignment(Pos.BOTTOM_CENTER);
    Insets inset = new Insets(30, 10, 30, 10);
    rootVbox.setPadding(inset);

    Scene scene = new Scene(rootVbox, 900, 800, Color.BLANCHEDALMOND);
    primaryStage.setTitle("Quiz Fenster");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  private void incrementPlayerPoints() {
    // Find the player named "NameSelector.getName()"
    // Find the index of the player
    int currentPlayerIndex = -1;
    for (int i = 0; i < players.size(); i++) {
      if (players.get(i).getName().equals(NameSelector.getName())) {
        currentPlayerIndex = i;
        break;
      }
    }

    // Increment the points if the player is found
    if (currentPlayerIndex != -1) {
      Player currentPlayer = players.get(currentPlayerIndex);
      currentPlayer.setPoints(currentPlayer.getPoints() + 1);
      players.set(currentPlayerIndex, currentPlayer);
    }

    ListView<Player> rankingListView = new ListView<>();
    rankingListView.setPrefWidth(300);
    rankingListView.setPrefHeight(200); // Set preferred height
    rankingListView.setMaxHeight(200); // Set maximum height
    rankingListView.setFixedCellSize(30); // Set height of each cell
    players.sort(Comparator.comparingInt(Player::getPoints).reversed());

    rankingListView.setItems(players);
    rankingListView.setCellFactory(
        param ->
            new ListCell<>() {
              @Override
              protected void updateItem(Player player, boolean empty) {
                super.updateItem(player, empty);
                if (empty || player == null) {
                  setText(null);
                } else {
                  setText(player.getName() + " - " + player.getPoints() + " points");
                }
              }
            });
  }

  public static void main(String[] args) {
    launch(args);
  }
}
