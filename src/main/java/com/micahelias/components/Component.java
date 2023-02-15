package com.micahelias.components;

import com.micahelias.core.MangoScript;
import com.micahelias.scene.GameObject;
import com.micahelias.scene.Scene;

public class Component implements MangoScript {

  private GameObject gameObject;

  public Component() {}

  // Scriptable
  public void init(Scene scene) {}

  public void update() {}

  public GameObject getOwner() {
    return gameObject;
  }

  public void setGameObject(GameObject object) {
    this.gameObject = object;
  }

  public Component getComponent(Class<Component> componentType) {
    for (int i = 0; i < gameObject.getComponents().size(); i++) {
      Component c = gameObject.getComponents().get(i);
      if (c instanceof componentType) {

      }
    }
  }

}

