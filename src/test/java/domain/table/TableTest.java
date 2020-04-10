package domain.table;

import domain.menu.Menu;
import domain.menu.MenuRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TableTest {

    @DisplayName("테이블의 주문이 있는지 확인하는 테스트")
    @Test
    void ExistOrderTest() {
        Table table = TableRepository.getTable(1);
        Assertions.assertThat(table.isExistOrder()).isFalse();
    }

    @DisplayName("테이블의 주문이 있는지 확인하는 테스트")
    @Test
    void notExistOrderTest() {
        Table table = TableRepository.getTable(1);
        Menu menu = MenuRepository.getMenu(1);
        Order order = new Order(menu, 2);

        table.addOrder(order);

        Assertions.assertThat(table.isExistOrder()).isTrue();
    }

    @DisplayName("테이블 초기화 작업")
    @AfterEach
    @Test
    void tearDown(){
        Table table = TableRepository.getTable(1);
        table.clear();
    }
}