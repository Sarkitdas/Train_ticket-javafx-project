package Checkbooking;

import java.io.IOException;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class Checkbook extends Thread implements Initializable{
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	
	@FXML
    private TableColumn<Sservice, String> Trnname;

    @FXML
    private Button button;
    
    @FXML
    private Button dlte;

    @FXML
    private TableColumn<Sservice, String> cvn;

    @FXML
    private TableColumn<Sservice, String> dte;

    @FXML
    private TableColumn<Sservice, String> frm;

    @FXML
    private TableColumn<Sservice, String> name;

    @FXML
    private TableColumn<Sservice, String> st;

    @FXML
    private TableColumn<Sservice, String> too;
    
    @FXML
    private TableView<Sservice> tableview;
    
    @FXML
    void dlt(ActionEvent event) throws ClassNotFoundException, SQLException, IOException 
    {
    	
    	Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost/train_ticket?useTimezone=true&serverTimezone=UTC", "","");

		PreparedStatement pst1,pst2;
		ResultSet rs1;
		
		pst1=con.prepareStatement("SELECT Id  FROM bookingticket ORDER BY Id * 1 desc limit 1;");
		rs1=pst1.executeQuery();
		while(rs1.next())
		{
			String id=rs1.getString("Id");
			pst2=con.prepareStatement("DELETE FROM bookingticket WHERE Id='"+1+"' <= '"+id+"'");
			pst2.execute();

				Parent parent = FXMLLoader.load(getClass().getResource("/Checkbooking/Checkbook.fxml"));
		        Scene scene = new Scene(parent);
		        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		        window.setScene(scene);
		        window.show();

		}

    }
    


    @FXML
    void btn(ActionEvent event) throws IOException {
    	Parent parent = FXMLLoader.load(getClass().getResource("/Admin/admin.fxml"));
        Scene scene = new Scene(parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
}

ObservableList<Sservice>service=FXCollections.observableArrayList();


	@Override
	public void initialize(URL url, ResourceBundle resourcebundle) {
		// TODO Auto-generated method stub
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/train_ticket?useTimezone=true&serverTimezone=UTC", "","");

			pst=con.prepareStatement("SELECT profilename,trainname,cabin,sit,date,from_d,to_a FROM bookingticket");
			rs=pst.executeQuery();
			while(rs.next())
			{
				service.add(new Sservice(rs.getString("profilename"),rs.getString("trainname"),rs.getString("Cabin"),rs.getString("sit"),rs.getString("date"),rs.getString("from_d"),rs.getString("to_a")));
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
 		
		
		name.setCellValueFactory(new PropertyValueFactory<>("profile"));
		Trnname.setCellValueFactory(new PropertyValueFactory<>("trainname"));
		cvn.setCellValueFactory(new PropertyValueFactory<>("cabin"));
		st.setCellValueFactory(new PropertyValueFactory<>("sit"));
		dte.setCellValueFactory(new PropertyValueFactory<>("date"));
		frm.setCellValueFactory(new PropertyValueFactory<>("from"));
		too.setCellValueFactory(new PropertyValueFactory<>("to"));
		
		tableview.setItems(service);
		
	}
	
	
}
