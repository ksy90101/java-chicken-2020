package domain.menu;

import java.util.List;

public class PaymentAmount {
    private long paymentAmount;

    public void calculatePaymentAmount(List<Menu> menus) {
        paymentAmount = menus.stream()
                .mapToLong(Menu::getPrice)
                .sum();
    }

    public long getPaymentAmount() {
        return paymentAmount;
    }
}
