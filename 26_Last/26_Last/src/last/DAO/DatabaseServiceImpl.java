package last.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	private int boardNum=0;
	
	public DatabaseServiceImpl() {
		
		try {			   
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
		// TODO: handle exception
			e.printStackTrace();
		}
		try {
			url = "jdbc:oracle:thin:@localhost:1521:xe";
			user = "system";
			pass = "oracle";
			
			con = DriverManager.getConnection(url,user,pass);
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
				System.out.println("ï¿½Î±ï¿½ï¿½Î¼ï¿½ï¿½ï¿½");
				return true;
			}
			else {
				System.out.println("ï¿½Î±ï¿½ï¿½Î½ï¿½ï¿½ï¿½");
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
			
			if(list == null || list.equals("ï¿½ï¿½ï¿½ï¿½")) {
				ppst.setString(1, "title");
			}
			else if(list.equals("ï¿½Û¾ï¿½ï¿½ï¿½")) {
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
	public boolean insertMembership(UserInfo u) 
	{
		// TODO Auto-generated method stub
		
		String sql = "insert into userInfo values(?,?,?)";
		try {
			ppst=con.prepareStatement(sql);
			ppst.setString(1, u.getId());
			ppst.setString(2, u.getPw());
			ppst.setString(3, u.getName());
			int result= ppst.executeUpdate();
			if(result>=1) return true;
			else return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void insertBoard(String id, String title, String content) {
		// TODO Auto-generated method stub
		boardNum++;
		String sql = "insert into board values(?,?,?,?)";
		try {
			ppst=con.prepareStatement(sql);
			ppst.setInt(1, boardNum);
			ppst.setString(2, id);
			ppst.setString(3, title);
			ppst.setString(4, content);
			int result= ppst.executeUpdate();
			if(result>=1) System.out.println("¼º°ø");
			ppst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		
	
}
