package com.hackerrank.functional.intro

object PolygonPerimeter extends App {
  case class Coord(x : Int, y: Int) {
    def distance(o: Coord): Double = Math.sqrt(Math.pow(x - o.x, 2) + Math.pow(y - o.y, 2))
  }

  private def any2Int(x: Any): Int = x.asInstanceOf[Long].toInt

  private def tuple2Coord(tuple: (Any, Any)): Coord = Coord(any2Int(tuple._1), any2Int(tuple._2))

  private def calculatePerimeter(numOfPoints: Int): Double = {
    if(numOfPoints == 0) return 0.0

    val coords = for(p <- 1 to numOfPoints) yield {
      tuple2Coord(scala.io.StdIn.readf2("{0,number,integer} {1,number,integer}"))
    }

    (coords.last +: coords.dropRight(1), coords).zipped.map(_.distance(_)).sum
  }

  val perimeter = calculatePerimeter(scala.io.StdIn.readInt())
  println(f"$perimeter%.1f")
}
