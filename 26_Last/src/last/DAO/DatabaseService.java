package last.DAO;

import javafx.scene.Parent;

public interface DatabaseService {
	public void listView(Parent root);

	public boolean login(String id, String pw);
	
	public void search(String string, String string2, Parent root);
}