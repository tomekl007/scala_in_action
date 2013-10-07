package ch8_build_reusable_components

/**
 * Created with IntelliJ IDEA.
 * User: tomaszlelek
 * Date: 10/3/13
 * Time: 3:27 PM
 * To change this template use File | Settings | File Templates.
 */
/*
class PRocessPayment {

}

case class Employee(name: String, id: Long)
trait Payroll {
  def processEmployees(
                        employees: Vector[Employee]): Either[String, Throwable]
}
//class USPayroll extends Payroll {
//  def processEmployees(employees: Vector[Employee]) = ...
//
//}
class CanadaPayroll extends Payroll {
  def processEmployees(employees: Vector[Employee]) = ...
}

case class Employee(name: String, id: Long)
case class Contractor(name: String)
trait Payroll extends ch8_build_reusable_components.Payroll {
  def processEmployees(
                        employees: Vector[Employee]): Either[String, Throwable]
  def processContractors(
                          contractors: Vector[Contractor]): Either[String, Throwable]
}

//when add new : ProcessJapanContractors you must add new function to Payroll, so recompile base code
*/