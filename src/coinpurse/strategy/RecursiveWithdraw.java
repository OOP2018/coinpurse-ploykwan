package coinpurse.strategy;

import java.util.ArrayList;
import java.util.List;

import coinpurse.MoneyUtil;
import coinpurse.Valuable;

public class RecursiveWithdraw implements WithdrawStrategy {

	@Override
	public List<Valuable> withdraw(Valuable amount, List<Valuable> money) {
		// enter(amount,money);
		MoneyUtil.filterByCurrency(money, amount.getCurrency());
		return helper(amount.getValue(), money);
		// leave(money);

	}

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

	public void enter(Valuable amount, List<Valuable> money) {
		int all = 0;
		for (int i = 0; i < money.size(); i++) {
			all += money.get(i).getValue();
		}
		System.out.println("Withdraw: " + amount + " In list: " + all);
	}

	public void leave(List<Valuable> money) {
		int all = 0;
		for (int i = 0; i < money.size(); i++) {
			all += money.get(i).getValue();
		}
	}
}
