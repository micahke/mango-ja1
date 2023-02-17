package com.micahelias.graphic;

import org.joml.Matrix4f;

import com.micahelias.opengl.IndexBuffer;
import com.micahelias.opengl.Shader;
import com.micahelias.opengl.VertexArray;
import com.micahelias.opengl.VertexBuffer;
import com.micahelias.opengl.VertexBufferLayout;
import com.micahelias.util.Color;

// The base Mesh class

public class Mesh {

  private VertexArray vao;
  private VertexBuffer vbo;
  private VertexBufferLayout layout;
  private IndexBuffer ibo;

  private Shader shader;

  private Matrix4f modelMatrix;

  private Color color;

  public Mesh() {
    // default constructor
    this.modelMatrix = new Matrix4f().translate(0, 0, 0);
  }

  public Mesh(VertexArray vao, VertexBuffer vbo, VertexBufferLayout layout) {
    this.vao = vao;
    this.vbo = vbo;
    this.layout = layout;
    this.modelMatrix = new Matrix4f().translate(0, 0, 0);
  }

  public Mesh(VertexArray vao, VertexBuffer vbo, VertexBufferLayout layout, Shader shader) {
    this.vao = vao;
    this.vbo = vbo;
    this.layout = layout;
    this.shader = shader;
    this.modelMatrix = new Matrix4f().translate(0, 0, 0);
  }

  public Mesh(VertexArray vao, VertexBuffer vbo, VertexBufferLayout layout, IndexBuffer ibo, Shader shader) {
    this.vao = vao;
    this.vbo = vbo;
    this.layout = layout;
    this.ibo = ibo;
    this.shader = shader;
    this.modelMatrix = new Matrix4f().translate(0, 0, 0);
  }


  // +++++++++++++= GETTERS +++++++++++++++++

  public VertexArray getVao() {
    return vao;
  }


  public VertexBuffer getVBO() {
    return vbo;
  }


  public VertexBufferLayout getLayout() {
    return layout;
  }


  public IndexBuffer getIBO() {
    return ibo;
  }


  public Shader getShader() {
    return shader;
  }

  public Matrix4f getModelMatrix() {
    return modelMatrix;
  }

  public boolean hasColor() {
    return color != null;
  }

  public Color getColor() {
    return color;
  }

  // +++++++++++++++++++++++++ SETTERS ++++++++++++++++++++=



  public void setVAO(VertexArray vao) {
    this.vao = vao;
  }


  public void setVBO(VertexBuffer vbo) {
    this.vbo = vbo;
  }


  public void setLayout(VertexBufferLayout layout) {
    this.layout = layout;
  }


  public void setIBO(IndexBuffer ibo) {
    this.ibo = ibo;
  }


  public void setShader(Shader shader) {
    this.shader = shader;
  }

  public void setModelMatrix(Matrix4f matrix) {
    this.modelMatrix = matrix;
  }

  public void setColor(Color color) {
    this.color = color;
  }

}
