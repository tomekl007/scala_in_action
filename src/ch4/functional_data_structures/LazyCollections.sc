/**
 * Created with IntelliJ IDEA.
 * User: tomaszlelek
 * Date: 9/26/13
 * Time: 9:53 AM
 * To change this template use File | Settings | File Templates.
 */
//strict
val newList = List(1, 2, 3, 4, 5).map( _ + 1)
//non-strict
List(1, 2, 3, 4, 5).view.map( _ + 1).head

import scala.collection.parallel.ForkJoinTaskSupport
import scala.io._
import scala.xml.XML
def tweets(handle: String) = {
  println("processing tweets for " + handle)
  val source = Source.fromURL(new
      java.net.URL("http://search.twitter.com/search.atom?q=" + handle))
  val iterator = source.getLines()
  val builder = new StringBuilder
  for(line <- iterator) builder.append(line)
  XML.loadString(builder.toString)
}


//val allTweets = Map("nraychaudhuri" -> tweets("nraychaudhuri"),
//  "ManningBooks" -> tweets("ManningBooks"),
//  "bubbl_scala" -> tweets("bubbl_scala")
//)
val allTweets2 = Map(
  "nraychaudhuri" -> tweets _ , "ManningBooks" -> tweets _,
  "bubbl_scala" -> tweets _)



//normal func
//tweets("ManningBooks")
//partial func
tweets _
//allTweets2.view.map{ t => t._2(t._1)}.head
List("zero", "one", "two", "three", "four",
  "five").zip(Stream.from(0))


//def fib(n: Int): Int = n match {
//  case 0 => 0
//  case 1 => 1
//  case n => fib(n - 1) + fib(n - 2)
//}
import scala.collection.parallel.immutable._
ParVector(10, 20, 30, 40, 50, 60, 70, 80, 90).map {x =>
  println(Thread.currentThread.getName); x / 2 }










val pv = ParVector(1,2,3)
pv.tasksupport  = new ForkJoinTaskSupport(new scala.concurrent.forkjoin.ForkJoinPool(3))




val fib: Stream[Int] = Stream.cons(0, Stream.cons(1,
  fib.zip(fib.tail).map(t => t._1 + t._2)))


val vs = Vector.range(1, 100000)
vs.par.filter(_ % 2 == 0)
//
Vector.range(1, 100000).par.filter(_ % 2 == 0).seq



fib(14)









