package com.micahelias.util;

import org.joml.Vector4f;

public class Color {


  public static final Color LIGHT_GREEN = new Color(85, 239, 196);
  public static final Color PINK_GLAMOUR = new Color(255, 118, 117);


  // Members

  private float red;
  private float green;
  private float blue;
  private float alpha;


  public Color(float red, float green, float blue) {
    this.red = red;
    this.green = green;
    this.blue = blue;
    this.alpha = 1.0f;
  }


  public Color(float red, float green, float blue, float alpha) {
    this.red = red;
    this.green = green;
    this.blue = blue;
    this.alpha = alpha;
  }

  public Color(int red, int green, int blue) {
    this.red = red / 255.0f;
    this.green = green / 255.0f;
    this.blue = blue / 255.0f;
    this.alpha = 1.0f;
  }


  public Color(int red, int green, int blue, float alpha) {
    this.red = red / 255.0f;
    this.green = green / 255.0f;
    this.blue = blue / 255.0f;
    this.alpha = alpha;
  }


  // Gets the color in vector form
  public Vector4f toVector() {
    return new Vector4f(red, green, blue, alpha);
  }

  public float getRed() {
    return red;
  }

  public float getGreen() {
    return green;
  }

  public float getBlue() {
    return blue;
  }

}
