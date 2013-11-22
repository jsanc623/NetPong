package scala.main

import org.lwjgl.input.Keyboard
import org.newdawn.slick.Color
import org.lwjgl.opengl.{GL11, Display, DisplayMode}

object NetPong extends App{
  var step: Int = 0

  def run() : Any = {
    this.init()

    Player.reset()
    Computer.reset()
    Ball.reset()

    while(!Display.isCloseRequested()){
      Color.white.bind()

      this.input()
      this.render()
      Display.update()

      this.step += 1
    }

    this.destroy()
  }

  def init() : Any = {
    Display.setDisplayMode(new DisplayMode(800, 800))
    Display.setTitle("Scala NetPong v1.0")
    Display.setVSyncEnabled(true)
    Display.setResizable(false)
    Display.create()

    GL11.glMatrixMode(GL11.GL_2D)
    GL11.glLoadIdentity()
    GL11.glOrtho(0, Display.getWidth(), Display.getHeight(), 0, 1, -1)
    GL11.glMatrixMode(GL11.GL_MODELVIEW)
    GL11.glEnable(GL11.GL_BLEND)
  }

  def destroy() : Any = {
    GL11.glDisable(GL11.GL_BLEND)
    Display.destroy()
  }

  def render() : Any = {
    GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA)
    Stage.main()
    Player.main()
    Computer.main()
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

  run()
}