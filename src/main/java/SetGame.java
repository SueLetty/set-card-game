
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class SetGame {

  private static final int  THRESHOLD = 12;
  private static final int THRESHOLD_FOR_SET = 3;
  private final Card[] cards;
  private final Card[] set;
  private final Deck deck;
  private int card1;
  private int card2;
  private int card3;
  private int count;


  public SetGame(Random rng) {
    deck = new Deck();
    deck.shuffle(rng);
    cards = new Card[THRESHOLD];
    set = new Card[THRESHOLD_FOR_SET];
    divideCards(deck);
  }

  public void divideCards(Deck deck) {
    Iterator<Card> iterator = deck.iterator();
    for (int i = 0; i < THRESHOLD; i++) {
      cards[i] = iterator.next();
    }
  }

  public void display() {
    System.out.println("Hello, \nPlease select three cards to find a set. Please type the card’s number below.\n"
        + "If you want to get 12 different cards, then type R to reset the cards. \nIf you want to stop the game, you can type Q to stop it.");
    System.out.println("-------------------------------------------------------------------------------");
    for (int i = 0; i < THRESHOLD; i++) {
      System.out.printf("Card %d: %s%n",
          i+1, cards[i].toString());
    }
    System.out.println("-------------------------------------------------------------------------------");

    getUserInput();
  }
  public void getUserInput(){
    Scanner input = new Scanner(System.in);
    System.out.print("Card 1:");

    String userInput = input.next();

    if (userInput.equals("R")) {
      reset();
    } else if(userInput.equals("Q")){
      System.out.println("Thank you for playing! Bye~~");
      System.exit(0);
    } else {
      setCard1(Integer.parseInt(userInput));
      set[0] = cards[getCard1() - 1];
      System.out.print("Card 2:");
      setCard2(input.nextInt());
      set[1] = cards[getCard2() - 1];
      System.out.print("Card 3:");
      setCard3(input.nextInt());
      set[2] = cards[getCard3() - 1];
    }
    checkSet();
  }



  public void checkSet() {

    boolean result = checkColor() && checkNumber() && checkShading() && checkShape();
    if(result){
      setCount(getCount()+1);
      System.out.printf("You have found %d set(s)!%n ", getCount());
      reset();
    }else{
      System.out.println("Try again!");
      getUserInput();

    }
  }
  public void reset(){
    deck.shuffle();
    divideCards(deck);
    display();
  }
  public void play(){
    display();
    checkSet();

  }
  private boolean checkColor() {

    return ((set[0].getColor() == set[1].getColor()
        && set[1].getColor() == set[2].getColor())
        || set[0].getColor() != set[1].getColor()
        && set[1].getColor() != set[2].getColor()
        && set[0].getColor() != set[2].getColor());
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
    return ((set[0].getShape() == set[1].getShape()
        && set[1].getShape() == set[2].getShape())
        || set[0].getShape() != set[1].getShape()
        && set[1].getShape() != set[2].getShape()
        && set[0].getShape() != set[2].getShape());
  }

  public int getCard1() {
    return card1;
  }

  public void setCard1(int card1) {
    this.card1 = card1;
  }

  public int getCard2() {
    return card2;
  }

  public void setCard2(int card2) {
    this.card2 = card2;
  }

  public int getCard3() {
    return card3;
  }

  public void setCard3(int card3) {
    this.card3 = card3;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

}
