package domain.payment;

import java.math.BigDecimal;
import java.math.RoundingMode;

import domain.menu.Category;
import domain.table.OrderHistories;
import domain.table.OrderHistory;

public class CashPayment implements PaymentStrategy {

	private static final String CASH_DISCOUNT_PERCENT = "0.95";
	private static final int CHICKEN_SIZE_DISCOUNT_MONEY = 10000;
	private static final int CHICKEN_SIZE_DISCOUNT_AMOUNT = 10;

	@Override
	public BigDecimal pay(final OrderHistories orderHistories) {
		BigDecimal paymentAmountOfChicken = calculatePaymentAmountOfChicken(orderHistories);

		return paymentAmountOfChicken.add(calculatePaymentAmountOfBeverage(orderHistories))
			.multiply(new BigDecimal(CASH_DISCOUNT_PERCENT))
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
		return new BigDecimal(
			CHICKEN_SIZE_DISCOUNT_MONEY * (orderHistories.getChickenCount() / CHICKEN_SIZE_DISCOUNT_AMOUNT));
	}
}
