package coinpurse;

import java.util.ArrayList;
import java.util.List;

/**
 * a coin with a monetary value and currency
 * 
 * @author Kwankaew Uttama
 *
 */

public class Coin extends Money {
	/**
	 * A coin with given value using the default currency.
	 * 
	 * @param value
	 *            is amount of money.
	 * @param currency
	 *            is monetary of that money.
	 */
	public Coin(double value, String currency) {
		super(value,currency);
	}

	/**
	 * Return a String describing what is in the purse.
	 * @return a String describing what is in the purse.
	 */
	public String toString() {
		return getValue() + "-" + getCurrency();
	}

}
