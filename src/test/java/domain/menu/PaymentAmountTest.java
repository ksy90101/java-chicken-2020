package domain.menu;

import domain.discount.CardDiscount;
import domain.discount.CashDiscount;
import domain.table.Table;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PaymentAmountTest {

    @DisplayName("카드 계산 시 할인 제도 없는 기능 구현")
    @Test
    void calculateCardPaymentAmountTest() {
        Table table = new Table(1);
        table.addMenu(MenuRepository.menus().get(0));
        table.addMenu(MenuRepository.menus().get(1));
        PaymentAmount paymentAmount = new PaymentAmount(new CardDiscount());
        long payment = paymentAmount.calculatePaymentAmount(table.getMenus());

        assertThat(payment).isEqualTo(32000);
    }

    @DisplayName("현금 결제시 할인 금액 반환 테스트")
    @Test
    void calculateCashPaymentAmountTest() {
        Table table = new Table(1);
        table.addMenu(MenuRepository.menus().get(0));
        table.addMenu(MenuRepository.menus().get(1));
        PaymentAmount paymentAmount = new PaymentAmount(new CashDiscount());
        long payment = paymentAmount.calculatePaymentAmount(table.getMenus());

        assertThat(payment).isEqualTo(30400);
    }
}