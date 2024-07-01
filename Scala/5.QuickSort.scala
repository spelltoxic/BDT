//5. Write the scala program using imperative style to implement quick sort algorithm.

object QuickSort {
  def quickSort(arr: Array[Int]): Unit = {
    def swap(i: Int, j: Int): Unit = {
      val temp = arr(i)
      arr(i) = arr(j)
      arr(j) = temp
    }

    def partition(low: Int, high: Int): Int = {
      val pivot = arr(high)
      var i = low - 1
      for (j <- low until high) {
        if (arr(j) < pivot) {
          i += 1
          swap(i, j)
        }
      }
      swap(i + 1, high)
      i + 1
    }

    var stack = List((0, arr.length - 1))
    while (stack.nonEmpty) {
      val (low, high) = stack.head
      stack = stack.tail
      if (low < high) {
        val pivotIndex = partition(low, high)
        stack = (low, pivotIndex - 1) :: stack
        stack = (pivotIndex + 1, high) :: stack
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val arr = Array(64, 25, 12, 22, 11)
    println("Original Array:")
    arr.foreach(println)
    
    quickSort(arr)
    
    println("\nSorted Array:")
    arr.foreach(println)
  }
}
