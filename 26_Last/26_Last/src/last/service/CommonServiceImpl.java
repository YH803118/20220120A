package last.service;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class CommonServiceImpl implements CommonService{

	@Override
	public void alert(String a, String b, String c) {

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(a);
		alert.setHeaderText(b);
		alert.setContentText(c);
		alert.show();
	}
	
	@Override
	public void windowClose(ActionEvent e) {
		Parent p = (Parent) e.getSource();
		Stage s = (Stage) p.getScene().getWindow();
		s.close();
		
	}

}
