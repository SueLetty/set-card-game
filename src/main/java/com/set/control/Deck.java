package com.set.control;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


public class Deck implements Iterable<Card> {

  private final List<Card> cards;

  public Deck() {
    cards = new ArrayList<>();
    for (ShapeWithColor shape : ShapeWithColor.values()) {
      for (Shading shading : Shading.values()) {
        for (Number number : Number.values()) {
          Card card = new Card(number, shape, shading);
          cards.add(card);
        }
      }
    }
  }

  public void shuffle(Random rng) {
    Collections.shuffle(cards, rng);

  }

  public void shuffle() {
    Collections.shuffle(cards);
  }

  @Override
  public Iterator<Card> iterator() {
    return Collections.unmodifiableList(cards).iterator();
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
