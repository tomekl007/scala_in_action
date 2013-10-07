package ch8_build_reusable_components.modelingOrthogonalConcerns

/**
 * Created with IntelliJ IDEA.
 * User: tomaszlelek
 * Date: 10/5/13
 * Time: 10:56 AM
 * To change this template use File | Settings | File Templates.
 */
object Test {

  trait XmlConverter[A] {
    def toXml(a: A): String
  }
  case class Movie(name: String, year: Int, rating: Double)
  object Converters {
    implicit object MovieConverter extends XmlConverter[Movie] {
      def toXml(a: Movie) = <movie>
        <name>{a.name}</name>
        <year>{a.year}</year>
        <rating>{a.rating}</rating>
      </movie>.toString
    }
    object MovieConverterWithoutRating extends XmlConverter [Movie] {
      def toXml(a: Movie) = <movie>
        <name>{a.name}</name>
        <year>{a.year}</year>
      </movie>.toString
    }
  }
  object Main {
    import Converters._

    def toXml[A](a: A)(implicit converter: XmlConverter[A]) =
      converter.toXml(a)
    def main(args: Array[String]) = {
      val p = Movie("Inception", 2010, 10)
      println(toXml(p))
      val p2 = Movie("Inception", 2010, 10)
      toXml(p2)(MovieConverterWithoutRating)
    }
  }

}
