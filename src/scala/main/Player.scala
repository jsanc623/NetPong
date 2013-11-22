package scala.main

import org.lwjgl.opengl.{GL11, Display}

object Player {
  var xPos: Float = 0f
  var yPos: Float = 0f
  var yVary: Float = 0f
  var speed: Float = 10f
  val width: Float = 10f
  val height: Float = 50f

  def main(){
    this.draw(this.xPos, this.yPos, 0.7f, 0.7f, 1.0f)
  }

  def reset() : Any = {
    this.xPos = 10
    this.yPos = (Display.getHeight() / 2) - (this.height / 2)
    this.main()
  }

  def draw(xPos : Float, yPos: Float, Red: Float = 0.0f, Green: Float = 0.0f, Blue: Float = 0.0f) : Any = {
    GL11.glColor3f(Red, Green, Blue)

    GL11.glBegin(GL11.GL_QUADS)
    GL11.glVertex2f(xPos, yPos + this.yVary)
    GL11.glVertex2f(xPos + this.width, yPos + this.yVary)
    GL11.glVertex2f(xPos + this.width, (yPos + this.height) + this.yVary)
    GL11.glVertex2f(xPos, (yPos + this.height) + this.yVary)
    GL11.glEnd()
  }
}
