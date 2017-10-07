package com.hackerrank.functional.intro

object ListLength extends App {
  def f(arr : List[Int]): Int = arr.map(i => 1).sum

  println(f(List(2,4,5,6,7,4)))
  println(f(List(3,4,5)))
}
