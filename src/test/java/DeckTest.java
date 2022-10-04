import static org.junit.jupiter.api.Assertions.*;

import java.security.SecureRandom;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class DeckTest {
  private Deck deck;

  @Test
  void iterator() {

    ArrayList<String> list = new ArrayList<String>();
    list.iterator();

  }

  @Test
  void testShuffle() {
    Deck deck1 = new Deck();
    String original = deck1.toString();
    deck1.shuffle();
    String shuffled = deck1.toString();
    assertFalse(original.equals(shuffled));


  }

  @Test
  void testShuffleWithParameter() {
    Deck deck1 = new Deck();
    String original = deck1.toString();
    deck1.shuffle(new SecureRandom());
    String shuffled = deck1.toString();
    assertFalse(original.equals(shuffled));


  }

  @Test
  void testHashCode() {
    System.out.println(deck.hashCode());
  }

  @Test
  void testEquals() {
    Deck deck1 = new Deck();
    assertEquals(deck, deck1);
    Deck deck2 = new Deck();
    assertNotEquals(deck, deck2);

  }

  @Test
  void testToString() {
    System.out.println(deck.toString());
    assertEquals("One, Purple_circle, Outlined", deck.toString());
  }
}