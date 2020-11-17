package radiator.state;

import radiator.Radiator;

public class PowerOneState implements RadiatorState
{
  private static final int power = 1;
  @Override public void turnUp(Radiator radiator)
  {
    System.out.println("Turned radiator from 1 to 2");
    radiator.setCurrentState(new PowerTwoState());
  }

  @Override public void turnDown(Radiator radiator)
  {
    System.out.println("Turned radiator from 1 to 0");
    radiator.setCurrentState(new OffState());
  }

  @Override public int getPower()
  {
    return power;
  }
}
