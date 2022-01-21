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
	private DatabaseService db;
	private LoginService ls;
	private SearchService ss;
	private MembershipService ms;
	private BoardService bs;
	
	private String id;
	private CommonService cs;
	public Controller(){
		db = new DatabaseServiceImpl();
		ls = new LoginServiceImpl();
		ss = new SearchServiceImpl();
		ms = new MembershipServiceImpl();
		bs = new BoardServiceImpl();
		cs = new CommonServiceImpl();
	}
	
	public void setRoot(Parent root) {
		// TODO Auto-generated method stub
		this.root=root;
		db.listView(root);
		ComboBox<String> cb = (ComboBox<String>) root.lookup("#list");
		cb.getItems().addAll("제목","글쓴이");
	}
	
	public void setMembership(Parent membership)
	{
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
	
	// 占싯삼옙
	public void search() {
		ss.search(root);
		setRoot(root);
	}
	
	// 글쓰기
	public void write() {
//		bs.write(id, root);
	}
	
	public void notice() {
		
	}

	public void logout() {
		
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
