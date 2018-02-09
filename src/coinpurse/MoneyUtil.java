package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This class for flitered the coins that have the same currency and sort the
 * coins by the value.
 * 
 * @author Kwankaew Uttama
 *
 */
public class MoneyUtil {
	/**
	 * Return a List of the elements from the parameter List (money) with currency
	 * that is the same as the currency parameter. If no matches, return an empty
	 * list.
	 * 
	 * @param money
	 *            is the list of money in purse.
	 * @param currency
	 *            is the currency we want. Must not be null.
	 * @return the list of money that same currency.
	 */
	public static List<Valuable> filterByCurency(List<Valuable> money, String currency) {
		List<Valuable> sameCurrency = null;
		for (Valuable c : money) {
			if (currency.equalsIgnoreCase(c.getCurrency())) {
				sameCurrency.add(c);
			}
		}
		return sameCurrency;
	}

	/**
	 * The method is sort the money from most valuable.
	 * 
	 * @param money
	 *            is the list of money in purse.
	 */
	public static void sortCoins(List<Valuable> money) {
		Collections.sort(money, new Comparator<Valuable>() {
			@Override
			public int compare(Valuable obj1, Valuable obj2) {
				return (int) Math.signum(obj2.getValue() - obj1.getValue());
			}
		});
	}

	/**
	 * Return a List of the elements from the parameter List (money) with currency
	 * that is the same as the currency parameter. If no matches, return an empty
	 * list.
	 * 
	 * @param money
	 *            is the list of money in purse
	 * @param currency
	 *            is the currency of the money.
	 * @return list of money that have same currency.
	 */
	public static List<Valuable> filterByCurrency(List<Valuable> money, String currency) {
		List<Valuable> filled = new ArrayList<Valuable>();

		for (Valuable f : money) {
			if (f.getCurrency() == currency) {
				filled.add(f);
			}
		}
		return filled;
	}
}
