package domain.table;

import domain.menu.Category;
import domain.menu.Menu;

public class Order {
    private Menu menu;
    private int amount;

    public Order(Menu menu, int amount) {
        this.menu = menu;
        this.amount = amount;
    }

    public boolean isChicken() {
        return menu.getCategory() == Category.CHICKEN;
    }

    public long getTotalPrice() {
        return menu.getPrice() * amount;
    }

    @Override
    public String toString() {
        return menu.getName() + " " + amount + " " + menu.getPrice();
    }
}
