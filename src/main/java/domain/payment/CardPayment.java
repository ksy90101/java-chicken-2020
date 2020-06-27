package domain.payment;

import java.math.BigDecimal;
import java.util.List;

import domain.OrderHistory;
import domain.menu.Category;

public class CardPayment implements PaymentStrategy{
	@Override
	public BigDecimal pay(final List<OrderHistory> orderHistories) {
		BigDecimal paymentAmountOfChicken = calculatePaymentAmountOfChicken(orderHistories);

		return paymentAmountOfChicken.add(
			calculatePaymentAmountOfBeverage(orderHistories)
		);
	}

	private BigDecimal calculatePaymentAmountOfChicken(final List<OrderHistory> orderHistories) {
		long chickenPaymentAmount = orderHistories.stream()
			.filter(orderHistory -> orderHistory.isSameCategory(Category.CHICKEN))
			.map(OrderHistory::calculatePaymentAmount)
			.mapToLong(n -> n)
			.sum();

		return new BigDecimal(String.valueOf(chickenPaymentAmount));
	}

	private BigDecimal calculatePaymentAmountOfBeverage(final List<OrderHistory> orderHistories) {
		long beveragePaymentAmount = orderHistories.stream()
			.filter(orderHistory -> orderHistory.isSameCategory(Category.BEVERAGE))
			.map(OrderHistory::calculatePaymentAmount)
			.mapToLong(n -> n)
			.sum();

		return new BigDecimal(String.valueOf(beveragePaymentAmount));
	}
}
