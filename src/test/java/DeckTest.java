import static org.junit.jupiter.api.Assertions.*;

import java.security.SecureRandom;
import java.util.Iterator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DeckTest {

  private Deck deck;

  @BeforeEach
  public void init() {
    deck = new Deck();
  }

  @Test
  void testIterator() {
    Iterator<Card> iterator = deck.iterator();
    int count = 0;
    while (iterator.hasNext()) {
      iterator.next();
      count++;
    }
    assertEquals(81, count);


  }

  @Test
  void testShuffle() {
    Deck deck1 = new Deck();
    String original = deck1.toString();
    deck1.shuffle();
    String shuffled = deck1.toString();
    assertNotEquals(original, shuffled);


  }

  @Test
  void testShuffleWithParameter() {
    Deck deck1 = new Deck();
    String original = deck1.toString();
    deck1.shuffle(new SecureRandom());
    String shuffled = deck1.toString();
    assertNotEquals(original, shuffled);


  }

  @Test
  void testHashCode() {
    Deck deck1 = new Deck();
    assertNotEquals(deck1.hashCode(), deck.hashCode());

  }

  @Test
  void testEquals() {
    Deck deck1 = deck;
    assertEquals(deck, deck1);
    Deck deck2 = new Deck();
    assertEquals(deck, deck2);

  }

  @Test
  void testToString() {
    Deck deck1 = deck;
    assertEquals(deck1.toString(), deck.toString());


  }
}