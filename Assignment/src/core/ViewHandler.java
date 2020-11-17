package core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import view.log.LogViewController;
import view.temperature.TemperatureViewController;

import java.io.IOException;

public class ViewHandler
{
  private ViewModelFactory viewModelFactory;
  private Scene scene;
  private Stage mainStage;

  public ViewHandler(ViewModelFactory viewModelFactory)
  {
    this.viewModelFactory = viewModelFactory;
    scene = null;
    mainStage = new Stage();
  }

  public void start() throws Exception{
    openView("TemperatureView");
  }

  public void openView(String viewToOpen) throws IOException{

    FXMLLoader loader = new FXMLLoader();
    Parent root = null;

    switch (viewToOpen)
    {
      case "TemperatureView":
      {
        loader.setLocation(
            getClass().getResource("..\\view\\temperature\\TemperatureView.fxml")
        );
        root = loader.load();
        TemperatureViewController temperatureViewController = loader.getController();
        temperatureViewController.init(viewModelFactory.getTemperatureViewModel(),this);
        mainStage.setTitle("Temperature View");
        break;
      }
      case "LogView":
      {
        loader.setLocation(
            getClass().getResource("..\\view\\log\\LogView.fxml")
        );
        root = loader.load();
        LogViewController logViewController = loader.getController();
        logViewController.init(viewModelFactory.getLogViewModel(),this);
        mainStage.setTitle("Log View");
        break;
      }
    }

    scene = new Scene(root);
    scene.getStylesheets().add(getClass().getResource("..\\view\\style\\style.css").toExternalForm());
    Font.loadFont(getClass().getResourceAsStream("..\\view\\style\\roboto.ttf"), 20);
    mainStage.setScene(scene);
    mainStage.show();
  }
}
