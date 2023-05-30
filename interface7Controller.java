package Controlleur;

import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;



import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import metier.Categorie;
import metier.CategorieCrud;
import metier.Coffee;
import metier.CoffeeCrud;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class interface7Controller implements Initializable {
	@FXML
	private TableView <Categorie> tablecateg;
	@FXML
	private TableColumn<Categorie, Integer> id;
	@FXML
	private TableColumn<Categorie, String> nom;
	@FXML
	private Button a1;
	@FXML
	private Button s1;
	@FXML
	private Button m1;
	@FXML
    private TextField idcol;
	@FXML
	private TextField nomcol;
	@FXML
    private Button pg;
	
	
	@FXML
    void afficherproduit(MouseEvent event) {
     Categorie c =  tablecateg.getSelectionModel().getSelectedItem();
     idcol.setText(""+c.getId());
     nomcol.setText(""+c.getNom());
    }


	// Event Listener on Button[#a1].onAction
	@FXML
	public void ajouter(ActionEvent event) {
		int id=Integer.parseInt(idcol.getText());
		String nom=nomcol.getText();
		Categorie c=new Categorie(id,nom);
		CategorieCrud categ=new CategorieCrud();
		categ.add(c);
		CategorieCrud categorie=new CategorieCrud();
		ObservableList<Categorie> listeCateg=categorie.getAll();
		 tablecateg.setItems(listeCateg);
		
	}
	// Event Listener on Button[#s1].onAction
	@FXML
	public void supprimer(ActionEvent event) {
		int id=Integer.parseInt(idcol.getText());
		String nom=nomcol.getText();
		
		Categorie c=new Categorie(id,nom);
		CategorieCrud categ=new CategorieCrud();
		categ.delete(c);
		idcol.setText("");
		nomcol.setText("");
		
		CategorieCrud cc=new CategorieCrud();
		ObservableList<Categorie> listeCateg=cc.getAll();
		 tablecateg.setItems(listeCateg);
		
	}
	// Event Listener on Button[#m1].onAction
	@FXML
	public void modifier(ActionEvent event) {
		int id=Integer.parseInt(idcol.getText());
		String nom=nomcol.getText();
		Categorie c=new Categorie(id,nom);
		CategorieCrud categ=new CategorieCrud();
		categ.update(c);
		CategorieCrud categorie=new CategorieCrud();
		ObservableList<Categorie> listeCateg=categorie.getAll();
		 tablecateg.setItems(listeCateg);
		
	}
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		id.setCellValueFactory(new PropertyValueFactory<Categorie,Integer>("id") );
		nom.setCellValueFactory(new PropertyValueFactory<Categorie,String>("nom") );
		
		CategorieCrud c=new CategorieCrud();
		ObservableList<Categorie> listeCateg=c.getAll();
		 tablecateg.setItems(listeCateg);
		
		
	}
	@FXML
    void retour(ActionEvent event) {	
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

