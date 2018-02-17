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
	}
	
	/**
	 *  A banknote with given value using the default currency.
	 * @param value is amount of money.
	 * @param currency is monetary of that money.
	 * @param serialNumber of each bank note.
	 */
	public BankNote(double value, String currency,long serialNumber) {
		super(value,currency);
		this.serialNumber = serialNumber;
	}

	/**
	 * Get the serial number from this bank note.
	 * 
	 * @return the serial number of the bank note.
	 */
	public long getSerial() {
		return this.serialNumber;
	}

	/**
	 * Return a value , currency and serial number of this bank note.
	 * 
	 * @return a String describing what is in the purse.
	 */
	public String toString() {
		return getValue() + "-" + getCurrency() + " note [" + this.serialNumber + "]";
	}

}
