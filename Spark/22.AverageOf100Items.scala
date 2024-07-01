// Question 22:
// Consider a collection of 100 items of type integer given in the csv file. Write the Spark code to find the average of these 100 items.

import org.apache.spark.{SparkConf, SparkContext}

object AverageOf100Items {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("AverageOf100Items").setMaster("local")
    val sc = new SparkContext(conf)
    
    val data = sc.textFile("items.csv")
    val numbers = data.map(_.toInt)
    
    val totalSum = numbers.reduce(_ + _)
    val count = numbers.count()
    val average = totalSum.toDouble / count
    
    println(s"Average: $average")
  }
}


/*name := "AverageOf100Items"
version := "1.0"
scalaVersion := "2.12.10"

libraryDependencies += "org.apache.spark" %% "spark-core" % "3.1.2"
*/
