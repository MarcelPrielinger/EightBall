package controllerview.login;

import controllerview.eightBall.EightBallC;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class LoginC implements Initializable {
  private Stage stage;
  @FXML
  private TextField txtUser;
  @FXML
  private TextField txtPassword;
  @FXML
  private Label txtException;
  
  public static void show(Stage stage) {
    try {
      FXMLLoader fxmlLoader = new FXMLLoader(LoginC.class.getResource("LoginV.fxml"));
      Parent root = fxmlLoader.load();
      
      //get controller which is connected to this fxml file
      LoginC ctrl = fxmlLoader.getController();
      ctrl.stage = stage;
      
      stage.setTitle("Login");
      stage.setScene(new Scene(root, 400, 400));
      stage.show();
    }
    catch (IOException e) {
      System.err.println("Something wrong with LoginV.fxml: " + e.getMessage());
      e.printStackTrace(System.err);
    }
  }
  
  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
  }
  
  @FXML
  private void login() {
      txtException.setText("");
      try {
          if (model.Model.isCorrectLogin(txtUser.getText(), txtPassword.getText())) {
              //navigate from welcome screen to main screen
              System.out.println("Navigation started ...");
              EightBallC.show(new Stage(), "Hello from Welcome Controller!");
              stage.close();

          }
          else {
              txtException.setText("Wrong user or password!   Try again!");
              System.out.println("Wrong user or password!");
          }
      }
      catch (Exception e)
      {
          txtException.setText("Error! Try again!");
          System.err.println(e.getMessage());
          e.printStackTrace(System.err);
      }
    }
}
