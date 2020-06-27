package domain.table;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import domain.menu.Category;

public class OrderHistories {
	private final List<OrderHistory> orderHistories;

	public OrderHistories(final List<OrderHistory> orderHistories) {
		this.orderHistories = orderHistories;
	}

	public void add(OrderHistory orderHistory) {
		orderHistories.add(orderHistory);
	}

	public int getChickenCount(){
		return orderHistories.stream()
			.filter(orderHistory -> orderHistory.isSameCategory(Category.CHICKEN))
			.map(OrderHistory::getQuantity)
			.mapToInt(n -> n)
			.sum();
	}

	public int size() {
		return orderHistories.size();
	}

	public void clear() {
		orderHistories.clear();
	}

	public List<OrderHistory> getOrderHistories() {
		return Collections.unmodifiableList(orderHistories);
	}
}
