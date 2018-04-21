package coinpurse.strategy;

import java.util.ArrayList;
import java.util.List;

import coinpurse.MoneyUtil;
import coinpurse.Valuable;
/**
 * Withdraw money by use recursive strategy
 * @author kwankaew
 *
 */
public class RecursiveWithdraw implements WithdrawStrategy {
	/**
	 * withdraw money by recursion
	 * @param amount is money that user want to withdraw
	 * @param money is amount of money that user has.
	 * @return list of money that could withdraw
	 */
	@Override
	public List<Valuable> withdraw(Valuable amount, List<Valuable> money) {
		money = MoneyUtil.filterByCurrency(money, amount.getCurrency());
		return helper(amount.getValue(), money);
	}

	/**
	 * helper method for withdraw method
	 * @param amount is money that user want to withdraw
	 * @param money is amount of money that user has.
	 * @return list of money
	 */
	public List<Valuable> helper(double amount, List<Valuable> money) {
		if (amount < 0)
			return null;
		if (money.isEmpty()&& amount != 0)
			return null;
		if(amount == 0) {
			return new ArrayList<Valuable>();
		}
		List<Valuable> temp = helper(amount - money.get(0).getValue(), money.subList(1, money.size()));
		if (temp != null) {
			temp.add(money.get(0));
			return temp;
		} else
			return helper(amount, money.subList(1, money.size()));
	}
}
