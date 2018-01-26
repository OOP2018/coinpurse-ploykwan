package coinpurse;

import java.util.ArrayList;
import java.util.List;

/**
 * a coin with a monetary value and currency
 * 
 * @author Kwankaew Uttama
 *
 */

public class Coin implements Valuable {
	/** Value of the coin. */
	private double value;
	/** The currency of coin. */
	private String currency;

	/**
	 * A coin with given value using the default currency.
	 * 
	 * @param value
	 *            is amount of money.
	 * @param currency
	 *            is monetary of that money.
	 */
	public Coin(double value, String currency) {
		this.value = value;
		this.currency = currency;
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
		Coin coins = (Coin) arg;
		return (this.getValue() == coins.getValue())
				&& (this.getCurrency() == coins.getCurrency());
	}

	/**
	 * Compare the value of two coins.
	 * 
	 * @param coin
	 *            is amount of money.
	 * @return -1 if the first money's currency is come first, 0 if they are
	 *         equal, 1 if the second money's currency is come first.
	 */
	public int compareTo(Coin coin) {
		if (coin == null)
			return -1;
		return (int) (Math.signum(this.getValue() - coin.getValue()));

	}

	/**
	 * Return a String describing what is in the purse.
	 * @return a String describing what is in the purse.
	 */
	public String toString() {
		return this.value + "-" + this.currency;
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

}
