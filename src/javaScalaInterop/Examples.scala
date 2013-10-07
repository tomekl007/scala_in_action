package javaScalaInterop

/**
 * Created with IntelliJ IDEA.
 * User: tomaszlelek
 * Date: 10/3/13
 * Time: 11:44 AM
 * To change this template use File | Settings | File Templates.
 */
object Examples {
  def main(args: Array[String]) {


    import java.util.{ArrayList => JList}
    val jList = new JList[Int]()

    jList.add(1)

    jList.add(2)


    import scala.collection.JavaConverters._
    jList.asScala foreach println
    List(1, 2).asJava

  }

}
