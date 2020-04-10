package domain;

import domain.menu.MenuRepository;
import domain.table.Order;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderTest {

    @DisplayName("주문이 치킨인지 확인하는 테스트 - 치킨 O")
    @Test
    void existChicken() {
        Order order = new Order(MenuRepository.getMenu(1), 1);
        Assertions.assertThat(order.isChicken()).isTrue();
    }

    @DisplayName("주문이 치킨인지 확인하는 테스트 - 치킨 X")
    @Test
    void notExistChicken() {
        Order order = new Order(MenuRepository.getMenu(21), 1);
        Assertions.assertThat(order.isChicken()).isFalse();
    }

    @DisplayName("주문내역 계산 테스트")
    @Test
    void getTotalPrice() {
        Order order = new Order(MenuRepository.getMenu(21), 10);
        Assertions.assertThat(order.getTotalPrice()).isEqualTo(10000);
    }

    @DisplayName("주문내역 확인 테스트")
    @Test
    void testToString() {
        Order order = new Order(MenuRepository.getMenu(21), 1);
        Assertions.assertThat(order.toString()).isEqualTo("콜라 1 1000");
    }
}