package com.hackerrank.functional.intro

/**
  * Created by raistlin on 9/10/2017.
  */
object FilterArray extends App {
  // arr.foldRight(List[Int]())({case(v,l)=> if(v >= delim) l else v::l
  def f(delim: Int, arr: List[Int]): List[Int] = for(a <- arr if a < delim) yield a

  val delim = scala.io.StdIn.readInt
  val numbers = io.Source.stdin.getLines().takeWhile(_ != "").map(_.toInt).toList

  print(f(delim, numbers))
}
