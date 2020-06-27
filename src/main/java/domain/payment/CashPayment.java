package domain.payment;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import domain.table.OrderHistories;
import domain.table.OrderHistory;
import domain.menu.Category;

public class CashPayment implements PaymentStrategy {

	@Override
	public BigDecimal pay(final OrderHistories orderHistories) {
		BigDecimal paymentAmountOfChicken = calculatePaymentAmountOfChicken(orderHistories);

		return paymentAmountOfChicken.add(calculatePaymentAmountOfBeverage(orderHistories))
			.multiply(new BigDecimal("0.95"))
			.setScale(0, RoundingMode.CEILING);
	}

	private BigDecimal calculatePaymentAmountOfChicken(final OrderHistories orderHistories) {
		long chickenPaymentAmount = orderHistories.getOrderHistories()
			.stream()
			.filter(orderHistory -> orderHistory.isSameCategory(Category.CHICKEN))
			.map(OrderHistory::calculatePaymentAmount)
			.mapToLong(n -> n)
			.sum();

		return new BigDecimal(chickenPaymentAmount).subtract(disCountByChickenSize(orderHistories));
	}

	private BigDecimal calculatePaymentAmountOfBeverage(final OrderHistories orderHistories) {
		long beveragePaymentAmount = orderHistories.getOrderHistories()
			.stream()
			.filter(orderHistory -> orderHistory.isSameCategory(Category.BEVERAGE))
			.map(OrderHistory::calculatePaymentAmount)
			.mapToLong(n -> n)
			.sum();

		return new BigDecimal(beveragePaymentAmount);
	}

	private BigDecimal disCountByChickenSize(OrderHistories orderHistories) {
		return new BigDecimal(10000 * (orderHistories.getChickenCount() / 10));
	}
}
