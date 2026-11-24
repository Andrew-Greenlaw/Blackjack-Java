package blackJack;

public abstract class Participant {
private String name;
private Hand hand;

/**
 * Initializes a new Participant with the following fields
 * @param name
 * @param hand
 */
public Participant(String name, Hand hand) {
	super();
	this.name = name;
	this.hand = hand;
}
public void Hit(Card c) {
	//TODO create the hit method
}
public int handValue() {
	return 0; //TODO create the handValue method
}

/**
 * returns a String in the following format
 * {name}{hand}
 * @return String
 */
@Override
public String toString() {
	return String.format("%s %s",name,hand);
}

}
