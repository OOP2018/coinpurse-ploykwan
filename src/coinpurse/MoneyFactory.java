package coinpurse;

public abstract class MoneyFactory {
	
	private static MoneyFactory factory = null;

	public static MoneyFactory getInstance() {
		if (factory == null)
			return factory = new ThaiMoneyFactory();
		return factory;

	}

	public abstract Valuable createMoney(double value);

	public Valuable createMoney(String value) {
		return createMoney(Double.parseDouble(value));
	}

}
