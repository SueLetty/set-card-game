import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


public class Deck implements Iterable<Card> {

  private final List<Card> cards;

  public Deck() {
    cards = new ArrayList<>();
    for (Color color : Color.values()) {
      for (Shading shading : Shading.values()) {
        for (Number number : Number.values()) {
          for (Shape shape : Shape.values()) {
            Card card = new Card( number, shape, color, shading);
            cards.add(card);
          }
        }
      }
    }
  }


  @Override
  public Iterator<Card> iterator() {
    return Collections.unmodifiableList(cards).iterator();
  }

  public void shuffle(Random rng) {
    Collections.shuffle(cards, rng);

  }


  public void shuffle() {
    Collections.shuffle(cards);
  }

  public void sort() {

  }

  public void sort(Comparator<Card> comparator) {
    cards.sort(comparator);

  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    boolean result;
    if (this == obj) {
      result = true;

    } else if (obj instanceof Deck) {
      result = cards.equals(((Deck) obj).cards);

    } else {
      result = false;

    }
    return result;
  }

  @Override
  public String toString() {
    return cards.toString();
  }

}
