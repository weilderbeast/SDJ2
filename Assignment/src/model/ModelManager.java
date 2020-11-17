package model;

import radiator.Radiator;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ModelManager implements Model
{
  private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

  private double x;
  private double y;
  private double z;

  private Radiator radiator;

  public ModelManager(){
    radiator = new Radiator();
    radiator.addListener("Power",evt -> onPowerChange(evt));
  }

  private void onPowerChange(PropertyChangeEvent evt)
  {
    changeSupport.firePropertyChange(evt);
  }

  @Override public void addListener(String name,
      PropertyChangeListener listener)
  {
    if(name == null)
      changeSupport.addPropertyChangeListener(listener);
    else
      changeSupport.addPropertyChangeListener(name,listener);
  }

  @Override public void addTemperature(String id, double value)
  {

    switch (id)
    {
      case "t1":
        x = value;
        break;
      case "t2":
        y = value;
        break;
      case "t3":
        z = value;
        break;
    }
    changeSupport.firePropertyChange("Data",null, new double[]{x,y,z});
    changeSupport.firePropertyChange("ChartData",null, new double[]{x,y,z});

    checkCritical(x,y);
  }

  @Override public void turnRadiatorUp()
  {
    radiator.turnUp();
  }

  @Override public void turnRadiatorDown()
  {
    radiator.turnDown();
  }

  @Override public int getRadiatorPower()
  {
    return radiator.getPower();
  }

  @Override public void checkCritical(double x, double y)
  {
    String temp = "";
    if(x > 25 || y > 25)
      temp = "high";
    else
    if(x < 15 || y < 15)
      temp = "low";
    else if(x >= 15 && x<= 25 || y>= 15 && y<=25)
      temp = "normal";

    changeSupport.firePropertyChange("Critical",null,temp);
  }

}
