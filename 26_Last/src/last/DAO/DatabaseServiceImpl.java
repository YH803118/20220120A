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

public class DatabaseServiceImpl implements DatabaseService{

	private Connection con = null;
	private PreparedStatement ppst = null;
	private ResultSet rs = null;
	private String url, user, pass;
	
	public DatabaseServiceImpl() {
		
		System.out.println("===========");
		try {			   
			Class.forName("oracle.jdbc.driver.OracleDriver");
<<<<<<< HEAD
			System.out.println("오라클 등록 성공");
=======
			System.out.println("오라클 드라이버 연결");
>>>>>>> branch 'master' of https://github.com/YH803118/20220120A.git
		} catch (Exception e) {
		// TODO: handle exception
			e.printStackTrace();
		}
		try {
			url = "jdbc:oracle:thin:@localhost:1521:xe";
			user = "system";
			pass = "oracle";
			
			con = DriverManager.getConnection(url,user,pass);
<<<<<<< HEAD
			System.out.println("오라클 연결 성공");
=======
			System.out.println("오라클 연결 객체 생성");
>>>>>>> branch 'master' of https://github.com/YH803118/20220120A.git
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	@Override
	public void listView(Parent root) {
		// TODO Auto-generated method stub
		ListView<String> listV = new ListView<String>();
		listV = (ListView<String>) root.lookup("#boardListView");
		
		List<String> list = new ArrayList<String>();
		
		String sql = "select * from board";
		
		try {
			
			ppst = con.prepareStatement(sql);
			rs = ppst.executeQuery();
			System.out.println("##################");
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
	
}
