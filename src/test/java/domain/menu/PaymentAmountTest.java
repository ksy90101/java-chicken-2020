package domain.menu;

import domain.table.Table;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PaymentAmountTest {

    @Test
    void calculatePaymentAmountTest() {
        Table table = new Table(1);
        table.addMenu(MenuRepository.menus().get(1));
        table.addMenu(MenuRepository.menus().get(2));
        PaymentAmount paymentAmount = new PaymentAmount();

        paymentAmount.calculatePaymentAmount(table.getMenus());
        assertThat(paymentAmount.getPaymentAmount()).isEqualTo(32000);
    }
}