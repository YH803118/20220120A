package last.service;

import javafx.event.ActionEvent;
import javafx.scene.Parent;

public interface LoginService {
	public String login(Parent root);
	public void OpenMembership();
	public void logout(ActionEvent e);
}
