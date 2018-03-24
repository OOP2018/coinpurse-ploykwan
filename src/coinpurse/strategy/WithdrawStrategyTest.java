package coinpurse.strategy;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import coinpurse.BankNote;
import coinpurse.Coin;
import coinpurse.Money;
import coinpurse.Valuable;

public class WithdrawStrategyTest {

	private WithdrawStrategy strategy;
	private static final double TOL = 1.0E-6;

	/**
	 * Code to run before each test. Setup the "test fixture".
	 */
	@Before
	public void setup() {
		strategy = new GreedyWithdraw();
	}

	private Money makeThaiCoin(double value) {
		return new Coin(value, "Bath");
	}

	private Money makeThaiBanknote(double value) {
		return new BankNote(value, "Bath");
	}

	@Test
	public void testSimpleWithdraw() {
		List<Valuable> money = new ArrayList<Valuable>();
		money.add(makeThaiCoin(5));
		money.add(makeThaiCoin(2));
		money.add(makeThaiCoin(1));
		int amount = 0;
		for (int i = 0; i < money.size(); i++) {
			amount += money.get(i).getValue();
		}
		List<Valuable> wd1 = strategy.withdraw(makeThaiCoin(7), money);
		assertTrue(wd1 != null);
		for (Valuable c : wd1) {
			money.remove(c);
		}
		int amountWD = 0;
		for (int i = 0; i < wd1.size(); i++) {
			amountWD += wd1.get(i).getValue();
		}
		assertTrue(amountWD != amount); // money that withdraw not equals to money that we have
		assertEquals(amountWD, 7, TOL);

		amount = 0;
		for (int i = 0; i < money.size(); i++) {
			amount += money.get(i).getValue();
		}
		assertTrue(amount == 1); // in money have 1 coins

		wd1 = null;
		wd1 = strategy.withdraw(makeThaiCoin(5), money); // withdraw more than we have.
		assertTrue(wd1 == null); // cann't withdraw

	}

	@Test
	public void testGreedyWithdraw() {
		List<Valuable> money = Arrays.asList(makeThaiCoin(1), makeThaiCoin(1), makeThaiCoin(5), makeThaiBanknote(20));
		List<Valuable> withdraw1 = strategy.withdraw(makeThaiBanknote(20), money);
		assertTrue(withdraw1.size() == 1); // can withdraw 20 from money.
		List<Valuable> withdraw2 = strategy.withdraw(makeThaiCoin(10), money);
		assertTrue(withdraw2 == null);// cann't withdraw 10 from money
		List<Valuable> withdraw3 = strategy.withdraw(makeThaiCoin(27), money);
		assertTrue(withdraw3.size() == 4);// can withdraw 27 from money

	}

	@Test
	public void testDifferentCurrency() {
		List<Valuable> money = Arrays.asList(makeThaiCoin(5), new Coin(5, "Ringitt"));
		List<Valuable> wd1 = strategy.withdraw(makeThaiCoin(5), money);
		assertTrue(wd1.size() == 1); // in wd1 has 1 money
		assertTrue(wd1.get(0).getCurrency().equals("Bath")); // in wd1 has money's currency that "Bath"
		assertFalse(wd1.get(0).getCurrency().equals("Ringitt")); // in wd1 hasn't money's currency that "Ringitt"
		List<Valuable> wd2 = strategy.withdraw(makeThaiCoin(10), money);
		assertTrue(wd2 == null); // wd2 cann't withdraw 10 Bath.
		List<Valuable> wd3 = strategy.withdraw(new Coin(5, "Ringitt"), money);
		assertTrue(wd3.size() == 1); // wd3 can withdraw 5 Bath.
		assertFalse(wd3.get(0).getCurrency().equals("Bath")); // in wd3 hasn't money's currency that "Bath"
		assertTrue(wd3.get(0).getCurrency().equals("Ringitt")); // in wd3 has money's currency that "Ringitt"
	}

	@Test
	public void testGreedyWithdrawFail() {
		List<Valuable> money = Arrays.asList(makeThaiCoin(5), makeThaiCoin(2), makeThaiBanknote(2), makeThaiCoin(2));
		List<Valuable> greedyWithdraw = strategy.withdraw(makeThaiCoin(6), money);
		assertFalse(greedyWithdraw != null); // in greedyWithdraw not contains money
	}

	@Test
	public void testImpossibleWithdraw() {
		List<Valuable> money = new ArrayList<Valuable>();
		money.add(makeThaiCoin(10));
		assertNull(strategy.withdraw(makeThaiCoin(1), money));
		assertNull(strategy.withdraw(makeThaiCoin(5), money));
		money.add(makeThaiBanknote(50));
		assertNull(strategy.withdraw(makeThaiCoin(5), money));
		assertNull(strategy.withdraw(makeThaiBanknote(20), money));
	}

	@Test
	public void testNotChangeTheList() {
		List<Valuable> money = new ArrayList<Valuable>();
		money.add(makeThaiCoin(5));
		money.add(makeThaiCoin(2));
		money.add(makeThaiCoin(1));
		List<Valuable> copy = new ArrayList<Valuable>();
		
		int amount = 0;
		int amountCopy = 0;
		for(int i = 0 ; i < money.size() ; i++ ) {
			amount += money.get(i).getValue();
			copy.add(money.get(i));
		}
		for(int i = 0 ; i < copy.size() ; i++ ) {
			amountCopy += copy.get(i).getValue();
		}
		List<Valuable> wd1 = strategy.withdraw(makeThaiCoin(7), money); // withdraw from money
		assertTrue(amount == amountCopy); //old list didn't change.
		}

}
