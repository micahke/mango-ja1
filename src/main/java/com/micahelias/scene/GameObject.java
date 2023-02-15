package com.micahelias.scene;

import java.util.ArrayList;

import com.micahelias.components.Component;
import com.micahelias.components.PositionComponent;

public class GameObject {

  ArrayList<Component> components;

  public GameObject() {
    components = new ArrayList<Component>();

    // by default, add a new position component to the game object
    components.add(new PositionComponent(0, 0));
  }

  // update all the components in the scene
  public void update() {
    for (int i = 0; i < this.components.size(); i++) {
      Component component = this.components.get(i);
      component.update();
    }
  }

  public ArrayList<Component> getComponents() {
    return this.components;
  }

}
