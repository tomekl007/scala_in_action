/**
 * Created with IntelliJ IDEA.
 * User: tomaszlelek
 * Date: 10/3/13
 * Time: 12:32 PM
 * To change this template use File | Settings | File Templates.
 */
import java.util.{ArrayList => JList}
val jList = new JList[Int]()

jList.add(1)

jList.add(2)


import scala.collection.JavaConverters._
jList.asScala foreach println

List(1, 2).asJava

trait Summable[A] {
  def plus(a1: A, a2: A): A
  def init: A
}

object IntSummable extends Summable[Int] {
  def plus(a1: Int, a2: Int): Int = a1 + a2
  def init: Int = 0
}
object StringSummable extends Summable[String] {
  def plus(a1: String, a2: String): String = a1 + a2
  def init: String = ""
}

trait Foldable[F[_]] {
  def foldLeft[A](xs: F[A], m: Summable[A]) : A
}

object ListFoldLeft extends Foldable[List] {
  def foldLeft[A](xs:List[A],m:Summable[A]) =
    xs.foldLeft(m.init)(m.plus)
}
object ArrayFoldLeft extends Foldable[Array] {
  def foldLeft[A](xs:Array[A],m:Summable[A]) =
    xs.foldLeft(m.init)(m.plus)
}

def sum[F[_], A](xs: F[A], f: Foldable[F], m: Summable[A]): A =
  f.foldLeft(xs, m)

sum(List(1, 2, 3), ListFoldLeft, IntSummable)
sum(Array("one", "two", "three"), ArrayFoldLeft, StringSummable)
