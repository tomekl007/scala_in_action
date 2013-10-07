package ch4_functionalProgramming

/**
 * Created with IntelliJ IDEA.
 * User: tomaszlelek
 * Date: 9/6/13
 * Time: 10:33 AM
 * To change this template use File | Settings | File Templates.
 */
object PureFunctionalProgram {
  def main(args: Array[String]):Unit = {
    val r = singleExpression(args.toList)
    println(r)

    //pure square test
    val pureSquare = new PureSquare(2)
    println(pureSquare.area)
    val newSquare = pureSquare.newSide(4)
    println(pureSquare.area)
    println(newSquare.area)

  }
  def singleExpression: List[String] => (List[Int], List[Int]) = { a =>
    a map (_.toInt) partition (_ < 30)
  }
}

