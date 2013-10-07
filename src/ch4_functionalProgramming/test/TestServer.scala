package ch4_functionalProgramming.test


import scala.io._
import ch4_functionalProgramming.{Server, Pure}
import Pure._

/**
 * Created with IntelliJ IDEA.
 * User: tomaszlelek
 * Date: 9/6/13
 * Time: 11:26 AM
 * To change this template use File | Settings | File Templates.
 */
object TestServer {

  def main(args: Array[String]) {
    val response = get("GET /test.txt HTTP/1.0\n".toIterator)(name => Server.IOResource(name))
    println(response)
  }

}
