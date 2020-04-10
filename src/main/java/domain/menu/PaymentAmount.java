package domain.menu;

import domain.table.Order;
import domain.discount.AmountDiscount;
import domain.discount.Discount;

import java.util.List;

public class PaymentAmount {
    private long paymentAmount;
    private Discount discount;

    public PaymentAmount(Discount discount) {
        this.discount = discount;
    }

    public long calculatePaymentAmount(List<Order> orders, int chickenMenuCount) {
        paymentAmount = orders.stream()
                .mapToLong(Order::getTotalPrice)
                .sum();

        paymentAmount = AmountDiscount.calculateDiscount(paymentAmount, chickenMenuCount);
        return discount.calculateDiscount(paymentAmount);
    }
}
