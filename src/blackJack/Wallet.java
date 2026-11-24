package blackJack;

public class Wallet {
private int balance;

/**
 * Initializes a new Wallet with a starting balance
 * @param balance
 */
public Wallet(int balance) {
	super();
	this.balance = 0;
}

public void deposit(int amt) {
	this.balance += amt;
}

public boolean withdraw(int amt) {
	return false; //TODO  calls a check to see weather you can withdraw then minus the balance with amount and return true if completed
}

public boolean canAfford(int amt) {
	return false;
}
}
