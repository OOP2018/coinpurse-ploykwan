package coinpurse;

import java.util.Collections;
import java.util.List;

public class MoneyUtil {
	
	public static List<Coin> filterByCurency(List<Coin> coins, String currency ){
		List<Coin> sameCurrency = null;
		for(Coin c: coins){
			if(c.getCurrency() == currency ){
				sameCurrency.add(c);
			}
		}
		return sameCurrency; 
	}
	
	public static void sortCoins(List<Coin> coins){
		Collections.sort(coins);	
	}
}
