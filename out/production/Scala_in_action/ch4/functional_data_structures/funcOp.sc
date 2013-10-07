/**
 * Created with IntelliJ IDEA.
 * User: tomaszlelek
 * Date: 9/25/13
 * Time: 12:45 PM
 * To change this template use File | Settings | File Templates.
 */

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
 flatten(map(xs, f))
}




flatMap(List("one", "two", "three")) { _.toList }



