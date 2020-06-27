package controller;

import domain.MenuRepository;
import domain.TableRepository;
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
		OutputView.printTables(tableService.findTable());
		final int tableNumber = InputView.inputTableNumber();
		OutputView.printMenus(menuService.findMenus());
	}
}
