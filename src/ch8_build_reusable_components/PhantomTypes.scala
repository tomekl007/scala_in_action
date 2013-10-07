package ch8_build_reusable_components


import ch8_build_reusable_components.PhantomTypes.{OrderingSystem, Order}

/**
 * Created with IntelliJ IDEA.
 * User: tomaszlelek
 * Date: 10/5/13
 * Time: 10:45 AM
 * To change this template use File | Settings | File Templates.
 */
object PhantomTypes {



  sealed trait OrderCompleted
  sealed trait InCompleteOrder
  sealed trait ItemProvided
  sealed trait NoItem
  sealed trait AddressProvided
  sealed trait NoAddress
  case class Order[A, B, C](itemId: Option[String],
                            shippingAddress: Option[String])
  object Order {
    def emptyOrder = Order[InCompleteOrder, NoItem, NoAddress](None, None)
  }
  object OrderingSystem {
    def addItem[A, B](item: String, o: Order[A, NoItem, B]) =
      o.copy[A, ItemProvided, B](itemId = Some(item))
    def addShipping[A, B](address: String, o: Order[A, B, NoAddress]) =
      o.copy[A, B, AddressProvided](shippingAddress = Some(address))
    def placeOrder (o: Order[InCompleteOrder, ItemProvided, AddressProvided])=
    {
      o.copy[OrderCompleted, ItemProvided, AddressProvided]()
    }

  }



}

object Test {
  def main(args: Array[String]) {
    import OrderingSystem._
    val o = Order.emptyOrder
    val o1 = addItem("some book", o)
    val o2 = addShipping("some address", o1)
    placeOrder (o2)
  }
}
