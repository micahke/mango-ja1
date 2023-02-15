package com.micahelias.scene;

import java.util.ArrayList;

public class Scene {

  private ArrayList<GameObject> gameObjects;

  public Scene() {
    gameObjects = new ArrayList<GameObject>();
  }


  public void addGameObject(GameObject object) {
    this.gameObjects.add(object);
  }

  // update the components in the scene
  public void update() {
    for (int i = 0; i < this.gameObjects.size(); i++) {
      GameObject gameObject = this.gameObjects.get(i);
      gameObject.update();
    }
  }

}

