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
	private String realCurrency;
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
	 * A coin with given value using the default currency.
	 * @param value is amount of money.
	 * @param realCurrency is monetary of that money that use to calculate.
	 * @param showCurrency is monetary of that money that using in toString().
	 */
	public Coin(double value, String calCurrency, String realCurrency) {
		super(value,calCurrency);
		this.realCurrency = realCurrency;
		
	}

	/**
	 * Return a String describing what is in the purse.
	 * @return a String describing what is in the purse.
	 */
	public String toString() {
		if(getValue() < 1 ) {
			return (getValue()*100) + "-" + this.realCurrency;
		}
		return getValue() + "-" + getCurrency();
	}

}
