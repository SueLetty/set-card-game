import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CardTest {
  private Card card;

  @BeforeEach
  public void init(){
   card = new Card(Number.ONE, Shape.DIAMOND,Color.GREEN, Shading.OUTLINED);

  }


  @Test
  void getShape() {
    assertTrue(card.getShape()== Shape.DIAMOND);
  }


  @Test
  void getNumber() {
    assertEquals("One", card.getNumber().toString());
  }

  @Test
  void getColor() {
    assertEquals("Green", card.getColor().toString());
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
    Card other1 = new Card(Number.ONE, Shape.DIAMOND,Color.GREEN, Shading.OUTLINED);
    assertEquals(card, other1);
    Card other2 = new Card(Number.THREE, Shape.DIAMOND, Color.GREEN, Shading.OUTLINED);
    assertNotEquals(card, other2);

  }

  @Test
  void testToString() {
    System.out.println(card.toString());
  }
}