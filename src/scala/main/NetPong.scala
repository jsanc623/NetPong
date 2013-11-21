package scala.main

import org.lwjgl.input.Keyboard
import org.newdawn.slick.Color
import org.lwjgl.opengl.{GL11, Display, DisplayMode}

object NetPong extends App {
  class NetPong extends App{
    var step: Int = 0

    def run() : Any = {
      this.initDisplay()

      while(!Display.isCloseRequested()){
        Color.white.bind()

        this.input()
        this.render()
        Display.update()

        this.step += 1
      }

      this.killDisplay()
    }

    def initDisplay() : Any = {
      Display.setDisplayMode(new DisplayMode(800, 800))
      Display.setTitle("Scala NetPong v1.0")
      Display.setVSyncEnabled(true)
      Display.setResizable(false)
      Display.create()

      GL11.glEnable(GL11.GL_BLEND)
    }

    def killDisplay() : Any = {
      GL11.glDisable(GL11.GL_BLEND)
      Display.destroy()
    }

    def render() : Any = {
      GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA)
    }

    def input(): Any = {
      val key_event = Keyboard.getEventKey() match {
        case Keyboard.KEY_UP => {}
        case Keyboard.KEY_DOWN => {}
        case Keyboard.KEY_SPACE => {}
        case Keyboard.KEY_R => { Display.destroy(); this.run() }
        case _ => false
      }
    }
  }



  val NetPong = new NetPong
  NetPong.run()
}
