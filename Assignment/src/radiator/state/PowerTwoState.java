package radiator.state;

import radiator.Radiator;

public class PowerTwoState implements RadiatorState
{
  private static final int power = 2;
  @Override public void turnUp(Radiator radiator)
  {
    System.out.println("Turned radiator from 2 to 3");
    radiator.setCurrentState(new PowerThreeState(radiator));
  }

  @Override public void turnDown(Radiator radiator)
  {
    System.out.println("Turned radiator from 2 to 1");
    radiator.setCurrentState(new PowerOneState());
  }

  @Override public int getPower()
  {
    return power;
  }
}
