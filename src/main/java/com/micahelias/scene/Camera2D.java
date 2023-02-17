package com.micahelias.scene;


import org.joml.*;

import com.micahelias.core.MangoInstance;

public class Camera2D extends GameObject {


  private Matrix4f projection;
  private Matrix4f view;

  
  public Camera2D() {
    super();
    
    int windowWidth = MangoInstance.getActiveWindow().getWidth();
    int windowHeight = MangoInstance.getActiveWindow().getHeight();
    this.projection = new Matrix4f().ortho(0, windowWidth, 0, windowHeight, -1.0f, 1.0f);
    this.view = new Matrix4f().translate(0.0f, 0.0f, 0.0f);
  }



  public Matrix4f getProjectionMatrix() {
    return projection;
  }


  public Matrix4f getViewMatrix() {
    return view;
  }


}
