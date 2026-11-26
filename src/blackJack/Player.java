package blackJack;

import java.util.List;

public class Player {
private Wallet wallet;
private List<StoreItem> inventory;
private CardStyle activeStyle;

/**
 * Initializes a new Player with the following fields
 * @param wallet
 * @param inventory
 * @param activeStyle
 */

public Player(Wallet wallet, List<StoreItem> inventory, CardStyle activeStyle) {
	super();
	this.wallet = wallet;
	this.inventory = inventory;
	this.activeStyle = activeStyle;
}

/**
 * places a bet with an amount within the bounds of your wallet
 * @param amt
 */
public void placeBet(int amt) {
	//TODO implement bet;
}

/**
 * buys something from the store
 * @return true you can buy and false you can't buy
 */
public boolean buy() {
	return false; //TODO implement buy method from store using store item interface
}
}
