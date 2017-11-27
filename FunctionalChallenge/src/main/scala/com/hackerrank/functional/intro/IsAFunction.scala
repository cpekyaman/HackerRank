package com.hackerrank.functional.intro

import scala.io.StdIn

object IsAFunction extends App {
  case class Pair(x : Int, y: Int)

  private def any2Int(x: Any): Int = x.asInstanceOf[Long].toInt

  private def tuple2Pair(tuple: (Any, Any)): Pair = Pair(any2Int(tuple._1), any2Int(tuple._2))

  private def checkIsFunction(iter: Int): Unit = {
    val pairs = for(p <- 1 to scala.io.StdIn.readInt()) yield {
      tuple2Pair(StdIn.readf2("{0,number,integer} {1,number,integer}"))
    }

    // 1. for each x find list of y values (groupby)
    // 2. convert map of (x,Seq[Pair]) to (x,Seq[Int]) (mapvalues)
    // 3. create x -> f(x) unique values (distinct)
    // 4. check if any keys which violates the rule (exists)
    val notAFunc = pairs.groupBy(_.x).mapValues(_.map(_.y).distinct).exists(_._2.size > 1)
    if(notAFunc) println("NO") else println("YES")
  }

  (1 to scala.io.StdIn.readInt()).foreach(checkIsFunction)
}
