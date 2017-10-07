package com.hackerrank.functional.recursion

import scala.annotation.tailrec

/**
  * Created by raistlin on 9/16/2017.
  */
object Fibonacci extends App {
  // 0 1 1 2 3 5 8 13
  @tailrec
  def loop(x: Int, a: Int, b: Int): Int = if(x == 1) b else loop(x - 1, a + b, a)

  def get(x: Int): Int = {
    loop(x, 1, 0)
  }

  println(get(1))
  println(get(2))
  println(get(3))
  println(get(4))
  println(get(5))

}
