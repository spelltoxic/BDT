// Question 16:
// Consider a text file text.txt. Develop Spark code to read the file and count the number of occurrences of each word using Spark RDD.
// Store the result in a file. Display the words which appear more than 4 times.

import org.apache.spark.{SparkConf, SparkContext}

object WordCount {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("WordCount").setMaster("local")
    val sc = new SparkContext(conf)
    
    val textFile = sc.textFile("text.txt")
    
    val wordCounts = textFile.flatMap(line => line.split(" "))
                             .map(word => (word, 1))
                             .reduceByKey(_ + _)
    
    wordCounts.saveAsTextFile("word_counts_output")
    
    val wordsMoreThan4 = wordCounts.filter { case (_, count) => count > 4 }
    wordsMoreThan4.collect().foreach(println)
  }
}

/*name := "WordCount"
version := "1.0"
scalaVersion := "2.12.10"

libraryDependencies += "org.apache.spark" %% "spark-core" % "3.1.2"
*/
