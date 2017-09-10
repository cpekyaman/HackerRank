package com.hackerrank.funcional.intro

/**
  * Created by raistlin on 9/10/2017.
  */
object HelloWorldNTimes extends App {
  def f(n: Int) = (1 to n).foreach(_ => println("Hello World"))

  f(scala.io.StdIn.readInt)
}
