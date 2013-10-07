package ch4.functional_data_structures

import scala.annotation.tailrec

/**
 * Created with IntelliJ IDEA.
 * User: tomaszlelek
 * Date: 9/25/13
 * Time: 12:49 PM
 * To change this template use File | Settings | File Templates.
 */
object FuncDataStruct {

  def main(args: Array[String]) {

    def map[A, B](xs: List[A], f: A => B): List[B] = {
      xs match {

        case head :: tail => f(head) :: map(tail, f)
        case _ => List()
      }
    }

    def addOne(num: Int) = {
      def ++ = (x:Int) => x + 1
      ++(num)
    }
    map(List(1, 2, 3), addOne)
    def map1[A, B](f: A => B, xs: List[A]): List[B] = for(x <- xs) yield f(x)
    List("one","two", "three", "") flatMap { _.toList }


    def flatten[B](xss: List[List[B]]): List[B] = {
      xss match {
        case head :: tail => head ::: flatten(tail)
        case _ => List()
      }
    }
    def flatMap[A, B](xs: List[A])(f: A => List[B]) : List[B] = {
      flatten3(map(xs, f))
    }

   println(flatMap(List("one", "two", "three")) { _.toList })


    def map2[A, B](xs: List[A])(f: A => B): List[B] = {
      val startValue = List.empty[B]
      xs.foldRight(startValue) { f(_) :: _ }
    }
    def flatten2[B](xss: List[List[B]]): List[B] = {
      val startValue = List.empty[B]
      xss.foldRight(startValue) { _ ::: _ }
    }
    def map3[A, B](xs: List[A])(f: A => B): List[B] = {
      val startValue = List.empty[B]
      xs.foldLeft(startValue)((a, x) => f(x) :: a).reverse
    }
    println(List(1, 2, 3, 4).foldLeft(0) { _ + _ })
    println(List(1, 2, 3, 4).foldLeft(0) { (a, b) => a + 1 })

    println(map2(List(1,2,3)){x:Int => x + 2})

    object ++ extends Function1[Int, Int]{
      def apply(p: Int): Int = p + 1
    }
     //same as
    object s extends (Int => Int) {
      def apply(p: Int): Int = p + 1
    }
    val addOnee: Int => Int = x => x + 1
    val addTwo: Int => Int = x => x + 2
    val addThree = addOnee compose addTwo
    println(addThree(3))

    val addThreee: Int => Int = x => addOnee(addTwo(x))


  }




  def flatten3[B](xss: List[List[B]]): List[B] = {
    @tailrec
    def _flatten3(oldList: List[List[B]], newList: List[B]): List[B] =
      oldList match {
        case List() => newList
        case head :: tail => _flatten3(tail, newList ::: head)
      }
    _flatten3(xss, Nil)
  }




}
