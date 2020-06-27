package domain.payment;

import java.math.BigInteger;
import java.util.List;

import domain.OrderHistory;

public class CashPayment implements PaymentStrategy{

	@Override
	public BigInteger pay(final List<OrderHistory> orderHistories) {
		return null;
	}
}
