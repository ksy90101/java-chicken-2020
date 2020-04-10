package domain.menu;

import domain.discount.Discount;

import java.util.List;

public class PaymentAmount {
    private long paymentAmount;
    private Discount discount;

    public PaymentAmount(Discount discount) {
        this.discount = discount;
    }

    public long calculatePaymentAmount(List<Menu> menus) {
        paymentAmount = menus.stream()
                .mapToLong(Menu::getPrice)
                .sum();
        return paymentAmount;
    }
}
