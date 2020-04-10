package domain.table;

import domain.menu.Menu;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private final int number;
    private final List<Menu> menus = new ArrayList<>();

    public Table(final int number) {
        this.number = number;
    }

    public void addMenu(Menu menu){
        menus.add(menu);
    }


    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
