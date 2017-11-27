package com.hackerrank.functional.intro

/**
  * Created by raistlin on 9/16/2017.
  */
object UpdateList extends App {
  def f(arr:List[Int]): List[Int] = arr.map(_.abs)

  println(f(List(-3,4,5,-23,-1,0,-5)))
}
