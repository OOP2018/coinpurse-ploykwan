package coinpurse;

/**
 * a coin with a monetary value and currency
 * 
 * @author Kwankaew Uttama
 *
 */
/**
 * a money with a monetary value and currency
 * 
 * @author Kwankaew Uttama
 *
 */

public class BankNote implements Valuable{
	private static long nextSerialNumber = 1000000;
	private double value;
	private String currency;
	private long serialNumber;

	/**
	 * A banknote with given value using the default currency.
	 * 
	 * @param value
	 *            is amount of money.
	 * @param currency
	 *            is monetary of that money.
	 */
	public BankNote(double value, String currency) {
		this.value = value;
		this.currency = currency;
		this.serialNumber = nextSerialNumber;
	}

	/**
	 * Return the current money.
	 * 
	 * @return the current money
	 */
	public double getValue() {
		return this.value;
	}

	/**
	 * Return the currency of money.
	 * 
	 * @return currency of money
	 */
	public String getCurrency() {
		return this.currency;
	}

	/**
	 * Return the serial number of the banknote.
	 * 
	 * @return the serial number of the banknote.
	 */
	public long getSerial() {
		return this.serialNumber;
	}

	/**
	 * Compare the value of two banknotes.
	 * 
	 * @param obj
	 *            is amount of money.
	 * @return -1 if the first money's currency is come first, 0 if they are equal,
	 *         1 if the second money's currency is come first.
	 */
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		else if (obj.getClass() != this.getClass())
			return false;
		BankNote bankNote = (BankNote) obj;
		return (bankNote.getValue() == this.getValue()) && (bankNote.getCurrency() == this.getCurrency());
	}

	/**
	 * Return a String describing what is in the purse.
	 * 
	 * @return a String describing what is in the purse.
	 */
	public String toString() {
		return this.value + "-Currency note [" + this.serialNumber + "]";
	}

}
