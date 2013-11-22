package scala.main

import org.lwjgl.input.Keyboard
import org.newdawn.slick.Color
import org.lwjgl.opengl.{GL11, Display, DisplayMode}

object NetPong extends App{
  var step: Int = 0

  def run() : Any = {
    this.init()

    Stage.main()
    Player.reset()
    Computer.reset()
    Ball.reset()

    Keyboard.enableRepeatEvents(true)

    while(!Display.isCloseRequested()){
      Color.white.bind()
      this.render()
      this.step += 1
      Display.update()
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
  }

  def destroy() : Any = {
    Display.destroy()
  }

  def render() : Any = {
    GL11.glClear(GL11.GL_COLOR_BUFFER_BIT)
    GL11.glEnable(GL11.GL_BLEND)
    GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA)

    while(Keyboard.next()){
      if(Keyboard.getEventKeyState())
        this.input()
    }

    Stage.main()
    Player.main()
    Computer.main()
    Ball.main()
    GL11.glDisable(GL11.GL_BLEND)
  }

  def input(): Any = {
    val key_event = Keyboard.getEventKey() match {
      case Keyboard.KEY_UP => {
        if(Ball.isInMotion && Player.yVary > -375)
          Player.yVary = Player.yVary + (-1 * Player.speed)
      }
      case Keyboard.KEY_DOWN => {
        if(Ball.isInMotion && Player.yVary < 375)
          Player.yVary = Player.yVary + Player.speed
      }
      case Keyboard.KEY_SPACE => {
        Ball.setInMotion()
      }
      case Keyboard.KEY_R => {
        Display.destroy(); this.run()
      }
      case _ => false
    }
  }

  run()
}