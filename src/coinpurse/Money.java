package coinpurse;

import java.util.ArrayList;
import java.util.List;

public class Money implements Valuable {

	/** Value of the money. */
	protected double value;
	/** The currency of money. */
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
	 * Check if two money is equal to value and currency or not.
	 * 
	 * @param org
	 *            is the money.
	 * 
	 * @return true if the two money are equals.
	 * 
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

	/**
	 * Compare money by currency but if two money have same currency order by value.
	 * 
	 * @param o
	 *            is the money.
	 * @return @return -1 if the first money is come first, 0 if they are equal, 1
	 *         if the second money is come first.
	 *
	 */
	@Override
	public int compareTo(Valuable o) {
		if (this.getCurrency().compareToIgnoreCase(o.getCurrency()) == 0) {
			return Double.compare(this.getValue(), o.getValue());
		} else
			return this.getCurrency().compareToIgnoreCase(o.getCurrency());
	}

//	 /**
//	 * Check compareTo()
//	 *
//	 */
//	 public static void main(String[] args) {
//	 Money b1 = new BankNote(1, "Bath");
//	 Valuable b2 = new BankNote(2, "Bath");
//	 System.out.println(b1.compareTo(b2));
//	 }

}