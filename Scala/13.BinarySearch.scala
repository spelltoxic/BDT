//13. Implement function for binary search using recursion in Scala to find the number, given a list of numbers. 
//The function will have two arguments: Sorted list of numbers and the number to be searched.


object BinarySearch {
  def binarySearch(sortedList: List[Int], target: Int): Boolean = {
    def binarySearchHelper(left: Int, right: Int): Boolean = {
      if (left > right) false
      else {
        val mid = left + (right - left) / 2
        sortedList(mid) match {
          case `target` => true
          case x if x > target => binarySearchHelper(left, mid - 1)
          case _ => binarySearchHelper(mid + 1, right)
        }
      }
    }

    binarySearchHelper(0, sortedList.length - 1)
  }

  def main(args: Array[String]): Unit = {
    val numbers = List(2, 4, 6, 8, 10, 12, 14, 16)
    val target1 = 8
    val target2 = 5
    
    println(s"Searching for $target1 in the list: ${binarySearch(numbers, target1)}")
    println(s"Searching for $target2 in the list: ${binarySearch(numbers, target2)}")
  }
}
