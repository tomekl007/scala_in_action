/**
 * Created with IntelliJ IDEA.
 * User: tomaszlelek
 * Date: 9/26/13
 * Time: 10:57 AM
 * To change this template use File | Settings | File Templates.
 */
def tap[A](a: A)(sideEffect: A => Unit): A = {
  sideEffect(a)
  a
}
  /*
val x = Person(firstName, lastName)
tap(x) { p =>
  import p._
  setInfo(someInfo)
  println("log: new person is created")
  mailer.mail("new person joined " + x)
}.firstName */

//val in = Console.readLine("Type Either a string or an Int: ")
val in = "sd"
val result: Either[String,Int] = try {
  Right(in.toInt)
} catch {
  case e: Exception =>
    Left(in)
}
println( result match {
  case Right(x) => "You passed me the Int: " + x + ", which I will increment. " + x + " + 1 = " + (x+1)
  case Left(x) => "You passed me the String: " + x
})

