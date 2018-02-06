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
	 *            is the list of coin in purse.
	 * @param currency
	 *            is the currency we want. Must not be null.
	 * @return the list of coin that same currency.
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
	 * The method is sort the coins from most valuable.
	 * 
	 * @param money
	 *            is the list of coins in purse.
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
	 *            is the list of coin in purse
	 * @param currency
	 *            is the currency of the coin.
	 * @return list of coin that have same currency.
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
//	public static void main(String[] arg) {
//		Purse purse = new Purse(10);
//		Valuable coin1 = new Coin(1,"B");
//		Valuable coin2 = new Coin(2,"a");
//		Valuable coin3 = new Coin(3,"A");
//		Valuable coin4 = new Coin(4,"B");
//		Valuable coin5 = new Coin(5,"b");
//		Valuable coin6 = new Coin(6,"D");
//		Valuable coin7 = new Coin(7,"b");
//		Valuable coin8 = new Coin(8,"B");
//		Valuable coin9 = new Coin(9,"D");
//		Valuable coin10 = new Coin(10,"d");
//		
//		List<Valuable> money = new ArrayList<Valuable>();
//		money.add(coin1);
//		money.add(coin2);
//		money.add(coin3);
//		money.add(coin4);
//		money.add(coin5);
//		money.add(coin6);
//		money.add(coin7);
//		money.add(coin8);
//		money.add(coin9);
//		money.add(coin10);
//		
//		System.out.println(filterByCurrency(money,"b"));
//	}
}
