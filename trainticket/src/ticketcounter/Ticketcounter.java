package ticketcounter;

import javafx.collections.FXCollections;




import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;


public class Ticketcounter extends Thread implements Initializable{
 
  
	@FXML
	private TableColumn<Service, String> arrived;
	
	@FXML
	private TableColumn<Service, String> price;

	@FXML
	private TableColumn<Service, String> derived;
	
	@FXML
    private TableColumn<Service, String> trainname;
	
	@FXML
	public DatePicker date;
	
	@FXML
    private TableView<Service> tableview;
	
	@FXML
    private Button search;


    @FXML
    public ComboBox from;

    @FXML
    private Button placesubmit;

    @FXML
    public ComboBox to;

    @FXML
    public TextField ticket;
    
    @FXML
    public Label iid;

	Connection con;
	PreparedStatement pst;
	ResultSet resultSet;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    connect();
    setcellvalue();
    trainname.setCellValueFactory(new PropertyValueFactory<>("trainname"));
	arrived.setCellValueFactory(new PropertyValueFactory<>("to_time")); 
	derived.setCellValueFactory(new PropertyValueFactory<>("from_time"));   
	price.setCellValueFactory(new PropertyValueFactory<>("price"));
	

  }

  public void connect() {

  
    //ObservableList<Object> data = FXCollections.observableArrayList();
    try {
    	Class.forName("com.mysql.cj.jdbc.Driver");
 		con=DriverManager.getConnection("jdbc:mysql://localhost/train_ticket?useTimezone=true&serverTimezone=UTC", "","");


          pst = con.prepareStatement("select * from place ");
          resultSet = pst.executeQuery();
          while (resultSet.next()) {
    	  from.getItems().addAll(resultSet.getString("Destination"));
	      to.getItems().addAll(resultSet.getString("Destination"));

      }

    } catch (SQLException | ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  public void check(ActionEvent actionEvent) throws ClassNotFoundException, SQLException {
    loaddata();
  }

  public void loaddata() throws ClassNotFoundException, SQLException {

    ObservableList<Service> data = FXCollections.observableArrayList();
    
	
    String derived = from.getSelectionModel().getSelectedItem().toString();
    String arrived = to.getSelectionModel().getSelectedItem().toString();
    String Dte=date.getEditor().getText();
    if(Dte=="")
    {
    	JOptionPane.showMessageDialog(null, "Please Select Date!");
    }
    else
    {
    	PreparedStatement pst3;
    	String Date=date.getEditor().getText();
    	
    	pst3=con.prepareStatement("select * from admin_booking where date=?");
		  ResultSet rs3;
		  pst3.setString(1, Date);
		  rs3=pst3.executeQuery();
		  if(rs3.next())
		  {
				PreparedStatement pst;
			    pst = con.prepareStatement("SELECT * FROM train WHERE derived='"+ derived +"' AND arrived='"+ arrived +"' ");
			    ResultSet rs = pst.executeQuery();
			              while (rs.next()) {
			                data.add(new Service(
			                    		rs.getString(1),
			                    		rs.getString(2),
			                    		rs.getString(3),
			                            rs.getString(4),
			                            rs.getString(5),
			                            rs.getString(6)));

			                tableview.setItems(data);
			              }

		  }
		  else
		  {
			  
			JOptionPane.showMessageDialog(null, "Train is off!!");
		 }
    }
    
  }
  public void setcellvalue() {
	  
    tableview.setOnMouseClicked(e -> {
      Service Service = tableview.getItems().get(tableview.getSelectionModel().getSelectedIndex());
        ticket.setText(Service.getTrainname());
      }
    );
  }
  
  @FXML
  void placesubmit(ActionEvent event) throws IOException, ClassNotFoundException, SQLException
  {
	  
	  loaddata();
	  connect();
	  setcellvalue();
	
	  
	  try {
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  con=DriverManager.getConnection("jdbc:mysql://localhost/train_ticket?useTimezone=true&serverTimezone=UTC", "","");
		  
		  pst=con.prepareStatement("SELECT IFNULL((SELECT Id  FROM bookingticket ORDER BY Id * 1 desc limit 1), 0) as id");
		  resultSet=pst.executeQuery();

		  while (resultSet.next()) 
		  {
		        
			  String iiid4=resultSet.getString("id");
			  
			  Class.forName("com.mysql.cj.jdbc.Driver");
			  con=DriverManager.getConnection("jdbc:mysql://localhost/train_ticket?useTimezone=true&serverTimezone=UTC", "","");
			  PreparedStatement pst4;
			  ResultSet resultSet6;
			  
			  pst4=con.prepareStatement("SELECT IFNULL((SELECT Id  FROM bookingticket ORDER BY Id * 1 asc limit 1), 0) as id");
			  resultSet6=pst4.executeQuery();
			  while(resultSet6.next())
			  {
				  
				  String iiid=resultSet6.getString("id");

		          if(iiid==iiid4)
				  {
		        	  
		        	  if(iiid=="0")
		        	  {
		        		  iid.setText("1");
		        	  }
		        	  else
		        	  {
		        		  iid.setText("2");
		        	  }

				  }
		          
		          else
				  {
					  int j=Integer.parseInt(resultSet.getString("Id"));
					  j++;
					  String s=Integer.toString(j);
					  iid.setText(s);
				  }
			  }

		        
		  }
		  
		  
		    //ObservableList<Service> data = FXCollections.observableArrayList();
		    
			
		    String ID=iid.getText();
		    String derived = from.getSelectionModel().getSelectedItem().toString();
		    String arrived = to.getSelectionModel().getSelectedItem().toString();
		    String utname=ticket.getText();
		    String Date =date.getEditor().getText();
		    String profile="";
		    String cabin="";
		    String sit="";
		    String phne="";
		    String price="";
		    String transaction="";
		    
		   
		    if(utname =="")
		    {
		    	JOptionPane.showMessageDialog(null, "Please Select a Train!!");

		    }
		    else
		    {
		    	Statement statement;
		          
		            statement = con.createStatement();
		            
		            statement.execute("insert into bookingticket values('"+ ID +"','"+ profile +"','" + utname + "','"+ cabin +"','" + sit + "','" + Date + "','" + phne + "','" + price + "','" + transaction + "','" + derived + "','" + arrived + "')");
		            Parent parent = FXMLLoader.load(getClass().getResource("/booking/book.fxml"));
		            Scene scene = new Scene(parent);
		            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		            window.setScene(scene);
		            window.show();
	 
		    }
      

	} catch (SQLException | ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }

}