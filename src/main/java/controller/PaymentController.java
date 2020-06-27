package controller;

import domain.Table;
import service.TableService;
import view.InputView;
import view.OutputView;

public class PaymentController implements RunController{
	private final TableService tableService;

	public PaymentController(final TableService tableService) {
		this.tableService = tableService;
	}

	@Override
	public void run() {
		Table table = tableService.findByNumber(getTableNumber());
		OutputView.printOrderHistories(table.getOrderHistories());
		OutputView.printTablePaymentGuide(table.getNumber());
		int paymentNumber = InputView.inputPaymentNumber();
	}

	private int getTableNumber() {
		OutputView.printTables(tableService.findTables());
		return InputView.inputTableNumber();
	}
}
