package com.set.model;

import com.set.control.Card;
import com.set.control.Deck;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import com.set.control.Number;


public class SetGame implements Runnable {

  private static final int THRESHOLD = 12;
  private static final int THRESHOLD_FOR_SET = 3;
  private final Card[] cards;
  private final Card[] set;
  private final int[] indexes;
  private final Deck deck;
  private int count;

  public SetGame(Random rng) {
    deck = new Deck();
    deck.shuffle(rng);
    cards = new Card[THRESHOLD];
    set = new Card[THRESHOLD_FOR_SET];
    indexes = new int[THRESHOLD_FOR_SET];
    divideCards(deck);
  }

  public void divideCards(Deck deck) {
    Iterator<Card> iterator = deck.iterator();
    for (int i = 0; i < THRESHOLD; i++) {
      cards[i] = iterator.next();
    }
  }

  public void display() {
    System.out.println(
        "Hello, "
            + "\nPlease select three cards to find a set. Please type the card’s number from 1 to 12."
            + "\nIf you want to get 12 different cards, then type R to reset the cards. "
            + "\nIf you want to stop the game, you can type Q to stop it.");
    System.out.println(
        "-------------------------------------------------------------------------------");
    for (int i = 0; i < THRESHOLD; i++) {
      Card card = cards[i];
      if(card.getNumber() == Number.ONE) {
        System.out.print("com.set.control.Card " + (i + 1) + ": " + card.getShading()+ " " );
        System.out.println(card.getShape().getSymbol());
      }
      if(card.getNumber() == Number.TWO) {
        System.out.print("com.set.control.Card " + (i + 1) + ": " + card.getShading()+ " " );
        System.out.print(card.getShape().getSymbol());
        System.out.println(card.getShape().getSymbol());

      }
      if(card.getNumber() == Number.THREE) {
        System.out.print("com.set.control.Card " + (i + 1) + ": " + card.getShading() + " " );
        System.out.print(card.getShape().getSymbol());
        System.out.print(card.getShape().getSymbol());
        System.out.println(card.getShape().getSymbol());
      }
    }
    System.out.println(
        "-------------------------------------------------------------------------------");
    getUserInput();
  }

  public void getUserInput() {
    for(int i = 0; i < THRESHOLD_FOR_SET; i++){
      Scanner input = new Scanner(System.in);
      System.out.print("com.set.control.Card " + (i + 1) + ": ");
      String userInput = input.next();
      if(inputValidation(userInput)){
        if (userInput.equals("R")) {
          reset();
        } else if (userInput.equals("Q")) {
          System.out.println("Thank you for playing! Bye~~");
          System.exit(0);
        } else if( isInteger(userInput)) {
          indexes[i] = Integer.parseInt(userInput);
          set[i] = cards[indexes[i] - 1];
        }
      }
    }
    checkSet();
  }

  private boolean inputValidation(String input){
    boolean result = false;
    if(input.equals("Q") || input.equals("R") || isInteger(input)){
      result = true;
    }else{
      System.out.println("Please enter the valid value. "
          + "\nR for reset the game."
          + "\nQ for stop the game."
          + "\nselect from 1 to 12 to choose a card.");
      getUserInput();
    }
    return result;
  }

  private boolean isInteger(String str) {
    try {
      Integer.parseInt(str);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  public void checkSet() {
    boolean result = checkColor() && checkNumber() && checkShading() && checkShape();
    if (result) {
      setCount(getCount() + 1);
      System.out.printf("You have found %d set(s)!%n ", getCount());
      reset();
    } else {
      System.out.println("Try again!");
      getUserInput();

    }
  }

  public void reset() {
    deck.shuffle();
    divideCards(deck);
    display();
  }


  private boolean checkColor() {

    return ((set[0].getShape().getColor() == set[1].getShape().getColor()
        && set[1].getShape().getColor() == set[2].getShape().getColor())
        || set[0].getShape().getColor() != set[1].getShape().getColor()
        && set[1].getShape().getColor() != set[2].getShape().getColor()
        && set[0].getShape().getColor() != set[2].getShape().getColor());
  }

  private boolean checkNumber() {
    return ((set[0].getNumber() == set[1].getNumber()
        && set[1].getNumber() == set[2].getNumber())
        || set[0].getNumber() != set[1].getNumber()
        && set[1].getNumber() != set[2].getNumber()
        && set[0].getNumber() != set[2].getNumber());
  }

  private boolean checkShading() {
    return ((set[0].getShading() == set[1].getShading()
        && set[1].getShading() == set[2].getShading())
        || set[0].getShading() != set[1].getShading()
        && set[1].getShading() != set[2].getShading()
        && set[0].getShading() != set[2].getShading());
  }

  private boolean checkShape() {
    return ((set[0].getShape().getSymbol().equals(set[1].getShape().getSymbol())
        && set[1].getShape().getSymbol().equals(set[2].getShape().getSymbol()))
        || (!set[0].getShape().getSymbol().equals(set[1].getShape().getSymbol())
        && !set[1].getShape().getSymbol().equals(set[2].getShape().getSymbol())
        && !set[0].getShape().getSymbol().equals(set[2].getShape().getSymbol())));
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  @Override
  public void run() {
    display();
  }
}
