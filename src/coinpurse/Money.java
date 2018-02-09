package coinpurse;

import java.util.ArrayList;
import java.util.List;

public class Money implements Valuable {

	/** Value of the coin. */
	protected double value;
	/** The currency of coin. */
	protected String currency;

	public Money(double value, String currency) {
		this.value = value;
		this.currency = currency;
	}

	/**
	 * Return the current money.
	 * 
	 * @return the current money
	 */
	public double getValue() {
		return value;
	}

	/**
	 * Return the currency of money.
	 * 
	 * @return currency of money
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * Check if the coin is equal to value and currency or not.
	 */
	public boolean equals(Object arg) {
		if (arg == null) {
			return false;
		} else if (this.getClass() != arg.getClass()) {
			return false;
		}
		Money coins = (Money) arg;
		return (this.getValue() == coins.getValue()) && (this.getCurrency() == coins.getCurrency());
	}

	@Override
	public int compareTo(Valuable o) {
		if (this.getCurrency().compareToIgnoreCase(o.getCurrency()) == 0) {
			if (this.getValue() - o.getValue() > 1)
				return 1;
			if (this.getValue() - o.getValue() < 1)
				return -1;
			else
				return 0;
		} else
			return (int) Math.signum(this.getCurrency().compareTo(o.getCurrency()));
	}

	// public static void main(String[] arg) {
	// Purse purse = new Purse(10);
	// Valuable coin1 = new Coin(1, "B");
	// Valuable coin2 = new Coin(2, "a");
	// Valuable coin3 = new Coin(3, "A");
	// Valuable coin4 = new Coin(4, "B");
	// Valuable coin5 = new BankNote(1, "B");
	// Valuable coin6 = new Coin(6, "D");
	// Valuable coin7 = new Coin(7, "b");
	// Valuable coin8 = new BankNote(1, "B");
	// Valuable coin9 = new Coin(9, "D");
	// Valuable coin10 = new Coin(10, "d");
	//
	// List<Valuable> money = new ArrayList<Valuable>();
	// money.add(coin1);
	// money.add(coin2);
	// money.add(coin3);
	// money.add(coin4);
	// money.add(coin5);
	// money.add(coin6);
	// money.add(coin7);
	// money.add(coin8);
	// money.add(coin9);
	// money.add(coin10);
	//
	//
	//
	// System.out.println(coin1.equals(coin4)); // f
	// System.out.println(coin1.equals(coin3)); // f
	// System.out.println(coin1.equals(coin5)); // t
	// System.out.println(coin5.equals(coin8)); // f
	//
	// }

}