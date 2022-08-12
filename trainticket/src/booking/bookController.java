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
import java.util.Optional;
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
    private Button check;
    

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
		
		pst10=con.prepareStatement("SELECT Id  FROM bookingticket ORDER BY Id * 1 desc limit 1;");
		resultSet=pst10.executeQuery();

    	while(resultSet.next())
		{
			//resultSet.getString("Max(Id)");
    		

			String ID=resultSet.getString("Id");
			
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
		
		
		pst=con.prepareStatement("SELECT Id  FROM bookingticket ORDER BY Id * 1 desc limit 1;");
		resultSet=pst.executeQuery();

    	while(resultSet.next())
		{
			//resultSet.getString("Max(Id)");
    		

			String nticket=resultSet.getString("Id");
			
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
    public void bta1(ActionEvent event)throws IOException, SQLException, ClassNotFoundException
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
    		pst=con.prepareStatement("SELECT Id  FROM bookingticket ORDER BY Id * 1 desc limit 1");
    		resultSet=pst.executeQuery();

        	while(resultSet.next())
    		{
    			resultSet.getString("Id");

    			String nticket=resultSet.getString("Id");

    			pst=con.prepareStatement("SELECT trainname,date FROM bookingticket WHERE Id='"+ nticket + "'");
    			ResultSet resultSet0=pst.executeQuery();
    			while(resultSet0.next())
    			{
    				ntrain.setText(resultSet0.getString("trainname"));
    				String ntrain=resultSet0.getString("trainname");
    				String ndate=resultSet0.getString("date");
    				
    				pst=con.prepareStatement("SELECT * FROM bookingticket WHERE sit=? && cabin=? && date='"+ ndate +"' && trainname='"+ ntrain +"'");
        			
    				pst.setString(1, st);
    				pst.setString(2, Coach);
    				
    				ResultSet resultSet1=pst.executeQuery();
        			if(resultSet1.next())
        			{
        				
    						JOptionPane.showMessageDialog(null, "oops! The seat is booked already. Select another");
        			}
    				else
    				{
    					pst=con.prepareStatement("SELECT Id  FROM admin_booking ORDER BY Id * 1 desc limit 1");
    		    		resultSet=pst.executeQuery();
    		    		while(resultSet.next())
    		    		{
    		    			String ID=resultSet.getString("Id");
    		    			int p=Integer.parseInt(ID);
    			    		int j=1+p;
    			    		String id=Integer.toString(j);
    			    		
    			    		A1.setOnAction(e -> {
    							bta1 = true;
    				            A1.setStyle(yellow); 
    				            
    				            PreparedStatement pst5;
    		    				try {
									pst5=con.prepareStatement("INSERT INTO admin_booking(Id,sit, coach, date) VALUES ('"+ id +"','"+ st +"','"+ Coach +"','"+ ndate +"')");
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
    public void bta2(ActionEvent event) throws ClassNotFoundException, SQLException {
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
    		pst=con.prepareStatement("SELECT Id  FROM bookingticket ORDER BY Id * 1 desc limit 1");
    		resultSet=pst.executeQuery();

        	while(resultSet.next())
    		{
    			resultSet.getString("Id");

    			String nticket=resultSet.getString("Id");

    			pst=con.prepareStatement("SELECT trainname,date FROM bookingticket WHERE Id='"+ nticket + "'");
    			ResultSet resultSet0=pst.executeQuery();
    			while(resultSet0.next())
    			{
    				ntrain.setText(resultSet0.getString("trainname"));
    				String ntrain=resultSet0.getString("trainname");
    				String ndate=resultSet0.getString("date");
    				
    				pst=con.prepareStatement("SELECT * FROM bookingticket WHERE sit=? && cabin=? && date='"+ ndate +"' && trainname='"+ ntrain +"'");
        			
    				pst.setString(1, st);
    				pst.setString(2, Coach);
    				
    				ResultSet resultSet1=pst.executeQuery();
        			if(resultSet1.next())
        			{
        				
    						JOptionPane.showMessageDialog(null, "oops! The seat is booked already. Select another");
        			}
    				else
    				{
    					pst=con.prepareStatement("SELECT Id  FROM admin_booking ORDER BY Id * 1 desc limit 1");
    		    		resultSet=pst.executeQuery();
    		    		while(resultSet.next())
    		    		{
    		    			String ID=resultSet.getString("Id");
    		    			int p=Integer.parseInt(ID);
    			    		int j=1+p;
    			    		String id=Integer.toString(j);
    			    		
    			    		A2.setOnAction(e -> {
    							bta2 = true;
    				            A2.setStyle(yellow); 
    				            
    				            PreparedStatement pst5;
    		    				try {
									pst5=con.prepareStatement("INSERT INTO admin_booking(Id,sit, coach, date) VALUES ('"+ id +"','"+ st +"','"+ Coach +"','"+ ndate +"')");
									pst5.execute();
        		             		
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}

    				            seatCount2 = 1;
    				           
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
    public void bta3(ActionEvent event) throws ClassNotFoundException, SQLException {
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
    		pst=con.prepareStatement("SELECT Id  FROM bookingticket ORDER BY Id * 1 desc limit 1");
    		resultSet=pst.executeQuery();

        	while(resultSet.next())
    		{
    			resultSet.getString("Id");

    			String nticket=resultSet.getString("Id");

    			pst=con.prepareStatement("SELECT trainname,date FROM bookingticket WHERE Id='"+ nticket + "'");
    			ResultSet resultSet0=pst.executeQuery();
    			while(resultSet0.next())
    			{
    				ntrain.setText(resultSet0.getString("trainname"));
    				String ntrain=resultSet0.getString("trainname");
    				String ndate=resultSet0.getString("date");
    				
    				pst=con.prepareStatement("SELECT * FROM bookingticket WHERE sit=? && cabin=? && date='"+ ndate +"' && trainname='"+ ntrain +"'");
        			
    				pst.setString(1, st);
    				pst.setString(2, Coach);
    				
    				ResultSet resultSet1=pst.executeQuery();
        			if(resultSet1.next())
        			{
        				
    						JOptionPane.showMessageDialog(null, "oops! The seat is booked already. Select another");
        			}
    				else
    				{
    					pst=con.prepareStatement("SELECT Id  FROM admin_booking ORDER BY Id * 1 desc limit 1");
    		    		resultSet=pst.executeQuery();
    		    		while(resultSet.next())
    		    		{
    		    			String ID=resultSet.getString("Id");
    		    			int p=Integer.parseInt(ID);
    			    		int j=1+p;
    			    		String id=Integer.toString(j);
    			    		
    			    		A3.setOnAction(e -> {
    							bta3 = true;
    				            A3.setStyle(yellow); 
    				            
    				            PreparedStatement pst5;
    		    				try {
									pst5=con.prepareStatement("INSERT INTO admin_booking(Id,sit, coach, date) VALUES ('"+ id +"','"+ st +"','"+ Coach +"','"+ ndate +"')");
									pst5.execute();
        		             		
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}

    				            seatCount3 = 1;
    				           
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
    public void bta4(ActionEvent event) throws ClassNotFoundException, SQLException {
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
    		pst=con.prepareStatement("SELECT Id  FROM bookingticket ORDER BY Id * 1 desc limit 1");
    		resultSet=pst.executeQuery();

        	while(resultSet.next())
    		{
    			resultSet.getString("Id");

    			String nticket=resultSet.getString("Id");

    			pst=con.prepareStatement("SELECT trainname,date FROM bookingticket WHERE Id='"+ nticket + "'");
    			ResultSet resultSet0=pst.executeQuery();
    			while(resultSet0.next())
    			{
    				ntrain.setText(resultSet0.getString("trainname"));
    				String ntrain=resultSet0.getString("trainname");
    				String ndate=resultSet0.getString("date");
    				
    				pst=con.prepareStatement("SELECT * FROM bookingticket WHERE sit=? && cabin=? && date='"+ ndate +"' && trainname='"+ ntrain +"'");
        			
    				pst.setString(1, st);
    				pst.setString(2, Coach);
    				
    				ResultSet resultSet1=pst.executeQuery();
        			if(resultSet1.next())
        			{
        				
    						JOptionPane.showMessageDialog(null, "oops! The seat is booked already. Select another");
        			}
    				else
    				{
    					pst=con.prepareStatement("SELECT Id  FROM admin_booking ORDER BY Id * 1 desc limit 1");
    		    		resultSet=pst.executeQuery();
    		    		while(resultSet.next())
    		    		{
    		    			String ID=resultSet.getString("Id");
    		    			int p=Integer.parseInt(ID);
    			    		int j=1+p;
    			    		String id=Integer.toString(j);
    			    		
    			    		A4.setOnAction(e -> {
    							bta4 = true;
    				            A4.setStyle(yellow); 
    				            
    				            PreparedStatement pst5;
    		    				try {
									pst5=con.prepareStatement("INSERT INTO admin_booking(Id,sit, coach, date) VALUES ('"+ id +"','"+ st +"','"+ Coach +"','"+ ndate +"')");
									pst5.execute();
        		             		
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}

    				            seatCount4 = 1;
    				           
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
    public void btb1(ActionEvent event) throws ClassNotFoundException, SQLException {
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
    		pst=con.prepareStatement("SELECT Id  FROM bookingticket ORDER BY Id * 1 desc limit 1");
    		resultSet=pst.executeQuery();

        	while(resultSet.next())
    		{
    			resultSet.getString("Id");

    			String nticket=resultSet.getString("Id");

    			pst=con.prepareStatement("SELECT trainname,date FROM bookingticket WHERE Id='"+ nticket + "'");
    			ResultSet resultSet0=pst.executeQuery();
    			while(resultSet0.next())
    			{
    				ntrain.setText(resultSet0.getString("trainname"));
    				String ntrain=resultSet0.getString("trainname");
    				String ndate=resultSet0.getString("date");
    				
    				pst=con.prepareStatement("SELECT * FROM bookingticket WHERE sit=? && cabin=? && date='"+ ndate +"' && trainname='"+ ntrain +"'");
        			
    				pst.setString(1, st);
    				pst.setString(2, Coach);
    				
    				ResultSet resultSet1=pst.executeQuery();
        			if(resultSet1.next())
        			{
        				
    						JOptionPane.showMessageDialog(null, "oops! The seat is booked already. Select another");
        			}
    				else
    				{
    					pst=con.prepareStatement("SELECT Id  FROM admin_booking ORDER BY Id * 1 desc limit 1");
    		    		resultSet=pst.executeQuery();
    		    		while(resultSet.next())
    		    		{
    		    			String ID=resultSet.getString("Id");
    		    			int p=Integer.parseInt(ID);
    			    		int j=1+p;
    			    		String id=Integer.toString(j);
    			    		
    			    		B1.setOnAction(e -> {
    							btb1 = true;
    				            B1.setStyle(yellow); 
    				            
    				            PreparedStatement pst5;
    		    				try {
									pst5=con.prepareStatement("INSERT INTO admin_booking(Id,sit, coach, date) VALUES ('"+ id +"','"+ st +"','"+ Coach +"','"+ ndate +"')");
									pst5.execute();
        		             		
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}

    				            seatCount5 = 1;
    				           
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
    public void btb2(ActionEvent event) throws ClassNotFoundException, SQLException {
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
    		pst=con.prepareStatement("SELECT Id  FROM bookingticket ORDER BY Id * 1 desc limit 1");
    		resultSet=pst.executeQuery();

        	while(resultSet.next())
    		{
    			resultSet.getString("Id");

    			String nticket=resultSet.getString("Id");

    			pst=con.prepareStatement("SELECT trainname,date FROM bookingticket WHERE Id='"+ nticket + "'");
    			ResultSet resultSet0=pst.executeQuery();
    			while(resultSet0.next())
    			{
    				ntrain.setText(resultSet0.getString("trainname"));
    				String ntrain=resultSet0.getString("trainname");
    				String ndate=resultSet0.getString("date");
    				
    				pst=con.prepareStatement("SELECT * FROM bookingticket WHERE sit=? && cabin=? && date='"+ ndate +"' && trainname='"+ ntrain +"'");
        			
    				pst.setString(1, st);
    				pst.setString(2, Coach);
    				
    				ResultSet resultSet1=pst.executeQuery();
        			if(resultSet1.next())
        			{
        				
    						JOptionPane.showMessageDialog(null, "oops! The seat is booked already. Select another");
        			}
    				else
    				{
    					pst=con.prepareStatement("SELECT Id  FROM admin_booking ORDER BY Id * 1 desc limit 1");
    		    		resultSet=pst.executeQuery();
    		    		while(resultSet.next())
    		    		{
    		    			String ID=resultSet.getString("Id");
    		    			int p=Integer.parseInt(ID);
    			    		int j=1+p;
    			    		String id=Integer.toString(j);
    			    		
    			    		B2.setOnAction(e -> {
    							btb2 = true;
    				            B2.setStyle(yellow); 
    				            
    				            PreparedStatement pst5;
    		    				try {
									pst5=con.prepareStatement("INSERT INTO admin_booking(Id,sit, coach, date) VALUES ('"+ id +"','"+ st +"','"+ Coach +"','"+ ndate +"')");
									pst5.execute();
        		             		
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}

    				            seatCount6 = 1;
    				           
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
    public void btb3(ActionEvent event) throws ClassNotFoundException, SQLException {
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
    		pst=con.prepareStatement("SELECT Id  FROM bookingticket ORDER BY Id * 1 desc limit 1");
    		resultSet=pst.executeQuery();

        	while(resultSet.next())
    		{
    			resultSet.getString("Id");

    			String nticket=resultSet.getString("Id");

    			pst=con.prepareStatement("SELECT trainname,date FROM bookingticket WHERE Id='"+ nticket + "'");
    			ResultSet resultSet0=pst.executeQuery();
    			while(resultSet0.next())
    			{
    				ntrain.setText(resultSet0.getString("trainname"));
    				String ntrain=resultSet0.getString("trainname");
    				String ndate=resultSet0.getString("date");
    				
    				pst=con.prepareStatement("SELECT * FROM bookingticket WHERE sit=? && cabin=? && date='"+ ndate +"' && trainname='"+ ntrain +"'");
        			
    				pst.setString(1, st);
    				pst.setString(2, Coach);
    				
    				ResultSet resultSet1=pst.executeQuery();
        			if(resultSet1.next())
        			{
        				
    						JOptionPane.showMessageDialog(null, "oops! The seat is booked already. Select another");
        			}
    				else
    				{
    					pst=con.prepareStatement("SELECT Id  FROM admin_booking ORDER BY Id * 1 desc limit 1");
    		    		resultSet=pst.executeQuery();
    		    		while(resultSet.next())
    		    		{
    		    			String ID=resultSet.getString("Id");
    		    			int p=Integer.parseInt(ID);
    			    		int j=1+p;
    			    		String id=Integer.toString(j);
    			    		
    			    		B3.setOnAction(e -> {
    							btb3 = true;
    				            B3.setStyle(yellow); 
    				            
    				            PreparedStatement pst5;
    		    				try {
									pst5=con.prepareStatement("INSERT INTO admin_booking(Id,sit, coach, date) VALUES ('"+ id +"','"+ st +"','"+ Coach +"','"+ ndate +"')");
									pst5.execute();
        		             		
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}

    				            seatCount7 = 1;
    				           
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
    public void btb4(ActionEvent event) throws ClassNotFoundException, SQLException {
    	
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
        		pst=con.prepareStatement("SELECT Id  FROM bookingticket ORDER BY Id * 1 desc limit 1");
        		resultSet=pst.executeQuery();

            	while(resultSet.next())
        		{
        			resultSet.getString("Id");

        			String nticket=resultSet.getString("Id");

        			pst=con.prepareStatement("SELECT trainname,date FROM bookingticket WHERE Id='"+ nticket + "'");
        			ResultSet resultSet0=pst.executeQuery();
        			while(resultSet0.next())
        			{
        				ntrain.setText(resultSet0.getString("trainname"));
        				String ntrain=resultSet0.getString("trainname");
        				String ndate=resultSet0.getString("date");
        				
        				pst=con.prepareStatement("SELECT * FROM bookingticket WHERE sit=? && cabin=? && date='"+ ndate +"' && trainname='"+ ntrain +"'");
            			
        				pst.setString(1, st);
        				pst.setString(2, Coach);
        				
        				ResultSet resultSet1=pst.executeQuery();
            			if(resultSet1.next())
            			{
            				
        						JOptionPane.showMessageDialog(null, "oops! The seat is booked already. Select another");
            			}
        				else
        				{
        					pst=con.prepareStatement("SELECT Id  FROM admin_booking ORDER BY Id * 1 desc limit 1");
        		    		resultSet=pst.executeQuery();
        		    		while(resultSet.next())
        		    		{
        		    			String ID=resultSet.getString("Id");
        		    			int p=Integer.parseInt(ID);
        			    		int j=1+p;
        			    		String id=Integer.toString(j);
        			    		
        			    		B4.setOnAction(e -> {
        							btb4 = true;
        				            B4.setStyle(yellow); 
        				            
        				            PreparedStatement pst5;
        		    				try {
    									pst5=con.prepareStatement("INSERT INTO admin_booking(Id,sit, coach, date) VALUES ('"+ id +"','"+ st +"','"+ Coach +"','"+ ndate +"')");
    									pst5.execute();
            		             		
    								} catch (SQLException e1) {
    									// TODO Auto-generated catch block
    									e1.printStackTrace();
    								}

        				            seatCount8 = 1;
        				           
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
    
    ///not insert yet
    
    

    @FXML
    public void btc1(ActionEvent event) throws SQLException, ClassNotFoundException {
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
        		pst=con.prepareStatement("SELECT Id  FROM bookingticket ORDER BY Id * 1 desc limit 1");
        		resultSet=pst.executeQuery();

            	while(resultSet.next())
        		{
        			resultSet.getString("Id");

        			String nticket=resultSet.getString("Id");

        			pst=con.prepareStatement("SELECT trainname,date FROM bookingticket WHERE Id='"+ nticket + "'");
        			ResultSet resultSet0=pst.executeQuery();
        			while(resultSet0.next())
        			{
        				ntrain.setText(resultSet0.getString("trainname"));
        				String ntrain=resultSet0.getString("trainname");
        				String ndate=resultSet0.getString("date");
        				
        				pst=con.prepareStatement("SELECT * FROM bookingticket WHERE sit=? && cabin=? && date='"+ ndate +"' && trainname='"+ ntrain +"'");
            			
        				pst.setString(1, st);
        				pst.setString(2, Coach);
        				
        				ResultSet resultSet1=pst.executeQuery();
            			if(resultSet1.next())
            			{
            				
        						JOptionPane.showMessageDialog(null, "oops! The seat is booked already. Select another");
            			}
        				else
        				{
        					pst=con.prepareStatement("SELECT Id  FROM admin_booking ORDER BY Id * 1 desc limit 1");
        		    		resultSet=pst.executeQuery();
        		    		while(resultSet.next())
        		    		{
        		    			String ID=resultSet.getString("Id");
        		    			int p=Integer.parseInt(ID);
        			    		int j=1+p;
        			    		String id=Integer.toString(j);
        			    		
        			    		C1.setOnAction(e -> {
        							btc1 = true;
        				            C1.setStyle(yellow); 
        				            
        				            PreparedStatement pst5;
        		    				try {
    									pst5=con.prepareStatement("INSERT INTO admin_booking(Id,sit, coach, date) VALUES ('"+ id +"','"+ st +"','"+ Coach +"','"+ ndate +"')");
    									pst5.execute();
            		             		
    								} catch (SQLException e1) {
    									// TODO Auto-generated catch block
    									e1.printStackTrace();
    								}

        				            seatCount9 = 1;
        				           
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
    		pst=con.prepareStatement("SELECT Id  FROM bookingticket ORDER BY Id * 1 desc limit 1");
    		resultSet=pst.executeQuery();

        	while(resultSet.next())
    		{
    			resultSet.getString("Id");

    			String nticket=resultSet.getString("Id");

    			pst=con.prepareStatement("SELECT trainname,date FROM bookingticket WHERE Id='"+ nticket + "'");
    			ResultSet resultSet0=pst.executeQuery();
    			while(resultSet0.next())
    			{
    				ntrain.setText(resultSet0.getString("trainname"));
    				String ntrain=resultSet0.getString("trainname");
    				String ndate=resultSet0.getString("date");
    				
    				pst=con.prepareStatement("SELECT * FROM bookingticket WHERE sit=? && cabin=? && date='"+ ndate +"' && trainname='"+ ntrain +"'");
        			
    				pst.setString(1, st);
    				pst.setString(2, Coach);
    				
    				ResultSet resultSet1=pst.executeQuery();
        			if(resultSet1.next())
        			{
        				
    						JOptionPane.showMessageDialog(null, "oops! The seat is booked already. Select another");
        			}
    				else
    				{
    					pst=con.prepareStatement("SELECT Id  FROM admin_booking ORDER BY Id * 1 desc limit 1");
    		    		resultSet=pst.executeQuery();
    		    		while(resultSet.next())
    		    		{
    		    			String ID=resultSet.getString("Id");
    		    			int p=Integer.parseInt(ID);
    			    		int j=1+p;
    			    		String id=Integer.toString(j);
    			    		
    			    		C2.setOnAction(e -> {
    							btc2 = true;
    				            C2.setStyle(yellow); 
    				            
    				            PreparedStatement pst5;
    		    				try {
									pst5=con.prepareStatement("INSERT INTO admin_booking(Id,sit, coach, date) VALUES ('"+ id +"','"+ st +"','"+ Coach +"','"+ ndate +"')");
									pst5.execute();
        		             		
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}

    				            seatCount10 = 1;
    				           
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
    public void btc3(ActionEvent event) throws SQLException, ClassNotFoundException {
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
    		pst=con.prepareStatement("SELECT Id  FROM bookingticket ORDER BY Id * 1 desc limit 1");
    		resultSet=pst.executeQuery();

        	while(resultSet.next())
    		{
    			resultSet.getString("Id");

    			String nticket=resultSet.getString("Id");

    			pst=con.prepareStatement("SELECT trainname,date FROM bookingticket WHERE Id='"+ nticket + "'");
    			ResultSet resultSet0=pst.executeQuery();
    			while(resultSet0.next())
    			{
    				ntrain.setText(resultSet0.getString("trainname"));
    				String ntrain=resultSet0.getString("trainname");
    				String ndate=resultSet0.getString("date");
    				
    				pst=con.prepareStatement("SELECT * FROM bookingticket WHERE sit=? && cabin=? && date='"+ ndate +"' && trainname='"+ ntrain +"'");
        			
    				pst.setString(1, st);
    				pst.setString(2, Coach);
    				
    				ResultSet resultSet1=pst.executeQuery();
        			if(resultSet1.next())
        			{
        				
    						JOptionPane.showMessageDialog(null, "oops! The seat is booked already. Select another");
        			}
    				else
    				{
    					pst=con.prepareStatement("SELECT Id  FROM admin_booking ORDER BY Id * 1 desc limit 1");
    		    		resultSet=pst.executeQuery();
    		    		while(resultSet.next())
    		    		{
    		    			String ID=resultSet.getString("Id");
    		    			int p=Integer.parseInt(ID);
    			    		int j=1+p;
    			    		String id=Integer.toString(j);
    			    		
    			    		C3.setOnAction(e -> {
    							btc3 = true;
    				            C3.setStyle(yellow); 
    				            
    				            PreparedStatement pst5;
    		    				try {
									pst5=con.prepareStatement("INSERT INTO admin_booking(Id,sit, coach, date) VALUES ('"+ id +"','"+ st +"','"+ Coach +"','"+ ndate +"')");
									pst5.execute();
        		             		
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}

    				            seatCount11 = 1;
    				           
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
    public void btc4(ActionEvent event) throws SQLException, ClassNotFoundException {
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
    		pst=con.prepareStatement("SELECT Id  FROM bookingticket ORDER BY Id * 1 desc limit 1");
    		resultSet=pst.executeQuery();

        	while(resultSet.next())
    		{
    			resultSet.getString("Id");

    			String nticket=resultSet.getString("Id");

    			pst=con.prepareStatement("SELECT trainname,date FROM bookingticket WHERE Id='"+ nticket + "'");
    			ResultSet resultSet0=pst.executeQuery();
    			while(resultSet0.next())
    			{
    				ntrain.setText(resultSet0.getString("trainname"));
    				String ntrain=resultSet0.getString("trainname");
    				String ndate=resultSet0.getString("date");
    				
    				pst=con.prepareStatement("SELECT * FROM bookingticket WHERE sit=? && cabin=? && date='"+ ndate +"' && trainname='"+ ntrain +"'");
        			
    				pst.setString(1, st);
    				pst.setString(2, Coach);
    				
    				ResultSet resultSet1=pst.executeQuery();
        			if(resultSet1.next())
        			{
        				
    						JOptionPane.showMessageDialog(null, "oops! The seat is booked already. Select another");
        			}
    				else
    				{
    					pst=con.prepareStatement("SELECT Id  FROM admin_booking ORDER BY Id * 1 desc limit 1");
    		    		resultSet=pst.executeQuery();
    		    		while(resultSet.next())
    		    		{
    		    			String ID=resultSet.getString("Id");
    		    			int p=Integer.parseInt(ID);
    			    		int j=1+p;
    			    		String id=Integer.toString(j);
    			    		
    			    		C4.setOnAction(e -> {
    							btc4 = true;
    				            C4.setStyle(yellow); 
    				            
    				            PreparedStatement pst5;
    		    				try {
									pst5=con.prepareStatement("INSERT INTO admin_booking(Id,sit, coach, date) VALUES ('"+ id +"','"+ st +"','"+ Coach +"','"+ ndate +"')");
									pst5.execute();
        		             		
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}

    				            seatCount12 = 1;
    				           
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
    public void btd1(ActionEvent event) throws SQLException, ClassNotFoundException {
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
    		pst=con.prepareStatement("SELECT Id  FROM bookingticket ORDER BY Id * 1 desc limit 1");
    		resultSet=pst.executeQuery();

        	while(resultSet.next())
    		{
    			resultSet.getString("Id");

    			String nticket=resultSet.getString("Id");

    			pst=con.prepareStatement("SELECT trainname,date FROM bookingticket WHERE Id='"+ nticket + "'");
    			ResultSet resultSet0=pst.executeQuery();
    			while(resultSet0.next())
    			{
    				ntrain.setText(resultSet0.getString("trainname"));
    				String ntrain=resultSet0.getString("trainname");
    				String ndate=resultSet0.getString("date");
    				
    				pst=con.prepareStatement("SELECT * FROM bookingticket WHERE sit=? && cabin=? && date='"+ ndate +"' && trainname='"+ ntrain +"'");
        			
    				pst.setString(1, st);
    				pst.setString(2, Coach);
    				
    				ResultSet resultSet1=pst.executeQuery();
        			if(resultSet1.next())
        			{
        				
    						JOptionPane.showMessageDialog(null, "oops! The seat is booked already. Select another");
        			}
    				else
    				{
    					pst=con.prepareStatement("SELECT Id  FROM admin_booking ORDER BY Id * 1 desc limit 1");
    		    		resultSet=pst.executeQuery();
    		    		while(resultSet.next())
    		    		{
    		    			String ID=resultSet.getString("Id");
    		    			int p=Integer.parseInt(ID);
    			    		int j=1+p;
    			    		String id=Integer.toString(j);
    			    		
    			    		D1.setOnAction(e -> {
    							btd1 = true;
    				            D1.setStyle(yellow); 
    				            
    				            PreparedStatement pst5;
    		    				try {
									pst5=con.prepareStatement("INSERT INTO admin_booking(Id,sit, coach, date) VALUES ('"+ id +"','"+ st +"','"+ Coach +"','"+ ndate +"')");
									pst5.execute();
        		             		
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}

    				            seatCount13 = 1;
    				           
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
    public void btd2(ActionEvent event) throws SQLException, ClassNotFoundException {
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
    		pst=con.prepareStatement("SELECT Id  FROM bookingticket ORDER BY Id * 1 desc limit 1");
    		resultSet=pst.executeQuery();

        	while(resultSet.next())
    		{
    			resultSet.getString("Id");

    			String nticket=resultSet.getString("Id");

    			pst=con.prepareStatement("SELECT trainname,date FROM bookingticket WHERE Id='"+ nticket + "'");
    			ResultSet resultSet0=pst.executeQuery();
    			while(resultSet0.next())
    			{
    				ntrain.setText(resultSet0.getString("trainname"));
    				String ntrain=resultSet0.getString("trainname");
    				String ndate=resultSet0.getString("date");
    				
    				pst=con.prepareStatement("SELECT * FROM bookingticket WHERE sit=? && cabin=? && date='"+ ndate +"' && trainname='"+ ntrain +"'");
        			
    				pst.setString(1, st);
    				pst.setString(2, Coach);
    				
    				ResultSet resultSet1=pst.executeQuery();
        			if(resultSet1.next())
        			{
        				
    						JOptionPane.showMessageDialog(null, "oops! The seat is booked already. Select another");
        			}
    				else
    				{
    					pst=con.prepareStatement("SELECT Id  FROM admin_booking ORDER BY Id * 1 desc limit 1");
    		    		resultSet=pst.executeQuery();
    		    		while(resultSet.next())
    		    		{
    		    			String ID=resultSet.getString("Id");
    		    			int p=Integer.parseInt(ID);
    			    		int j=1+p;
    			    		String id=Integer.toString(j);
    			    		
    			    		D2.setOnAction(e -> {
    							btd2 = true;
    				            D2.setStyle(yellow); 
    				            
    				            PreparedStatement pst5;
    		    				try {
									pst5=con.prepareStatement("INSERT INTO admin_booking(Id,sit, coach, date) VALUES ('"+ id +"','"+ st +"','"+ Coach +"','"+ ndate +"')");
									pst5.execute();
        		             		
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}

    				            seatCount14 = 1;
    				           
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
    public void btd3(ActionEvent event) throws SQLException, ClassNotFoundException {
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
    		pst=con.prepareStatement("SELECT Id  FROM bookingticket ORDER BY Id * 1 desc limit 1");
    		resultSet=pst.executeQuery();

        	while(resultSet.next())
    		{
    			resultSet.getString("Id");

    			String nticket=resultSet.getString("Id");

    			pst=con.prepareStatement("SELECT trainname,date FROM bookingticket WHERE Id='"+ nticket + "'");
    			ResultSet resultSet0=pst.executeQuery();
    			while(resultSet0.next())
    			{
    				ntrain.setText(resultSet0.getString("trainname"));
    				String ntrain=resultSet0.getString("trainname");
    				String ndate=resultSet0.getString("date");
    				
    				pst=con.prepareStatement("SELECT * FROM bookingticket WHERE sit=? && cabin=? && date='"+ ndate +"' && trainname='"+ ntrain +"'");
        			
    				pst.setString(1, st);
    				pst.setString(2, Coach);
    				
    				ResultSet resultSet1=pst.executeQuery();
        			if(resultSet1.next())
        			{
        				
    						JOptionPane.showMessageDialog(null, "oops! The seat is booked already. Select another");
        			}
    				else
    				{
    					pst=con.prepareStatement("SELECT Id  FROM admin_booking ORDER BY Id * 1 desc limit 1");
    		    		resultSet=pst.executeQuery();
    		    		while(resultSet.next())
    		    		{
    		    			String ID=resultSet.getString("Id");
    		    			int p=Integer.parseInt(ID);
    			    		int j=1+p;
    			    		String id=Integer.toString(j);
    			    		
    			    		D3.setOnAction(e -> {
    							btd3 = true;
    				            D3.setStyle(yellow); 
    				            
    				            PreparedStatement pst5;
    		    				try {
									pst5=con.prepareStatement("INSERT INTO admin_booking(Id,sit, coach, date) VALUES ('"+ id +"','"+ st +"','"+ Coach +"','"+ ndate +"')");
									pst5.execute();
        		             		
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}

    				            seatCount15 = 1;
    				           
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
    public void btd4(ActionEvent event) throws SQLException, ClassNotFoundException {
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
    		pst=con.prepareStatement("SELECT Id  FROM bookingticket ORDER BY Id * 1 desc limit 1");
    		resultSet=pst.executeQuery();

        	while(resultSet.next())
    		{
    			resultSet.getString("Id");

    			String nticket=resultSet.getString("Id");

    			pst=con.prepareStatement("SELECT trainname,date FROM bookingticket WHERE Id='"+ nticket + "'");
    			ResultSet resultSet0=pst.executeQuery();
    			while(resultSet0.next())
    			{
    				ntrain.setText(resultSet0.getString("trainname"));
    				String ntrain=resultSet0.getString("trainname");
    				String ndate=resultSet0.getString("date");
    				
    				pst=con.prepareStatement("SELECT * FROM bookingticket WHERE sit=? && cabin=? && date='"+ ndate +"' && trainname='"+ ntrain +"'");
        			
    				pst.setString(1, st);
    				pst.setString(2, Coach);
    				
    				ResultSet resultSet1=pst.executeQuery();
        			if(resultSet1.next())
        			{
        				
    						JOptionPane.showMessageDialog(null, "oops! The seat is booked already. Select another");
        			}
    				else
    				{
    					pst=con.prepareStatement("SELECT Id  FROM admin_booking ORDER BY Id * 1 desc limit 1");
    		    		resultSet=pst.executeQuery();
    		    		while(resultSet.next())
    		    		{
    		    			String ID=resultSet.getString("Id");
    		    			int p=Integer.parseInt(ID);
    			    		int j=1+p;
    			    		String id=Integer.toString(j);
    			    		
    			    		D4.setOnAction(e -> {
    							btd4 = true;
    				            D4.setStyle(yellow); 
    				            
    				            PreparedStatement pst5;
    		    				try {
									pst5=con.prepareStatement("INSERT INTO admin_booking(Id,sit, coach, date) VALUES ('"+ id +"','"+ st +"','"+ Coach +"','"+ ndate +"')");
									pst5.execute();
        		             		
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}

    				            seatCount16 = 1;
    				           
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
		
		pst10=con.prepareStatement("SELECT Id  FROM bookingticket ORDER BY Id * 1 desc limit 1");
		resultSet=pst10.executeQuery();

    	while(resultSet.next())
		{
			String ID=resultSet.getString("Id");
			PreparedStatement pst1;
			pst1=con.prepareStatement(" DELETE FROM bookingticket WHERE Id='"+ ID +"' ");
			pst1.execute();
			
			
			PreparedStatement pst11;
			pst11=con.prepareStatement("SELECT Id  FROM admin_booking ORDER BY Id * 1 desc limit 1");
			ResultSet resultSet2;
			resultSet2=pst11.executeQuery();
			while(resultSet2.next())
			{
				String adminbookid=resultSet2.getString("Id");
				PreparedStatement pst12;
				pst12=con.prepareStatement(" DELETE FROM admin_booking WHERE Id='"+ adminbookid +"' ");
				pst12.execute();
			}
			
			Parent parent = FXMLLoader.load(getClass().getResource("/ticketcounter/Place.fxml"));
	        Scene scene = new Scene(parent);
	        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        window.setScene(scene);
	        window.show();
			
			
		}

    }

    @FXML
    void Tktsubmit(ActionEvent event) throws ClassNotFoundException, SQLException, IOException
    {

    	Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost/train_ticket?useTimezone=true&serverTimezone=UTC", "","");
		  
    	
		String sttrain=ntrain.getText();
    	String stprice=nprice.getText();
    	
    	
    	pst=con.prepareStatement("SELECT Id  FROM admin_booking ORDER BY Id * 1 desc limit 1");
		resultSet=pst.executeQuery();

    	while(resultSet.next())
		{
			//resultSet.getString("Id");

			String nticket=resultSet.getString("Id");
    		PreparedStatement pst1;
    		pst1=con.prepareStatement("SELECT sit,coach FROM admin_booking WHERE id='"+ nticket +"'");
    		ResultSet resultSet1;
    		resultSet1=pst1.executeQuery();
    		while(resultSet1.next())
			{
				String newsit=resultSet1.getString("sit");
				String newcoach=resultSet1.getString("coach");
				PreparedStatement pst9;
				pst9=con.prepareStatement("SELECT Id  FROM bookingticket ORDER BY Id * 1 desc limit 1");
				ResultSet resultSet9;
				resultSet9=pst9.executeQuery();
				while(resultSet9.next())
				{
					String nid=resultSet9.getString("Id");
					
					PreparedStatement pst5;
					pst5=con.prepareStatement("UPDATE bookingticket SET trainname='"+ sttrain +"',cabin='"+ newcoach +"',sit='"+ newsit +"',price='"+ stprice +"' WHERE Id='"+ nid +"'");
					pst5.executeUpdate();

						Parent parent = FXMLLoader.load(getClass().getResource("/payment/Payment.fxml"));
		    	        Scene scene = new Scene(parent);
		    	        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		    	        window.setScene(scene);
		    	        window.show();
						
				}
			}
		}
    	
    }
    
    @FXML
    void Check(ActionEvent event) throws SQLException, ClassNotFoundException {
    	
    	Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost/train_ticket?useTimezone=true&serverTimezone=UTC", "","");
		 
		
    	
    	String COACH=coach.getValue();
    	
    	PreparedStatement pst2;
    	ResultSet resultSet1;
    	pst2=con.prepareStatement("SELECT Id  FROM bookingticket ORDER BY Id * 1 desc limit 1");
		resultSet1=pst2.executeQuery();
		
		while(resultSet1.next())
		{

			String iid=resultSet1.getString("Id");
			
			PreparedStatement pst3;
        	ResultSet resultSet3;
        	pst3=con.prepareStatement("SELECT trainname,cabin,sit,date,from_d,to_a FROM bookingticket WHERE Id='"+iid+"'");
    		resultSet3=pst3.executeQuery();
    		while(resultSet3.next())
    		{
    			String usertrain=resultSet3.getString("trainname");
        		String userdate=resultSet3.getString("date");
        		String userfrm=resultSet3.getString("from_d");
        		String userto=resultSet3.getString("to_a");
        		
        		PreparedStatement pst4;
            	ResultSet resultSet4;
            	pst4=con.prepareStatement("SELECT * FROM bookingticket WHERE cabin=? and sit=? and date=? and trainname=?");
            	
            	
            	
            	pst4.setString(1, COACH);
            	pst4.setString(3, userdate);
            	pst4.setString(4, usertrain);
            	
            	String button1="A1";
            	pst4.setString(2, button1);
            	
            	resultSet4=pst4.executeQuery();
            	if(resultSet4.next())
    			{
    			    A1.setStyle("-fx-background-color:red");
    		    }
    			else
    			{
    				A1.setStyle("-fx-background-color:green");
    			}
            	String button2="A2";
            	pst4.setString(2, button2);
            	resultSet4=pst4.executeQuery();
            	if(resultSet4.next())
				{
					A2.setStyle("-fx-background-color:red");
				}
				else
				{
					A2.setStyle("-fx-background-color:green");
				}
            	String button3="A3";
            	pst4.setString(2, button3);
            	resultSet4=pst4.executeQuery();
            	if(resultSet4.next())
				{
					A3.setStyle("-fx-background-color:red");
				}
				else
				{
					A3.setStyle("-fx-background-color:green");
				}
            	String button4="A4";
            	pst4.setString(2, button4);
            	resultSet4=pst4.executeQuery();
            	if(resultSet4.next())
				{
					A4.setStyle("-fx-background-color:red");
				}
				else
				{
					A4.setStyle("-fx-background-color:green");
				}
            	String button5="B1";
            	pst4.setString(2, button5);
            	resultSet4=pst4.executeQuery();
            	if(resultSet4.next())
				{
					B1.setStyle("-fx-background-color:red");
				}
				else
				{
					B1.setStyle("-fx-background-color:green");
				}
            	String button6="B2";
            	pst4.setString(2, button6);
            	resultSet4=pst4.executeQuery();
            	if(resultSet4.next())
				{
					B2.setStyle("-fx-background-color:red");
				}
				else
				{
					B2.setStyle("-fx-background-color:green");
				}
            	String button7="B3";
            	pst4.setString(2, button7);
            	resultSet4=pst4.executeQuery();
            	if(resultSet4.next())
				{
					B3.setStyle("-fx-background-color:red");
				}
				else
				{
					B3.setStyle("-fx-background-color:green");
				}
            	String button8="B4";
            	pst4.setString(2, button8);
            	resultSet4=pst4.executeQuery();
            	if(resultSet4.next())
				{
					B4.setStyle("-fx-background-color:red");
				}
				else
				{
					B4.setStyle("-fx-background-color:green");
				}
            	String button9="C1";
            	pst4.setString(2, button9);
            	resultSet4=pst4.executeQuery();
            	if(resultSet4.next())
				{
					C1.setStyle("-fx-background-color:red");
				}
				else
				{
					C1.setStyle("-fx-background-color:green");
				}
            	String button10="C2";
            	pst4.setString(2, button10);
            	resultSet4=pst4.executeQuery();
            	if(resultSet4.next())
				{
					C2.setStyle("-fx-background-color:red");
				}
				else
				{
					C2.setStyle("-fx-background-color:green");
				}
            	String button11="C3";
            	pst4.setString(2, button11);
            	resultSet4=pst4.executeQuery();
            	if(resultSet4.next())
				{
					C3.setStyle("-fx-background-color:red");
				}
				else
				{
					C3.setStyle("-fx-background-color:green");
				}
            	String button12="C4";
            	pst4.setString(2, button12);
            	resultSet4=pst4.executeQuery();
            	if(resultSet4.next())
				{
					C4.setStyle("-fx-background-color:red");
				}
				else
				{
					C4.setStyle("-fx-background-color:green");
				}
            	String button13="D1";
            	pst4.setString(2, button13);
            	resultSet4=pst4.executeQuery();
            	if(resultSet4.next())
				{
					D1.setStyle("-fx-background-color:red");
				}
				else
				{
					D1.setStyle("-fx-background-color:green");
				}
            	String button14="D2";
            	pst4.setString(2, button14);
            	resultSet4=pst4.executeQuery();
            	if(resultSet4.next())
				{
					D2.setStyle("-fx-background-color:red");
				}
				else
				{
					D2.setStyle("-fx-background-color:green");
				}
            	String button15="D3";
            	pst4.setString(2, button15);
            	resultSet4=pst4.executeQuery();
            	if(resultSet4.next())
				{
					D3.setStyle("-fx-background-color:red");
				}
				else
				{
					D3.setStyle("-fx-background-color:green");
				}
            	String button16="D4";
            	pst4.setString(2, button16);
            	resultSet4=pst4.executeQuery();
            	if(resultSet4.next())
				{
					D4.setStyle("-fx-background-color:red");
				}
				else
				{
					D4.setStyle("-fx-background-color:green");
				}
            	
 
    		}

		}

    }

}