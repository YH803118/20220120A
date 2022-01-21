package last.service;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import last.Controller;
import last.DAO.DatabaseService;
import last.DAO.DatabaseServiceImpl;

public class LoginServiceImpl implements LoginService{

	DatabaseService db = new DatabaseServiceImpl();

	@Override
	public void login(Parent root) {
		// TODO Auto-generated method stub
		TextField idChk = (TextField) root.lookup("#loginId");
		TextField pwChk = (TextField) root.lookup("#loginPw");
		
		// 로그인성공시 BoardMain_Login으로
		if(db.login(idChk.getText(), pwChk.getText())) {
			FXMLLoader loader = new FXMLLoader(
					getClass().getResource("../BoardMain_Login.fxml"));
			
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
		else {
			
		}
	}

}
