package last.service;

import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import last.DAO.DatabaseService;
import last.DAO.DatabaseServiceImpl;

public class SearchServiceImpl implements SearchService{

	DatabaseService db = new DatabaseServiceImpl();
	
	@Override
	public void search(Parent root) {
		// TODO Auto-generated method stub
		TextField searchText = (TextField) root.lookup("#searchText");
		ComboBox<String> search = (ComboBox<String>) root.lookup("#list");
		
		db.search(searchText.getText(), search.getValue(), root);
	}

}