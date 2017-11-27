package com.hackerrank.functional.recursion

import scala.annotation.tailrec

/**
  * Created by raistlin on 9/16/2017.
  */
object GCD extends App {
  @tailrec
  def gcd(x: Int, y: Int): Int = if(x == y) x else if(x > y) gcd(x - y, y) else gcd(x, y - x)

  println(gcd(1,5))
  println(gcd(10,100))
  println(gcd(22,131))
  println(gcd(14,21))
  println(gcd(21,14))
  println(gcd(54,45))
}
