package coinpurse.strategy;

import java.util.List;

import coinpurse.Valuable;

public class RecursiveWithdraw implements WithdrawStrategy{
	
	@Override
	public List<Valuable> withdraw(Valuable amount, List<Valuable> money) {
		enter(amount,money);
//		Valuable first = money.get(0);
//		Valuable remaining = new Money(amoount - first.getValue(),first.getCurrency());
		leave(money);
		return null;
	}
	
	public void enter(Valuable amount, List<Valuable> money) {
		int all = 0;
		for(int i = 0 ; i < money.size() ; i++ ) {
			all += money.get(i).getValue();
		}
		System.out.println("Withdraw: "+amount+" In list: "+all);
	}

	public void leave(List<Valuable> money) {
		int all = 0;
		for(int i = 0 ; i < money.size() ; i++ ) {
			all += money.get(i).getValue();
		}
	}
}
