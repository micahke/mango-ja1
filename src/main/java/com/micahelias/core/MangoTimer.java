package com.micahelias.core;

import static org.lwjgl.glfw.GLFW.*;


public final class MangoTimer {

  private static float deltaTime;
  private static float lastFrame = 0;
  private static float timeDilation = 1;


  public static float getTime() {
    return (float)glfwGetTime();
  }

  public static float deltaTime() {
    return timeDilation * deltaTime;
  }

  public static void setTimeDilation(float multiplier) {
    timeDilation = multiplier;
  }

  // Internally update DeltaTime
  static void updateDeltaTime() {
    deltaTime = getTime() - lastFrame;
    lastFrame = getTime();

  }



}
