package com.set.ui;

import com.set.model.Card;
import com.set.model.Deck;
import com.set.model.Number;
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
      + "\nPlease enter a different card number.";
  /**
   * stores 12 cards that are going to be displayed on console
   */
  private final Card[] cards;
  /**
   * deck of cards
   */
  private final Deck deck;
  /**
   * stores the 3 cards that the user selected to make a set
   */
  private Card[] set;

  /**
   * stores the user input
   */
  private int[] indexes;

  private Set<Integer> userInput;
  /**
   * counts how many sets that the user has found
   */
  private int count;

  /**
   * Constructor for the SetGame class. It initializes the deck, cards, set, and indexes. Shuffles
   * the deck and calls the divideCards method.
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
   * Gets 12 cards into the cards variable from the card deck.
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
   * Displays 12 cards that are followed by the instructions message on the console.
   */
  public void display() {
    System.out.println(
        "Please select three cards to find a set. Please type the card’s number from 1 to 12."
            + "\nPlease choose 3 different cards to make a set."
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

  /**
   * Get inputs from the user, and store the inputs into some data structures
   */
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

  /**
   * check if the user found a set or not
   */
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

  /**
   * reset the game.
   */
  public void reset() {
    deck.shuffle();
    divideCards(deck);
    resetDataStructures();
    display();
  }

  /**
   * reset all the data structures
   */
  private void resetDataStructures() {
    indexes = new int[THRESHOLD_FOR_SET];
    set = new Card[THRESHOLD_FOR_SET];
    userInput = new HashSet<>();
  }

  /**
   * check if the input is duplicated or not
   * @param input is an integer.
   * @return true if the input is duplicated otherwise return false
   */
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

  /**
   * check if the input is valid or not
   * @param input the user input
   * @return true if the input valid otherwise return false
   */
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

  /**
   * check if the input is integer or not
   * @param str the user input
   * @return return true if the input is integer otherwise return false
   */
  private boolean isInteger(String str) {
    try {
      Integer.parseInt(str);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  /**
   * check if the three cards have the same color or have different colors
   * @return return true if they have the same color or have different colors, otherwise return false
   */
  private boolean checkColor() {

    return ((set[0].getShape().getColor() == set[1].getShape().getColor()
        && set[1].getShape().getColor() == set[2].getShape().getColor())
        || set[0].getShape().getColor() != set[1].getShape().getColor()
        && set[1].getShape().getColor() != set[2].getShape().getColor()
        && set[0].getShape().getColor() != set[2].getShape().getColor());
  }
  /**
   * check if the three cards have the same number or have different numbers
   * @return return true if they have the same number or have different numbers, otherwise return false
   */
  private boolean checkNumber() {
    return ((set[0].getNumber() == set[1].getNumber()
        && set[1].getNumber() == set[2].getNumber())
        || set[0].getNumber() != set[1].getNumber()
        && set[1].getNumber() != set[2].getNumber()
        && set[0].getNumber() != set[2].getNumber());
  }
  /**
   * check if the three cards have the same shading or have different shadings
   * @return return true if they have the same shading or have different shadings, otherwise return false
   */
  private boolean checkShading() {
    return ((set[0].getShading() == set[1].getShading()
        && set[1].getShading() == set[2].getShading())
        || set[0].getShading() != set[1].getShading()
        && set[1].getShading() != set[2].getShading()
        && set[0].getShading() != set[2].getShading());
  }
  /**
   * check if the three cards have the same shape or have different shapes
   * @return return true if they have the same shape or have different shapes, otherwise return false
   */
  private boolean checkShape() {
    return ((set[0].getShape().getSymbol().equals(set[1].getShape().getSymbol())
        && set[1].getShape().getSymbol().equals(set[2].getShape().getSymbol()))
        || (!set[0].getShape().getSymbol().equals(set[1].getShape().getSymbol())
        && !set[1].getShape().getSymbol().equals(set[2].getShape().getSymbol())
        && !set[0].getShape().getSymbol().equals(set[2].getShape().getSymbol())));
  }

  /**
   * count the number of sets the user found
   * @return the count
   */
  public int getCount() {
    return count;
  }


  @Override
  public void run() {
    display();
  }
}
