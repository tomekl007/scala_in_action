package ch8_build_reusable_components

/**
 * Created with IntelliJ IDEA.
 * User: tomaszlelek
 * Date: 10/5/13
 * Time: 9:39 AM
 * To change this template use File | Settings | File Templates.
 */
class StructuralTypes {


  def close(closable: { def close: Unit }) = {
    closable.close
  }

  trait objectWithMethodClose {
    def close:Unit


  }

  def main(args: Array[String]) {
    type Closable = { def close: Unit }
    close(new objectWithMethodClose {
      def close: Unit = println("close")
    })

    amountPaidAsSalary(Vector(new SalariedWorker {
      def salary: BigDecimal = 1
    }))

    amountPaidAsSalary2(Vector(new SalariedWorker {
      def salary: BigDecimal = 4
    }))
   }

  trait SalariedWorker {
    def salary: BigDecimal
  }

  def amountPaidAsSalary(workers: Vector[SalariedWorker]) = {

  }
  def amountPaidAsSalary2(workers: Vector[{def salary: BigDecimal }]) = {

  }
}


