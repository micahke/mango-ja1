package com.micahelias.components;


import com.micahelias.core.MangoScript;
import com.micahelias.scene.GameObject;
import com.micahelias.scene.Scene;

public class Component implements MangoScript {

  GameObject gameObject;

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

  public <T extends Component> T getComponent(Class<T> componentType) {
    return this.gameObject.getComponent(componentType);
  }

}

