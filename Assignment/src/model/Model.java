package model;

import java.beans.PropertyChangeListener;

public interface Model
{
  void addListener(String name, PropertyChangeListener listener);
  void addTemperature(String id, double temperature);
  void turnRadiatorUp();
  void turnRadiatorDown();
  int getRadiatorPower();
  void checkCritical(double x, double y);
}
