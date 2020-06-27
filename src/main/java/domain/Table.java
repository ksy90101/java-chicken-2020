package domain;

import java.util.List;

public class Table {
	private final int number;
	private final List<OrderHistory> orderHistories;

	public Table(final int number, final List<OrderHistory> orderHistories) {
		this.number = number;
		this.orderHistories = orderHistories;
	}

	@Override
	public String toString() {
		return Integer.toString(number);
	}

	public int getNumber() {
		return number;
	}

	public boolean isSameNumber(final int tableNumber) {
		return this.number == tableNumber;
	}

	public void saveMenu(Menu menu) {
	}
}
