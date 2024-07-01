//7. Write scala code to show functional style program to implement quick sort algorithm.

object QuickSortFunctional {

  def quickSort(arr: List[Int]): List[Int] = arr match {
    case Nil          => Nil
    case pivot :: tail =>
      val (left, right) = tail.partition(_ < pivot)
      quickSort(left) ::: pivot :: quickSort(right)
  }

  def main(args: Array[String]): Unit = {
    val arr = List(64, 25, 12, 22, 11)
    println("Original List:")
    println(arr.mkString(", "))
    
    val sortedArr = quickSort(arr)
    
    println("\nSorted List:")
    println(sortedArr.mkString(", "))
  }
}
