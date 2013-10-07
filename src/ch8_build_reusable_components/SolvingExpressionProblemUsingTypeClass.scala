package ch8_build_reusable_components

import ch8_build_reusable_components.PayrollSystemWithTypeclass.PayrollProcessor


/**
 * Created with IntelliJ IDEA.
 * User: tomaszlelek
 * Date: 10/7/13
 * Time: 12:48 PM
 * To change this template use File | Settings | File Templates.
 */
object SolvingExpressionProblemUsingTypeClass {


}

object PayrollSystemWithTypeclass {
  case class Employee(name: String, id: Long)
  trait PayrollProcessor[C[_], A] {
    def processPayroll(payees: Seq[A]): Either[String, Throwable]
  }
  case class USPayroll[A](
                           payees: Seq[A])(implicit processor: PayrollProcessor[USPayroll, A]) {
    def processPayroll = processor.processPayroll(payees)
  }
  case class CanadaPayroll[A](
                               payees: Seq[A])(implicit processor: PayrollProcessor[CanadaPayroll, A])
  {
    def processPayroll = processor.processPayroll(payees)
  }

}
object PayrollSystemWithTypeclassExtension {
  import PayrollSystemWithTypeclass._
  case class JapanPayroll[A](payees: Vector[A])(
    implicit processor: PayrollProcessor[JapanPayroll, A]) {
    def processPayroll = processor.processPayroll(payees)
  }
  case class Contractor(name: String)
}

object PayrollProcessors {
  import PayrollSystemWithTypeclass._
  implicit object USPayrollProcessor
    extends PayrollProcessor[USPayroll, Employee] {
    def processPayroll(
                        payees: Seq[Employee]) = Left("us employees are processed")
  }
  implicit object CanadaPayrollProcessor
    extends PayrollProcessor[CanadaPayroll, Employee] {
    def processPayroll(
                        payees: Seq[Employee]) = Left("canada employees are processed")
  }


  import PayrollSystemWithTypeclassExtension._


  implicit object USContractorPayrollProcessor
    extends PayrollProcessor[USPayroll, Contractor] {
    def processPayroll(payees: Seq[Contractor]) =
      Left("us contractors are processed")
  }
  implicit object CanadaContractorPayrollProcessor
    extends PayrollProcessor[CanadaPayroll, Contractor] {
    def processPayroll(payees: Seq[Contractor]) =
      Left("canada contractors are processed")
  }
  implicit object JapanContractorPayrollProcessor
    extends PayrollProcessor[JapanPayroll, Contractor] {
    def processPayroll(payees: Seq[Contractor]) =
      Left("japan contractors are processed")
  }
}





object PayrollProcessorsExtension {
  import PayrollSystemWithTypeclassExtension._
  import PayrollSystemWithTypeclass._
  implicit object JapanPayrollProcessor
    extends PayrollProcessor[JapanPayroll, Employee] {

    def processPayroll(payees: Seq[Employee]) =
      Left("japan employees are processed")
  }
}
//object RunPayroll {
//  import PayrollSystemWithTypeclass._
//  import PayrollProcessors._
//  def main(args: Array[String]): Unit = run
//  def run = {
//    val r = USPayroll(Vector(Employee("a", 1))).processPayroll
//    println(r)
//  }



object RunNewPayroll {
  import PayrollSystemWithTypeclass._
  import PayrollProcessors._
  import PayrollSystemWithTypeclassExtension._
  import PayrollProcessorsExtension._
  def main(args: Array[String]): Unit = run
  def run = {
    val r1 = JapanPayroll(Vector(Employee("a", 1))).processPayroll
    val r2 = JapanPayroll(Vector(Contractor("a"))).processPayroll

    println(r1 + " " + r2)
  }

}