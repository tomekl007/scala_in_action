/**
 * Created with IntelliJ IDEA.
 * User: tomaszlelek
 * Date: 9/25/13
 * Time: 3:31 PM
 * To change this template use File | Settings | File Templates.
 */
import java.util.{Collection => JCollection, ArrayList }
class JavaToTraversable[E](javaCollection: JCollection[E]) extends
Traversable[E] {
  def foreach[U](f : E => U): Unit = {
    val iterator = javaCollection.iterator
    while(iterator.hasNext) {
      f(iterator.next)
    }
  }
}

val jCol = new ArrayList[Int]
(1 to 5) foreach { jCol.add(_) }
jCol
val jtoT = new JavaToTraversable(jCol)
jtoT map { _ * 10 } filter { _ > 20 }
Iterable(1, 2, 3, 4, 5) dropRight 2

val languages = Seq("Scala", "Haskell", "OCaml", "ML")
val default: PartialFunction[Int, String] = {
  case _ => "Is it a functional language?" }
val languagesWithDefault = languages orElse default
languagesWithDefault(12)

val m = Map((1, "1st"), (2, "2nd"))
m(1)
val artists = Map(
  "Pink Floyd" -> "Rock", "Led Zeppelin" -> "Rock",
  "Michael Jackson" -> "Pop", "Above & Beyond" -> "Trance")

artists filter { (t) => t._2 == "Rock" }

for(t <- artists; if(t._2 == "Rock")) yield t


