//6. Write a scala function to convert the each word to capitalize each word in the given sentence.

object CapitalizeWords {
  def capitalizeSentence(sentence: String): String = {
    val words = sentence.split("\\s+")
    val capitalizedWords = words.map(_.capitalize)
    capitalizedWords.mkString(" ")
  }

  def main(args: Array[String]): Unit = {
    val sentence = "scala is a powerful programming language"
    val capitalizedSentence = capitalizeSentence(sentence)
    
    println(s"Original Sentence: $sentence")
    println(s"Capitalized Sentence: $capitalizedSentence")
  }
}
