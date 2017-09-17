package com.hackerrank.functional.intro

import scala.annotation.tailrec

/**
  * Created by raistlin on 9/16/2017.
  */
object EvaluateEToPowerX extends App {
  private def fact(n: Int): Int = {
    @tailrec
    def loop(acc:Int, x: Int): Int = if(x == 0) acc else loop(x * acc, x - 1)

    loop(1, n)
  }

  private def doubleTerm(x: Double, i: Int): Double = scala.math.pow(x, i) / fact(i).toDouble

  private def e2x(x: Double): Double = (0 to 9).toList.map(doubleTerm(x, _)).sum

  private def prn(x: Double): Unit = println(f"$x%.4f")

  val sc = new java.util.Scanner(System.in)
  (1 to sc.nextInt()).foreach { _ => prn(e2x(sc.nextDouble())) }
}
