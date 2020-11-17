import core.ModelFactory;
import core.ViewHandler;
import core.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;
import thermometer.Thermometer;

public class App extends Application
{
  @Override public void start(Stage stage) throws Exception
  {
    ModelFactory modelFactory = new ModelFactory();
    ViewModelFactory viewModelFactory = new ViewModelFactory(modelFactory);
    ViewHandler viewHandler = new ViewHandler(viewModelFactory);

    viewHandler.start();

    Thermometer t1 = new Thermometer(modelFactory.getModel(),15,2,"t1");
    Thermometer t2 = new Thermometer(modelFactory.getModel(),15,7,"t2");
    Thermometer t3 = new Thermometer(modelFactory.getModel(),0,15,"t3");

    Thread thermometer1 = new Thread(t1);
    Thread thermometer2 = new Thread(t2);
    Thread thermometer3 = new Thread(t3);

    thermometer1.start();
    thermometer2.start();
    thermometer3.start();
  }
}
