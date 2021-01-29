package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import entity.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import userDatabase.DatabaseManager;

public class MainViewController implements Initializable{
	private TableView<Person> userdata;
	@FXML
	private TableColumn<Person,String> col_id;
	@FXML
	private TableColumn<Person,String> col_name;
	@FXML
	private TableColumn<Person,String> col_age;
	
	ObservableList<Person> oblist = FXCollections.observableArrayList();

	@Override
	public void initialize(URL Location, ResourceBundle arg1) {
		System.out.println("Good");
		col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
		col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
		col_age.setCellValueFactory(new PropertyValueFactory<>("age"));
		
		
		try {
			DatabaseManager db = new DatabaseManager();
			Connection cn = db.fileConnection();
			
			String sql="select * from person";
			Statement s = cn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				
				oblist.add(new Person(rs.getString("id"),
						rs.getString("name"),
						rs.getString("age")));
			}
			userdata.setItems(oblist);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	

//	public void addBtnClicked() {
//		if(input.getText().isEmpty()) return;
//		listview.getItems().add(input.getText());
//	}
//	
//	public void deleteBtnClicked() {
//		String data=listview.getSelectionModel().getSelectedItem();
//		listview.getItems().remove(data);
//	}
}
