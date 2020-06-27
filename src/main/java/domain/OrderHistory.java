package domain;

public class OrderHistory {
	private final Menu menu;
	private final int quantity;

	public OrderHistory(final Menu menu, final int quantity) {
		this.menu = menu;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return menu.getName() + " " + quantity + " " + menu.getPrice();
	}

	public Menu getMenu() {
		return menu;
	}

	public int getQuantity() {
		return quantity;
	}
}
