package com.hackerrank.funcional.intro

/**
  * Created by raistlin on 9/10/2017.
  */
object ListReplication extends App {
  def f(num: Int, arr: List[Int]): List[Int] = arr.foldLeft(List[Int]())(_ ::: List.fill(num)(_))

  val replicas = scala.io.StdIn.readInt
  val numbers = io.Source.stdin.getLines().takeWhile(_ != "").map(_.toInt).toList

  print(f(replicas, numbers))
}
