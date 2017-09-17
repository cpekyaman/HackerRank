package com.hackerrank.functional.intro

import scala.util.Random

/**
  * Created by raistlin on 9/15/2017.
  */
object ArrayOfNElements extends App {
  def generate(sz: Int): List[Int] = List.fill(sz)(new Random().nextInt(100))

  print(generate(new Random().nextInt(20)))
}
