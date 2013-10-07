package ch3_oop_inScala

/**
 * Created with IntelliJ IDEA.
 * User: tomaszlelek
 * Date: 9/20/13
 * Time: 1:49 PM
 * To change this template use File | Settings | File Templates.
 */
abstract class Role { def canAccess(page: String): Boolean }
class Root extends Role {
  override def canAccess(page:String) = true
}
class SuperAnalyst extends Role {
  override def canAccess(page:String) = page != "Admin"
}
class Analyst extends Role {
  override def canAccess(page:String) = false }
object Role {
  def apply(roleName:String) = roleName match {
    case "root" => new Root
    case "superAnalyst" => new SuperAnalyst
    case "analyst" => new Analyst
  }
}

