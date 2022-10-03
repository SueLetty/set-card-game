import java.security.SecureRandom;

public class Main {

  public static void main(String[] args) {
    SetGame game = new SetGame(new SecureRandom());
    game.play();

  }

}
