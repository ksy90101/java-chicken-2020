package controller;

import java.util.List;

import domain.Menu;
import domain.Table;

public class ExitController implements RunController{
	@Override
	public void run() {
		System.exit(0);
	}
}
