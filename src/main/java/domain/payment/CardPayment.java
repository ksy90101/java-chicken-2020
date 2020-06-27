package domain.payment;

import java.math.BigDecimal;
import java.util.List;

import domain.table.OrderHistories;
import domain.table.OrderHistory;
import domain.menu.Category;

public class CardPayment implements PaymentStrategy{
	@Override
	public BigDecimal pay(final OrderHistories orderHistories) {
		BigDecimal paymentAmountOfChicken = calculatePaymentAmountOfChicken(orderHistories);

		return paymentAmountOfChicken.add(
			calculatePaymentAmountOfBeverage(orderHistories)
		);
	}

	private BigDecimal calculatePaymentAmountOfChicken(final OrderHistories orderHistories) {
		long chickenPaymentAmount = orderHistories.getOrderHistories()
			.stream()
			.filter(orderHistory -> orderHistory.isSameCategory(Category.CHICKEN))
			.map(OrderHistory::calculatePaymentAmount)
			.mapToLong(n -> n)
			.sum();

		return new BigDecimal(String.valueOf(chickenPaymentAmount))
			.subtract(disCountByChickenSize(orderHistories));
	}

	private BigDecimal calculatePaymentAmountOfBeverage(final OrderHistories orderHistories) {
		long beveragePaymentAmount = orderHistories.getOrderHistories()
			.stream()
			.filter(orderHistory -> orderHistory.isSameCategory(Category.BEVERAGE))
			.map(OrderHistory::calculatePaymentAmount)
			.mapToLong(n -> n)
			.sum();

		return new BigDecimal(String.valueOf(beveragePaymentAmount));
	}

	private BigDecimal disCountByChickenSize(OrderHistories orderHistories) {
		return new BigDecimal(10000 * (orderHistories.getChickenCount() / 10));
	}
}
