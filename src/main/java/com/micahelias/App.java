package com.micahelias;


import com.micahelias.components.MeshRenderer;
import com.micahelias.core.MangoInstance;
import com.micahelias.core.MangoWindow;
import com.micahelias.graphic.Mesh;
import com.micahelias.graphic.Triangle;
import com.micahelias.scene.Camera2D;
import com.micahelias.scene.GameObject;
import com.micahelias.scene.Scene;




public class App {


  public static void main(String[] args) {


    MangoInstance.init();

    MangoWindow window = new MangoWindow(800, 540, "Hello, world!", true);
    MangoInstance.attachWindow(window);
    Scene scene = new Scene();
    MangoInstance.setScene(scene);


    GameObject object = new GameObject();
    object.setMesh(new Triangle());
    object.addComponent(new MeshRenderer());

    scene.addGameObject(object);
    scene.addGameObject(new Camera2D());
    scene.setBackgroundColor(0.5f, 0.5f, 0.5f);


    MangoInstance.run();

  }



}

