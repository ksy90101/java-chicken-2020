package controller;

import domain.menu.Menu;
import domain.menu.MenuRepository;
import domain.state.State;
import domain.table.Table;
import domain.table.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class PosController {
    public static State start() {
        try {
            OutputView.mainScreenPrint();
            final int featNumber = InputView.inputFeatNumber();

            return State.isCorrectState(featNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            start();
        }
        throw new IllegalAccessError("잘못된 접근입니다.");
    }

    public static void enrollOrder() {
        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);

        final int tableNumber = InputView.inputTableNumber();

        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);

        int menuNumber = InputView.inputMenuNumber();
        final int amountNumber = InputView.inputAmountNumber();
    }

    public static void Payment() {
        int tableNumber = InputView.inputTableNumber();
        Table table = new Table(1);
        OutputView.printOrderMenu(table.getMenus());

        int paymentWayNumber = InputView.inputPaymentWay(tableNumber);

        OutputView.printTotalPayment(10000);
    }

}
