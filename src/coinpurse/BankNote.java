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

public class BankNote extends Money {
	private static long nextSerialNumber = 1000000;
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
		super(value,currency);
		this.serialNumber = nextSerialNumber;
		nextSerialNumber++;
	}

	/**
	 * Get the serial number from this banknote.
	 * 
	 * @return the serial number of the banknote.
	 */
	public long getSerial() {
		return this.serialNumber;
	}

	/**
	 * Return a value , currency and serial number of this banknote.
	 * 
	 * @return a String describing what is in the purse.
	 */
	public String toString() {
		return getValue() + "-" + getCurrency() + " note [" + this.serialNumber + "]";
	}

}
