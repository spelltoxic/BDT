//2. Write scala code to find the length of each word from the array.

object WordLength{
    def main(args:Array[String]): Unit={
        val words=Array("This","is","a","scala","code")
        words.foreach(word => println(s"Length of '$word' is ${word.length}"))
    }
}
