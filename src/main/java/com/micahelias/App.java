package com.micahelias;

import org.lwjgl.opengl.*;

import com.micahelias.core.MangoInstance;
import com.micahelias.core.MangoTimer;
import com.micahelias.core.MangoWindow;
import com.micahelias.opengl.IndexBuffer;
import com.micahelias.opengl.Shader;
import com.micahelias.opengl.VertexArray;
import com.micahelias.opengl.VertexBuffer;
import com.micahelias.opengl.VertexBufferLayout;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL30.*;
import static org.lwjgl.system.MemoryUtil.*;


public class App {


  public static void main(String[] args) {


    MangoInstance.init();

    MangoWindow window = new MangoWindow(800, 600, "Hello, world!", true);

    // Render stuff

    float[] positions = {
      -0.5f, -0.5f,
      -0.5f, 0.5f,
      0.5f, 0.5f,
      0.5f, -0.5f
    };

    int[] indeces = {
      0, 1, 2,
      2, 3, 0
    };


    VertexArray vao = new VertexArray();
    VertexBuffer vbo = new VertexBuffer(positions);

    VertexBufferLayout layout = new VertexBufferLayout();
    layout.pushf(2);
    vao.addBuffer(vbo, layout);

    IndexBuffer ibo = new IndexBuffer(indeces);


    Shader shader = new Shader("vertex2D.glsl", "fragment2D.glsl");
    shader.bind();
    shader.setUniform4f("u_Color", 0.8f, 0.3f, 0.8f, 1.0f);

    while (!glfwWindowShouldClose(window.getID())) {
      glClear(GL_COLOR_BUFFER_BIT);

      shader.bind();
      shader.setUniform4f("u_Color", 0.7f, 0.3f, 0.8f, 1.0f);


      // render

      shader.bind();
      vao.bind();
      ibo.bind();


      glDrawElements(GL_TRIANGLES, ibo.getCount(), GL_UNSIGNED_INT, NULL);


      glfwSwapBuffers(window.getID());
      glfwPollEvents();


    }


  }



}
