package application;
	
import java.io.IOException;




import org.controlsfx.control.textfield.TextFields;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application 
{
	@Override
	public void start(Stage primaryStage) throws Exception
	{
	    Parent root= FXMLLoader.load(getClass().getResource("/login/login.fxml"));
		//Parent root= FXMLLoader.load(getClass().getResource("/booking/book.fxml"));
		//Parent root= FXMLLoader.load(getClass().getResource("/payment/Payment.fxml"));
		//Parent parent= FXMLLoader.load(getClass().getResource("/ticketcounter/Place.fxml"));
		primaryStage.setTitle("Saikat");
		primaryStage.setScene(new Scene(root,700,400));
		//primaryStage.setScene(new Scene(parent,700,400));
		primaryStage.show();
		primaryStage.setResizable(false);
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}

	
}
