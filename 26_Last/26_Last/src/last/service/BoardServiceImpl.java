package last.service;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import last.Controller;

public class BoardServiceImpl implements BoardService{
	CommonService cs = new CommonServiceImpl();
	@Override
	public void write(String id, ActionEvent ev) {
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
		cs.windowClose(ev);
		
		stage.setTitle("°Ô½ÃÆÇ");
		stage.show();
	}

}