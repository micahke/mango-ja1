package com.micahelias.graphic;

import com.micahelias.opengl.IndexBuffer;
import com.micahelias.opengl.Shader;
import com.micahelias.opengl.VertexArray;
import com.micahelias.opengl.VertexBuffer;
import com.micahelias.opengl.VertexBufferLayout;

public class Triangle extends Mesh {


  private final float[] positions = {
    0.0f, 0.0f,
    100.0f, 100.0f,
    200.0f, 50.0f
  };

  private final int[] indeces = {
    0, 1, 2
  };

  public Triangle() {
    super();

    VertexArray vao = new VertexArray();
    VertexBuffer vbo = new VertexBuffer(positions);
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


}
