package com.set.test;

import static org.junit.jupiter.api.Assertions.*;

import com.set.model.Card;
import com.set.model.Number;
import com.set.model.Shading;
import com.set.model.ShapeWithColor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CardTest {
  private Card card;

  @BeforeEach
  public void init(){
   card = new Card(Number.ONE, ShapeWithColor.PURPLE_CIRCLE, Shading.OUTLINED);

  }


  @Test
  void getShape() {
    assertSame(card.getShape(), ShapeWithColor.PURPLE_CIRCLE);
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
    Card card1 = card;
    assertEquals(card.hashCode(), card1.hashCode());
    Card card2 = new Card(Number.THREE, ShapeWithColor.PURPLE_HEART, Shading.OUTLINED);
    assertNotEquals(card.hashCode(), card2.hashCode());
  }

  @Test
  void testEquals() {
    Card other1 = new Card(Number.ONE, ShapeWithColor.PURPLE_CIRCLE, Shading.OUTLINED);
    assertEquals(card, other1);
    Card other2 = new Card(Number.THREE, ShapeWithColor.PURPLE_HEART, Shading.OUTLINED);
    assertNotEquals(card, other2);

  }

  @Test
  void testToString() {
    assertEquals("One, Purple_circle, Outlined", card.toString());
  }
}