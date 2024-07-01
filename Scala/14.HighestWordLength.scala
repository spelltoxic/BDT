/*14. Write a function to find the length of each word and return the word with highest length .

Ex for the collection of words = (“games”, “television”,”rope”,”table”)

The function should return (“television”,10). The word with the highest length .

Read the words from the keyboard.
*/

import scala.io.StdIn

object HighestWordLength {
  def main(args: Array[String]): Unit = {
    println("Enter words separated by spaces:")
    val words = StdIn.readLine().trim().split("\\s+")
    
    if (words.isEmpty) {
      println("No words entered. Exiting.")
    } else {
      val maxLengthWord = words.maxByOption(_.length)
      
      maxLengthWord match {
        case Some(word) => println(s"The word with the highest length is '$word' with length ${word.length}.")
        case None => println("No valid words found.")
      }
    }
  }
}
