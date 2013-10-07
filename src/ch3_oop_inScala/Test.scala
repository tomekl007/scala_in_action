package ch3_oop_inScala

/**
 * Created with IntelliJ IDEA.
 * User: tomaszlelek
 * Date: 9/20/13
 * Time: 1:54 PM
 * To change this template use File | Settings | File Templates.
 */
class Test extends App {
  override def main(args: Array[String]) {
    val root = Role("root")
    val analyst = Role("analyst")
    println("root : " + root + " analyst : " + analyst )
  }
}