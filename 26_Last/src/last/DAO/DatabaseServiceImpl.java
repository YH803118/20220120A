package last.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.Parent;
import javafx.scene.control.ListView;
import last.Board;
import last.UserInfo;

public class DatabaseServiceImpl implements DatabaseService{

	private Connection con = null;
	private PreparedStatement ppst = null;
	private ResultSet rs = null;
	private String url, user, pass;
	
	public DatabaseServiceImpl() {
		
		System.out.println("===========");
		try {			   
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("오라클 드라이버 연결");
		} catch (Exception e) {
		// TODO: handle exception
			e.printStackTrace();
		}
		try {
			url = "jdbc:oracle:thin:@localhost:1521:xe";
			user = "system";
			pass = "oracle";
			
			con = DriverManager.getConnection(url,user,pass);
			System.out.println("오라클 연결 객체 생성");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	@Override
	public void listView(Parent root) {
		// TODO Auto-generated method stub
		ListView<String> listV = (ListView<String>) root.lookup("#boardListView");
		
		List<String> list = new ArrayList<String>();
		
		String sql = "select * from board";
		
		try {
			
			ppst = con.prepareStatement(sql);
			rs = ppst.executeQuery();
			while(rs.next()) {
				Board b = new Board();
				b.setNum(rs.getInt(1));
				b.setTitle(rs.getString(3));
				b.setId(rs.getString(2));
				String listString = "\t"+b.getNum()+"\t\t"+b.getTitle()+"\t\t\t\t\t\t\t\t\t"+b.getId();
				listV.getItems().add(listString);
//				list.add(listString);
			}
			ppst.close(); rs.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public boolean login(String id, String pw) {
		// TODO Auto-generated method stub
		
		String sql = "select count(*) from userInfo where id=? and pw=?";
		
		try {
			ppst = con.prepareStatement(sql);
			ppst.setString(1, id);
			ppst.setString(2, pw);

			rs = ppst.executeQuery();
			
			rs.next();
			int result = rs.getInt(1);
			
			if(result >=1) {
				System.out.println("로그인성공");
				return true;
			}
			else {
				System.out.println("로그인실패");
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void search(String search, String list, Parent root) {
		// TODO Auto-generated method stub
		String sql = "select * from board where ? like '%"+search
				+ "%'";
		try {
			ppst = con.prepareStatement(sql);
			
			if(list == null || list.equals("제목")) {
				ppst.setString(1, "title");
			}
			else if(list.equals("글쓴이")) {
				ppst.setString(1, "id");
			}
			ListView<String> listV = (ListView<String>) root.lookup("#boardListView");

			rs = ppst.executeQuery();
			
			while(rs.next()) {
				Board b = new Board();
				b.setNum(rs.getInt(1));
				b.setTitle(rs.getString(3));
				b.setId(rs.getString(2));
				listV.getItems().add("\t"+b.getNum()+"\t\t"+b.getTitle()+"\t\t\t\t\t\t\t\t\t"+b.getId());
			}
			ppst.close(); rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public boolean insertMembership(UserInfo u) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
