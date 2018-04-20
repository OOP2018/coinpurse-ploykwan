package coinpurse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This class for flitered the money that have the same currency and sort the
 * money by the value.
 * 
 * @author Kwankaew Uttama
 *
 */
public class MoneyUtil {

	/**
	 * The method is sort the money from most valuable.
	 * 
	 * @param money
	 *            is the list of money in purse.
	 */
	public static void sortMoney(List<? extends Valuable> money) {
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
	 * @return
	 * @return list of money that have same currency.
	 */
	public static <E extends Valuable> List<E> filterByCurrency(List<? extends E> money, String currency) {
		List<E> filled = new ArrayList<E>();

		for (E f : money) {
			if (f.getCurrency().equalsIgnoreCase(currency)) {
				filled.add(f);
			}
		}
		return filled;
	}

	/**
	 * Return the larger argument, based on sort order, using the objects' own
	 * compareTo method for comparing.
	 * 
	 * @param args
	 *            one or more Comparable objects to compare.
	 * @return the argument that would be last if sorted the elements.
	 * @throws IllegalArgumentException
	 *             if no arguments given.
	 */
	public static <E extends Comparable<? super E>> E max(E... args) {
		E max = null;
		try {
			int length = args.length - 1;
			max = args[0];
			for (int i = 1; i < length; i++) {
				if (args[i].compareTo(max) > 0)
					max = args[i];
			}
		} catch (NullPointerException e) {
			throw new IllegalArgumentException();
		}
		return max;
	}

	//text max(), sortManey(), filterByCurrency()
	public static void main(String[] args) {
		Money m1 = new BankNote(100, "Baht");
		Money m2 = new BankNote(500, "Baht");
		Money m3 = new Coin(20, "Baht");
		Money max = MoneyUtil.max(m1, m2, m3);
		System.out.println(max.toString());
		List<BankNote> list = new ArrayList<BankNote>();
		list.add(new BankNote(10.0, "USD"));
		list.add(new BankNote(500.0, "Baht"));
		MoneyUtil.sortMoney(list);
		System.out.println(list);
		List<Coin> coins = Arrays.asList(new Coin(5, "Baht"), new Coin(0.1, "Ringgit"), new Coin(5, "Cent"));
		List<Coin> result = MoneyUtil.filterByCurrency(coins, "Baht");
		System.out.println(result);
	}
}
