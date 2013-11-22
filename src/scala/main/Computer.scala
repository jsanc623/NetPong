package scala.main

import org.lwjgl.opengl.Display

object Computer {
  def main(){
    Paddle.draw(Paddle.xPos, Paddle.yPos)
  }

  def reset() : Any = {
    Paddle.xPos = Display.getWidth() - 20
    Paddle.yPos = (Display.getHeight() / 2) - (Paddle.height / 2)
    this.main()
  }
}