// Question 25:
// i. Find how many partitions are created for the collection Item?
// ii. Display the content of the RDD
// iii. Display the content of each partition separately.

import org.apache.spark.{SparkConf, SparkContext}

object DistributedData {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("DistributedData").setMaster("local")
    val sc = new SparkContext(conf)
    
    val data = Array(("Ball", 10), ("Ribbon", 50), ("Box", 20), ("Pen", 5), ("Book", 8), ("Dairy", 4), ("Pin", 20))
    val rdd = sc.parallelize(data, 3)
    
    val numPartitions = rdd.getNumPartitions
    println(s"Number of partitions: $numPartitions")
    
    val rddContent = rdd.collect()
    println(s"RDD Content: ${rddContent.mkString(", ")}")
    
    rdd.mapPartitionsWithIndex { case (index, iter) => 
      Iterator(s"Partition: $index, values: ${iter.toList}")
    }.collect().foreach(println)
  }
}


/*name := "DistributedData"
version := "1.0"
scalaVersion := "2.12.10"

libraryDependencies += "org.apache.spark" %% "spark-core" % "3.1.2"
*/
