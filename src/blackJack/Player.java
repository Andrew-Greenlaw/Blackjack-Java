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




}
