/**
 * Created with IntelliJ IDEA.
 * User: tomaszlelek
 * Date: 9/25/13
 * Time: 4:02 PM
 * To change this template use File | Settings | File Templates.
 */

case class Artist(name: String, genre: String)
val artists = List(Artist("Pink Floyd", "Rock"),
  Artist("Led Zeppelin", "Rock"),
  Artist("Michael Jackson", "Pop"),
  Artist("Above & Beyond", "trance")
)

for(Artist(name, genre) <- artists; if(genre == "Rock"))
yield name
case class ArtistWithAlbums(artist: Artist, albums: List[String])
val artistsWithAlbums = List(
  ArtistWithAlbums(Artist("Pink Floyd", "Rock"),
    List("Dark side of the moon", "Wall")),
  ArtistWithAlbums(Artist("Led Zeppelin", "Rock"),
    List("Led Zeppelin IV", "Presence")),
  ArtistWithAlbums(Artist("Michael Jackson", "Pop"),
    List("Bad", "Thriller")),
  ArtistWithAlbums(Artist("Above & Beyond", "trance"),
    List("Tri-State", "Sirens of the Sea"))
)





for { ArtistWithAlbums(artist, albums) <- artistsWithAlbums
      album <- albums
      if(artist.genre == "Rock")
} yield album

val artists2 = Map("Pink Floyd" -> "Rock", "Led Zeppelin" -> "Rock", "Michael Jackson" -> "Pop", "Above & Beyond" -> "Trance")

artists2.get("Abba")

def throwableToLeft[T](block: => T):Either[Throwable, T] =
  try {
    Right(block)
  } catch {
    case ex:Throwable => Left(ex)
  }
val r = throwableToLeft {
  new java.net.Socket("localhost", 4444)
}

r match {
  case Left(e) => e.printStackTrace
  case Right(e) => println(e)
}



