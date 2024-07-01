// Question 26:
// i. Count the number of occurrences of each word.
// ii. Arrange the word count in ascending order based on Key.
// iii. Display the words that begin with ‘s’.

import org.apache.spark.{SparkConf, SparkContext}

object WordOperations {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("WordOperations").setMaster("local")
    val sc = new SparkContext(conf)
    
    val textFile = sc.textFile("words.txt")
    
    val wordCounts = textFile.flatMap(line => line.split(" "))
                             .map(word => (word, 1))
                             .reduceByKey(_ + _)
    
    wordCounts.saveAsTextFile("word_count_output")
    
    val sortedWordCounts = wordCounts.sortByKey()
    sortedWordCounts.saveAsTextFile("sorted_word_count_output")
    
    val wordsStartingWithS = wordCounts.filter { case (word, _) => word.startsWith("s") }
    wordsStartingWithS.collect().foreach(println)
  }
}

/*name := "WordOperations"
version := "1.0"
scalaVersion := "2.12.10"

libraryDependencies += "org.apache.spark" %% "spark-core" % "3.1.2"
*/
