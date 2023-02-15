package com.micahelias;

import org.lwjgl.opengl.*;

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

    long window; 

    if (!glfwInit()) {
      System.out.println("Could not start GLFW");
      System.exit(-1);
    }

    glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
    glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 2);
    glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);
    glfwWindowHint(GLFW_OPENGL_FORWARD_COMPAT, GL_TRUE);


    window = glfwCreateWindow(640, 480, "Hello, world", NULL, NULL);

    if (window == NULL) {
      glfwTerminate();
      System.exit(-1);
    }

    glfwMakeContextCurrent(window);
    glfwSwapInterval(1);
    GL.createCapabilities();

    // Render stuff

    float[] positions = {
      -0.5f, -0.5f,
      0.0f, 0.5f,
      0.5f, -0.5f
    };

    int[] indeces = {
      0, 1, 2
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

    while (!glfwWindowShouldClose(window)) {
      glClear(GL_COLOR_BUFFER_BIT);

      shader.bind();
      shader.setUniform4f("u_Color", 0.7f, 0.3f, 0.8f, 1.0f);


      // render

      shader.bind();
      vao.bind();
      ibo.bind();


      glDrawElements(GL_TRIANGLES, ibo.getCount(), GL_UNSIGNED_INT, NULL);


      glfwSwapBuffers(window);
      glfwPollEvents();


    }


  }



}
