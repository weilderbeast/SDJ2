package radiator.state;

import radiator.Radiator;

public class OffState implements RadiatorState
{
  private static final int power = 0;
  @Override public void turnUp(Radiator radiator)
  {
    System.out.println("Turned radiator from 0 to 1");
    radiator.setCurrentState(new PowerOneState());
  }

  @Override public void turnDown(Radiator radiator)
  {
    //do nothing
  }

  @Override public int getPower()
  {
    return power;
  }

}
