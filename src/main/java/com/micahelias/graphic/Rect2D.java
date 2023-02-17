package com.micahelias.graphic;

import org.joml.Vector2f;

import com.micahelias.opengl.IndexBuffer;
import com.micahelias.opengl.Shader;
import com.micahelias.opengl.VertexArray;
import com.micahelias.opengl.VertexBuffer;
import com.micahelias.opengl.VertexBufferLayout;

public class Rect2D extends Mesh {


  private int x, y, width, height;


  private float[] vertices = {
    -0.5f, -0.5f,
    -0.5f, 0.5f,
    0.5f, 0.5f,
    0.5f, -0.5f
  };

  private final int[] indeces = {
    0, 1, 2,
    2, 3, 0
  };

  public Rect2D(int x, int y, int width, int height) {
    super();

    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;

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
      x, y,
      x, y + height,
      x + width, y + height,
      x + width, y
    };
  }


}

