package booking;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

public class bookController implements Initializable {
	
	
	boolean bta1, bta2, bta3, bta4, btb1, btb2, btb3, btb4, btc1, btc2, btc3, btc4, btd1, btd2, btd3, btd4, bte1, bte2, bte3, bte4, btf1, btf2, btf3, btf4, btg1, btg2, btg3, btg4, bth1, bth2, bth3, bth4, bti1, bti2, bti3, bti4, btj1, btj2, btj3, btj4;
	
	
	Boolean count;
	int seatCount1 = 0, seatCount2 = 0, seatCount3 = 0, seatCount4 = 0, seatCount5 =0 , seatCount6 = 0, seatCount7 = 0,
		      seatCount8 = 0, seatCount9 = 0,
		      seatCount10 = 0, seatCount11 = 0, seatCount12 = 0, seatCount13 = 0, seatCount14 = 0, seatCount15 = 0, seatCount16 = 0,seatCount17 = 0, seatCount18 = 0, seatCount19 = 0,
		      seatCount20 = 0, seatCount21 =0 , seatCount22 = 0, seatCount23 = 0,
		    	      seatCount24 = 0, seatCount25 = 0,seatCount26 = 0, seatCount27 = 0, seatCount28 = 0, seatCount29 = 0, seatCount30 = 0, seatCount31 = 0, seatCount32 = 0,seatCount33 = 0, seatCount34 = 0, seatCount35 = 0,
		    	    	      seatCount36 = 0, seatCount37 =0 , seatCount38 = 0, seatCount39 = 0,
		    	    	      seatCount40 = 0;

	

	  String yellow = "-fx-background-color:#ffb805";
	  String red = "-fx-background-color:#ff4040";
	  String green = "-fx-background-color:#00b400";
	

    @FXML
    private Button A1;

    @FXML
    private Button A2;

    @FXML
    private Button A3;

    @FXML
    private Button A4;

    @FXML
    private Button B1;

    @FXML
    private Button B2;

    @FXML
    private Button B3;

    @FXML
    private Button B4;

    @FXML
    private Button C1;

    @FXML
    private Button C2;

    @FXML
    private Button C3;

    @FXML
    private Button C4;

    @FXML
    private Button D1;

    @FXML
    private Button D2;

    @FXML
    private Button D3;

    @FXML
    private Button D4;

    @FXML
    private Button E1;

    @FXML
    private Button E2;

    @FXML
    private Button E3;

    @FXML
    private Button E4;

    @FXML
    private Button F1;

    @FXML
    private Button F2;

    @FXML
    private Button F3;

    @FXML
    private Button F4;

    @FXML
    private Button G1;

    @FXML
    private Button G2;

    @FXML
    private Button G3;

    @FXML
    private Button G4;

    @FXML
    private Button H1;

    @FXML
    private Button H2;

    @FXML
    private Button H3;

    @FXML
    private Button H4;

    @FXML
    private Button I1;

    @FXML
    private Button I2;

    @FXML
    private Button I3;

    @FXML
    private Button I4;

    @FXML
    private Button J1;

    @FXML
    private Button J2;

    @FXML
    private Button J3;

    @FXML
    private Button J4;
    
    @FXML
    private Button bck;
    
    @FXML
    private Button reset;

    @FXML
    private ChoiceBox<String> coach;
    private String[] cabin= {"A","B","C","D","E"};

    @FXML
    private TextField nprice;

    @FXML
    private TextField nsit;

    @FXML
    private TextField ntrain;
    
    @FXML
    private Button price;
    

    @FXML
    private Button tktsubmit;
    
    Connection con;
    PreparedStatement pst;
	ResultSet resultSet;
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		coach.getItems().addAll(cabin);
		coach.getValue();
	}
	
	@FXML
    void resetbtn(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost/train_ticket?useTimezone=true&serverTimezone=UTC", "","");
		  
		PreparedStatement pst10;
		
		pst10=con.prepareStatement("SELECT Max(Id) FROM bookingticket");
		resultSet=pst10.executeQuery();

    	while(resultSet.next())
		{
			//resultSet.getString("Max(Id)");
    		

			String ID=resultSet.getString("Max(Id)");
			
			int p=Integer.parseInt(ID);
			int j=5+p;
			String Id=Integer.toString(j);
			

			
			
			PreparedStatement pst1;
			pst1=con.prepareStatement(" DELETE FROM admin_booking WHERE Id='"+ Id +"' ");
			pst1.execute();
			
			///refresh 
			
			Parent parent = FXMLLoader.load(getClass().getResource("/booking/book.fxml"));
	        Scene scene = new Scene(parent);
	        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        window.setScene(scene);
	        window.show();

			
		}

    }
	
	
    
	@FXML
    void setprice(ActionEvent event) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
    	
    	Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost/train_ticket?useTimezone=true&serverTimezone=UTC", "","");
		  
		String nnsit=nsit.getText();
		int n=Integer.parseInt(nnsit);
		
		
		pst=con.prepareStatement("SELECT Max(Id) FROM bookingticket");
		resultSet=pst.executeQuery();

    	while(resultSet.next())
		{
			//resultSet.getString("Max(Id)");
    		

			String nticket=resultSet.getString("Max(Id)");
			
			//nprice.setText(nticket);
			
			PreparedStatement pst0;
			pst0=con.prepareStatement("SELECT trainname, from_d, to_a FROM bookingticket WHERE Id="+ nticket +"");
			ResultSet resultSet0;
			
			
			
			resultSet0=pst0.executeQuery();
			
			while(resultSet0.next())
			{
				
				String frmplc=resultSet0.getString("from_d");
				String toplc=resultSet0.getString("to_a");
				String train=resultSet0.getString("trainname");
				PreparedStatement pst1;
				pst1=con.prepareStatement("SELECT price FROM train WHERE derived='"+ frmplc +"' AND arrived='"+ toplc +"' AND trainname='"+ train +"'");
				ResultSet resultSet1;
				
				resultSet1=pst1.executeQuery();
				while(resultSet1.next())
				{
					String prce=resultSet1.getString("price");
					
					
					int p=Integer.parseInt(prce);
					int j=0;
					for(int i=0;i<n;i++)
					{
						j=j+p;
					}
					
					String newprice=Integer.toString(j);
					
					nprice.setText(newprice);
				}
				
			}
			
		}
		
	}

 
    @FXML
    void bta1(ActionEvent event)throws IOException, SQLException, ClassNotFoundException
    {
    	
    	Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost/train_ticket?useTimezone=true&serverTimezone=UTC", "","");
		  

    	String st="A1";
    	String Coach=coach.getValue();
    	
    	if(Coach==null)
    	{
    		JOptionPane.showMessageDialog(null, "Please Select Coach!");
    	}
    	else
    	{
    		
    		pst=con.prepareStatement("SELECT Max(Id) FROM bookingticket");
    		resultSet=pst.executeQuery();

        	while(resultSet.next())
    		{
    			resultSet.getString("Max(Id)");

    			String nticket=resultSet.getString("Max(Id)");

    			pst=con.prepareStatement("SELECT trainname FROM bookingticket WHERE Id='"+ nticket + "'");
    			ResultSet resultSet0=pst.executeQuery();
    			while(resultSet0.next())
    			{
    				ntrain.setText(resultSet0.getString("trainname"));
    			}
    			
    			pst=con.prepareStatement("SELECT date FROM bookingticket WHERE Id='"+ nticket +"'");
    			ResultSet resultSet1=pst.executeQuery();
    			while(resultSet1.next())
    			{
    				String dte=resultSet1.getString("date");
    				PreparedStatement pst1;
    				pst1=con.prepareStatement("SELECT sit, coach FROM admin_booking WHERE date='"+ dte +"'");

    				
    				ResultSet resultSet2=pst1.executeQuery();
             		while(resultSet2.next())
    				{

             			String newsit=resultSet2.getString("sit");
    					String newcoach=resultSet2.getString("coach");


        					if(newsit.equals(st) && newcoach.equals(Coach))
        					{
        						
        						
        
        						JOptionPane.showMessageDialog(null, "oops! The seat is booked already. Select another");
        						A1.setStyle("-fx-background-color:red");
        					}
        					else
        					{ 						
        						int p=Integer.parseInt(nticket);
        						int j=5+p;
        						String Id=Integer.toString(j);
        						
        						A1.setOnAction(e -> {
        							bta1 = true;
        				            A1.setStyle(yellow);
        				           //nsit.setText(newsit); 
        				            
        				            PreparedStatement pst5;
        		    				try {
										pst5=con.prepareStatement("INSERT INTO admin_booking(Id, sit, coach, date) VALUES ('"+ Id +"','"+ st +"','"+ Coach +"','"+ dte +"')");
										pst5.execute();
	        		             		
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}

        				            
        				            
        				            
        				            seatCount1 = 1;
        				           
        				           nsit.setText(String.valueOf(seatCount1  + seatCount2  + seatCount3  + seatCount4  + seatCount5  + seatCount6  + seatCount7  +
        				     		      seatCount8  + seatCount9  +
        				    		      seatCount10  + seatCount11  + seatCount12  + seatCount13  + seatCount14  + seatCount15  + seatCount16  +seatCount17  + seatCount18  + seatCount19  +
        				    		      seatCount20  + seatCount21  + seatCount22  + seatCount23  +
        				    		    	      seatCount24  + seatCount25  +seatCount26  + seatCount27  + seatCount28  + seatCount29  + seatCount30  + seatCount31  + seatCount32  +seatCount33  + seatCount34  + seatCount35  +
        				    		    	    	      seatCount36  + seatCount37  + seatCount38  + seatCount39  +
        				    		    	    	      seatCount40 ));
        				           
        					});

    					}			
    			}
    		  }
    		} 	
    	}		
	}


	@FXML
    void bta2(ActionEvent event) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost/train_ticket?useTimezone=true&serverTimezone=UTC", "","");
		  

    	String st="A2";
    	String Coach=coach.getValue();
    	
    	if(Coach==null)
    	{
    		JOptionPane.showMessageDialog(null, "Please Select Coach!");
    	}
    	else
    	{
    		
    		pst=con.prepareStatement("SELECT Max(Id) FROM bookingticket");
    		resultSet=pst.executeQuery();

        	while(resultSet.next())
    		{
    			resultSet.getString("Max(Id)");

    			String nticket=resultSet.getString("Max(Id)");
    			
    			pst=con.prepareStatement("SELECT trainname FROM bookingticket WHERE Id='"+ nticket + "'");
    			ResultSet resultSet0=pst.executeQuery();
    			while(resultSet0.next())
    			{
    				ntrain.setText(resultSet0.getString("trainname"));
    			}
    			
    			pst=con.prepareStatement("SELECT date FROM bookingticket WHERE Id='"+ nticket +"'");
    			ResultSet resultSet1=pst.executeQuery();
    			while(resultSet1.next())
    			{
    				String dte=resultSet1.getString("date");
    				pst=con.prepareStatement("SELECT sit, coach FROM admin_booking WHERE date='"+ dte +"'");
    				ResultSet resultSet2=pst.executeQuery();
             		while(resultSet2.next())
    				{

             			String newsit=resultSet2.getString("sit");
    					String newcoach=resultSet2.getString("coach");

    					if(newsit.equals(st) && newcoach.equals(Coach))
    					{
    						A2.setStyle("-fx-background-color:red");
    						JOptionPane.showMessageDialog(null, "oops! The seat is booked already. Select another");
    						
    					}
    					else
    					{
    						int p=Integer.parseInt(nticket);
    						int j=5+p;
    						String Id=Integer.toString(j);
    						
    						
    						A2.setOnAction(e -> {
    							bta2 = true;
    				            A2.setStyle(yellow);
    				            
    				            PreparedStatement pst5;
    		    				try {
									pst5=con.prepareStatement("INSERT INTO admin_booking(Id, sit, coach, date) VALUES ('"+ Id +"','"+ st +"','"+ Coach +"','"+ dte +"')");
									pst5.execute();
        		             		
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
    				            
    				            seatCount2 = 1;
    				           //nsit.setText(newsit);
    				           nsit.setText(String.valueOf(seatCount1  + seatCount2  + seatCount3  + seatCount4  + seatCount5  + seatCount6  + seatCount7  +
    				     		      seatCount8  + seatCount9  +
    				    		      seatCount10  + seatCount11  + seatCount12  + seatCount13  + seatCount14  + seatCount15  + seatCount16  +seatCount17  + seatCount18  + seatCount19  +
    				    		      seatCount20  + seatCount21  + seatCount22  + seatCount23  +
    				    		    	      seatCount24  + seatCount25  +seatCount26  + seatCount27  + seatCount28  + seatCount29  + seatCount30  + seatCount31  + seatCount32  +seatCount33  + seatCount34  + seatCount35  +
    				    		    	    	      seatCount36  + seatCount37  + seatCount38  + seatCount39  +
    				    		    	    	      seatCount40));
    					});

    				}	
    			}
    		  }
    		} 	
    	}
    	

    }

    @FXML
    void bta3(ActionEvent event) throws ClassNotFoundException, SQLException {
    	Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost/train_ticket?useTimezone=true&serverTimezone=UTC", "","");
		  

    	String st="A3";
    	String Coach=coach.getValue();
    	
    	if(Coach==null)
    	{
    		JOptionPane.showMessageDialog(null, "Please Select Coach!");
    	}
    	else
    	{
    		
    		pst=con.prepareStatement("SELECT Max(Id) FROM bookingticket");
    		resultSet=pst.executeQuery();

        	while(resultSet.next())
    		{
    			resultSet.getString("Max(Id)");

    			String nticket=resultSet.getString("Max(Id)");
    			
    			pst=con.prepareStatement("SELECT trainname FROM bookingticket WHERE Id='"+ nticket + "'");
    			ResultSet resultSet0=pst.executeQuery();
    			while(resultSet0.next())
    			{
    				ntrain.setText(resultSet0.getString("trainname"));
    			}
    			
    			pst=con.prepareStatement("SELECT date FROM bookingticket WHERE Id='"+ nticket +"'");
    			ResultSet resultSet1=pst.executeQuery();
    			while(resultSet1.next())
    			{
    				String dte=resultSet1.getString("date");
    				pst=con.prepareStatement("SELECT sit, coach FROM admin_booking WHERE date='"+ dte +"'");
    				ResultSet resultSet2=pst.executeQuery();
             		while(resultSet2.next())
    				{

             			String newsit=resultSet2.getString("sit");
    					String newcoach=resultSet2.getString("coach");

    					if(newsit.equals(st) && newcoach.equals(Coach))
    					{
    						A3.setStyle("-fx-background-color:red");
    						JOptionPane.showMessageDialog(null, "oops! The seat is booked already. Select another");
    						
    					}
    					else
    					{
    						int p=Integer.parseInt(nticket);
    						int j=5+p;
    						String Id=Integer.toString(j);
    						
    						
    						A3.setOnAction(e -> {
    							bta3 = true;
    				            A3.setStyle(yellow);
    				            
    				            PreparedStatement pst5;
    		    				try {
									pst5=con.prepareStatement("INSERT INTO admin_booking(Id, sit, coach, date) VALUES ('"+ Id +"','"+ st +"','"+ Coach +"','"+ dte +"')");
									pst5.execute();
        		             		
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
    				            
    				            seatCount3 = 1;
    				           //nsit.setText(newsit);
    				           nsit.setText(String.valueOf(seatCount1  + seatCount2  + seatCount3  + seatCount4  + seatCount5  + seatCount6  + seatCount7  +
    				     		      seatCount8  + seatCount9  +
    				    		      seatCount10  + seatCount11  + seatCount12  + seatCount13  + seatCount14  + seatCount15  + seatCount16  +seatCount17  + seatCount18  + seatCount19  +
    				    		      seatCount20  + seatCount21  + seatCount22  + seatCount23  +
    				    		    	      seatCount24  + seatCount25  +seatCount26  + seatCount27  + seatCount28  + seatCount29  + seatCount30  + seatCount31  + seatCount32  +seatCount33  + seatCount34  + seatCount35  +
    				    		    	    	      seatCount36  + seatCount37  + seatCount38  + seatCount39  +
    				    		    	    	      seatCount40));
   
    					});
    						
    						

    				}	
    			}
    		  }
    		} 	
    	}
    	

    }

    @FXML
    void bta4(ActionEvent event) throws ClassNotFoundException, SQLException {
    	Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost/train_ticket?useTimezone=true&serverTimezone=UTC", "","");
		  
//
    	String st="A4";
    	String Coach=coach.getValue();
    	
    	if(Coach==null)
    	{
    		JOptionPane.showMessageDialog(null, "Please Select Coach!");
    	}
    	else
    	{
    		
    		pst=con.prepareStatement("SELECT Max(Id) FROM bookingticket");
    		resultSet=pst.executeQuery();

        	while(resultSet.next())
    		{
    			resultSet.getString("Max(Id)");

    			String nticket=resultSet.getString("Max(Id)");
    			
    			pst=con.prepareStatement("SELECT trainname FROM bookingticket WHERE Id='"+ nticket + "'");
    			ResultSet resultSet0=pst.executeQuery();
    			while(resultSet0.next())
    			{
    				ntrain.setText(resultSet0.getString("trainname"));
    			}
    			
    			pst=con.prepareStatement("SELECT date FROM bookingticket WHERE Id='"+ nticket +"'");
    			ResultSet resultSet1=pst.executeQuery();
    			while(resultSet1.next())
    			{
    				String dte=resultSet1.getString("date");
    				pst=con.prepareStatement("SELECT sit, coach FROM admin_booking WHERE date='"+ dte +"'");
    				ResultSet resultSet2=pst.executeQuery();
             		while(resultSet2.next())
    				{

             			String newsit=resultSet2.getString("sit");
    					String newcoach=resultSet2.getString("coach");

    					if(newsit.equals(st) && newcoach.equals(Coach))
    					{
    						A4.setStyle("-fx-background-color:red");
    						JOptionPane.showMessageDialog(null, "oops! The seat is booked already. Select another");
    						
    					}
    					else
    					{
    						
    						int p=Integer.parseInt(nticket);
    						int j=5+p;
    						String Id=Integer.toString(j);
    						
    						A4.setOnAction(e -> {
    							bta4 = true;
    				            A4.setStyle(yellow);
    				           
    				            
    				            PreparedStatement pst5;
    		    				try {
									pst5=con.prepareStatement("INSERT INTO admin_booking(Id, sit, coach, date) VALUES ('"+ Id +"','"+ st +"','"+ Coach +"','"+ dte +"')");
									pst5.execute();
        		             		
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
    				            
    				            
    				            seatCount4 = 1;
    				           //nsit.setText(newsit);
    				           nsit.setText(String.valueOf(seatCount1  + seatCount2  + seatCount3  + seatCount4  + seatCount5  + seatCount6  + seatCount7  +
    				     		      seatCount8  + seatCount9  +
    				    		      seatCount10  + seatCount11  + seatCount12  + seatCount13  + seatCount14  + seatCount15  + seatCount16  +seatCount17  + seatCount18  + seatCount19  +
    				    		      seatCount20  + seatCount21  + seatCount22  + seatCount23  +
    				    		    	      seatCount24  + seatCount25  +seatCount26  + seatCount27  + seatCount28  + seatCount29  + seatCount30  + seatCount31  + seatCount32  +seatCount33  + seatCount34  + seatCount35  +
    				    		    	    	      seatCount36  + seatCount37  + seatCount38  + seatCount39  +
    				    		    	    	      seatCount40));
    				        
    					});
    						
    						
    						

    				}	
    			}
    		  }
    		} 	
    	}
    	

    }

    @FXML
    void btb1(ActionEvent event) throws ClassNotFoundException, SQLException {
    	Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost/train_ticket?useTimezone=true&serverTimezone=UTC", "","");
		  
//
    	String st="B1";
    	String Coach=coach.getValue();
    	
    	if(Coach==null)
    	{
    		JOptionPane.showMessageDialog(null, "Please Select Coach!");
    	}
    	else
    	{
    		
    		pst=con.prepareStatement("SELECT Max(Id) FROM bookingticket");
    		resultSet=pst.executeQuery();

        	while(resultSet.next())
    		{
    			resultSet.getString("Max(Id)");

    			String nticket=resultSet.getString("Max(Id)");
    			
    			pst=con.prepareStatement("SELECT trainname FROM bookingticket WHERE Id='"+ nticket + "'");
    			ResultSet resultSet0=pst.executeQuery();
    			while(resultSet0.next())
    			{
    				ntrain.setText(resultSet0.getString("trainname"));
    			}
    			
    			pst=con.prepareStatement("SELECT date FROM bookingticket WHERE Id='"+ nticket +"'");
    			ResultSet resultSet1=pst.executeQuery();
    			while(resultSet1.next())
    			{
    				String dte=resultSet1.getString("date");
    				pst=con.prepareStatement("SELECT sit, coach FROM admin_booking WHERE date='"+ dte +"'");
    				ResultSet resultSet2=pst.executeQuery();
             		while(resultSet2.next())
    				{

             			String newsit=resultSet2.getString("sit");
    					String newcoach=resultSet2.getString("coach");

    					if(newsit.equals(st) && newcoach.equals(Coach))
    					{
    						B1.setStyle("-fx-background-color:red");
    						JOptionPane.showMessageDialog(null, "oops! The seat is booked already. Select another");
    						
    					}
    					else
    					{
    						
    						int p=Integer.parseInt(nticket);
    						int j=5+p;
    						String Id=Integer.toString(j);
    						
    						B1.setOnAction(e -> {
    							btb1 = true;
    							//
    				            B1.setStyle(yellow);
    				         //   
    				            
    				            PreparedStatement pst5;
    		    				try {
									pst5=con.prepareStatement("INSERT INTO admin_booking(Id, sit, coach, date) VALUES ('"+ Id +"','"+ st +"','"+ Coach +"','"+ dte +"')");
									pst5.execute();
        		             		
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
    				            
    				            
    				            seatCount5 = 1;
    				           //nsit.setText(newsit);
    				           nsit.setText(String.valueOf(seatCount1  + seatCount2  + seatCount3  + seatCount4  + seatCount5  + seatCount6  + seatCount7  +
    				     		      seatCount8  + seatCount9  +
    				    		      seatCount10  + seatCount11  + seatCount12  + seatCount13  + seatCount14  + seatCount15  + seatCount16  +seatCount17  + seatCount18  + seatCount19  +
    				    		      seatCount20  + seatCount21  + seatCount22  + seatCount23  +
    				    		    	      seatCount24  + seatCount25  +seatCount26  + seatCount27  + seatCount28  + seatCount29  + seatCount30  + seatCount31  + seatCount32  +seatCount33  + seatCount34  + seatCount35  +
    				    		    	    	      seatCount36  + seatCount37  + seatCount38  + seatCount39  +
    				    		    	    	      seatCount40));
    					});

    				}	
    			}
    		  }
    		} 	
    	}

    }

    @FXML
    void btb2(ActionEvent event) throws ClassNotFoundException, SQLException {
    	Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost/train_ticket?useTimezone=true&serverTimezone=UTC", "","");
		  
//
    	String st="B2";
    	String Coach=coach.getValue();
    	
    	if(Coach==null)
    	{
    		JOptionPane.showMessageDialog(null, "Please Select Coach!");
    	}
    	else
    	{
    		
    		pst=con.prepareStatement("SELECT Max(Id) FROM bookingticket");
    		resultSet=pst.executeQuery();

        	while(resultSet.next())
    		{
    			resultSet.getString("Max(Id)");

    			String nticket=resultSet.getString("Max(Id)");
    			
    			pst=con.prepareStatement("SELECT trainname FROM bookingticket WHERE Id='"+ nticket + "'");
    			ResultSet resultSet0=pst.executeQuery();
    			while(resultSet0.next())
    			{
    				ntrain.setText(resultSet0.getString("trainname"));
    			}
    			
    			pst=con.prepareStatement("SELECT date FROM bookingticket WHERE Id='"+ nticket +"'");
    			ResultSet resultSet1=pst.executeQuery();
    			while(resultSet1.next())
    			{
    				String dte=resultSet1.getString("date");
    				pst=con.prepareStatement("SELECT sit, coach FROM admin_booking WHERE date='"+ dte +"'");
    				ResultSet resultSet2=pst.executeQuery();
             		while(resultSet2.next())
    				{

             			String newsit=resultSet2.getString("sit");
    					String newcoach=resultSet2.getString("coach");

    					if(newsit.equals(st) && newcoach.equals(Coach))
    					{
    						B2.setStyle("-fx-background-color:red");
    						JOptionPane.showMessageDialog(null, "oops! The seat is booked already. Select another");
    						
    					}
    					else
    					{
    						int p=Integer.parseInt(nticket);
    						int j=5+p;
    						String Id=Integer.toString(j);
    						
    						
    						B2.setOnAction(e -> {
    							btb2 = true;
    							//
    				            B2.setStyle(yellow);
    				         //   
    				            
    				            PreparedStatement pst5;
    		    				try {
									pst5=con.prepareStatement("INSERT INTO admin_booking(Id, sit, coach, date) VALUES ('"+ Id +"','"+ st +"','"+ Coach +"','"+ dte +"')");
									pst5.execute();
        		             		
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
    				            
    				            
    				            seatCount6 = 1;
    				           //nsit.setText(newsit);
    				           nsit.setText(String.valueOf(seatCount1  + seatCount2  + seatCount3  + seatCount4  + seatCount5  + seatCount6  + seatCount7  +
    				     		      seatCount8  + seatCount9  +
    				    		      seatCount10  + seatCount11  + seatCount12  + seatCount13  + seatCount14  + seatCount15  + seatCount16  +seatCount17  + seatCount18  + seatCount19  +
    				    		      seatCount20  + seatCount21  + seatCount22  + seatCount23  +
    				    		    	      seatCount24  + seatCount25  +seatCount26  + seatCount27  + seatCount28  + seatCount29  + seatCount30  + seatCount31  + seatCount32  +seatCount33  + seatCount34  + seatCount35  +
    				    		    	    	      seatCount36  + seatCount37  + seatCount38  + seatCount39  +
    				    		    	    	      seatCount40));
    					});

    				}	
    			}
    		  }
    		} 	
    	}

    }

    @FXML
    void btb3(ActionEvent event) throws ClassNotFoundException, SQLException {
    	Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost/train_ticket?useTimezone=true&serverTimezone=UTC", "","");
		  
//
    	String st="B3";
    	String Coach=coach.getValue();
    	
    	if(Coach==null)
    	{
    		JOptionPane.showMessageDialog(null, "Please Select Coach!");
    	}
    	else
    	{
    		
    		pst=con.prepareStatement("SELECT Max(Id) FROM bookingticket");
    		resultSet=pst.executeQuery();

        	while(resultSet.next())
    		{
    			resultSet.getString("Max(Id)");

    			String nticket=resultSet.getString("Max(Id)");
    			
    			pst=con.prepareStatement("SELECT trainname FROM bookingticket WHERE Id='"+ nticket + "'");
    			ResultSet resultSet0=pst.executeQuery();
    			while(resultSet0.next())
    			{
    				ntrain.setText(resultSet0.getString("trainname"));
    			}
    			
    			pst=con.prepareStatement("SELECT date FROM bookingticket WHERE Id='"+ nticket +"'");
    			ResultSet resultSet1=pst.executeQuery();
    			while(resultSet1.next())
    			{
    				String dte=resultSet1.getString("date");
    				pst=con.prepareStatement("SELECT sit, coach FROM admin_booking WHERE date='"+ dte +"'");
    				ResultSet resultSet2=pst.executeQuery();
             		while(resultSet2.next())
    				{

             			String newsit=resultSet2.getString("sit");
    					String newcoach=resultSet2.getString("coach");

    					if(newsit.equals(st) && newcoach.equals(Coach))
    					{
    						B3.setStyle("-fx-background-color:red");
    						JOptionPane.showMessageDialog(null, "oops! The seat is booked already. Select another");
    						
    					}
    					else
    					{
    						
    						int p=Integer.parseInt(nticket);
    						int j=5+p;
    						String Id=Integer.toString(j);
    						
    						B3.setOnAction(e -> {
    							btb3 = true;
    							//
    				            B3.setStyle(yellow);
    				         //   
    				            
    				            PreparedStatement pst5;
    		    				try {
									pst5=con.prepareStatement("INSERT INTO admin_booking(Id, sit, coach, date) VALUES ('"+ Id +"','"+ st +"','"+ Coach +"','"+ dte +"')");
									pst5.execute();
        		             		
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
    				            
    				            
    				            seatCount7 = 1;
    				           //nsit.setText(newsit);
    				           nsit.setText(String.valueOf(seatCount1  + seatCount2  + seatCount3  + seatCount4  + seatCount5  + seatCount6  + seatCount7  +
    				     		      seatCount8  + seatCount9  +
    				    		      seatCount10  + seatCount11  + seatCount12  + seatCount13  + seatCount14  + seatCount15  + seatCount16  +seatCount17  + seatCount18  + seatCount19  +
    				    		      seatCount20  + seatCount21  + seatCount22  + seatCount23  +
    				    		    	      seatCount24  + seatCount25  +seatCount26  + seatCount27  + seatCount28  + seatCount29  + seatCount30  + seatCount31  + seatCount32  +seatCount33  + seatCount34  + seatCount35  +
    				    		    	    	      seatCount36  + seatCount37  + seatCount38  + seatCount39  +
    				    		    	    	      seatCount40));
    					});

    				}	
    			}
    		  }
    		} 	
    	}
    }

    @FXML
    void btb4(ActionEvent event) throws ClassNotFoundException, SQLException {
    	
        	Class.forName("com.mysql.cj.jdbc.Driver");
    		con=DriverManager.getConnection("jdbc:mysql://localhost/train_ticket?useTimezone=true&serverTimezone=UTC", "","");
    		  
    //
        	String st="B4";
        	String Coach=coach.getValue();
        	
        	if(Coach==null)
        	{
        		JOptionPane.showMessageDialog(null, "Please Select Coach!");
        	}
        	else
        	{
        		
        		pst=con.prepareStatement("SELECT Max(Id) FROM bookingticket");
        		resultSet=pst.executeQuery();

            	while(resultSet.next())
        		{
        			resultSet.getString("Max(Id)");

        			String nticket=resultSet.getString("Max(Id)");
        			
        			pst=con.prepareStatement("SELECT trainname FROM bookingticket WHERE Id='"+ nticket + "'");
        			ResultSet resultSet0=pst.executeQuery();
        			while(resultSet0.next())
        			{
        				ntrain.setText(resultSet0.getString("trainname"));
        			}
        			
        			pst=con.prepareStatement("SELECT date FROM bookingticket WHERE Id='"+ nticket +"'");
        			ResultSet resultSet1=pst.executeQuery();
        			while(resultSet1.next())
        			{
        				String dte=resultSet1.getString("date");
        				pst=con.prepareStatement("SELECT sit, coach FROM admin_booking WHERE date='"+ dte +"'");
        				ResultSet resultSet2=pst.executeQuery();
                 		while(resultSet2.next())
        				{

                 			String newsit=resultSet2.getString("sit");
        					String newcoach=resultSet2.getString("coach");

        					if(newsit.equals(st) && newcoach.equals(Coach))
        					{
        						B4.setStyle("-fx-background-color:red");
        						JOptionPane.showMessageDialog(null, "oops! The seat is booked already. Select another");
        						
        					}
        					else
        					{
        						int p=Integer.parseInt(nticket);
        						int j=5+p;
        						String Id=Integer.toString(j);
        						
        						
        						B4.setOnAction(e -> {
        							btb4 = true;
        							//
        				            B4.setStyle(yellow);
        				         //   
        				            
        				            PreparedStatement pst5;
        		    				try {
										pst5=con.prepareStatement("INSERT INTO admin_booking(Id, sit, coach, date) VALUES ('"+ Id +"','"+ st +"','"+ Coach +"','"+ dte +"')");
										pst5.execute();
	        		             		
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
        				            
        				            seatCount8 = 1;
        				           //nsit.setText(newsit);
        				           nsit.setText(String.valueOf(seatCount1  + seatCount2  + seatCount3  + seatCount4  + seatCount5  + seatCount6  + seatCount7  +
        				     		      seatCount8  + seatCount9  +
        				    		      seatCount10  + seatCount11  + seatCount12  + seatCount13  + seatCount14  + seatCount15  + seatCount16  +seatCount17  + seatCount18  + seatCount19  +
        				    		      seatCount20  + seatCount21  + seatCount22  + seatCount23  +
        				    		    	      seatCount24  + seatCount25  +seatCount26  + seatCount27  + seatCount28  + seatCount29  + seatCount30  + seatCount31  + seatCount32  +seatCount33  + seatCount34  + seatCount35  +
        				    		    	    	      seatCount36  + seatCount37  + seatCount38  + seatCount39  +
        				    		    	    	      seatCount40));
        					});

        				}	
        			}
        		  }
        		} 	
        	}

    }
    
    ///not insert yet
    
    

    @FXML
    void btc1(ActionEvent event) throws SQLException, ClassNotFoundException {
        	Class.forName("com.mysql.cj.jdbc.Driver");
    		con=DriverManager.getConnection("jdbc:mysql://localhost/train_ticket?useTimezone=true&serverTimezone=UTC", "","");
    		  
    //
        	String st="C1";
        	String Coach=coach.getValue();
        	
        	if(Coach==null)
        	{
        		JOptionPane.showMessageDialog(null, "Please Select Coach!");
        	}
        	else
        	{
        		
        		pst=con.prepareStatement("SELECT Max(Id) FROM bookingticket");
        		resultSet=pst.executeQuery();

            	while(resultSet.next())
        		{
        			resultSet.getString("Max(Id)");

        			String nticket=resultSet.getString("Max(Id)");
        			
        			pst=con.prepareStatement("SELECT trainname FROM bookingticket WHERE Id='"+ nticket + "'");
        			ResultSet resultSet0=pst.executeQuery();
        			while(resultSet0.next())
        			{
        				ntrain.setText(resultSet0.getString("trainname"));
        			}
        			
        			pst=con.prepareStatement("SELECT date FROM bookingticket WHERE Id='"+ nticket +"'");
        			ResultSet resultSet1=pst.executeQuery();
        			while(resultSet1.next())
        			{
        				String dte=resultSet1.getString("date");
        				pst=con.prepareStatement("SELECT sit, coach FROM admin_booking WHERE date='"+ dte +"'");
        				ResultSet resultSet2=pst.executeQuery();
                 		while(resultSet2.next())
        				{

                 			String newsit=resultSet2.getString("sit");
        					String newcoach=resultSet2.getString("coach");

        					if(newsit.equals(st) && newcoach.equals(Coach))
        					{
        						C1.setStyle("-fx-background-color:red");
        						JOptionPane.showMessageDialog(null, "oops! The seat is booked already. Select another");
        						
        					}
        					else
        					{
        						//
        						C1.setOnAction(e -> {
        							btc1 = true;
        							//
        				            C1.setStyle(yellow);
        				         //   
        				            
        				            PreparedStatement pst5;
        		    				try {
										pst5=con.prepareStatement("INSERT INTO admin_booking(Id, sit, coach, date) VALUES ('"+ nticket +"','"+ st +"','"+ Coach +"','"+ dte +"')");
										pst5.execute();
	        		             		
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
        				            
        				            seatCount9 = 1;
        				           //nsit.setText(newsit);
        				           nsit.setText(String.valueOf(seatCount1  + seatCount2  + seatCount3  + seatCount4  + seatCount5  + seatCount6  + seatCount7  +
        				     		      seatCount8  + seatCount9  +
        				    		      seatCount10  + seatCount11  + seatCount12  + seatCount13  + seatCount14  + seatCount15  + seatCount16  +seatCount17  + seatCount18  + seatCount19  +
        				    		      seatCount20  + seatCount21  + seatCount22  + seatCount23  +
        				    		    	      seatCount24  + seatCount25  +seatCount26  + seatCount27  + seatCount28  + seatCount29  + seatCount30  + seatCount31  + seatCount32  +seatCount33  + seatCount34  + seatCount35  +
        				    		    	    	      seatCount36  + seatCount37  + seatCount38  + seatCount39  +
        				    		    	    	      seatCount40));
        					});

        				}	
        			}
        		  }
        		} 	
        	}

    }

    @FXML
    void btc2(ActionEvent event)throws SQLException, ClassNotFoundException {
    	Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost/train_ticket?useTimezone=true&serverTimezone=UTC", "","");
		  
//
    	String st="C2";
    	String Coach=coach.getValue();
    	
    	if(Coach==null)
    	{
    		JOptionPane.showMessageDialog(null, "Please Select Coach!");
    	}
    	else
    	{
    		
    		pst=con.prepareStatement("SELECT Max(Id) FROM bookingticket");
    		resultSet=pst.executeQuery();

        	while(resultSet.next())
    		{
    			resultSet.getString("Max(Id)");

    			String nticket=resultSet.getString("Max(Id)");
    			
    			pst=con.prepareStatement("SELECT trainname FROM bookingticket WHERE Id='"+ nticket + "'");
    			ResultSet resultSet0=pst.executeQuery();
    			while(resultSet0.next())
    			{
    				ntrain.setText(resultSet0.getString("trainname"));
    			}
    			
    			pst=con.prepareStatement("SELECT date FROM bookingticket WHERE Id='"+ nticket +"'");
    			ResultSet resultSet1=pst.executeQuery();
    			while(resultSet1.next())
    			{
    				String dte=resultSet1.getString("date");
    				pst=con.prepareStatement("SELECT sit, coach FROM admin_booking WHERE date='"+ dte +"'");
    				ResultSet resultSet2=pst.executeQuery();
             		while(resultSet2.next())
    				{

             			String newsit=resultSet2.getString("sit");
    					String newcoach=resultSet2.getString("coach");

    					if(newsit.equals(st) && newcoach.equals(Coach))
    					{
    						C2.setStyle("-fx-background-color:red");
    						JOptionPane.showMessageDialog(null, "oops! The seat is booked already. Select another");
    						
    					}
    					else
    					{
    						//
    						C2.setOnAction(e -> {
    							btc2 = true;
    							//
    				            C2.setStyle(yellow);
    				         //   
    				            
    				            PreparedStatement pst5;
    		    				try {
									pst5=con.prepareStatement("INSERT INTO admin_booking(Id, sit, coach, date) VALUES ('"+ nticket +"','"+ st +"','"+ Coach +"','"+ dte +"')");
									pst5.execute();
        		             		
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
    				            
    				            seatCount10 = 1;
    				           //nsit.setText(newsit);
    				           nsit.setText(String.valueOf(seatCount1  + seatCount2  + seatCount3  + seatCount4  + seatCount5  + seatCount6  + seatCount7  +
    				     		      seatCount8  + seatCount9  +
    				    		      seatCount10  + seatCount11  + seatCount12  + seatCount13  + seatCount14  + seatCount15  + seatCount16  +seatCount17  + seatCount18  + seatCount19  +
    				    		      seatCount20  + seatCount21  + seatCount22  + seatCount23  +
    				    		    	      seatCount24  + seatCount25  +seatCount26  + seatCount27  + seatCount28  + seatCount29  + seatCount30  + seatCount31  + seatCount32  +seatCount33  + seatCount34  + seatCount35  +
    				    		    	    	      seatCount36  + seatCount37  + seatCount38  + seatCount39  +
    				    		    	    	      seatCount40));
    					});

    				}	
    			}
    		  }
    		} 	
    	}

    }

    @FXML
    void btc3(ActionEvent event) throws SQLException, ClassNotFoundException {
    	Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost/train_ticket?useTimezone=true&serverTimezone=UTC", "","");
		  
//
    	String st="C3";
    	String Coach=coach.getValue();
    	
    	if(Coach==null)
    	{
    		JOptionPane.showMessageDialog(null, "Please Select Coach!");
    	}
    	else
    	{
    		
    		pst=con.prepareStatement("SELECT Max(Id) FROM bookingticket");
    		resultSet=pst.executeQuery();

        	while(resultSet.next())
    		{
    			resultSet.getString("Max(Id)");

    			String nticket=resultSet.getString("Max(Id)");
    			
    			pst=con.prepareStatement("SELECT trainname FROM bookingticket WHERE Id='"+ nticket + "'");
    			ResultSet resultSet0=pst.executeQuery();
    			while(resultSet0.next())
    			{
    				ntrain.setText(resultSet0.getString("trainname"));
    			}
    			
    			pst=con.prepareStatement("SELECT date FROM bookingticket WHERE Id='"+ nticket +"'");
    			ResultSet resultSet1=pst.executeQuery();
    			while(resultSet1.next())
    			{
    				String dte=resultSet1.getString("date");
    				pst=con.prepareStatement("SELECT sit, coach FROM admin_booking WHERE date='"+ dte +"'");
    				ResultSet resultSet2=pst.executeQuery();
             		while(resultSet2.next())
    				{

             			String newsit=resultSet2.getString("sit");
    					String newcoach=resultSet2.getString("coach");

    					if(newsit.equals(st) && newcoach.equals(Coach))
    					{
    						C3.setStyle("-fx-background-color:red");
    						JOptionPane.showMessageDialog(null, "oops! The seat is booked already. Select another");
    						
    					}
    					else
    					{
    						//
    						C3.setOnAction(e -> {
    							btc3 = true;
    							//
    				            C3.setStyle(yellow);
    				         //   
    				            
    				            PreparedStatement pst5;
    		    				try {
									pst5=con.prepareStatement("INSERT INTO admin_booking(Id, sit, coach, date) VALUES ('"+ nticket +"','"+ st +"','"+ Coach +"','"+ dte +"')");
									pst5.execute();
        		             		
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
    				            
    				            seatCount11 = 1;
    				           //nsit.setText(newsit);
    				           nsit.setText(String.valueOf(seatCount1  + seatCount2  + seatCount3  + seatCount4  + seatCount5  + seatCount6  + seatCount7  +
    				     		      seatCount8  + seatCount9  +
    				    		      seatCount10  + seatCount11  + seatCount12  + seatCount13  + seatCount14  + seatCount15  + seatCount16  +seatCount17  + seatCount18  + seatCount19  +
    				    		      seatCount20  + seatCount21  + seatCount22  + seatCount23  +
    				    		    	      seatCount24  + seatCount25  +seatCount26  + seatCount27  + seatCount28  + seatCount29  + seatCount30  + seatCount31  + seatCount32  +seatCount33  + seatCount34  + seatCount35  +
    				    		    	    	      seatCount36  + seatCount37  + seatCount38  + seatCount39  +
    				    		    	    	      seatCount40));
    					});

    				}	
    			}
    		  }
    		} 	
    	}

    }

    @FXML
    void btc4(ActionEvent event) throws SQLException, ClassNotFoundException {
    	Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost/train_ticket?useTimezone=true&serverTimezone=UTC", "","");
		  
//
    	String st="C4";
    	String Coach=coach.getValue();
    	
    	if(Coach==null)
    	{
    		JOptionPane.showMessageDialog(null, "Please Select Coach!");
    	}
    	else
    	{
    		
    		pst=con.prepareStatement("SELECT Max(Id) FROM bookingticket");
    		resultSet=pst.executeQuery();

        	while(resultSet.next())
    		{
    			resultSet.getString("Max(Id)");

    			String nticket=resultSet.getString("Max(Id)");
    			
    			pst=con.prepareStatement("SELECT trainname FROM bookingticket WHERE Id='"+ nticket + "'");
    			ResultSet resultSet0=pst.executeQuery();
    			while(resultSet0.next())
    			{
    				ntrain.setText(resultSet0.getString("trainname"));
    			}
    			
    			pst=con.prepareStatement("SELECT date FROM bookingticket WHERE Id='"+ nticket +"'");
    			ResultSet resultSet1=pst.executeQuery();
    			while(resultSet1.next())
    			{
    				String dte=resultSet1.getString("date");
    				pst=con.prepareStatement("SELECT sit, coach FROM admin_booking WHERE date='"+ dte +"'");
    				ResultSet resultSet2=pst.executeQuery();
             		while(resultSet2.next())
    				{

             			String newsit=resultSet2.getString("sit");
    					String newcoach=resultSet2.getString("coach");

    					if(newsit.equals(st) && newcoach.equals(Coach))
    					{
    						
    						C4.setStyle("-fx-background-color:red");
    						JOptionPane.showMessageDialog(null, "oops! The seat is booked already. Select another");
    						
    					}
    					else
    					{
    						//
    						C4.setOnAction(e -> {
    							btc4 = true;
    							//
    				            C4.setStyle(yellow);
    				         //   
    				            PreparedStatement pst5;
    		    				try {
									pst5=con.prepareStatement("INSERT INTO admin_booking(Id, sit, coach, date) VALUES ('"+ nticket +"','"+ st +"','"+ Coach +"','"+ dte +"')");
									pst5.execute();
        		             		
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
    				            
    				            seatCount12 = 1;
    				           //nsit.setText(newsit);
    				           nsit.setText(String.valueOf(seatCount1  + seatCount2  + seatCount3  + seatCount4  + seatCount5  + seatCount6  + seatCount7  +
    				     		      seatCount8  + seatCount9  +
    				    		      seatCount10  + seatCount11  + seatCount12  + seatCount13  + seatCount14  + seatCount15  + seatCount16  +seatCount17  + seatCount18  + seatCount19  +
    				    		      seatCount20  + seatCount21  + seatCount22  + seatCount23  +
    				    		    	      seatCount24  + seatCount25  +seatCount26  + seatCount27  + seatCount28  + seatCount29  + seatCount30  + seatCount31  + seatCount32  +seatCount33  + seatCount34  + seatCount35  +
    				    		    	    	      seatCount36  + seatCount37  + seatCount38  + seatCount39  +
    				    		    	    	      seatCount40));
    					});

    				}	
    			}
    		  }
    		} 	
    	}

    }

    @FXML
    void btd1(ActionEvent event) throws SQLException, ClassNotFoundException {
    	Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost/train_ticket?useTimezone=true&serverTimezone=UTC", "","");
		  
//
    	String st="D1";
    	String Coach=coach.getValue();
    	
    	if(Coach==null)
    	{
    		JOptionPane.showMessageDialog(null, "Please Select Coach!");
    	}
    	else
    	{
    		
    		pst=con.prepareStatement("SELECT Max(Id) FROM bookingticket");
    		resultSet=pst.executeQuery();

        	while(resultSet.next())
    		{
    			resultSet.getString("Max(Id)");

    			String nticket=resultSet.getString("Max(Id)");
    			
    			pst=con.prepareStatement("SELECT trainname FROM bookingticket WHERE Id='"+ nticket + "'");
    			ResultSet resultSet0=pst.executeQuery();
    			while(resultSet0.next())
    			{
    				ntrain.setText(resultSet0.getString("trainname"));
    			}
    			
    			pst=con.prepareStatement("SELECT date FROM bookingticket WHERE Id='"+ nticket +"'");
    			ResultSet resultSet1=pst.executeQuery();
    			while(resultSet1.next())
    			{
    				String dte=resultSet1.getString("date");
    				pst=con.prepareStatement("SELECT sit, coach FROM admin_booking WHERE date='"+ dte +"'");
    				ResultSet resultSet2=pst.executeQuery();
             		while(resultSet2.next())
    				{

             			String newsit=resultSet2.getString("sit");
    					String newcoach=resultSet2.getString("coach");

    					if(newsit.equals(st) && newcoach.equals(Coach))
    					{
    						D1.setStyle("-fx-background-color:red");
    						JOptionPane.showMessageDialog(null, "oops! The seat is booked already. Select another");
    						
    					}
    					else
    					{
    						//
    						D1.setOnAction(e -> {
    							btd1 = true;
    							//
    				            D1.setStyle(yellow);
    				         //   
    				            seatCount13 = 1;
    				           //nsit.setText(newsit);
    				           nsit.setText(String.valueOf(seatCount1  + seatCount2  + seatCount3  + seatCount4  + seatCount5  + seatCount6  + seatCount7  +
    				     		      seatCount8  + seatCount9  +
    				    		      seatCount10  + seatCount11  + seatCount12  + seatCount13  + seatCount14  + seatCount15  + seatCount16  +seatCount17  + seatCount18  + seatCount19  +
    				    		      seatCount20  + seatCount21  + seatCount22  + seatCount23  +
    				    		    	      seatCount24  + seatCount25  +seatCount26  + seatCount27  + seatCount28  + seatCount29  + seatCount30  + seatCount31  + seatCount32  +seatCount33  + seatCount34  + seatCount35  +
    				    		    	    	      seatCount36  + seatCount37  + seatCount38  + seatCount39  +
    				    		    	    	      seatCount40));
    					});

    				}	
    			}
    		  }
    		} 	
    	}

    }

    @FXML
    void btd2(ActionEvent event) throws SQLException, ClassNotFoundException {
    	Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost/train_ticket?useTimezone=true&serverTimezone=UTC", "","");
		  
//
    	String st="D2";
    	String Coach=coach.getValue();
    	
    	if(Coach==null)
    	{
    		JOptionPane.showMessageDialog(null, "Please Select Coach!");
    	}
    	else
    	{
    		
    		pst=con.prepareStatement("SELECT Max(Id) FROM bookingticket");
    		resultSet=pst.executeQuery();

        	while(resultSet.next())
    		{
    			resultSet.getString("Max(Id)");

    			String nticket=resultSet.getString("Max(Id)");
    			
    			pst=con.prepareStatement("SELECT trainname FROM bookingticket WHERE Id='"+ nticket + "'");
    			ResultSet resultSet0=pst.executeQuery();
    			while(resultSet0.next())
    			{
    				ntrain.setText(resultSet0.getString("trainname"));
    			}
    			
    			pst=con.prepareStatement("SELECT date FROM bookingticket WHERE Id='"+ nticket +"'");
    			ResultSet resultSet1=pst.executeQuery();
    			while(resultSet1.next())
    			{
    				String dte=resultSet1.getString("date");
    				pst=con.prepareStatement("SELECT sit, coach FROM admin_booking WHERE date='"+ dte +"'");
    				ResultSet resultSet2=pst.executeQuery();
             		while(resultSet2.next())
    				{

             			String newsit=resultSet2.getString("sit");
    					String newcoach=resultSet2.getString("coach");

    					if(newsit.equals(st) && newcoach.equals(Coach))
    					{
    						
    						D2.setStyle("-fx-background-color:red");
    						
    						JOptionPane.showMessageDialog(null, "oops! The seat is booked already. Select another");
    						
    					}
    					else
    					{
    						//
    						D2.setOnAction(e -> {
    							btd2 = true;
    							//
    				            D2.setStyle(yellow);
    				         //   
    				            seatCount14 = 1;
    				           //nsit.setText(newsit);
    				           nsit.setText(String.valueOf(seatCount1  + seatCount2  + seatCount3  + seatCount4  + seatCount5  + seatCount6  + seatCount7  +
    				     		      seatCount8  + seatCount9  +
    				    		      seatCount10  + seatCount11  + seatCount12  + seatCount13  + seatCount14  + seatCount15  + seatCount16  +seatCount17  + seatCount18  + seatCount19  +
    				    		      seatCount20  + seatCount21  + seatCount22  + seatCount23  +
    				    		    	      seatCount24  + seatCount25  +seatCount26  + seatCount27  + seatCount28  + seatCount29  + seatCount30  + seatCount31  + seatCount32  +seatCount33  + seatCount34  + seatCount35  +
    				    		    	    	      seatCount36  + seatCount37  + seatCount38  + seatCount39  +
    				    		    	    	      seatCount40));
    					});

    				}	
    			}
    		  }
    		} 	
    	}


    }

    @FXML
    void btd3(ActionEvent event) throws SQLException, ClassNotFoundException {
    	Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost/train_ticket?useTimezone=true&serverTimezone=UTC", "","");
		  
//
    	String st="D3";
    	String Coach=coach.getValue();
    	
    	if(Coach==null)
    	{
    		JOptionPane.showMessageDialog(null, "Please Select Coach!");
    	}
    	else
    	{
    		
    		pst=con.prepareStatement("SELECT Max(Id) FROM bookingticket");
    		resultSet=pst.executeQuery();

        	while(resultSet.next())
    		{
    			resultSet.getString("Max(Id)");

    			String nticket=resultSet.getString("Max(Id)");
    			
    			pst=con.prepareStatement("SELECT trainname FROM bookingticket WHERE Id='"+ nticket + "'");
    			ResultSet resultSet0=pst.executeQuery();
    			while(resultSet0.next())
    			{
    				ntrain.setText(resultSet0.getString("trainname"));
    			}
    			
    			pst=con.prepareStatement("SELECT date FROM bookingticket WHERE Id='"+ nticket +"'");
    			ResultSet resultSet1=pst.executeQuery();
    			while(resultSet1.next())
    			{
    				String dte=resultSet1.getString("date");
    				pst=con.prepareStatement("SELECT sit, coach FROM admin_booking WHERE date='"+ dte +"'");
    				ResultSet resultSet2=pst.executeQuery();
             		while(resultSet2.next())
    				{

             			String newsit=resultSet2.getString("sit");
    					String newcoach=resultSet2.getString("coach");

    					if(newsit.equals(st) && newcoach.equals(Coach))
    					{
    						D2.setStyle("-fx-background-color:red");
    						JOptionPane.showMessageDialog(null, "oops! The seat is booked already. Select another");
    						
    					}
    					else
    					{
    						//
    						D3.setOnAction(e -> {
    							btd3 = true;
    							//
    				            D3.setStyle(yellow);
    				         //   
    				            seatCount15 = 1;
    				           //nsit.setText(newsit);
    				           nsit.setText(String.valueOf(seatCount1  + seatCount2  + seatCount3  + seatCount4  + seatCount5  + seatCount6  + seatCount7  +
    				     		      seatCount8  + seatCount9  +
    				    		      seatCount10  + seatCount11  + seatCount12  + seatCount13  + seatCount14  + seatCount15  + seatCount16  +seatCount17  + seatCount18  + seatCount19  +
    				    		      seatCount20  + seatCount21  + seatCount22  + seatCount23  +
    				    		    	      seatCount24  + seatCount25  +seatCount26  + seatCount27  + seatCount28  + seatCount29  + seatCount30  + seatCount31  + seatCount32  +seatCount33  + seatCount34  + seatCount35  +
    				    		    	    	      seatCount36  + seatCount37  + seatCount38  + seatCount39  +
    				    		    	    	      seatCount40));
    					});

    				}	
    			}
    		  }
    		} 	
    	}


    }

    @FXML
    void btd4(ActionEvent event) throws SQLException, ClassNotFoundException {
    	Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost/train_ticket?useTimezone=true&serverTimezone=UTC", "","");
		  
//
    	String st="D4";
    	String Coach=coach.getValue();
    	
    	if(Coach==null)
    	{
    		JOptionPane.showMessageDialog(null, "Please Select Coach!");
    	}
    	else
    	{
    		
    		pst=con.prepareStatement("SELECT Max(Id) FROM bookingticket");
    		resultSet=pst.executeQuery();

        	while(resultSet.next())
    		{
    			resultSet.getString("Max(Id)");

    			String nticket=resultSet.getString("Max(Id)");
    			
    			pst=con.prepareStatement("SELECT trainname FROM bookingticket WHERE Id='"+ nticket + "'");
    			ResultSet resultSet0=pst.executeQuery();
    			while(resultSet0.next())
    			{
    				ntrain.setText(resultSet0.getString("trainname"));
    			}
    			
    			pst=con.prepareStatement("SELECT date FROM bookingticket WHERE Id='"+ nticket +"'");
    			ResultSet resultSet1=pst.executeQuery();
    			while(resultSet1.next())
    			{
    				String dte=resultSet1.getString("date");
    				pst=con.prepareStatement("SELECT sit, coach FROM admin_booking WHERE date='"+ dte +"'");
    				ResultSet resultSet2=pst.executeQuery();
             		while(resultSet2.next())
    				{

             			String newsit=resultSet2.getString("sit");
    					String newcoach=resultSet2.getString("coach");

    					if(newsit.equals(st) && newcoach.equals(Coach))
    					{
    						D2.setStyle("-fx-background-color:red");
    						JOptionPane.showMessageDialog(null, "oops! The seat is booked already. Select another");
    						
    					}
    					else
    					{
    						//
    						D4.setOnAction(e -> {
    							btd4 = true;
    							//
    				            D4.setStyle(yellow);
    				         //   
    				            seatCount16 = 1;
    				           //nsit.setText(newsit);
    				           nsit.setText(String.valueOf(seatCount1  + seatCount2  + seatCount3  + seatCount4  + seatCount5  + seatCount6  + seatCount7  +
    				     		      seatCount8  + seatCount9  +
    				    		      seatCount10  + seatCount11  + seatCount12  + seatCount13  + seatCount14  + seatCount15  + seatCount16  +seatCount17  + seatCount18  + seatCount19  +
    				    		      seatCount20  + seatCount21  + seatCount22  + seatCount23  +
    				    		    	      seatCount24  + seatCount25  +seatCount26  + seatCount27  + seatCount28  + seatCount29  + seatCount30  + seatCount31  + seatCount32  +seatCount33  + seatCount34  + seatCount35  +
    				    		    	    	      seatCount36  + seatCount37  + seatCount38  + seatCount39  +
    				    		    	    	      seatCount40));
    					});

    				}	
    			}
    		  }
    		} 	
    	}


    }

    @FXML
    void bte1(ActionEvent event) {


    }

    @FXML
    void bte2(ActionEvent event) {


    }

    @FXML
    void bte3(ActionEvent event) {


    }

    @FXML
    void bte4(ActionEvent event) {


    }

    @FXML
    void btf1(ActionEvent event) {


    }

    @FXML
    void btf2(ActionEvent event) {


    }

    @FXML
    void btf3(ActionEvent event) {
  

    }

    @FXML
    void btf4(ActionEvent event) {


    }

    @FXML
    void btg1(ActionEvent event) {
  

    }

    @FXML
    void btg2(ActionEvent event) {
  

    }

    @FXML
    void btg3(ActionEvent event) {


    }

    @FXML
    void btg4(ActionEvent event) {
   

    }

    @FXML
    void bth1(ActionEvent event) {
    

    }

    @FXML
    void bth2(ActionEvent event) {
   

    }

    @FXML
    void bth3(ActionEvent event) {
    

    }

    @FXML
    void bth4(ActionEvent event) {
   

    }

    @FXML
    void bti1(ActionEvent event) {
 

    }

    @FXML
    void bti2(ActionEvent event) {
   

    }

    @FXML
    void bti3(ActionEvent event) {
    

    }

    @FXML
    void bti4(ActionEvent event) {
 

    }

    @FXML
    void btj1(ActionEvent event) {
  

    }

    @FXML
    void btj2(ActionEvent event) {
    

    }

    @FXML
    void btj3(ActionEvent event) {
   

    }

    @FXML
    void btj4(ActionEvent event) {
    

    }
    
    @FXML
    void back(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {
    	
    	
    	
    	Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost/train_ticket?useTimezone=true&serverTimezone=UTC", "","");
		  
		PreparedStatement pst10;
		
		pst10=con.prepareStatement("SELECT Max(Id) FROM bookingticket");
		resultSet=pst10.executeQuery();

    	while(resultSet.next())
		{
			String ID=resultSet.getString("Max(Id)");


			PreparedStatement pst1;
			pst1=con.prepareStatement(" DELETE FROM bookingticket WHERE Id='"+ ID +"' ");
			pst1.execute();
			
			Parent parent = FXMLLoader.load(getClass().getResource("/ticketcounter/Place.fxml"));
	        Scene scene = new Scene(parent);
	        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        window.setScene(scene);
	        window.show();
			
			
		}

    }

    @FXML
    void tktsubmit(ActionEvent event) throws ClassNotFoundException, SQLException, IOException
    {

    	Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost/train_ticket?useTimezone=true&serverTimezone=UTC", "","");
		  
    	
		String sttrain=ntrain.getText();
    	String stprice=nprice.getText();
    	
    	
    	pst=con.prepareStatement("SELECT Max(Id) FROM bookingticket");
		resultSet=pst.executeQuery();

    	while(resultSet.next())
		{
			resultSet.getString("Max(Id)");

			String nticket=resultSet.getString("Max(Id)");
            int p=Integer.parseInt(nticket);
    		int j=5+p;
    		String Id=Integer.toString(j);
    		
    		pst=con.prepareStatement("SELECT sit,coach FROM admin_booking WHERE id='"+ Id +"'");
    		ResultSet resultSet1=pst.executeQuery();
			while(resultSet1.next())
			{
				String newsit=resultSet1.getString("sit");
				String newcoach=resultSet1.getString("coach");
				PreparedStatement pst1;
				pst1=con.prepareStatement("UPDATE bookingticket SET trainname='"+ sttrain +"',cabin='"+ newcoach +"',sit='"+ newsit +"',price='"+ stprice +"' WHERE Id='"+ nticket +"'");
				pst1.execute();

	    			Parent parent = FXMLLoader.load(getClass().getResource("/payment/Payment.fxml"));
	    	        Scene scene = new Scene(parent);
	    	        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
	    	        window.setScene(scene);
	    	        window.show();

				
			}
			
		}
    	
    	
    }

}