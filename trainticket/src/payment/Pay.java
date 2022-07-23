package payment;

import java.io.FileNotFoundException;

import java.io.FileOutputStream;
import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.print.PrinterJob.JobStatus;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Pay {

    @FXML
    private Button fsubmit;

    @FXML
    private TextField name;

    @FXML
    private TextField phone;

    @FXML
    private TextField trid;
    
    @FXML
    private ImageView img;
    
    Connection con;
    
    

    @FXML
    void fnlsubmit(ActionEvent event) throws ClassNotFoundException, SQLException, FileNotFoundException{
    	
    	PreparedStatement pst;
    	ResultSet resultSet;
    	
    	String name1=name.getText();
    	String phne1=phone.getText();
    	String trnsction=trid.getText();
    	
    	Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost/train_ticket?useTimezone=true&serverTimezone=UTC", "","");
		  
		pst=con.prepareStatement("SELECT Max(Id) FROM bookingticket");
		resultSet=pst.executeQuery();
		
		while(resultSet.next())
		{
			//resultSet.getString("Max(Id)");

			String nticket=resultSet.getString("Max(Id)");
			
			PreparedStatement pst1;
			
			pst1=con.prepareStatement("UPDATE bookingticket SET profilename='"+ name1 +"',phone='"+ phne1 +"',transaction='"+ trnsction +"' WHERE Id='" + nticket +"'");
			pst1.executeUpdate();
			
			Alert alert = new Alert(Alert.AlertType.NONE);
	            alert.setAlertType(Alert.AlertType.CONFIRMATION);
	            alert.setContentText("Congratulations Your Ticket has been Confirmed!!");
	            

	            Optional<ButtonType> result = alert.showAndWait();
	            if (result.get() == ButtonType.OK) {

	                try {
	                    Parent parent = FXMLLoader.load(getClass().getResource("/ticketcounter/Place.fxml"));
	                    Scene scene = new Scene(parent);
	                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
	                    window.setScene(scene);
	                    window.show();

	                } catch (IOException e) {
	                    e.printStackTrace();
	                }

			
		}
    	

    }

    }
}
