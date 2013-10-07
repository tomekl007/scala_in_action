package ch4_functionalProgramming

/**
 * Created with IntelliJ IDEA.
 * User: tomaszlelek
 * Date: 10/3/13
 * Time: 10:05 AM
 * To change this template use File | Settings | File Templates.
 */
object PartialFunc {

  def main(args: Array[String]) {

    def even: Int => Boolean = _ % 2 == 0
    def not: Boolean => Boolean = !_
    def filter[A](criteria: A => Boolean)(col: Traversable[A])=
      col.filter(criteria)
    def map[A, B](f: A => B)(col: Traversable[A]) = col.map(f)

    def evenFilter = filter(even) _
    def double: Int => Int = _ * 2

    def doubleAllEven = evenFilter andThen map(double)   //order of execution is left to right

    println(doubleAllEven(List(1,2,3,4,5,6)))

    def odd: Int => Boolean = not compose even //order of execution is right to left
    def oddFilter = filter(odd) _
    def doubleAllOdd = oddFilter andThen map(double)
    println(doubleAllOdd(List(1,2,3,4,5,6)))
  }

}
