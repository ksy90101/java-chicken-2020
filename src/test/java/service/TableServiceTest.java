package service;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.menu.MenuRepository;
import domain.table.TableRepository;

class TableServiceTest {

	@DisplayName("전체 테이블 조회")
	@Test
	void findTablesTest() {
		TableService tableService = new TableService(new TableRepository(), new MenuRepository());
		assertThat(tableService.findTables()).hasSize(6);
	}

	@DisplayName("단일 테이블 조회")
	@Test
	void findByNumber(){
		TableService tableService = new TableService(new TableRepository(), new MenuRepository());
		assertThat(tableService.findByNumber(1)).isNotNull();
	}
}