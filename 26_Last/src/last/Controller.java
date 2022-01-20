package last;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import last.DAO.DatabaseService;
import last.DAO.DatabaseServiceImpl;
import last.service.CommonService;
import last.service.CommonServiceImpl;
import last.service.LoginService;
import last.service.LoginServiceImpl;
import last.service.MemberService;
import last.service.MemberServiceImpl;

public class Controller {
	private Parent loginForm;
	private Parent membershipForm;
	public Parent root;
	private DatabaseService db;
	private LoginService ls;
	private MemberService ms;
	private CommonServiceImpl cs;
	
	public Controller(){
		db = new DatabaseServiceImpl();
		ls = new LoginServiceImpl();
		cs = new CommonServiceImpl();
		ms = new MemberServiceImpl();
	}
	
	public void setRoot(Parent root) {
		// TODO Auto-generated method stub
		this.root=root;
		db.listView(root);
	}
	
	public void listClick() {
		System.out.println("$$$$$$$$$$$$$$$$$$$$");
	}
	
	
	public void LoginProc() {
		ls.LoginProc(loginForm);
	}
	
	public void OpenMemberShipForm() {
		ls.OpenMemberShipForm();
	}
	
	public void CancelProc(ActionEvent event) {
		cs.windowClose(event);
	}
	
	public void MembershipProc() {
		ms.MembershipProc(membershipForm);
	}
	
}