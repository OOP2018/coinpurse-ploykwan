package coinpurse;

import java.util.ArrayList;
import java.util.List;

public class Coin implements Comparable<Coin>{
	private double value;
	private String currency;
	
	Coin(double value, String currency){
		this.value = value;
		this.currency = currency;
	}
	
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
	
	public int compareTo(Coin coin){
		return (int)(Math.signum(coin.getValue() - this.getValue()));
		
	}
	
	public String toString(){
		return this.value+"-"+this.currency;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

}

