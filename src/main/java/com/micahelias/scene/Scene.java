package com.micahelias.scene;

import java.util.ArrayList;

import com.micahelias.components.MeshRenderer;
import com.micahelias.util.Color;

import static org.lwjgl.opengl.GL30.*;

public class Scene {

  private ArrayList<GameObject> gameObjects;

  public Scene() {
    gameObjects = new ArrayList<GameObject>();
  }


  // Add a game object to the scene
  public void addGameObject(GameObject object) {
    object.setScene(this);
    this.gameObjects.add(object);
  }

  // update the components in the scene
  public void update() {
    for (int i = 0; i < this.gameObjects.size(); i++) {
      GameObject gameObject = this.gameObjects.get(i);
      gameObject.update();
    }
  }


  // Render the scene
  public void render() {
    // loop through all the components
    // get the renderer
    Camera2D camera = getGameObject(Camera2D.class);
    if (camera == null) {
      System.out.println("No camera in scene");
      return;
    }
    for (int i = 0; i < this.gameObjects.size(); i++) {
      GameObject gameObject = this.gameObjects.get(i);
      if (gameObject.isRenderable()) {
        MeshRenderer renderer = gameObject.getComponent(MeshRenderer.class);
        if (renderer != null) {
          renderer.render(gameObject.getMesh(), camera);
        }
      }
    }

  }

  // Gets the first instance of a game object in the scene
  // Should be used to search for a specific game object type, not duplicates
  public <T extends GameObject> T getGameObject(Class<T> classType) {
    for (int i = 0; i < this.gameObjects.size(); i++) {
      GameObject gameObject = this.gameObjects.get(i);
      if (classType.isInstance(gameObject)) {
        return classType.cast(gameObject);
      }
    }
    return null;
  }

  public GameObject getGameObject(String tag) {
    for (int i = 0; i < this.gameObjects.size(); i++) {
      GameObject gameObject = this.gameObjects.get(i);
      if (gameObject.getTag().equals(tag)) return gameObject;
    }
    return null;
  }
  
  // Set the background color
  // Takes in red, green, blue, and alpha
  public void setBackgroundColor(float r, float g, float b, float alpha) {
    glClearColor(r, g, b, alpha);
  }


  // Set the background color
  // Takes in red, green, blue and alpha is automatically 1.0
  public void setBackgroundColor(float r, float g, float b) {
    glClearColor(r, g, b, 1.0f);
  }

  // Set the background color
  // Takes in red, green, blue and alpha is automatically 1.0
  public void setBackgroundColor(Color color) {

    glClearColor(color.red, color.green, color.blue, color.alpha);
  }
}

