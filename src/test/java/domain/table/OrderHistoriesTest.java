package domain.table;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.menu.Menu;
import domain.menu.MenuRepository;

class OrderHistoriesTest {
	@DisplayName("주문내역에 치킨이 몇개 있는지 확인하는 테스트")
	@Test
	void getChickenCountTest(){
		MenuRepository menuRepository = new MenuRepository();
		Table table = new Table(1, new ArrayList<>());
		Menu chicken = menuRepository.findById(1);
		Menu beverage = menuRepository.findById(21);
		table.addOrderHistory(new OrderHistory(chicken, 11));
		table.addOrderHistory(new OrderHistory(beverage, 10));
		assertThat(table.getOrderHistories().getChickenCount()).isEqualTo(11);
	}
}