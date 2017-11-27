package com.hackerrank.functional.intro

object PolygonArea extends App {
  case class Coord(x : Int, y: Int) {
    def areaTerm(o: Coord): Double = x * o.y - y * o.x
  }

  private def any2Int(x: Any): Int = x.asInstanceOf[Long].toInt

  private def tuple2Coord(tuple: (Any, Any)): Coord = Coord(any2Int(tuple._1), any2Int(tuple._2))

  private def calculateArea(numOfPoints: Int): Double = {
    if(numOfPoints == 0) return 0.0

    val coords = for(p <- 1 to numOfPoints) yield {
      tuple2Coord(scala.io.StdIn.readf2("{0,number,integer} {1,number,integer}"))
    }

    (coords, coords.drop(1) :+ coords.head).zipped.map(_.areaTerm(_)).sum.abs / 2.0
  }

  val area = calculateArea(scala.io.StdIn.readInt())
  println(f"$area%.1f")
}
