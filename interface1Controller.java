package Controlleur;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class interface1Controller {
	@FXML
	private Button gestion1;

	// Event Listener on Button[#gestion1].onAction
	@FXML
	public void gestionproduit(ActionEvent event) {
		// TODO Autogenerated
		try {
			//Parent root=new BorderPane();
			Parent root=FXMLLoader.load(getClass().getResource("/application/interface2.fxml"));
			Scene scene=new Scene(root,571,476);
			Stage stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
