package service;

import java.util.List;

import domain.Table;
import domain.TableRepository;

public class TableService {
	private TableRepository tableRepository;

	public TableService(final TableRepository tableRepository) {
		this.tableRepository = tableRepository;
	}

	public List<Table> findTable() {
		return TableRepository.tables();
	}
}
