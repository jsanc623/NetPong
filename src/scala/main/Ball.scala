package scala.main

import org.lwjgl.opengl.GL11

object Ball {
  var xPos: Double = 0.0
  var yPos: Double = 0.0

  def main(){
  }

  def draw(xPos : Double, yPos: Double) : Any = {
    GL11.glBegin(GL11.GL_QUADS)

    GL11.glEnd()
  }

  def reset() : Any = {
    this.draw(10, 455)
  }
}