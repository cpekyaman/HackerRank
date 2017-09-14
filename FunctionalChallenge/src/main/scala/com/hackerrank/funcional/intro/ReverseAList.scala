package com.hackerrank.funcional.intro

/**
  * Created by raistlin on 9/15/2017.
  */
object ReverseAList extends App {
  def reverse(arr: List[Int]): List[Int] = arr.foldRight(List.empty[Int])( (a, b) =>  b :+ a)

  println(reverse(List(1,2,3,4,5)))
}
