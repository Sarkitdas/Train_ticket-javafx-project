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
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	

	@FXML
    private ImageView account;

    @FXML
    private Hyperlink createnew;

    @FXML
    private Label forgetpassword;

    @FXML
    private TextField id;

    @FXML
    private Button login;

    @FXML
    private ImageView logo;

    @FXML
    private PasswordField password;

    @FXML
    void loginaction(ActionEvent event) 
    {
    	
    	String nid=id.getText();
		String pass=password.getText();
    	
    	if(nid.equals("") && pass.equals(""))
    	{
    		JOptionPane.showMessageDialog(null,"Please enter ID and Password");
    	}
    	
    	else
    	{
    		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost/train_ticket?useTimezone=true&serverTimezone=UTC", "","");
			
				pst=con.prepareStatement("select * from account_section where Nid=? and Password=?");
						
				pst.setString(1, nid);
				pst.setString(2, pass);
				
				rs=pst.executeQuery();
				
				if(rs.next())
				{
					JOptionPane.showConfirmDialog(null, "Login Success");
				}
				else {
					JOptionPane.showConfirmDialog(null, "Login Failed");
					id.setText("");
					password.setText("");
				}
						
    		} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }
    @FXML
    void addacount(ActionEvent event) throws IOException 
    {
    	    Stage primaryStage=new Stage();
    	    Parent root= FXMLLoader.load(getClass().getResource("/addaccount/Addaccount.fxml"));
    	    primaryStage.setTitle("Saikat");
			primaryStage.setScene(new Scene(root,700,400));
			primaryStage.show();
    }
    @FXML
        void forget(MouseEvent event) throws IOException {
    	Stage primaryStage=new Stage();
	    Parent root= FXMLLoader.load(getClass().getResource("/forgetpassword/Forget.fxml"));
	    primaryStage.setTitle("Saikat");
		primaryStage.setScene(new Scene(root,700,400));
		primaryStage.show();

    }
}