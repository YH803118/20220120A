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
	public void login(Parent root) {
		// TODO Auto-generated method stub
		TextField idChk = (TextField) root.lookup("#loginId");
		TextField pwChk = (TextField) root.lookup("#loginPw");
		
		// �α��μ����� BoardMain_Login����
		if(db.login(idChk.getText(), pwChk.getText())) {
			FXMLLoader loader = new FXMLLoader(
					getClass().getResource("../BoardMain_Login.fxml"));
			Parent load=null;
			Stage memberShow = new Stage();
			try {
				load = loader.load();
				memberShow.setScene(new Scene(load));
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			Controller ctr1 = loader.getController();
			ctr1.setRoot(load);
			
			memberShow.show();
		}
		else {
			
		}
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
		
		stage.setTitle("회원가입");
		stage.show();
		
	}

}
