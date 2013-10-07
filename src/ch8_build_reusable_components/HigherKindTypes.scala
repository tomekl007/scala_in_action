package ch8_build_reusable_components

import java.util.concurrent.BlockingQueue

/**
 * Created with IntelliJ IDEA.
 * User: tomaszlelek
 * Date: 10/5/13
 * Time: 10:08 AM
 * To change this template use File | Settings | File Templates.
 */
object HigherKindTypes {

  def fmap[A, B](xs: Vector[A], f: A => B): Vector[B] = xs map f

  def fmap[A, B](r: Option[A], f: A => B): Option[B] = r map f

  //how to abstract to one function

  trait Mapper[F[_]] {   //_ type of types
    def fmap[A, B](xs: F[A], f: A => B): F[B]
  }

  trait UnitMapper[F[_]]{
    def fmap[A, B](arg:A)(xs: (A) => B, f: (B) => A): Unit
  }

  def VectorMapper = new Mapper[Vector] {
    def fmap[A, B](xs: Vector[A], f: A => B): Vector[B] = xs map f
  }

  //Function0 take 0 arg
  def Function0Mapper = new Mapper[Function0] {
    def fmap[A, B](r: Function0[A], f: A => B) = new Function0[B] {
      def apply = f(r.apply)
    }
  }

                 /*
  def Function1Mapper = new UnitMapper[Function1]{
    def fmap[A, B](arg:A)(xs: (A) => B, f: (B) => A): Unit = {
      def apply = f(xs.apply(arg))
    }
  }                */

  val newFunction = Function0Mapper.fmap(() => "one",
    (s: String) => s.toUpperCase)

  //val newFunction2 = Function1Mapper.fmap(2)((x:Int)=> x*x,
  //  (y:Int) => y/2)

  def main(args: Array[String]) {
   println( newFunction() )
   //println(newFunction2 )
  }

     /*
  def fmap[A, B](r: Either[X, A], f: A => B): Either[X, B] = r match {
    case Left(a) => Left(a)
    case Right(a) => Right(f(a))
  }

  def EitherMapper[X] = new Mapper[({type E[A] = Either[X, A]})#E ] {
    def fmap[A, B](r: Either[X, A], f: A => B): Either[X, B] = r match
    {
      case Left(a) => Left(a)
      case Right(a) => Right(f(a))
    }
  }    */



}
