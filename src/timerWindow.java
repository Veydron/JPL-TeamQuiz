package ch.ffhs.semester2.jpl.projectgame;

import javafx.stage.Stage;

public class timerWindow {

  //Countdown
  //startQuizWindow();

  private static void startQuizWindow() {
    // Create an instance of QuizWindow
    QuizWindow quizWindow = new QuizWindow();

    // Call the start method of QuizWindow to show the new window
    quizWindow.start(new Stage());
  }
}
