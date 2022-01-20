package last.service;

import last.Member;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class MemberServiceImpl implements MemberService{

	@Override
	public void MembershipProc(Parent membershipForm) {
		// TODO Auto-generated method stub
		TextField txtFldArr[] = new TextField[4];
		String txtFldName[] = {"#txtName", "#txtId", "#txtPw", "#txtPwOk"};
		String columnName[] = { "이름","아이디","암호","암호확인"};
		CommonService cs = new CommonServiceImpl();
		Member m = new Member();
		
		
		for(int i=0;i<4;i++) {
			txtFldArr[i] = 
					(TextField) membershipForm.lookup(txtFldName[i]);
			if(txtFldArr[i].getText().isEmpty()) {
				cs.errorMsg("입력에러", "비어 있는 컬럼", columnName[i] + " 필드가 비어있습니다.");				
				txtFldArr[i].requestFocus();
				return;
			}
		}

		
		
		if(txtFldArr[2].getText().equals(txtFldArr[3].getText())) {
			System.out.println("암호 일치");
			m.setName(txtFldArr[0].getText());
			m.setId(txtFldArr[1].getText());
			m.setPw(txtFldArr[2].getText());
			cs.errorMsg("암호", "암호일치여부", "암호가 일치합니다.");
		} else {
			System.out.println("암호 불일치");
			cs.errorMsg("암호", "암호일치여부", "암호가 일치하지 않습니다.");
		}
		
		RadioButton RdoMan = (RadioButton) membershipForm.lookup("#RdoMan");
		RadioButton RdoWoman = (RadioButton) membershipForm.lookup("#RdoWoman");
		if(!RdoMan.isSelected() && !RdoWoman.isSelected()) {
			
			cs.errorMsg("성별", "성별 선택", "성별이 선택 되지 않았습니다.");
			return;
		} else if(RdoMan.isSelected()) {
			m.setGender(true);
		} else {
			m.setGender(false);
		}
		
		ComboBox<String> cmbAge = 
				(ComboBox<String>)membershipForm.lookup("#cmbAge");
		
		if(cmbAge.getValue() == null) {
			cs.errorMsg("나이", "나이대 선택", "나이대가 선택 되지 않았습니다.");
			return;
		} else if(cmbAge.getValue().equals("20대 미만")) {
			m.setAge(10);
		} else if (cmbAge.getValue().equals("20대")) {
			m.setAge(20);
		} else if (cmbAge.getValue().equals("30대")) {
			m.setAge(30);
		} else if(cmbAge.getValue().equals("40대")){
			m.setAge(40);
		} else if(cmbAge.getValue().equals("50대")) {
			m.setAge(50);
		} else if(cmbAge.getValue().equals("60대 이상")) {
			m.setAge(60);
		}
				
		int hobby = 0;
		if(((CheckBox)membershipForm.lookup("#chkMusic")).isSelected()) {
			hobby += 1;
		}
		if(((CheckBox)membershipForm.lookup("#chkSport")).isSelected()) {
			hobby += 2;
		}
		if(((CheckBox)membershipForm.lookup("#chkMovie")).isSelected()) {
			hobby += 4;
		}
		System.out.println("취미 : " + hobby);
		m.setHobby(hobby);
		
		
	}	
}