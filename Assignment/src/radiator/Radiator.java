package radiator;

import radiator.state.OffState;
import radiator.state.RadiatorState;
import java.beans.PropertyChangeListener;

import java.beans.PropertyChangeSupport;

public class Radiator
{
  private RadiatorState currentState;
  PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

  public Radiator()
  {
    currentState = new OffState();
  }

  public void turnUp() { currentState.turnUp(this); }
  public void turnDown()
  {
    currentState.turnDown(this);
  }
  public void setCurrentState(RadiatorState state)
  {
    currentState = state;
    changeSupport.firePropertyChange("Power",null,getPower());
  }
  public int getPower(){ return currentState.getPower(); };
  public void addListener(String name,PropertyChangeListener listener){
    if(name == null)
      changeSupport.addPropertyChangeListener(listener);
    else
      changeSupport.addPropertyChangeListener(name,listener);
  }
}
