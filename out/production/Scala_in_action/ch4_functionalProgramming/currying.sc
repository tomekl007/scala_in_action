import scala.annotation.tailrec

/**
 * Created with IntelliJ IDEA.
 * User: tomaszlelek
 * Date: 9/26/13
 * Time: 3:22 PM
 * To change this template use File | Settings | File Templates.
 */
trait TaxStrategy { def taxIt(product: String): Double }
val taxIt: (TaxStrategy, String) => Double = (s, p) => s.taxIt(p)
taxIt.curried
//same
taxIt _
class TaxFree extends TaxStrategy { override def taxIt(product:
                                                      String) = 0.0 }
val taxFree = taxIt.curried(new TaxFree)
taxFree("someProduct")


def intToChar: PartialFunction[Int, Char] = {
  case 1 => 'a'
  case 3 => 'c'
}

sealed trait Claim { val claimId: Int }
case class Full(val claimId: Int) extends Claim
case class Partial(val claimId: Int, percentage: Double) extends Claim
case class Generic(val claimId: Int) extends Claim

case class Location(stateCode: Option[String], zipCode: Option[String])
case class Req(productId: String, location: Location, claim: Claim)

type PC = Tuple2[Req, Option[Double]]

//def handleFullClaim: PartialFunction[PC, PC] = {
//  case (c@Req(id, l, Full(claimId)), basePrice) => PartialFunction
//
//}

def sum(xs: List[Int]): Int = xs match {
  case Nil => 0
  case x :: ys => x + sum(ys)
}

def removeDups[A](xs: List[A]): List[A] = xs match {
  case Nil => Nil
  case x :: ys if(ys.contains(x)) => removeDups(ys)
  case x :: ys => removeDups(ys) :+ x
}

removeDups(List(1,2,4,5,4,2))

//head recursion
def length[A](xs: List[A]): Int = xs match {
  case Nil => 0
  case x :: ys => 1 + length(ys)
}

def length2[A](xs: List[A]): Int = {
  @tailrec
  def _length(xs: List[A], currentLength: Int): Int = xs match {
    case Nil => currentLength
    case x :: ys => _length(ys, currentLength + 1)
  }
  _length(xs, 0)
}



