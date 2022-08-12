package Trainupdate;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

public class trainupdate {
	
	Connection con;
	PreparedStatement pst1;
	PreparedStatement pst2;
	PreparedStatement pst3;
	PreparedStatement pst4;
	PreparedStatement pst5;
	PreparedStatement pst6;

    @FXML
    private DatePicker date1;

    @FXML
    private DatePicker date2;

    @FXML
    private DatePicker date3;

    @FXML
    private DatePicker date4;

    @FXML
    private DatePicker date5;

    @FXML
    private Button submit;
    
    @FXML
    private Button back;

    @FXML
    void action(ActionEvent event) throws ClassNotFoundException, SQLException {
    	
    	String Date1=date1.getEditor().getText();
    	String Date2=date2.getEditor().getText();
    	String Date3=date3.getEditor().getText();
    	String Date4=date4.getEditor().getText();
    	String Date5=date5.getEditor().getText();
    	
    	Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost/train_ticket?useTimezone=true&serverTimezone=UTC", "","");
	
		PreparedStatement pst6;
		ResultSet rs6;
		pst6=con.prepareStatement("SELECT Id FROM admin_booking ORDER BY Id * 1 desc limit 1;");
		rs6=pst6.executeQuery();
		while(rs6.next())
		{
			String IID=rs6.getString("Id");
			int n=Integer.parseInt(IID);
			if(n>5)
			{
				pst6=con.prepareStatement("DELETE FROM admin_booking WHERE Id>='"+6+"' AND Id<='"+n+"'");
				pst6.execute();
			}
		}
		
		pst1=con.prepareStatement("UPDATE admin_booking SET date='"+ Date1 +"' WHERE Id='"+ 1 +"'");
		pst2=con.prepareStatement("UPDATE admin_booking SET date='"+ Date2 +"' WHERE Id='"+ 2 +"'");
		pst3=con.prepareStatement("UPDATE admin_booking SET date='"+ Date3 +"' WHERE Id='"+ 3 +"'");
		pst4=con.prepareStatement("UPDATE admin_booking SET date='"+ Date4 +"' WHERE Id='"+ 4 +"'");
		pst5=con.prepareStatement("UPDATE admin_booking SET date='"+ Date5 +"' WHERE Id='"+ 5 +"'");
		
		pst1.executeUpdate();
		pst2.executeUpdate();
		pst3.executeUpdate();
		pst4.executeUpdate();
		pst5.executeUpdate();
		
		JOptionPane.showMessageDialog(null, "Train Schedule Updated !");
		

    }
    

    @FXML
    void Back(ActionEvent event) throws IOException {
    	Parent parent = FXMLLoader.load(getClass().getResource("/Admin/admin.fxml"));
        Scene scene = new Scene(parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

    }

}
