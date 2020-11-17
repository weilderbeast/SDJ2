package core;

import view.log.LogViewModel;
import view.temperature.TemperatureViewModel;

public class ViewModelFactory
{
  private TemperatureViewModel temperatureViewModel;
  private LogViewModel logViewModel;

  public ViewModelFactory(ModelFactory modelFactory)
  {
    temperatureViewModel = new TemperatureViewModel(modelFactory.getModel());
    logViewModel = new LogViewModel(modelFactory.getModel());
  }

  public TemperatureViewModel getTemperatureViewModel(){
    return temperatureViewModel;
  }
  public LogViewModel getLogViewModel()
  {
    return logViewModel;
  }
}
