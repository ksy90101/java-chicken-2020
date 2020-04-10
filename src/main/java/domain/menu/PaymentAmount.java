package domain.menu;

import domain.discount.AmountDiscount;
import domain.discount.Discount;
import domain.table.Order;

import java.util.List;

public class PaymentAmount {
    private Discount discount;

    public PaymentAmount(Discount discount) {
        this.discount = discount;
    }

    public long calculatePaymentAmount(List<Order> orders, int chickenMenuCount) {
        long paymentAmount = orders.stream()
                .mapToLong(Order::getTotalPrice)
                .sum();
        paymentAmount = AmountDiscount.calculateDiscount(paymentAmount, chickenMenuCount);

        return discount.calculateDiscount(paymentAmount);
    }
}
