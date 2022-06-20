package login;

import javafx.event.ActionEvent;



import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

import javax.swing.JOptionPane;

public class LoginController {
	

	@FXML
    private ImageView account;

    @FXML
    private Hyperlink createnew;

    @FXML
    private Hyperlink forget;

    @FXML
    private TextField id;

    @FXML
    private Button login;

    @FXML
    private ImageView logo;

    @FXML
    private PasswordField password;

    @FXML
    void loginaction(ActionEvent event) {
    	
    	Stage primaryStage=new Stage();
    	if(id.getText().equals("") && password.getText().equals(""))
    	{
    		JOptionPane.showMessageDialog(null,"Please enter ID and Password");
    	}
    	
    	else if(id.getText().equals("admin") && password.getText().equals("12345"))
    	{
    		try {
    			Parent root= FXMLLoader.load(getClass().getResource("/ticketcounter/Ticketcounter.fxml"));
    			primaryStage.setTitle("Saikat");
    			primaryStage.setScene(new Scene(root,700,400));
    			primaryStage.show();
    		}
    		catch(Exception e)
    		{
    			e.printStackTrace();
    		}
    	}
    	else
    	{
    		JOptionPane.showMessageDialog(null,"Please enter correct info!");
    	}

    }
    
    @FXML
    void addacount(ActionEvent event) throws IOException {
    	    Stage primaryStage=new Stage();
    	    Parent root= FXMLLoader.load(getClass().getResource("/addaccount/Addaccount.fxml"));
    	    primaryStage.setTitle("Saikat");
			primaryStage.setScene(new Scene(root,700,400));
			primaryStage.show();

    }
    
    @FXML
    void forget(ActionEvent event) throws IOException {
    	Stage primaryStage=new Stage();
	    Parent root= FXMLLoader.load(getClass().getResource("/forgetpassword/Forget.fxml"));
	    primaryStage.setTitle("Saikat");
		primaryStage.setScene(new Scene(root,700,400));
		primaryStage.show();

    }
}