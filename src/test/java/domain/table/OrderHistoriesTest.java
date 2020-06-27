package domain.table;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.menu.Menu;
import domain.menu.MenuRepository;

class OrderHistoriesTest {

	@DisplayName("주문내역에 치킨이 몇개 있는지 확인하는 테스트")
	@Test
	void getChickenCountTest() {
		MenuRepository menuRepository = new MenuRepository();
		Menu chicken = menuRepository.findById(1);
		Menu beverage = menuRepository.findById(21);
		OrderHistories orderHistories = new OrderHistories(new ArrayList<>());
		orderHistories.add(new OrderHistory(chicken, 11));
		orderHistories.add(new OrderHistory(beverage, 10));
		assertThat(orderHistories.getChickenCount()).isEqualTo(11);
	}

	@DisplayName("주문내역이 삭제되는지 확인하는 테스트")
	@Test
	void clearOrderHistoriesTest() {
		MenuRepository menuRepository = new MenuRepository();
		Menu chicken = menuRepository.findById(1);
		Menu beverage = menuRepository.findById(21);
		OrderHistories orderHistories = new OrderHistories(new ArrayList<>());
		orderHistories.add(new OrderHistory(chicken, 11));
		orderHistories.add(new OrderHistory(beverage, 10));
		orderHistories.clear();
		assertThat(orderHistories.size()).isEqualTo(0);
	}
}