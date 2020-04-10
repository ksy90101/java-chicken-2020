package domain.menu;

import domain.discount.CardDiscount;
import domain.discount.CashDiscount;
import domain.table.Order;
import domain.table.Table;
import domain.table.TableRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PaymentAmountTest {

    @DisplayName("카드 계산 시 할인 제도 없는 기능 구현")
    @Test
    void calculateCardPaymentAmountTest() {
        Table table = TableRepository.getTable(1);
        Menu menu = MenuRepository.getMenu(1);

        Order order = new Order(menu, 2);
        table.addOrder(order);
        PaymentAmount paymentAmount = new PaymentAmount(new CardDiscount());
        long payment = paymentAmount.calculatePaymentAmount(table.getOrders(), table.calculateChickenCount());

        assertThat(payment).isEqualTo(32000);
    }

    @DisplayName("현금 결제시 할인 금액 반환 테스트")
    @Test
    void calculateCashPaymentAmountTest() {
        Table table = TableRepository.getTable(2);
        Menu menu = MenuRepository.getMenu(1);

        Order order = new Order(menu, 2);
        table.addOrder(order);

        PaymentAmount paymentAmount = new PaymentAmount(new CashDiscount());
        long payment = paymentAmount.calculatePaymentAmount(table.getOrders(), table.calculateChickenCount());

        assertThat(payment).isEqualTo(30400);
    }
}