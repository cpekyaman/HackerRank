package com.hackerrank.functional.recursion

/**
  * Created by raistlin on 9/17/2017.
  */
object PascalsTriangle extends App {
  private def col(n: Int, r: Int): Int = Factorial.get(n) / (Factorial.get(r) * Factorial.get(n - r))

  private def row(n: Int): Seq[Int] = for(r <- 0 to n) yield col(n, r)

  def create(n: Int): Unit = {
    (0 until n).map(row).map(_.mkString(" ")).foreach(println)
  }

  create(scala.io.StdIn.readInt())
}
