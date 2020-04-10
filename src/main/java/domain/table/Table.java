package domain.table;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private final int number;
    private final List<Order> orders = new ArrayList<>();

    public Table(final int number) {
        this.number = number;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public int getNumber() {
        return number;
    }

    public int calculateChickenCount() {
        return (int) orders.stream()
                .filter(Order::isChicken)
                .count();
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public void clear() {
        orders.clear();
    }

    public boolean isExistOrder(){
        return !orders.isEmpty();
    }
}
