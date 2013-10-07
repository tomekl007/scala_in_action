package ch8_build_reusable_components

/**
 * Created with IntelliJ IDEA.
 * User: tomaszlelek
 * Date: 10/3/13
 * Time: 2:51 PM
 * To change this template use File | Settings | File Templates.
 */
trait OrderingSystem {
  type O <: Order
  type I <: Inventory
  type S <: Shipping
  trait Order {def placeOrder (i: I):Unit }
  trait Inventory { def itemExists(order: O): Boolean }
  trait Shipping {def scheduleShipping(order: O): Long }

  trait Ordering {this: I with S =>
    def placeOrder(o: O): Option[Long] = {
      if(itemExists(o)) {
        o.placeOrder (this)
        Some(scheduleShipping(o))
      }
      else None
    }
  }
}

object BookOrderingSystem extends OrderingSystem {
  type O = BookOrder
  type I = AmazonBookStore
  type S = UPS
  class BookOrder extends Order {
    def placeOrder(i: AmazonBookStore): Unit = {
      println("place order in amazonBookStore")
    }
  }
  trait AmazonBookStore extends Inventory {
    def itemExists(o: BookOrder) = true
  }
  trait UPS extends Shipping {
    def scheduleShipping(order: BookOrder): Long = {
      println("shipping sheduled to ")
      3
    }
  }



  def main(args: Array[String]) {
    object BookOrdering extends Ordering with AmazonBookStore with UPS

    BookOrdering.placeOrder(new BookOrder)


  }

}

