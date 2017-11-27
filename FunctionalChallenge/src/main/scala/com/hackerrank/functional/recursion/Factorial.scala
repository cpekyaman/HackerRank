package com.hackerrank.functional.recursion

import scala.annotation.tailrec

object Factorial extends App {
  @tailrec
  def loop(acc: Int, n: Int): Int = if(n == 0) acc else loop(acc * n, n -1)

  def get(n: Int): Int = loop(1, n)

  println(get(0))
  println(get(4))
  println(get(6))

}
