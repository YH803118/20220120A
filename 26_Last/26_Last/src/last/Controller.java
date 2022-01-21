package last;

import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import last.DAO.DatabaseService;
import last.DAO.DatabaseServiceImpl;
import last.service.LoginService;
import last.service.LoginServiceImpl;
import last.service.MembershipService;
import last.service.MembershipServiceImpl;
import last.service.SearchService;
import last.service.SearchServiceImpl;

public class Controller {
	public Parent root;
	public Parent membership;
	private DatabaseService db;
	private LoginService ls;
	private SearchService ss;
	private MembershipService ms;
	
	public Controller(){
		db = new DatabaseServiceImpl();
		ls = new LoginServiceImpl();
		ss = new SearchServiceImpl();
		ms = new MembershipServiceImpl();
	}
	
	public void setRoot(Parent root) {
		// TODO Auto-generated method stub
		this.root=root;
		db.listView(root);
		ComboBox<String> cb = (ComboBox<String>) root.lookup("#list");
		cb.getItems().addAll("����","�۾���");
	}
	
	public void setMembership(Parent membership)
	{
		this.membership=membership;
	}
	
	public void login() {
		ls.login(root);
	}
	
	public void listClick() {
		System.out.println("$$$$$$$$$$$$$$$$$$$$");
	}
	
	public void membershipProc() {
		ms.membership(membership);
	}
	
	// �˻�
	public void search() {
		ss.search(root);
		setRoot(root);
	}
	
	public void write() {
		
	}
	
	public void notice() {
		
	}

	public void logout() {
		
	}
	
	public void OpenMembership()
	{
		ls.OpenMembership();
	}
}