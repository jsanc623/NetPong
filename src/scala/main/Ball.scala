package scala.main

import org.lwjgl.opengl.{Display, GL11}
import scala.util.Random

object Ball {
  var xPos: Float = 20
  var yPos: Float = Display.getHeight() / 2.04f
  var velocity: Float = 15.5f
  var initialPositionY: Float = 0
  var initialPositionX: Float = this.xPos
  var finalPositionY: Float = 0
  var finalPositionX: Float = Display.getWidth()
  var riseRun: Float = 0
  var isInMotion: Boolean = false

  def main(){
    if(this.isInMotion)
      this.followTrajectory()
    this.draw()
  }

  def randomNumbers: Random = new Random()

  def setInMotion(){
    this.isInMotion = true
    this.setTrajectory()
    this.main()
  }

  def followTrajectory(){
    this.xPos = this.xPos + (this.riseRun * this.velocity)
    this.yPos = this.yPos + (this.riseRun * this.velocity)
    //print(finalPositionX + ", " + finalPositionY + " ")
    //print(xPos + ", " + yPos + " \n")
  }

  def setTrajectory(){
    val low: Int = 0
    val high: Int = Display.getHeight()

    this.initialPositionY = this.yPos.toInt
    this.finalPositionY = new Random().nextInt(high-low) + low
    this.riseRun = this.finalPositionY / Math.abs(this.finalPositionX)
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
    this.isInMotion = false
    this.xPos =20
    this.yPos = Display.getHeight() / 2.04f
    this.main()
  }
}