package controllerview.eightBall;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class EightBallC implements Initializable {

  private String myData = "";
  @FXML
  private Label txtEightBall;
  @FXML
  private TextField txtQuestion;
  @FXML
  private Label txtException;

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
    } catch (Exception e) {
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
  private void ask() {
    txtException.setText("");
    try
    {
      if (txtQuestion.getText().contains("?") && !txtQuestion.getText().equals("?") && txtQuestion.getText().indexOf("?") == txtQuestion.getLength() - 1)
      {
        if(txtQuestion.getText().contains("SEW"))
        {
          txtEightBall.setText(model.Model.getPositiveAnswer());
          txtQuestion.setText("");
        }

        else if (txtQuestion.getText().contains("why") || txtQuestion.getText().contains("who") || txtQuestion.getText().contains("what") || txtQuestion.getText().contains("how") || txtQuestion.getText().contains("where") || txtQuestion.getText().contains("when") || txtQuestion.getText().contains("whose") || txtQuestion.getText().contains("whiche"))
        {
          txtEightBall.setText(model.Model.getNeutralAnswer());
          txtQuestion.setText("");
        }
        else
        {
          txtEightBall.setText(model.Model.getRandomAnswer());
          txtQuestion.setText("");
        }
      }
      else
      {
        txtException.setText("Not a Question!  Try again!");
        System.out.println("Not a Question!");
        txtQuestion.setText("");
        txtEightBall.setText("");
      }
    } catch (Exception e) {
      txtException.setText("Error!    Try again!");
      System.err.println(e.getMessage());
      e.printStackTrace(System.err);
      txtQuestion.setText("");
    }
  }
}
