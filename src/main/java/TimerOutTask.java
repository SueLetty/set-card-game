import java.util.Timer;
import java.util.TimerTask;

class TimeOutTask extends TimerTask {
  private final Thread thread;
  private final Timer timer;
  private final SetGame game;


  public TimeOutTask(Thread thread, Timer timer, SetGame game) {
    this.thread = thread;
    this.timer = timer;
    this.game = game;
  }

  @Override
  public void run() {
    if(thread != null && thread.isAlive()) {
      thread.interrupt();
      timer.cancel();
      System.out.printf("You are out of time! You have found %d set(s)!", game.getCount());
      System.exit(0);

    }
  }
}
