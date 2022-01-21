package last.service;

import java.io.IOException;

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
	public String login(Parent root) {
		// TODO Auto-generated method stub
		TextField idChk = (TextField) root.lookup("#loginId");
		TextField pwChk = (TextField) root.lookup("#loginPw");
		
		
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
			return idChk.getText();
		}
		else {
			// alert
		}
		return null;
	}

	@Override
	public void OpenMembership() {

		FXMLLoader loader = new  FXMLLoader(getClass().getResource("../MemberShip.fxml")) ;
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
		ctrl.setMembership(p);
		
		stage.setTitle("�쉶�썝媛��엯");
		stage.show();
		
	}

}