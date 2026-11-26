package blackJack;

public abstract class Card {
private CardStyle style;

/**
 * Initializes a new Card with the following fields
 * @param style
 */
public Card(CardStyle style) {
	super();
	this.style = style;
}

}
