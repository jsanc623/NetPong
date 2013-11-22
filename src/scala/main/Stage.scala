package scala.main

import org.lwjgl.opengl.{Display, GL11}

object Stage {
  def main(){
    this.net(Display.getWidth() / 2, Display.getHeight())
  }

  def net(xPos : Float, yPos : Float){
    GL11.glColor3f(1.0f,0.0f,0.0f)

    GL11.glBegin(GL11.GL_QUADS)
    GL11.glVertex2f(xPos, yPos - yPos)
    GL11.glVertex2f(xPos + 10, yPos - yPos)
    GL11.glVertex2f(xPos + 10, yPos)
    GL11.glVertex2f(xPos, yPos)
    GL11.glEnd()
  }
}
