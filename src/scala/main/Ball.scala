package scala.main

import org.lwjgl.opengl.{Display, GL11}
import scala.util.Random

object Ball {
  var xPos: Float = 20
  var yPos: Float = Display.getHeight() / 2.04f
  var speed: Float = 10f
  var isInMotion: Boolean = false

  def main(){
    val time = System.nanoTime() / 1000000
    val modifier = randomNumbers.nextFloat() * (if(time % 2 == 0) 1 else -1)
    if(this.isInMotion){
      this.xPos += modifier * ((modifier / 2) * this.speed)
      this.yPos += modifier * ((modifier / 1.765f) * this.speed)
      print(yPos + " " + xPos + "\n")
    }
    this.draw()
  }

  def randomNumbers: Random = new Random()

  def setInMotion(){
    this.isInMotion = true
    this.main()
  }

  def draw(xPos : Float = this.xPos, yPos: Float = this.yPos) : Any = {
    GL11.glBegin(GL11.GL_QUADS)
      GL11.glVertex2f(xPos, yPos)
      GL11.glVertex2f(xPos + 10, yPos)
      GL11.glVertex2f(xPos + 10, yPos + 10)
      GL11.glVertex2f(xPos, yPos + 10)
    GL11.glEnd()
  }

  def reset() : Any = {
    this.main()
  }
}