package ch8_build_reusable_components

import ch8_build_reusable_components.solution.JapanPayrollSystem

/**
 * Created with IntelliJ IDEA.
 * User: tomaszlelek
 * Date: 10/3/13
 * Time: 3:21 PM
 * To change this template use File | Settings | File Templates.
 */
class VisitorPattern {
  case class USPayroll {
    def accept(v: PayrollVisitor) = v.visit(this)
  }
  case class CanadaPayroll {
    def accept(v: PayrollVisitor) = v.visit(this)
  }
  trait PayrollVisitor {
    def visit(payroll: USPayroll): Either[String, Throwable]
    def visit(payroll: CanadaPayroll): Either[String, Throwable]
  }
  class EmployeePayrollVisitor extends PayrollVisitor {
    def visit(payroll: USPayroll): Either[String, Throwable] = Left("employeeUS")
    def visit(payroll: CanadaPayroll): Either[String, Throwable] = Left("employeeCanada")
  }

  class ContractorPayrollVisitor extends PayrollVisitor {
    def visit(payroll: USPayroll): Either[String, Throwable] = Left("contractreUS")
    def visit(payroll: CanadaPayroll): Either[String, Throwable] = Left("contaracCanada")
  }

}

trait PayrollSystem {
  case class Employee(name: String, id: Long)
  type P <: Payroll
  trait Payroll {
    def processEmployees(
                          employees: Vector[Employee]): Either[String, Throwable]
  }
  def processPayroll(p: P): Either[String, Throwable]
}

trait USPayrollSystem extends PayrollSystem {
  class USPayroll extends Payroll {
    def processEmployees(employees: Vector[Employee]) =
      Left("US payroll")
  }
}

trait CanadaPayrollSystem extends PayrollSystem {
  class CanadaPayroll extends Payroll {
    def processEmployees(employees: Vector[Employee]) =
      Left("Canada payroll") }
}

/*
object USPayrollInstance extends USPayrollSystem {
  type P = USPayroll
  def processPayroll(p: USPayroll) = {
    val employees: Vector[Employee] =  Vector(new Employee("name", 2))
    val result = p.processEmployees(employees)

  }
} */

/*
trait JapanPayrollSystem extends PayrollSystem {
  class JapanPayroll extends Payroll {
    def processEmployees(employees: Vector[Employee])
  }
}

*/
trait ContractorPayrollSystem extends PayrollSystem {
  type P <: Payroll
  case class Contractor(name: String)
  trait Payroll extends super.Payroll {
    def processContractors(
                            contractors: Vector[Contractor]): Either[String, Throwable]
  }
}

trait USContractorPayrollSystem extends USPayrollSystem with
ContractorPayrollSystem {
  class USPayroll extends super.USPayroll with Payroll {
    def processContractors(contractors: Vector[Contractor]) =
      Left("US contract payroll")
  }
}
trait CanadaContractorPayrollSystem extends CanadaPayrollSystem with
ContractorPayrollSystem {
  class CanadaPayroll extends super.CanadaPayroll with Payroll {
    def processContractors(contractors: Vector[Contractor]) =
      Left("Canada contract payroll")
  }
}
         /*
trait JapanContractorPayrollSystem extends JapanPayrollSystem with
ContractorPayrollSystem {
  class JapanPayroll extends super.JapanPayroll with Payroll {
    def processContractors(contractors: Vector[Contractor]) =
      Left("Japan contract payroll")
  }
}

object main{
  def main(args: Array[String]) {
    USPayrollInstance.processPayroll()
  }
}
         */