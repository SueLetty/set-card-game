import java.io.IOException;
import java.security.SecureRandom;

public class Main {

  public static void main(String[] args) throws IOException {
    SetGame game = new SetGame(new SecureRandom());
    game.play();


  }

}
