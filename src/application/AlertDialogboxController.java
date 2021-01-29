package application;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.application.Platform;
import javafx.event.ActionEvent;

public class AlertDialogboxController {

	// Event Listener on Button.onAction
	@FXML
	public void onYesBtnClicked(ActionEvent event) {
		Platform.exit();
	}
	// Event Listener on Button.onAction
	@FXML
	public void onNoBtnClicked(ActionEvent event) {
		Node source = (Node) event.getSource();
		Stage stage= (Stage) source.getScene().getWindow();
		stage.close();
	}
}
