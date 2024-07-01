// Question 24:
// i. Find how many partitions are created for the collection Item?
// ii. Display the content of the RDD Display the content of each partition separately

import org.apache.spark.{SparkConf, SparkContext}

object ItemRDD {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("ItemRDD").setMaster("local")
    val sc = new SparkContext(conf)
    
    val Item = Map("Ball" -> 10, "Ribbon" -> 50, "Box" -> 20, "Pen" -> 5, "Book" -> 8, "Dairy" -> 4, "Pin" -> 20)
    val rdd = sc.parallelize(Item.toSeq)
    
    val numPartitions = rdd.getNumPartitions
    println(s"Number of partitions: $numPartitions")
    
    rdd.mapPartitionsWithIndex { case (index, iter) => 
      Iterator(s"Partition: $index, values: ${iter.toList}")
    }.collect().foreach(println)
  }
}

/*name := "ItemRDD"
version := "1.0"
scalaVersion := "2.12.10"

libraryDependencies += "org.apache.spark" %% "spark-core" % "3.1.2"
*/
