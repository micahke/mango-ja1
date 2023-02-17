package com.micahelias.components;

import com.micahelias.scene.Scene;

public class PositionComponent extends Component {

  private float x;
  private float y;
  private float z;

  public PositionComponent() {
    super();
  }

  public PositionComponent(float x, float y) {
    super();

    this.x = x; 
    this.y = y;
    this.z = 0;
  }

  @Override
  public void init(Scene scene) {
    // Initialize the component

 }

  @Override
  public void update() {
    // update the component
  }

  // Getters and setters

  public float getX() {
    return this.x;
  }

  public float getY() {
    return this.y;
  }

  public float getZ() {
    return this.z;
  }


  public void setX(float x) {
    this.x = x;
  }

  public void setY(float y) {
    this.y = y;

  }



}
