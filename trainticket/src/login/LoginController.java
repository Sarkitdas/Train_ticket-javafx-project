package login;

import javafx.event.ActionEvent;




import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.Optional;



public class LoginController {
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	
	@FXML
    private Button admin;
	

	@FXML
    private ImageView account;

    @FXML
    private Label createnew;

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
    private AnchorPane rootpane;

    @FXML
    void loginaction(ActionEvent event) throws IOException 
    {
    	
    	String nid=id.getText();
		String pass=password.getText();
    	
    	if(nid.equals("") && pass.equals(""))
    	{
    		
    		Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Please enter ID and Password!");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
			id.setText("");
			password.setText("");
            }
    		
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
			    	Parent parent= FXMLLoader.load(getClass().getResource("/ticketcounter/Place.fxml"));
					
					//Parent parent= FXMLLoader.load(getClass().getResource("/Homepage/Home.fxml"));
			        
			    	Scene scene=new Scene(parent);
			    	Stage window=(Stage) ((Node) event.getSource()).getScene().getWindow();
			    	window.setScene(scene);
					window.show();
					
					
		    	    
				}
				else {
					Alert alert = new Alert(Alert.AlertType.ERROR);
		            alert.setAlertType(Alert.AlertType.ERROR);
		            alert.setContentText("Please insert Correct Information!");

		            Optional<ButtonType> result = alert.showAndWait();
		            if (result.get() == ButtonType.OK) {
					id.setText("");
					password.setText("");
		            }
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
    void createnew(MouseEvent event) throws IOException 
    {
    	
    	Parent parent = FXMLLoader.load(getClass().getResource("/addaccount/Addaccount.fxml"));
        Scene scene = new Scene(parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    	    

    }
    @FXML
        public void forget(MouseEvent event) throws IOException 
    {

		Parent parent = FXMLLoader.load(getClass().getResource("/forgetpassword/Forget.fxml"));
		
		
		Scene scene = new Scene(parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

    }
    
    @FXML
    void adminpanel(ActionEvent event) throws IOException {
    	//Parent parent = FXMLLoader.load(getClass().getResource("/Admin/admin.fxml"));
    	Parent parent = FXMLLoader.load(getClass().getResource("/adminlogin/adminlog.fxml"));
    	
        Scene scene = new Scene(parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

    }

}