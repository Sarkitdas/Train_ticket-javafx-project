package addaccount;

import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;

import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javafx.event.ActionEvent;

import javafx.scene.control.PasswordField;

import javafx.scene.control.DatePicker;

public class AddaccountController 
{


@FXML
private TextField address;

@FXML
private DatePicker birthdate;

@FXML
private TextField name;

@FXML
private TextField nid;

@FXML
private PasswordField password;

@FXML
private TextField phone;

@FXML
private Button signup;

@FXML
private Button login;





	// Event Listener on Button[#signup].onAction
	@FXML
	public void signup(ActionEvent event) throws SQLException 
	{
		// TODO Autogenerated
		
		
		String nme=name.getText();
		String adrss=address.getText();
		String nd=nid.getText();
		String birth=birthdate.getEditor().getText();
	    String phn=phone.getText();
		String pswd=password.getText();
    	
    	if(nme.equals("") || adrss.equals("") || nd.equals("") || birth.equals("")  || phn.equals("")  || pswd.equals("") )
    	{
    		JOptionPane.showMessageDialog(null,"Please,Enter your Information correctly!!");
    	}
		
    	else
    	{
		try 
		{
			

			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/train_ticket?useTimezone=true&serverTimezone=UTC", "","");
			
		    PreparedStatement stmt=con.prepareStatement("INSERT INTO account_section (Name, Address, Nid, Birthdate, Phone, Password) VALUES (?, ?, ?, ?, ?, ?)"); 
		    
		    stmt.setString(1, nme);
		    stmt.setString(2, adrss);
		    stmt.setString(3, nd);
		    stmt.setString(4, birth);
		    stmt.setString(5, phn);
		    stmt.setString(6, pswd);
		    
		    stmt.executeUpdate();
		    
		    	JOptionPane.showMessageDialog(null, "Success");
		    	name.setText(null);
		    	address.setText(null);
		    	nid.setText(null);
		    	//birthdate.setText(null).setEditor();
		    	phone.setText(null);
		    	password.setText(null);
		    	
		    	
		    
	}
		    
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
	
	@FXML
    void login(ActionEvent event) throws IOException {
		
		Parent parent = FXMLLoader.load(getClass().getResource("/login/login.fxml"));
        Scene scene = new Scene(parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

    }
	
}


		


