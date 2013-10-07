import ch4.functional_data_structures.Maybe



//some supertype of A
def defaultToNull[A <: Maybe[_]](p: A) = {
  p.getOrElse(null)
}

  final case class Just[A](value: A) extends Maybe[A] {
    def isEmpty = false
    def get = value
  }
  case object Nil extends Maybe[scala.Nothing] {
    def isEmpty = true
    def get = throw new NoSuchElementException("Nil.get")
  }

//
//def position[A](xs: List[A], value: A): Just[A] = {
//  Just(xs.indexOf(value))
//}
//position(List(), "something").getOrElse(-1)

