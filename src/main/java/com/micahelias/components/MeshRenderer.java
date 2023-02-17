package com.micahelias.components;

import com.micahelias.graphic.Mesh;
import com.micahelias.scene.Camera2D;
import com.micahelias.scene.Scene;
import com.micahelias.util.Color;

import static org.lwjgl.opengl.GL30.*;

import org.joml.Matrix4f;
import org.joml.Vector3f;

public class MeshRenderer extends Component {



  public MeshRenderer() {
    super();
  }



  public void render(Mesh mesh, Camera2D camera) {
    // System.out.println("WOuld be rendering");
    // return;

    if (mesh.getIBO() != null) {
      mesh.getIBO().bind();
    } 

    mesh.getVao().bind();
    mesh.getShader().bind();

    // set mesh color
    if (mesh.hasColor()) {
      mesh.getShader().setUniformVec4("color", mesh.getColor().toVector());
    }
    

    // mesh.getShader().setUniformMat4f("view", camera.getViewMatrix());
    mesh.getShader().setUniformMat4f("projection", camera.getProjectionMatrix());


    Vector3f position = gameObject.getPosition();
    Matrix4f translation = new Matrix4f().translate(position.x, position.y, 0); 
    translation = translation.mul(mesh.getModelMatrix());
    mesh.getShader().setUniformMat4f("model", translation);


    if (mesh.getIBO() != null) {
      // Using 0 in place of NULL from MemoryUtil package (just a wrapper around 0)
      glDrawElements(GL_TRIANGLES, mesh.getIBO().getCount(), GL_UNSIGNED_INT, 0);
    } 


  }


  public void init(Scene scene) {
    // Enabled rendering on this component
    gameObject.enableRendering();
  }


  public void update() {}


}
