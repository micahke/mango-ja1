package com.micahelias;



import com.micahelias.components.MeshRenderer;
import com.micahelias.core.MangoInstance;
import com.micahelias.core.MangoWindow;
import com.micahelias.graphic.Rect2D;
import com.micahelias.scene.Camera2D;
import com.micahelias.scene.GameObject;
import com.micahelias.scene.Scene;
import com.micahelias.util.Color;




public class App {


  public static void main(String[] args) {


    MangoInstance.init();

    MangoWindow window = new MangoWindow(800, 540, "Hello, world!", true);
    MangoInstance.attachWindow(window);
    Scene scene = new Scene();
    MangoInstance.setScene(scene);


    GameObject object = new GameObject(100, 400);

    Rect2D rect = new Rect2D(100, 100);
    rect.setColor(Color.PINK_GLAMOUR);
    object.setMesh(rect);
    object.addComponent(new MeshRenderer());

    scene.addGameObject(object);
    scene.addGameObject(new Camera2D());
    scene.setBackgroundColor(0.5f, 0.5f, 0.5f);


    MangoInstance.run();

  }



}

