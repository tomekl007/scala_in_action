package ch4.functional_data_structures

/**
 * Created with IntelliJ IDEA.
 * User: tomaszlelek
 * Date: 9/25/13
 * Time: 11:33 AM
 * To change this template use File | Settings | File Templates.
 */
//contravariant parameter A so subclasses can return more specialized types
//sealed
 abstract class Maybe[+A] {
  def isEmpty: Boolean
  def get: A
  //B is some super type to A
  def getOrElse[B >: A](default: B): B = {
    if(isEmpty) default else get
  }
}