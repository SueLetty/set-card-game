package com.set.ui;

import com.set.ui.SetGame;
import java.util.Timer;
import java.util.TimerTask;

/**
 * create timer for the game.
 */
public class TimeOutTask extends TimerTask {

  /**
   * create a thread
   */
  private final Thread thread;
  /**
   * create a timer
   */
  private final Timer timer;
  /**
   * create an instance of SetGame
   */
  private final SetGame game;

  /**
   * constructor
   * initialize all the fields
   * @param thread Thread
   * @param timer Timer
   * @param game SetGame
   */

  public TimeOutTask(Thread thread, Timer timer, SetGame game) {

    this.thread = thread;
    this.timer = timer;
    this.game = game;
  }

  @Override
  public void run() {
    if (thread != null && thread.isAlive()) {
      thread.interrupt();
      timer.cancel();
      System.out.printf("You are out of time! You have found %d set(s)!", game.getCount());
      System.exit(0);

    }
  }
}
