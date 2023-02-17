package com.micahelias.graphic;

import org.joml.Vector2f;

import com.micahelias.opengl.IndexBuffer;
import com.micahelias.opengl.Shader;
import com.micahelias.opengl.VertexArray;
import com.micahelias.opengl.VertexBuffer;
import com.micahelias.opengl.VertexBufferLayout;

public class Triangle extends Mesh {


  private Vector2f v1;
  private Vector2f v2;
  private Vector2f v3;


  private float[] vertices = {
    -0.5f, -0.5f,
    0.0f, 0.5f,
    0.5f, -0.5f
  };

  private final int[] indeces = {
    0, 1, 2
  };

  public Triangle(Vector2f xy1, Vector2f xy2, Vector2f xy3) {
    super();

    this.v1 = xy1;
    this.v2 = xy2;
    this.v3 = xy3;

    initVertices();

    VertexArray vao = new VertexArray();
    VertexBuffer vbo = new VertexBuffer(vertices);
    VertexBufferLayout layout = new VertexBufferLayout();
    layout.pushf(2);

    vao.addBuffer(vbo, layout);

    IndexBuffer ibo = new IndexBuffer(indeces);

    Shader shader = new Shader("vertex2D.glsl", "fragment2D.glsl");

    setVAO(vao);
    setVBO(vbo);
    setLayout(layout);
    setIBO(ibo);
    setShader(shader);

  }

  void initVertices() {
    this.vertices = new float[]{
      v1.get(0), v1.get(1),
      v2.get(0), v2.get(1),
      v3.get(0), v3.get(1)
    };
  }


}
