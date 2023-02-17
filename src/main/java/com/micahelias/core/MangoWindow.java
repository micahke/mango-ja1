package com.micahelias.core;

import static org.lwjgl.glfw.GLFW.*;

import org.joml.Vector2f;
import org.joml.Vector2i;
import org.lwjgl.opengl.GL;

public class MangoWindow {


  private long windowID;

  private int width;
  private int height;
  private String title;

  private boolean vsyncEnabled;


  public MangoWindow(int width, int height, String title, boolean vsync) {

    this.width = width;
    this.height = height;
    this.title = title;
    this.vsyncEnabled = vsync;

    createWindow();

  }

  private void createWindow() {

    this.windowID = glfwCreateWindow(this.width, this.height, this.title, 0, 0);

    // Check if window exists
    if (this.windowID == 0) {
      glfwTerminate();
      System.out.println("Could not create window");
    }
    glfwMakeContextCurrent(this.windowID);
    if (this.vsyncEnabled) {
      glfwSwapInterval(1);
    } else {
      glfwSwapInterval(0);
    }
    GL.createCapabilities();

  }

  public boolean shouldClose() {
    return glfwWindowShouldClose(this.windowID);
  }

  // GETTERS and SETTERS

  public long getID() {
    return this.windowID;
  }

  public int getWidth() {
    return this.width;
  }

  public int getHeight() {
    return this.height;
  }

  public String getTitle() {
    return this.title;
  }


  public Vector2i getDimensions() {
    return new Vector2i(this.width, this.height);
  }

}
