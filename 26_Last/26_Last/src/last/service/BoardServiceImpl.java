package last.service;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import last.Controller;
import last.DAO.DatabaseService;
import last.DAO.DatabaseServiceImpl;

public class BoardServiceImpl implements BoardService{
	CommonService cs = new CommonServiceImpl();
	DatabaseService db = new DatabaseServiceImpl();
	
	@Override
	public void write(String id) {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader(
				getClass().getResource("../BoardWrite.fxml"));
		Parent p= null;
		Stage stage = new Stage();
		
		try {
			p=loader.load();
			stage.setScene(new Scene(p));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Controller ctrl = loader.getController();
		ctrl.setWrite(p);
		
		stage.setTitle("°Ô½ÃÆÇ");
		stage.show();
	}

	@Override
	public void save(Parent root, String id) {
		// TODO Auto-generated method stub
		TextField title = (TextField) root.lookup("#title");
		TextArea content = (TextArea) root.lookup("#content");
		
		db.insertBoard(id, title.getText(), content.getText());
	}
	
	

}