import domain.Function;
import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import utils.Converter;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        OutputView.printMain();
        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);
        Function function = Function.of(InputView.inputFunction());
        final int tableNumber = InputView.inputTableNumber();

        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);
    }
}
