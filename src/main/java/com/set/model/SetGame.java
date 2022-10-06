package com.set.model;

import com.set.control.*;
import com.set.control.Number;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class SetGame implements Runnable {

  /**
   * the threshold for number of cards that are going to be displayed on console
   */
  private static final int THRESHOLD = 12;
  /**
   * the threshold for number of cards that will be selected by user
   */
  private static final int THRESHOLD_FOR_SET = 3;

  private static final String INVALID_WARNING_MESSAGE = "Please enter the valid value. "
      + "\nR for reset the game."
      + "\nQ for stop the game."
      + "\nselect from 1 to 12 to choose a card.";
  private static final String DUPLICATE_INPUT_WARNING_MESSAGE = "You have selected the same card."
      + "\nPlease re-enter card's number.";
  /**
   * stores 12 cards that are going to be displayed on console
   */
  private final Card[] cards;
  /**
   * deck of card
   */
  private final Deck deck;
  /**
   * stores the 3 cards that usr selected to make a set
   */
  private Card[] set;

  /**
   * stores the user input
   */
  private int[] indexes;

  private Set<Integer> userInput;
  /**
   * counts how many sets that user has found
   */
  private int count;

  /**
   * Constructor for the SetGame class. it initializes deck, cards, set, and indexes. Shuffles the
   * deck and call divideCards method.
   *
   * @param rng rng is a Random type to shuffle the deck.
   */

  public SetGame(Random rng) {
    deck = new Deck();
    deck.shuffle(rng);
    cards = new Card[THRESHOLD];
    set = new Card[THRESHOLD_FOR_SET];
    indexes = new int[THRESHOLD_FOR_SET];
    userInput = new HashSet<>();
    divideCards(deck);
  }

  /**
   * Gets 12 cards int to cards from a deck.
   *
   * @param deck deck is a deck of cards.
   */
  public void divideCards(Deck deck) {
    Iterator<Card> iterator = deck.iterator();
    for (int i = 0; i < THRESHOLD; i++) {
      cards[i] = iterator.next();
    }
  }

  /**
   * Displays 12 cards that are followed by instruction message on the console.
   */
  public void display() {
    System.out.println(
        "Please select three cards to find a set. Please type the card’s number from 1 to 12."
            + "\nPlease choose different three cards to make a set."
            + "\nIf you want to get 12 different cards, then type R to reset the cards. "
            + "\nIf you want to stop the game, you can type Q to stop it.");
    System.out.println(
        "-------------------------------------------------------------------------------");
    for (int i = 0; i < THRESHOLD; i++) {
      Card card = cards[i];
      if (card.getNumber() == Number.ONE) {
        System.out.print("Card " + (i + 1) + ": " + card.getShading() + " ");
        System.out.println(card.getShape().getSymbol());
      }
      if (card.getNumber() == Number.TWO) {
        System.out.print("Card " + (i + 1) + ": " + card.getShading() + " ");
        System.out.print(card.getShape().getSymbol());
        System.out.println(card.getShape().getSymbol());

      }
      if (card.getNumber() == Number.THREE) {
        System.out.print("Card " + (i + 1) + ": " + card.getShading() + " ");
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
    for (int i = 0; i < THRESHOLD_FOR_SET; i++) {
      Scanner input = new Scanner(System.in);
      System.out.print("Card " + (i + 1) + ": ");
      String userInput = input.next();
      if (inputValidation(userInput)) {
        if (userInput.equals("R")) {
          reset();
        } else if (userInput.equals("Q")) {
          System.out.println("Thank you for playing! Bye~~");
          System.exit(0);
        } else if (isInteger(userInput)) {
          int currentInput = Integer.parseInt(userInput);
          if (!duplicateInput(currentInput)) {
            indexes[i] = currentInput;
            set[i] = cards[indexes[i] - 1];
          } else {
            System.out.println(DUPLICATE_INPUT_WARNING_MESSAGE);
            resetDataStructures();
            getUserInput();
          }

        }
      }
    }

    checkSet();
  }


  public void checkSet() {

    boolean result = checkColor() && checkNumber() && checkShading() && checkShape();
    if (result) {
      count++;
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
    resetDataStructures();
    display();
  }

  private void resetDataStructures() {
    indexes = new int[THRESHOLD_FOR_SET];
    set = new Card[THRESHOLD_FOR_SET];
    userInput = new HashSet<>();
  }



  private boolean duplicateInput(int input) {
    if (userInput.size() == 3) {
      resetDataStructures();
    }
    boolean result = false;
    if (userInput.contains(input)) {
      return true;
    } else {
      userInput.add(input);
    }
    return result;
  }

  private boolean inputValidation(String input) {
    boolean result = false;
    if (input.equals("Q") || input.equals("R") || isInteger(input)) {
      result = true;
    } else {
      System.out.println(INVALID_WARNING_MESSAGE);
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


  @Override
  public void run() {
    display();
  }
}
