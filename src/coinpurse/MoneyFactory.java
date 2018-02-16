package coinpurse;

public abstract class MoneyFactory {

	private static MoneyFactory factory = null;

	public static MoneyFactory getInstance() {
		return factory;
	}

	public abstract Valuable createMoney(double value);

	public Valuable createMoney(String value) {
		return createMoney(Double.parseDouble(value));
	}

	public static void setMoneyFactory(MoneyFactory mf) {
		factory = mf;
	}

}
