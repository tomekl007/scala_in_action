import ch3_oop_inScala.Role

/**
 * Created with IntelliJ IDEA.
 * User: tomaszlelek
 * Date: 9/20/13
 * Time: 1:56 PM
 * To change this template use File | Settings | File Templates.
 */

val role = Role("root")
println(role)
val analys = Role("analyst")

object functor{
  def apply(some:String){
    println(some)
  }
  def apply(x:Int, y:Int):Int = {
    return x + y
  }
  def apply[T, L](x:T, y:T, z:L){
  }
}
functor("some apply method")
println(functor(1,3))

//------ getOrElseUpdate------
def cacheUnderlyingMethod(i:Int):String = {
  println("get from underlying")
  return i.toString
}
val cache = scala.collection.mutable.Map[Int, String]()
def getFromCache(key:Int) = {
  cache.getOrElseUpdate(key, {cacheUnderlyingMethod(key)})
}
getFromCache(2)


//not hit underlying method because is stored in cache already
getFromCache(2)

trait Number


case class Third(arg:String) extends Number
case class First(arg:Third) extends Number{
  def next():Number = {
      return arg
  }
}
case class Second(arg1:Int,arg2:Int) extends Number


def matching(nr:Number){
  nr match{
    case First(arg) =>  matching(arg)
    case Second(arg,arg2) => println(arg + " " + arg2)
    case Third(string) => println("string " + string)
    case _ => println("no number")
  }
}
matching(First(new Third("third")))

