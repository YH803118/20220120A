package last;

import javafx.scene.Parent;
import last.DAO.DatabaseService;
import last.DAO.DatabaseServiceImpl;
import last.service.LoginService;
import last.service.LoginServiceImpl;

public class Controller {
	public Parent root;
	private DatabaseService db;
	private LoginService ls;
	
	public Controller(){
		db = new DatabaseServiceImpl();
		ls = new LoginServiceImpl();
	}
	
	public void setRoot(Parent root) {
		// TODO Auto-generated method stub
		this.root=root;
		db.listView(root);
	}
	
	public void listClick() {
		System.out.println("$$$$$$$$$$$$$$$$$$$$");
	}
	
	public void membership() {
		ls.login();
	}
	
}