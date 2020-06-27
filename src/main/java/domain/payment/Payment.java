package domain.payment;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import domain.OrderHistory;

public enum Payment {
	CARD(1, new CardPayment()),
	CASH(2, new CardPayment());

	private final int number;
	private final PaymentStrategy paymentStrategy;

	Payment(final int number, final PaymentStrategy paymentStrategy) {
		this.number = number;
		this.paymentStrategy = paymentStrategy;
	}

	public static Payment of(int number){
		return Arrays.stream(Payment.values())
			.filter(payment -> payment.isSameNumber(number))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("해당 결제 방식이 존재하지 않습니다. number = " + number));
	}

	private boolean isSameNumber(int number){
		return this.number == number;
	}

	public BigInteger pay(List<OrderHistory> orderHistories) {
		return paymentStrategy.pay(orderHistories);
	}
}
