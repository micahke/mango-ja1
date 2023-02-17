package com.micahelias.core;

import com.micahelias.opengl.GLInitializer;
import com.micahelias.scene.Scene;

import static com.micahelias.opengl.RenderAPI.*;
import static org.lwjgl.opengl.GL30.*;
import static org.lwjgl.glfw.GLFW.*;

public final class MangoInstance {

  private static boolean isRunning;
  private static MangoWindow activeWindow;
  private static Scene activeScene;

  // Engine initialization
  public static void init() {
    GLInitializer.setRenderAPI(OPENGL);
  }

  public static void run() {
    isRunning = true;
    while (!activeWindow.shouldClose()) {

      // Clear the display
      glClear(GL_COLOR_BUFFER_BIT);

      // Poll for input events
      glfwPollEvents();

      // Update internals
      MangoTimer.updateDeltaTime();


      // Update game logic
      activeScene.update();

      // Render the scene
      activeScene.render();

      // End of frame stuff
      glfwSwapBuffers(activeWindow.getID());

    }
    glfwTerminate();
  }

  public static void attachWindow(MangoWindow window) {
    activeWindow = window;
  }

  public static boolean isRunning() {
    return isRunning;
  }

  public static MangoWindow getActiveWindow() {
    return activeWindow;
  }

  public static void setScene(Scene scene) {
    activeScene = scene;
  }

}
