package last.service;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import last.Controller;

public class BoardServiceImpl implements BoardService{

	@Override
	public void write(String id, Parent root) {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader(
				getClass().getResource("../BoardWrite.fxml"));
		
		Stage memberShow = (Stage) root.getScene().getWindow();
		
		try {
			memberShow.setScene(new Scene((Parent) loader.load()));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Controller ctr1 = loader.getController();
		
		memberShow.show();
	}

}