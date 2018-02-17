package coinpurse;

/**
 * Factor make Malaysian money.
 * @author kwankaew
 *
 */
public class MalayMoneyFactory extends MoneyFactory {
	private long serialNumber = 1000000;
	/**
	 * Create coins and banknotes.
	 */
	@Override
	public Valuable createMoney(double value) {
		if (value == 0.05 || value == 0.1 || value == 0.2 || value == 0.5) {
			return new Coin(value,"Ringgit");
		} else if (value == 1 || value == 2 || value == 5 || value == 10 || value == 20 || value == 50
				|| value == 100) {
			return new BankNote(value, "Ringgit",this.serialNumber++);
		} else {
			throw new IllegalArgumentException();
		}
	}

}
