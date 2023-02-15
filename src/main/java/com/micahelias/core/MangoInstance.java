package com.micahelias.core;

import com.micahelias.opengl.GLInitializer;
import static com.micahelias.opengl.RenderAPI.*;
import static org.lwjgl.opengl.GL30.*;

public final class MangoInstance {

  private static boolean isRunning;
  private static MangoWindow activeWindow;

  // Engine initialization
  public static void init() {
    GLInitializer.setRenderAPI(OPENGL);
  }

  public static void run() {
    isRunning = true;
    while (!activeWindow.shouldClose()) {

      MangoTimer.updateDeltaTime();

      // Clear the display
      glClear(GL_COLOR_BUFFER_BIT);

    }
    // TODO: cleanup
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

}
