//10. Illustrate the implementation by writing scala code to generate a down counter from 10 to 1.


object DownCounterForLoop {
  def main(args: Array[String]): Unit = {
    // Down counter using for loop
    for (i <- 10 to 1 by -1) {
      println(i)
    }
  }
}
