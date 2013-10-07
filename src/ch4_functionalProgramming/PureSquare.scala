package ch4_functionalProgramming

/**
 * Created with IntelliJ IDEA.
 * User: tomaszlelek
 * Date: 9/6/13
 * Time: 10:43 AM
 * To change this template use File | Settings | File Templates.
 */
class PureSquare(val side: Int) {
  def newSide(s: Int): PureSquare = new PureSquare(s)
  def area = side * side
}
