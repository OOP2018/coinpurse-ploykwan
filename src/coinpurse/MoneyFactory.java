package coinpurse;

/**
 * Creating money whatever currency.
 * @author kwankaew
 *
 */
public abstract class MoneyFactory {

	private static MoneyFactory factory = null;

	/**
	 * Create the new Money factory.
	 * @return new MoneyFactory
	 */
	public static MoneyFactory getInstance() {
		return factory;
	}

	/**
	 * Create money by using double.
	 * @param value is amount of money.
	 * @return money that created.
	 */
	public abstract Valuable createMoney(double value);

	/**
	 * Create money by using String.
	 * @param value is amount of money.
	 * @return money that created.
	 */
	public Valuable createMoney(String value) {
		return createMoney(Double.parseDouble(value));
	}

	/**
	 * Set factory for program.
	 * @param mf is the factory that want to create.
	 */
	public static void setMoneyFactory(MoneyFactory mf) {
		factory = mf;
	}

}
