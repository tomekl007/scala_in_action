package ch4_functionalProgramming

/**
 * Created with IntelliJ IDEA.
 * User: tomaszlelek
 * Date: 9/6/13
 * Time: 10:49 AM
 * To change this template use File | Settings | File Templates.
 */
object FunctionalDI {
  //Stratgey pattern
  def calculatePrice(product: String, taxingStrategy: String => Double) = {
    val tax = taxingStrategy(product)
  }

  //DI in functional style
  trait TaxStrategy {def taxIt(product: String): Double }
  class ATaxStrategy extends TaxStrategy {
    def taxIt(product: String): Double = 10.0
  }
  class BTaxStrategy extends TaxStrategy {
    def taxIt(product: String): Double = 20.0
  }

  def main(args: Array[String]) {
    def taxIt: TaxStrategy => String => Double = s => p => s.taxIt(p)

    def taxIt_a: String => Double = taxIt(new ATaxStrategy)
    println(taxIt_a("normal"))
    def taxIt_b: String => Double = taxIt(new BTaxStrategy)
    println(taxIt_b("higher val"))

  }

}
