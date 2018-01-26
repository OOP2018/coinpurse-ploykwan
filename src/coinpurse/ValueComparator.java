package coinpurse;

import java.util.Comparator;

public class ValueComparator implements Comparator<Valuable> {
	/**
	 * Compare two objects that implement Valuable. First compare them by currency,
	 * so that "Baht" < "Dollar". If both objects have the same currency, order them
	 * by value.
	 */
	public int compare(Valuable a, Valuable b) {
		return (int) Math.signum(a.getValue() - b.getValue());
	}
}
