
import java.security.SecureRandom;
import java.util.Timer;


public class Main {

  public static void main(String[] args) {

    SetGame game = new SetGame(new SecureRandom());

    Thread thread = new Thread(game);
    thread.start();
    Timer timer = new Timer();
    TimeOutTask timeOutTask = new TimeOutTask(thread, timer, game);
    timer.schedule(timeOutTask, 120000);

  }

}
