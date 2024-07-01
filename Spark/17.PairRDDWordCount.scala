// Question 17:
// Consider the content of text file text.txt. Perform the counting of occurrences of each word using pair RDD.

import org.apache.spark.{SparkConf, SparkContext}

object PairRDDWordCount {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("PairRDDWordCount").setMaster("local")
    val sc = new SparkContext(conf)
    
    val textFile = sc.textFile("text.txt")
    
    val words = textFile.flatMap(line => line.split(" "))
    val pairRDD = words.map(word => (word, 1))
    val wordCounts = pairRDD.reduceByKey(_ + _)
    
    wordCounts.saveAsTextFile("pair_rdd_word_counts_output")
    wordCounts.collect().foreach(println)
  }
}

/*name := "PairRDDWordCount"
version := "1.0"
scalaVersion := "2.12.10"

libraryDependencies += "org.apache.spark" %% "spark-core" % "3.1.2"
*/
