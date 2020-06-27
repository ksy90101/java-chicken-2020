package domain.payment;

import java.math.BigInteger;
import java.util.List;

import domain.menu.Category;
import domain.OrderHistory;

public class CardPayment implements PaymentStrategy{
	@Override
	public BigInteger pay(final List<OrderHistory> orderHistories) {
		BigInteger paymentAmountOfChicken = calculatePaymentAmountOfChicken(orderHistories);

		return paymentAmountOfChicken.add(
			calculatePaymentAmountOfBeverage(orderHistories)
		);
	}

	private BigInteger calculatePaymentAmountOfChicken(final List<OrderHistory> orderHistories) {
		long chickenPaymentAmount = orderHistories.stream()
			.filter(orderHistory -> orderHistory.isSameCategory(Category.CHICKEN))
			.map(OrderHistory::calculatePaymentAmount)
			.mapToLong(n -> n)
			.sum();

		return new BigInteger(String.valueOf(chickenPaymentAmount));
	}

	private BigInteger calculatePaymentAmountOfBeverage(final List<OrderHistory> orderHistories) {
		long beveragePaymentAmount = orderHistories.stream()
			.filter(orderHistory -> orderHistory.isSameCategory(Category.BEVERAGE))
			.map(OrderHistory::calculatePaymentAmount)
			.mapToLong(n -> n)
			.sum();

		return new BigInteger(String.valueOf(beveragePaymentAmount));
	}
}
