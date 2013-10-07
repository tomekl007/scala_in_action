package ch8_build_reusable_components

/**
 * Created with IntelliJ IDEA.
 * User: tomaszlelek
 * Date: 10/3/13
 * Time: 2:44 PM
 * To change this template use File | Settings | File Templates.
 */
trait DbConnection{}


trait Calculator {
  def initialize: DbConnection
  def close(s: DbConnection): Unit
  def calculate(productId: String):Double = {
  val s = initialize
  val price = calculate(s, productId)
  close(s)
  price
}
def calculate(s: DbConnection, productId: String): Double
}

package abstractMember {
trait Calculator {
  type S
  def initialize: S
  def close(s: S): Unit
  def calculate(productId: String): Double = {
    val s = initialize
    val price = calculate(s, productId)
    close(s)
    price
  }
  def calculate(s: S, productId: String): Double
  }
}

class MongoClient() extends DbConnection {
  def close = {}
}

        /*
class CostPlusCalculator extends Calculator {
  type S = MongoClient
  def initialize = new MongoClient()
  def close(dao: MongoClient) = dao.close
  def calculate(source: MongoClient, productId: String) = {
    //...
  }
}  */
