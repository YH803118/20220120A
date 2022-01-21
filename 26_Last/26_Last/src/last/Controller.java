package last;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import last.DAO.DatabaseService;
import last.DAO.DatabaseServiceImpl;
import last.service.BoardService;
import last.service.BoardServiceImpl;
import last.service.CommonService;
import last.service.CommonServiceImpl;
import last.service.LoginService;
import last.service.LoginServiceImpl;
import last.service.MembershipService;
import last.service.MembershipServiceImpl;
import last.service.SearchService;
import last.service.SearchServiceImpl;

public class Controller {
	public Parent root;
	public Parent membership;
	private Parent write;
	private DatabaseService db;
	private LoginService ls;
	private SearchService ss;
	private MembershipService ms;
	private CommonService cs;
	private BoardService bs;
	
	String id=null;
	
	public Controller(){
		db = new DatabaseServiceImpl();
		ls = new LoginServiceImpl();
		ss = new SearchServiceImpl();
		ms = new MembershipServiceImpl();
		cs = new CommonServiceImpl();
		bs = new BoardServiceImpl();
	}
	
	public void setRoot(Parent root) {
		// TODO Auto-generated method stub
		this.root=root;
		db.listView(root);
		ComboBox<String> cb = (ComboBox<String>) root.lookup("#list");
		cb.getItems().addAll("Á¦¸ñ","±Û¾´ÀÌ");
	}
	
	public void setWrite(Parent write) {
		this.write = write;
	}
	
	public void setMembership(Parent membership){
		this.membership=membership;
	}
	
	public void login() {
		id = ls.login(root);
	}
	
	public void listClick() {
		System.out.println("$$$$$$$$$$$$$$$$$$$$");
	}
	
	public void membershipProc() {
		ms.membership(membership);
	}
	
	// ï¿½Ë»ï¿½
	public void search() {
		ss.search(root);
		setRoot(root);
	}
	
	// ±Û¾²±â Ã¢¿­±â
	public void write() {
		bs.write(id);
	}
	// ±Û ÀúÀå
	public void save() {
		bs.save(root, id);
	}
	
	public void notice() {
		
	}

	public void logout(ActionEvent e) 
	{
		ls.logout(e);
	}
	
	public void OpenMembership()
	{
		ls.OpenMembership();
	}
	
	public void CancelProc(ActionEvent e)
	{
		cs.windowClose(e);
	}
}