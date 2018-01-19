package coinpurse;

import java.util.Collections;
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
 * Flitered the coins that have the same currency
 * @param coins is the list of money in purse.
 * @param currency is the currency we want. Must not be null.
 * @return the list of money that same currency.
 */
	public static List<Coin> filterByCurency(List<Coin> coins, String currency) {
		List<Coin> sameCurrency = null;
		for (Coin c : coins) {
			if (c.getCurrency() == currency) {
				sameCurrency.add(c);
			}
		}
		return sameCurrency;
	}
/**
 * The method is sort the money from most valuable.
 * @param coins is the list of money in purse.
 */
	public static void sortCoins(List<Coin> coins) {
		Collections.sort(coins);
	}
}
