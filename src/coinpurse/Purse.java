package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * A purse contains money. You can insert money, withdraw money, check the
 * balance, and check if the purse is full.
 * 
 * @author Kwankaew Uttama
 */
public class Purse {
	/** Collection of objects in the purse. */
	List<Valuable> money = new ArrayList<Valuable>();

	/**
	 * Capacity is maximum number of items the purse can hold. Capacity is set when
	 * the purse is created and cannot be changed.
	 */
	private final int capacity;

	/**
	 * Create a purse with a specified capacity.
	 * 
	 * @param capacity
	 *            is maximum number of money you can put in purse.
	 */
	public Purse(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * Count and return the number of money in the purse. This is the number of
	 * money, not their value.
	 * 
	 * @return the number of money in the purse
	 */
	public int count() {
		return money.size();
	}

	/**
	 * Get the total value of all items in the purse.
	 * 
	 * @return the total value of items in the purse.
	 */
	public double getBalance() {
		double sum = 0;
		for (Valuable i : money) {
			sum += i.getValue();
		}
		return sum;
	}

	/**
	 * Return the capacity of the purse.
	 * 
	 * @return the capacity
	 */
	public int getCapacity() {
		return this.capacity;
	}

	/**
	 * Test whether the purse is full. The purse is full if number of items in purse
	 * equals or greater than the purse capacity.
	 * 
	 * @return true if purse is full.
	 */
	public boolean isFull() {
		if (this.getCapacity() == this.count()) {
			return true;
		}
		return false;
	}

	/**
	 * Insert a money into the purse. The money is only inserted if the purse has
	 * space for it and the money has positive value. No worthless money!
	 * 
	 * @param money
	 *            is a object to insert into purse
	 * @return true if money inserted, false if can't insert
	 */
	public boolean insert(Valuable money) {
		if (this.isFull())
			return false;
		if (money.getValue() > 0) {
			this.money.add(money);
			return true;
		}
		return false;
	}

	/**
	 * Withdraw the amount, using only items that have the same currency as the
	 * parameter(amount). amount must not be not null and amount.getValue()>0.
	 * 
	 * @param amout
	 *            is the amount to withdraw
	 * @return array of money objects for money withdrawn, or null if cannot
	 *         withdraw requested amount.
	 */
	public Valuable[] withdraw(Valuable amount) {
		if (amount.getValue() < 0 || amount.getValue() > this.getBalance()) {
			return null;
		}
		double amounts = amount.getValue();
		Comparator<Valuable> comp = new ValueComparator();
		Collections.sort(money, comp);
		List<Valuable> templist = new ArrayList<Valuable>();
		for (int i = money.size() - 1; i > -1; i++) {
			if ((money.get(i).getValue() <= amounts) && money.get(i).getCurrency().equals(amount.getCurrency())) {
				templist.add(money.get(i));
				amounts -= money.get(i).getValue();
			}
		}
		if (amounts != 0) {
			return null;
		}

		for (Valuable c : templist) {
			money.remove(c);
		}

		Valuable[] array = new Valuable[templist.size()];
		templist.toArray(array);
		return array;

	}

	/**
	 * Withdraw the requested amount of money. Return an array of money withdrawn
	 * from purse, or return null if cannot withdraw the amount requested.
	 * 
	 * @param amount
	 *            is the amount to withdraw
	 * @return array of money objects for money withdrawn, or null if cannot
	 *         withdraw requested amount.
	 */
	public Valuable[] withdraw(double amount) {
		if (amount < 0 || amount > this.getBalance()) {
			return null;
		}
		double amountNeededToWithdraw = amount;
		Comparator<Valuable> comp = new ValueComparator();
		Collections.sort(money, comp);
		List<Valuable> templist = new ArrayList<Valuable>();
		for (int i = money.size() - 1; i > -1; i--) {
			if (money.get(i).getValue() <= amountNeededToWithdraw) {
				templist.add(money.get(i));
				amountNeededToWithdraw -= money.get(i).getValue();
			}
		}
		if (amountNeededToWithdraw != 0) {
			return null;
		}

		for (Valuable c : templist) {
			money.remove(c);
		}

		Valuable[] array = new Valuable[templist.size()];
		templist.toArray(array);
		return array;
	}

	/**
	 * toString returns a string description of the purse contents. It can return
	 * whatever is a useful description.
	 */
	public String toString() {
		return money.size() + " money with value " + this.getBalance();
	}

}
