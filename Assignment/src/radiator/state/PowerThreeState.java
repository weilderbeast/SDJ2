package radiator.state;

import radiator.Radiator;
import radiator.thread.RadiatorThread;

import java.beans.PropertyChangeSupport;

public class PowerThreeState implements RadiatorState
{
  private static final int power = 3;

  private Thread thread;
  public PowerThreeState(Radiator radiator)
  {
    RadiatorThread radiatorThread = new RadiatorThread(radiator);
    thread = new Thread(radiatorThread);
    thread.start();
  }

  @Override public void turnUp(Radiator radiator)
  {
    //do nothing
  }

  @Override public void turnDown(Radiator radiator)
  {
    System.out.println("Turned radiator from 3 to 2");
    thread.interrupt();
    radiator.setCurrentState(new PowerTwoState());
  }

  @Override public int getPower()
  {
    return power;
  }

}
