package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TableRepository {
	private static final List<Table> tables = new ArrayList<>();

	static {
		tables.add(new Table(1, new ArrayList<>()));
		tables.add(new Table(2, new ArrayList<>()));
		tables.add(new Table(3, new ArrayList<>()));
		tables.add(new Table(5, new ArrayList<>()));
		tables.add(new Table(6, new ArrayList<>()));
		tables.add(new Table(8, new ArrayList<>()));
	}

	public static List<Table> tables() {
		return Collections.unmodifiableList(tables);
	}

	public static void updateOrderHistoryBy(int tableNumber, int menuNumber, int menuQuantity) {
		Table table = findTable(tableNumber);
	}

	private static Table findTable(int tableNumber) {
		return tables().stream()
			.filter(table -> table.isSameNumber(tableNumber))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("해당 테이블을 찾을 수 없습니다."));
	}
}
