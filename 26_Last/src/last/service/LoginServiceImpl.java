package last.service;

import java.io.IOException;

import last.Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginServiceImpl implements LoginService{

	@Override
	public void LoginProc(Parent root) {
		TextField txtId = (TextField) root.lookup("#txtId");
		TextField txtPw = (TextField) root.lookup("#txtPw");

		System.out.println("아이디 : " + txtId.getText());
		System.out.println("암호 : " + txtPw.getText());
		System.out.println("입력 하셨습니다.");
	}

	@Override
	public Stage OpenMemberShipForm() {
		// TODO Auto-generated method stub
		Stage MembershipForm = new Stage();
		
		Parent member = null;
		FXMLLoader loader = new FXMLLoader(
				getClass().getResource("../Membership.fxml"));
		try {
			member = loader.load();
			MembershipForm.setScene(new Scene(member));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		ComboBox<String> cmbAge = 
				(ComboBox<String>)member.lookup("#cmbAge");
		cmbAge.getItems().addAll("20대 미만", "20대", "30대", 
				"40대", "50대", "60대 이상");
		
		MembershipForm.setTitle("회원가입창");
		MembershipForm.show();
		return MembershipForm;
	}

}
