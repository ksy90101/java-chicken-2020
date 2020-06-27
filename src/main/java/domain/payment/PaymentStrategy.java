package domain.payment;

import java.math.BigInteger;
import java.util.List;

import domain.OrderHistory;

public interface PaymentStrategy {
	BigInteger pay(List<OrderHistory> orderHistories);
}
