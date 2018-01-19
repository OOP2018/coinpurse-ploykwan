package coinpurse;

import java.util.ArrayList;
import java.util.List;

/**
 * a coin with a monetary value and currency
 * @author Kwankaew Uttama
 *
 */

public class Coin implements Comparable<Coin>{
	/** Value of the coin. */
	private double value;
	/** The currency of coin. */
	private String currency;
	
	/**
	 * A coin with given value using the default currency.
	 * 
	 * @param value
	 */
	public Coin(double value, String currency){
		this.value = value;
		this.currency = currency;
	}
	
	/**
	 * Check if the coin is equal to value and currency or not.
	 */
	public boolean equals(Object arg){
		if( arg == null){
			return false;
		}
		else if( this.getClass() != arg.getClass()){
			return false;
		}
		Coin coins = (Coin)arg;
		return (this.getValue() == coins.getValue()) && (this.getCurrency() == coins.getCurrency());
	}
	
	/**
	 * Compare the value of two coins.
	 */
	public int compareTo(Coin coin){
		return (int)(Math.signum(coin.getValue() - this.getValue()));
		
	}
	
	/**
	 * Return a String describing what is in the purse.
	 */
	public String toString(){
		return this.value+"-"+this.currency;
	}
	
	/**
	 * Return the current money.
	 * @return the current money
	 */
	public double getValue() {
		return value;
	}
	
	/**
	 * Return the currency of money.
	 * @return currency of money
	 */
	public String getCurrency() {
		return currency;
	}

}

