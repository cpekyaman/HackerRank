package com.hackerrank.functional.intro

/**
  * Created by raistlin on 9/14/2017.
  */
object FilterPositionsInList extends App {
  def filterOddPositions(arr : List[Int]): List[Int] = arr.zipWithIndex.filter(_._2 % 2 != 0).map(_._1)

  println(filterOddPositions(List(2,5,3,4,6,7,9,8)))
}
