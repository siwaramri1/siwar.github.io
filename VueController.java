package Controlleur;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;



import javafx.event.ActionEvent;

public class VueController {
	@FXML
	private Button bb1;

	// Event Listener on Button[#aa2].onAction
	@FXML
	public void connexion(ActionEvent event) {
		try {
			//Parent root=new BorderPane();
			Parent root=FXMLLoader.load(getClass().getResource("/application/interface1.fxml"));
			Scene scene=new Scene(root,571,476);
			Stage stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	}
