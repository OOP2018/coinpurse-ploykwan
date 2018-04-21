package coinpurse;

import java.util.ResourceBundle;

/**
 * A main class to create objects and connect objects together. The user
 * interface needs a reference to coin purse.
 * 
 * @author Kwankaew
 */
public class Main {
	/**
	 * Configure and start the application.
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {
		ResourceBundle bundle = ResourceBundle.getBundle("purse");
		String factoryclass = bundle.getString("moneyfactory");
		System.out.println("Factory class name is " + factoryclass);

		MoneyFactory instance = null;
		try {
				instance = (MoneyFactory) Class.forName(factoryclass).newInstance();

		} catch (ClassCastException cce) {
			System.out.println(factoryclass + " is not type MoneyFactory");
		} catch (Exception ex) {
			System.out.println("Error creating MoneyFactory " + ex.getMessage());
		}

		if (instance == null)
			System.exit(1);
		MoneyFactory.setMoneyFactory(instance);

		Purse purse = new Purse(10);
		ConsoleDialog ui = new ConsoleDialog(purse);
		ui.run();

	}
}
