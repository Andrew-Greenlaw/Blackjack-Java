package blackJack;

import java.util.List;

public class Deck {
private List<Card> cards;


/**
 * Initializes a Deck with the following fields
 * @param cards
 */
public Deck(List<Card> cards) {
	super();
	this.cards = cards;
}

public void shuffle() {
	//TODO shuffle the cards in the deck
}

public int getValue() {
	return 0; //TODO get value of cards from deck
}


}
