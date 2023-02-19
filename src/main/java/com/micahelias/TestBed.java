package com.micahelias;




import com.micahelias.components.Component;
import com.micahelias.components.MeshRenderer;
import com.micahelias.components.PositionComponent;
import com.micahelias.core.MangoInstance;
import com.micahelias.core.MangoTimer;
import com.micahelias.core.MangoWindow;
import com.micahelias.graphic.Rect2D;
import com.micahelias.scene.Camera2D;
import com.micahelias.scene.GameObject;
import com.micahelias.scene.Scene;
import com.micahelias.util.Color;




public class TestBed extends Component {


  public static void main(String[] args) {


    MangoInstance.init();

    MangoWindow window = new MangoWindow(800, 540, "Hello, world!", false);
    MangoInstance.attachWindow(window);
    Scene scene = new Scene();
    MangoInstance.setScene(scene);
    MangoTimer.setTimeDilation(3);


    GameObject object = new GameObject(100, 400);

    Rect2D rect = new Rect2D(100, 100);
    rect.setColor(Color.MINT_LEAF);
    object.setMesh(rect);
    object.addComponent(new MeshRenderer());
    object.addComponent(new TestBed());

    scene.addGameObject(object);
    scene.addGameObject(new Camera2D());
    scene.setBackgroundColor(Color.DRACULA);


    MangoInstance.run();

  }


  public void init(Scene scene) {
  }


  int right = MangoInstance.getActiveWindow().getWidth() - 100;
  int top = MangoInstance.getActiveWindow().getHeight() - 100;
  boolean goRight = true;

  public void update() {
    PositionComponent position = getComponent(PositionComponent.class);
    
    if (position.getX() >= right) {
      position.setX(right);
      goRight = false;
    }
    if (position.getX() <= 0) {
      position.setX(0);
      goRight = true;
    }

    if (goRight) {
      position.translate2D(50 * MangoTimer.deltaTime(), 0);
    } else {
      position.translate2D(-50 * MangoTimer.deltaTime(), 0);
    }
  }

}

