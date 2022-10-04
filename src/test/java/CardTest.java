import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CardTest {
  private Card card;

  @BeforeEach
  public void init(){
   card = new Card(Number.ONE, ShapeWithColor.PURPLECIRCLE, Shading.OUTLINED);

  }


  @Test
  void getShape() {
    assertSame(card.getShape(), ShapeWithColor.PURPLECIRCLE);
  }


  @Test
  void getNumber() {
    assertEquals("One", card.getNumber().toString());
  }


  @Test
  void getShading() {
    assertEquals("Outlined", card.getShading().toString());
  }

  @Test
  void testHashCode() {
    System.out.println(card.hashCode());
  }

  @Test
  void testEquals() {
    Card other1 = new Card(Number.ONE, ShapeWithColor.PURPLECIRCLE, Shading.OUTLINED);
    assertEquals(card, other1);
    Card other2 = new Card(Number.THREE, ShapeWithColor.PURPLEHEART, Shading.OUTLINED);
    assertNotEquals(card, other2);

  }

  @Test
  void testToString() {
    System.out.println(card.toString());
  }
}