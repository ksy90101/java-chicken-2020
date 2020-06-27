package service;

import java.util.List;

import domain.Menu;
import domain.MenuRepository;

public class MenuService {
	private final MenuRepository menuRepository;

	public MenuService(final MenuRepository menuRepository) {
		this.menuRepository = menuRepository;
	}

	public List<Menu> findMenus() {
		return MenuRepository.menus();
	}
}
