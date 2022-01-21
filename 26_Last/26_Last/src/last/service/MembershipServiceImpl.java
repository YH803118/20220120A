package last.service;

import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import last.UserInfo;
import last.DAO.DatabaseService;
import last.DAO.DatabaseServiceImpl;

public class MembershipServiceImpl implements MembershipService{

	CommonService sc = new CommonServiceImpl();
	DatabaseService ds = new DatabaseServiceImpl();
	@Override
	public void membership(Parent membership) {

		TextField txtFldArr[]= new TextField[4];
		String txtFldName[]= {"#txtName","#txtId","#txtPw","#chkPw"};
		String txtFldname[]= {"이름","아이디","비밀번호","비밀번호 확인"};
		UserInfo u = new UserInfo();
		for(int i=0; i<4; i++)
			txtFldArr[i]=(TextField) membership.lookup(txtFldName[i]); 
		for(int i=0; i<4; i++)
		{
			if(txtFldArr[i].getText().isEmpty())
			{
				sc.alert("정보 입력","입력 되지않음", txtFldname[i]+"을 입력하지 않으셨습니다.");
				txtFldArr[i].requestFocus();
				return;
			}
		}
		if(txtFldArr[2].getText().equals(txtFldArr[3].getText()))
		{
			u.setName(txtFldArr[0].getText());
			u.setId(txtFldArr[1].getText());
			u.setPw(txtFldArr[2].getText());
		}
		else sc.alert("비밀번호 확인", "불일치", "비밀번호와 확인이 일치하지 않습니다.");
		
		if(ds.insertMembership(u))
		{
			sc.alert("회원가입", "성공", "가입되었습니다");
			Stage stage = (Stage)membership.getScene().getWindow();
			stage.close();
		}
		
		else
		{
			sc.alert("회원가입", "실패", "이미있는 아이디거나 입력정보가 틀립니다.");
			for(int i=0; i<4; i++)
				txtFldArr[i].clear();
			txtFldArr[0].requestFocus();
		}
		
		
		
		
		
	}

	
}
