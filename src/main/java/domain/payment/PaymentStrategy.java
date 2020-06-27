package domain.payment;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import domain.OrderHistory;

public interface PaymentStrategy {
	BigDecimal pay(List<OrderHistory> orderHistories);
}
