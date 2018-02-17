package coinpurse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test for MoneyFactory.
 * 
 * @author kwankaew
 *
 */
public class MoneyFactoryTest {

	/**
	 * Sets up the test fixture. Called before every test method.
	 */
	@Before
	public void setUp() {
		// nothing to initialize
	}

	/**
	 * Test set factory.
	 */
	@Test
	public void testSetInstance() {
		MoneyFactory.setMoneyFactory(new ThaiMoneyFactory());
		assertEquals(MoneyFactory.getInstance().getClass().getSimpleName(), "ThaiMoneyFactory");
		MoneyFactory.setMoneyFactory(new MalayMoneyFactory());
		assertEquals(MoneyFactory.getInstance().getClass().getSimpleName(), "MalayMoneyFactory");
	}

	/**
	 * test create valid and invalid money.
	 */
	@Test
	public void testCreateMoney() {
		MoneyFactory.setMoneyFactory(new ThaiMoneyFactory());
		MoneyFactory moneyFactory = MoneyFactory.getInstance();
		Valuable t1 = moneyFactory.createMoney(10);
		Valuable t2 = moneyFactory.createMoney("20");
		assertTrue(t1.getValue() == 10.0);
		assertFalse(t1.getValue() == 5.0);
		assertTrue(t2.getValue() == 20.0);
		Valuable t3 = null;
		try {
			t3 = moneyFactory.createMoney(18);
		} catch (IllegalArgumentException ex) {
			assertTrue(t3 == null);
		}

		MoneyFactory.setMoneyFactory(new MalayMoneyFactory());
		MoneyFactory moneyFactory2 = MoneyFactory.getInstance();
		Valuable m1 = moneyFactory2.createMoney(0.5);
		Valuable m2 = moneyFactory2.createMoney("50");
		assertTrue(m1.getValue() == 0.5);
		assertFalse(m2.getValue() == 20.0);
		assertTrue(m2.getValue() == 50.0);
		Valuable m3 = null;
		try {
			m3 = moneyFactory2.createMoney(8);
		} catch (IllegalArgumentException ex) {
			assertTrue(m3 == null);
		}
	}

}
