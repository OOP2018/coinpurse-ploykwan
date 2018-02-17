package coinpurse;

/**
 * Class show that MoneyFactory is singleton and all methods work.
 * @author kwankaew
 *
 */
public class MoneyFactoryDemo {
	
	public static void main(String[] arg) {
		
		System.out.println("------ThaiMoneyFactory------");
		MoneyFactory.setMoneyFactory(new ThaiMoneyFactory());
		MoneyFactory thiaFactory = MoneyFactory.getInstance();
		System.out.println(thiaFactory.createMoney(5));
		System.out.println(thiaFactory.createMoney("20"));
		System.out.println(thiaFactory.createMoney(1000));

		System.out.println("\n------MalayMoneyFactory------");
		MoneyFactory.setMoneyFactory(new MalayMoneyFactory());
		MoneyFactory malayFactory = MoneyFactory.getInstance();
		System.out.println(malayFactory.createMoney(5));
		System.out.println(malayFactory.createMoney("20"));
		System.out.println(malayFactory.createMoney(100));
		
		
	}
}
