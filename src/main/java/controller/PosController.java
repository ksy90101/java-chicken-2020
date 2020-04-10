package controller;

import domain.discount.PaymentWay;
import domain.menu.Menu;
import domain.menu.MenuRepository;
import domain.menu.PaymentAmount;
import domain.state.State;
import domain.table.Order;
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
        Table table = TableRepository.getTable(tableNumber);

        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);

        int menuNumber = InputView.inputMenuNumber();
        Menu menu = MenuRepository.getMenu(menuNumber);

        final int amountNumber = InputView.inputAmountNumber();
        table.addOrder(new Order(menu, amountNumber));
    }

    public static void Payment() {
        int tableNumber = InputView.inputPaymentTable();
        Table table = TableRepository.getTable(tableNumber);

        OutputView.printOrderMenu(table.getOrders());

        int paymentWayNumber = InputView.inputPaymentWay(tableNumber);

        PaymentAmount paymentAmount = PaymentWay.getPaymentAmount(paymentWayNumber);
        OutputView.printTotalPayment(paymentAmount.calculatePaymentAmount(table.getOrders(),
                table.calculateChickenCount()));

        table.clear();
    }

}
