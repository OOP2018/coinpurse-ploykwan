package coinpurse;

public class MalayMoneyFactory extends MoneyFactory {
	
	private Valuable money;

	@Override
	public Valuable createMoney(double value) throws IllegalArgumentException {
		if (value == 0.05 || value == 0.1 || value == 0.2 || value == 0.5) {
			money = new Coin(value * 100, "Sen");
		} else if (value == 1 || value == 2 || value == 5 || value == 10 || value == 20 || value == 50
				|| value == 100) {
			money = new BankNote(value, "Ringgit");
		} else {
			throw new IllegalArgumentException();
		}
		return null;
	}

}
