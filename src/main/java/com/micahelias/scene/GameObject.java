package com.micahelias.scene;

import java.util.ArrayList;

import org.joml.Vector3f;

import com.micahelias.components.Component;
import com.micahelias.components.PositionComponent;
import com.micahelias.graphic.Mesh;

public class GameObject {

  private ArrayList<Component> components;
  private ArrayList<Component> componentBuffer; // A buffer to store the uninitialized components
  private Scene scene;
  private Mesh mesh;
  private boolean renderable;

  public GameObject() {
    this.components = new ArrayList<Component>();
    this.componentBuffer = new ArrayList<Component>();
    this.renderable = false;

    // by default, add a new position component to the game object
    addComponent(new PositionComponent(0, 0));
  }

  public GameObject(Mesh mesh) {

    this.components = new ArrayList<Component>();
    this.componentBuffer = new ArrayList<Component>();
    this.mesh = mesh;
    this.renderable = false;

    // by default, add a new position component to the game object if the user has not set
    addComponent(new PositionComponent(0, 0));
  }


  public GameObject(int x, int y) {

    this.components = new ArrayList<Component>();
    this.componentBuffer = new ArrayList<Component>();
    this.renderable = false;

    // by default, add a new position component to the game object if the user has not set
    addComponent(new PositionComponent(x, y));
  }


  public void addComponent(Component c) {
    c.setGameObject(this); // set the game object reference so that we don't get a null pointer
    this.componentBuffer.add(c);
  }

  // update all the components in the scene
  public void update() {

    // check for components in buffer
    if (componentBuffer.size() > 0) {
      // loop through component buffer
      for (Component c : componentBuffer) {
        c.init(scene);
        components.add(c);
      }
      componentBuffer = new ArrayList<Component>();
    }

    for (int i = 0; i < this.components.size(); i++) {
      Component component = this.components.get(i);
      component.update();
    }
  }

  public <T extends Component> T getComponent(Class<T> componentType) {
    for (int i = 0; i < this.getComponents().size(); i++) {
      Component c = this.getComponents().get(i);
      if (componentType.isInstance(c)) {
        return componentType.cast(c);
      }
    }
    return null;
  }

  public <T extends Component> T getComponentFromBuffer(Class<T> componentType) {
    for (int i = 0; i < this.componentBuffer.size(); i++) {
      Component c = this.componentBuffer.get(i);
      if (componentType.isInstance(c)) {
        return componentType.cast(c);
      }
    }
    return null;
  }

  // Link the scene to the gameobject
  public void setScene(Scene scene) {
    this.scene = scene;
  }

  // Get the list of components for the GameObject
  public ArrayList<Component> getComponents() {
    return this.components;
  }


  // Set the GameObject mesh
  public void setMesh(Mesh mesh) {
    this.mesh = mesh;
  }


  // Gets the mesh of the GameObject
  public Mesh getMesh() {
    return this.mesh;
  }


  // Enable rendering for the object
  public void enableRendering() {
    this.renderable = true;
  }


  // Chceck whether the objet is renderable
  public boolean isRenderable() {
    return this.renderable;
  }


  public Vector3f getPosition() {
    PositionComponent position = getComponent(PositionComponent.class);
    return position.getPosition();
  }

  public void setPosition(int x, int y) {
    PositionComponent position = getComponent(PositionComponent.class);
    if (position == null) {
      position = getComponentFromBuffer(PositionComponent.class);
    }
    position.setPosition(x, y, 0.0f);
  }

}
