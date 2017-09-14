package com.hackerrank.funcional.intro

/**
  * Created by raistlin on 9/15/2017.
  */
object SumOfOddElements extends App {
  def fn(arr:List[Int]):Int = arr.filter(_ % 2 != 0).sum

  println(fn(List(3,2,4,6,5,7,8,0,1)))

  println(fn(List(-3,2,4,6,-5,7,8,0,-1)))
}
