package com.micahelias;

import org.joml.Math;
import org.joml.Vector3f;

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

public class App {

  static int WIDTH = 800;
  static int HEIGHT = 600;

  int PADDLE_WIDTH = 30;
  int PADDLE_HEIGHT = 100;

  int BALL_SIZE = 20;

  Scene scene;
  
  GameObject p1;
  GameObject p2;
  GameObject ball;


  
  public static void main(String[] args) {
    MangoInstance.init();
    MangoInstance.attachWindow(new MangoWindow(App.WIDTH, App.HEIGHT, "GPU Pong", false));
    MangoTimer.setTimeDilation(10);
    
    new App();
  }

  public App() {

    scene = new Scene();
    MangoInstance.setScene(scene);



    Rect2D p1Mesh = new Rect2D(PADDLE_WIDTH, PADDLE_HEIGHT);
    p1Mesh.setColor(Color.MINT_LEAF);
    p1 = new GameObject(p1Mesh);
    p1.setPosition(0, (App.HEIGHT / 2) - (PADDLE_HEIGHT / 2));
    p1.setTag("paddleLeft");
    p1.addComponent(new MeshRenderer());
    p1.addComponent(new PaddleFollowComponent());
    scene.addGameObject(p1);


    Rect2D p2Mesh = new Rect2D(PADDLE_WIDTH, PADDLE_HEIGHT);
    p2Mesh.setColor(Color.MINT_LEAF);
    p2 = new GameObject(p2Mesh);
    p2.setPosition(App.WIDTH - PADDLE_WIDTH, (App.HEIGHT / 2) - (PADDLE_HEIGHT / 2));
    p2.setTag("paddleRight");
    p2.addComponent(new MeshRenderer());
    scene.addGameObject(p2);

    Rect2D ballMesh = new Rect2D(BALL_SIZE, BALL_SIZE);
    ballMesh.setColor(Color.PINK_GLAMOUR);
    ball = new GameObject(ballMesh);
    ball.setTag("ball");
    ball.setPosition((App.WIDTH / 2) - (BALL_SIZE / 2), (App.HEIGHT / 2) - (BALL_SIZE / 2));
    ball.addComponent(new MeshRenderer());
    ball.addComponent(new BallLogic());
    scene.addGameObject(ball);
    

    scene.addGameObject(new Camera2D());
    scene.setBackgroundColor(Color.DRACULA);

    MangoInstance.run();

  }

}



class BallLogic extends Component {
  
  float ballSpeed = 30;
  float xVelo;
  float yVelo;

  GameObject p1;
  GameObject p2;

  PositionComponent ballPositon;

  public BallLogic() {
    super();
  }


  public void init(Scene scene) {
    System.out.println("Init ball");
    ballPositon = getComponent(PositionComponent.class);
    xVelo = -1;
    yVelo = 0;
    p1 = scene.getGameObject("paddleLeft");
    p2 = scene.getGameObject("paddleRight");
  }


  public void update() {

    checkBallPosition();

    float xTrans = xVelo * ballSpeed * MangoTimer.deltaTime();
    float yTrans = yVelo * ballSpeed * MangoTimer.deltaTime();
    ballPositon.translate2D(xTrans, yTrans);


  }


  void checkBallPosition() {
    // if ball moving left
    if (ballPositon.getX() <= 30) {
      if (isCollidingY(p1)) {
        xVelo = 1;
        yVelo = (yDistanceFromPaddleCenter(p1) / 50) - 0.005f;
      }
    }
    if (ballPositon.getX() + 20 >= App.WIDTH - 30) {
      if (isCollidingY(p2)) {
        xVelo = -1;
        yVelo = yDistanceFromPaddleCenter(p2) / 50;
      }
    }

  }

  boolean isCollidingY(GameObject paddle) {
    Vector3f paddlePosition = paddle.getPosition();
    if (ballPositon.getY() >= paddlePosition.y && ballPositon.getY()+ 20 <= paddlePosition.y + 100) {
      return true;
    }
    return false;
  }


  float yDistanceFromPaddleCenter(GameObject paddle) {
    float paddleMiddle = paddle.getPosition().y + 50;
    return(ballPositon.getY() + 10) - paddleMiddle;
  }


  public PositionComponent getBallPosition() {
    return this.ballPositon; 
  }

}



class PaddleFollowComponent extends Component {

  GameObject ball;
  PositionComponent paddlePosition;

  public PaddleFollowComponent() {
    super();
  }

  public void init(Scene scene) {
    System.out.println("Init paddle");
    GameObject ball = scene.getGameObject("ball");
    this.ball = ball;
  }

  public void update() {

  }

}
