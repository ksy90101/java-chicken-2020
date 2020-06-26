package controller;

import domain.MenuRepository;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

public class OrderController implements RunController{
	@Override
	public void run() {
		OutputView.printTables(TableRepository.tables());
		final int tableNumber = InputView.inputTableNumber();
		OutputView.printMenus(MenuRepository.menus());
	}
}
