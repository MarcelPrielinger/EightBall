package controllerview.eightBall;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class EightBallC implements Initializable {
  
  private String myData = "";
  private model.Model model;
  @FXML
  private Label txtEightBall;
  
  public static void show(Stage stage, String greeting) {
    try {
      FXMLLoader fxmlLoader = new FXMLLoader(EightBallC.class.getResource("eightBallV.fxml"));
      Parent root = fxmlLoader.load();
      
      //send data to MainController
      EightBallC ctrl = fxmlLoader.getController();
      ctrl.setMyData(greeting);
      
      stage.setTitle("Eight Ball");
      stage.setScene(new Scene(root, 500, 500));
      stage.show();
    }
    catch (Exception e) {
      System.err.println("Something wrong with eightBallV.fxml: " + e.getMessage());
      e.printStackTrace(System.err);
    }
  }
  
  public void setMyData(String myData) {
    this.myData = myData;
    System.out.println("(MainController) Data received: " + this.myData);
  }
  
  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
  }

  @FXML
  private void ask()
  {
      try {
          txtEightBall.setText(model.getRandomAnswer());
      }
      catch (Exception e)
      {
          System.err.println(e.getMessage());
          e.printStackTrace(System.err);
      }

  }
}
