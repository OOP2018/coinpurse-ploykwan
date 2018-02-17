package coinpurse;

/**
 * Factor make Thai Money.
 * @author kwankaew
 *
 */
public class ThaiMoneyFactory extends MoneyFactory {
	private long serialNumber = 1000000;
	
	/**
	 * Create coins and banknotes.
	 */
	@Override
	public Valuable createMoney(double value) {
		Valuable money;
		if (value == 1 || value == 2 || value == 5 || value == 10) {
			money = new Coin(value, "Bath");
		} else if (value == 20 || value == 50 || value == 100 || value == 500 || value == 1000) {
			money = new BankNote(value, "Bath",this.serialNumber++);
		} else {
			throw new IllegalArgumentException();
		}
		return money;
	}

}
