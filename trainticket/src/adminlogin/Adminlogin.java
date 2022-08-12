package adminlogin;

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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Adminlogin {
	
	Connection con;
	PreparedStatement pst;

    @FXML
    private TextField id;

    @FXML
    private Button login;

    @FXML
    private TextField pass;

    @FXML
    void login(ActionEvent event) throws IOException {
    	
    	String nid=id.getText();
		String password=pass.getText();
		ResultSet rs;
		
    	
    	if(nid.equals("") && password.equals(""))
    	{
    		
    		Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Please enter ID and Password!");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
			id.setText("");
			pass.setText("");
            }
    		
    	}
    	
    	else
    	{
    		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost/train_ticket?useTimezone=true&serverTimezone=UTC", "","");
			
				pst=con.prepareStatement("select * from adminlogin where ID=? and PASSWORD=?");
						
				pst.setString(1, nid);
				pst.setString(2, password);
				
				rs=pst.executeQuery();
				
				if(rs.next())
				{
			    	Parent parent= FXMLLoader.load(getClass().getResource("/Admin/admin.fxml"));
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
					pass.setText("");
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

}