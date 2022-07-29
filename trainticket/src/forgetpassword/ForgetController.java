package forgetpassword;

import java.io.IOException;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.cj.protocol.Resultset;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;



public class ForgetController {
	
	ResultSet rs;
	Connection con;
	PreparedStatement pst;

    @FXML
    private TextField nid;

    @FXML
    private PasswordField password;

    @FXML
    private Button submit;
    
    @FXML
    private Button login;
    
    @FXML
    void forgetbtn(ActionEvent event) throws SQLException 
    {
    	
    	String Nd=nid.getText();
    	String Pswd=password.getText();
    	
    	if(Nd.equals("") && Pswd.equals(""))
    	{
    		JOptionPane.showMessageDialog(null,"Please enter ID and Password");
    	}
    	
    	else
    	{
    		try {
    			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/train_ticket?useTimezone=true&serverTimezone=UTC", "","");
			
			pst=con.prepareStatement("select * from account_section where Nid=?");
						
			pst.setString(1, Nd);
			
			rs=pst.executeQuery();
			if(rs.next())
			{
				pst=con.prepareStatement(" UPDATE account_section SET Password=? WHERE Nid=? ");
				
				pst.setString(2, Nd);
				pst.setString(1, Pswd);
				
	            pst.executeUpdate();

					JOptionPane.showMessageDialog(null, "Congratulation Your Password has been Changed!");

			}
    	else
    	{
    		JOptionPane.showMessageDialog(null, "Please Check your NID !");
    	}
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




