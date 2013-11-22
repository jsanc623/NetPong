package scala.main

import org.lwjgl.opengl.GL11

object Paddle {
  var xPos: Float = 0
  var yPos: Float = 0
  val width: Float = 10
  val height: Float = 50

  def draw(xPos : Float, yPos: Float) : Any = {
    GL11.glColor3f(1.0f,0.0f,0.0f)

    GL11.glBegin(GL11.GL_QUADS)
    GL11.glVertex2f(xPos, yPos)
    GL11.glVertex2f(xPos + Paddle.width, yPos)
    GL11.glVertex2f(xPos + Paddle.width, yPos + Paddle.height)
    GL11.glVertex2f(xPos, yPos + Paddle.height)
    GL11.glEnd()
  }
}
