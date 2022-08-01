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

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

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
    void fnlsubmit(ActionEvent event) throws ClassNotFoundException, SQLException, FileNotFoundException, DocumentException{
    	
    	PreparedStatement pst;
    	ResultSet resultSet;
    	
    	String name1=name.getText();
    	String phne1=phone.getText();
    	String trnsction=trid.getText();
    	
    	Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost/train_ticket?useTimezone=true&serverTimezone=UTC", "","");
		  
		pst=con.prepareStatement("SELECT Id  FROM bookingticket ORDER BY Id * 1 desc limit 1");
		resultSet=pst.executeQuery();
		
		while(resultSet.next())
		{

			String nticket=resultSet.getString("Id");
			
			PreparedStatement pst1;
			
			pst1=con.prepareStatement("UPDATE bookingticket SET profilename='"+ name1 +"',phone='"+ phne1 +"',transaction='"+ trnsction +"' WHERE Id='" + nticket +"'");
			pst1.executeUpdate();
			
			Alert alert = new Alert(Alert.AlertType.NONE);
	            alert.setAlertType(Alert.AlertType.CONFIRMATION);
	            alert.setContentText("Congratulations Your Ticket has been Confirmed and Downloaded!!");
	            

	            Optional<ButtonType> result = alert.showAndWait();
	            if (result.get() == ButtonType.OK) {

	                try {
	                	PreparedStatement pst2;
	                	ResultSet resultSet1;
	                	pst2=con.prepareStatement("SELECT Id  FROM bookingticket ORDER BY Id * 1 desc limit 1");
	            		resultSet1=pst2.executeQuery();
	            		
	            		while(resultSet1.next())
	            		{

	            			String iid=resultSet1.getString("Id");
	            			
	            			PreparedStatement pst3;
		                	ResultSet resultSet3;
		                	pst3=con.prepareStatement("SELECT profilename,trainname,cabin,sit,date,from_d,to_a FROM bookingticket WHERE Id='"+iid+"'");
		            		resultSet3=pst3.executeQuery();
		            		
		            		while(resultSet3.next())
		            		{
		            			        String customername=resultSet3.getString("profilename");
                                        String customertrainname=resultSet3.getString("trainname");
		            					String customercabin=resultSet3.getString("cabin");
		            					String customersit=resultSet3.getString("sit");
		            					String customerdate=resultSet3.getString("date");
		            					String customerfrom=resultSet3.getString("from_d");
		            					String customerto=resultSet3.getString("to_a");
		            					
		            					String pdf="C:/Users/ausyj'/Desktop/123/"+customername+".pdf";
		        	                	
		        	                	
		        	                	Document doc=new Document();
		        	                	
		        	                	PdfWriter.getInstance(doc, new FileOutputStream(pdf));
		        	                	doc.open();
		        	                	Image img=Image.getInstance("C:/Users/ausyj'/Desktop/trainticket/src/image/train.png");
		        	                	img.scaleToFit(100, 250);
		        	                	img.setAbsolutePosition(250, 660);
		        	                	doc.add(img);
		        	                	
		        	                	doc.add(new Paragraph("\n\n\n\n\n\n\n\n\n\n"));
		        	                	doc.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
		        	                	doc.add(new Paragraph("                                                      Name             :              "+customername));
		        	                	doc.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
		        	                	doc.add(new Paragraph("                                                      Train Name    :              "+customertrainname));
		        	                	doc.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
		        	                	doc.add(new Paragraph("                                                      From              :              "+customerfrom));
		        	                	doc.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
		        	                	doc.add(new Paragraph("                                                      To                  :              "+customerto));
		        	                	doc.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
		        	                	doc.add(new Paragraph("                                                      Cabin             :              "+customercabin));
		        	                	doc.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
		        	                	doc.add(new Paragraph("                                                      Sit                  :              "+customersit));
		        	                	doc.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
		        	                	doc.add(new Paragraph("                                                      Date               :             "+customerdate));
		        	                	doc.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
		        	                	
		        	                	doc.add(new Paragraph("\n\n"));
		        	                	doc.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
		        	                	doc.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
		        	                	doc.add(new Paragraph("\n"));
		        	                	doc.add(new Paragraph("                                                        **** ENJOY YOUR TRIP ****"));
		        	                	doc.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
		        	                	doc.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
		        	                	doc.add(new Paragraph("@team_cyclon"));
		        	                	doc.close();

		            		}
	            			
	            		}
	                	
	                	
	                	
	                	
	                	
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
