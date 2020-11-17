package core;

import model.Model;
import model.ModelManager;

public class ModelFactory
{
  private Model model;

  public Model getModel()
  {
    if(model == null) model = new ModelManager();
    return model;
  }
}
