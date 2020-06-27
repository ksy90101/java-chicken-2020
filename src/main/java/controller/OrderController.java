package controller;

import service.MenuService;
import service.TableService;
import view.InputView;
import view.OutputView;

public class OrderController implements RunController{
	private final MenuService menuService;
	private final TableService tableService;

	public OrderController(final MenuService menuService, final TableService tableService) {
		this.menuService = menuService;
		this.tableService = tableService;
	}

	@Override
	public void run() {
		final int tableNumber = getTableNumber();
		int menuNumber = getMenuNumber();
		int menuQuantity = getMenuQuantity();
	}

	private int getTableNumber() {
		OutputView.printTables(tableService.findTable());
		return InputView.inputTableNumber();
	}

	private int getMenuNumber() {
		OutputView.printMenus(menuService.findMenus());
		return InputView.inputMenuNumber();
	}

	private int getMenuQuantity() {
		return InputView.inputMenuQuantity();
	}
}
