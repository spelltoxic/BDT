//9. Develop a scala code to search an element in the given list of numbers. The function Search() will take two 
//arguments: list of numbers and the number to be searched. The function will write True if the number is found, False otherwise.


object SearchElement {
  def search(list: List[Int], target: Int): Boolean = {
    // Use list.exists to check if the target number exists in the list
    list.exists(_ == target)
  }

  def main(args: Array[String]): Unit = {
    val numbers = List(23, 45, 12, 67, 89, 34)
    
    // Test cases
    val target1 = 45
    val target2 = 100
    
    println(s"Searching for $target1 in the list: ${search(numbers, target1)}")
    println(s"Searching for $target2 in the list: ${search(numbers, target2)}")
  }
}
