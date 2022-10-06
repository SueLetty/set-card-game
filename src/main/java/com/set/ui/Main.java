package com.set.ui;

import java.security.SecureRandom;
import java.util.Scanner;
import java.util.Timer;

/**
 * start playing the game.
 */
public class Main{

  /**
   * Threshold for timer
   */
  private static final int THRESHOLD = 120000;

  /**
   * the user can start a game. The user can choose to play a practice game or a challenge game.
   *
   * @param args String array
   */
  public static void main(String[] args) {
    SetGame game = new SetGame(new SecureRandom());
    System.out.println(
        "Do you want to play a practice game, or directly go to a challenge game?(p/c)");
    Scanner input = new Scanner(System.in);

    String userInput = input.next();
    if (userInput.equals("p")) {
      game.display();
    } else if (userInput.equals("c")) {
      Thread thread = new Thread(game);
      thread.start();
      Timer timer = new Timer();
      TimeOutTask timeOutTask = new TimeOutTask(thread, timer, game);
      timer.schedule(timeOutTask, THRESHOLD);
    } else {
      System.out.println("Please enter a valid input. "
          + "\np for a practice game"
          + "\nc for a challenge game");
      main(args);
    }


  }

}
