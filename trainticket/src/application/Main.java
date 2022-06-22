package application;
	
import java.io.IOException;


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
		primaryStage.setTitle("Saikat");
		primaryStage.setScene(new Scene(root,700,400));
		primaryStage.show();
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}
