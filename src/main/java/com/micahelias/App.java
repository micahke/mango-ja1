package com.micahelias;


import com.micahelias.core.MangoInstance;
import com.micahelias.core.MangoWindow;
import com.micahelias.scene.GameObject;
import com.micahelias.scene.Scene;




public class App {


  public static void main(String[] args) {


    MangoInstance.init();

    MangoWindow window = new MangoWindow(800, 600, "Hello, world!", true);
    MangoInstance.attachWindow(window);
    Scene scene = new Scene();
    MangoInstance.setScene(scene);

    scene.addGameObject(new GameObject());


    MangoInstance.run();

  }



}

