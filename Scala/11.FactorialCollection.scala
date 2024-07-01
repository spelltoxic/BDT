//11. Design a scala function to perform factorial item in the given collection. The arguments passed to the function
// are the collection of items. Assume the type of the argument for the function suitably. The return type is to be integer.


object FactorialCollection {
  def factorial(n: Int): Int = {
    if (n < 0) throw new IllegalArgumentException("Factorial undefined for negative numbers")
    (1 to n).foldLeft(1)(_ * _)
  }

  def factorialCollection(items: List[Int]): List[Int] = {
    items.map(factorial)
  }

  def main(args: Array[String]): Unit = {
    val numbers = List(5, 3, 7, 2)
    println(s"Original Numbers: ${numbers.mkString(", ")}")
    val factorialList = factorialCollection(numbers)
    println(s"Factorials: ${factorialList.mkString(", ")}")
  }
}
