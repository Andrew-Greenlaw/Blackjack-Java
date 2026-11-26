package blackJack;

import java.util.List;

public class Hand {
private List<Card> cards;
private int value;

/**
 * @param cards
 */
public Hand(List<Card> cards) {
	super();
	this.cards = cards;
}

public void addCard(Card c) {
	//TODO add a card to your hand
}

public int getValue() {
	return value; // TODO get the value of entire hand by adding list of cards
}
}
