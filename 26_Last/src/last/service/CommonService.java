package last.service;

import javafx.event.ActionEvent;

public interface CommonService {
	public void windowClose(ActionEvent event);
	public void errorMsg(String title, String headerStr, String contextStr);
}
