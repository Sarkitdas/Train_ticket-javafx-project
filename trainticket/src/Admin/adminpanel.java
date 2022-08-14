package Admin;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class adminpanel {

    @FXML
    private Button checkbook;

    @FXML
    private Button train;

    @FXML
    void Booking(ActionEvent event) throws IOException {
    	Parent parent = FXMLLoader.load(getClass().getResource("/Checkbooking/Checkbook.fxml"));
        Scene scene = new Scene(parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    	

    }

    @FXML
    void update(ActionEvent event) throws IOException {
    	Parent parent = FXMLLoader.load(getClass().getResource("/Trainupdate/update.fxml"));
        Scene scene = new Scene(parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

    }

}