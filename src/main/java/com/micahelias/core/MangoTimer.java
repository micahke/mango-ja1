package com.micahelias.core;

import static org.lwjgl.glfw.GLFW.*;


public final class MangoTimer {

  private static double deltaTime;
  private static double lastFrame = 0;


  public static double getTime() {
    return glfwGetTime();
  }

  public static double deltaTime() {
    return deltaTime;
  }

  // Internally update DeltaTime
  static void updateDeltaTime() {

    deltaTime = getTime() - lastFrame;
    lastFrame = deltaTime;

  }

  


}
