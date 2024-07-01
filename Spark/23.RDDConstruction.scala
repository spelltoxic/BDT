// Question 23:
// i. Illustrate how spark context will construct the RDD from the collection, assuming number of partitions to be made is 3.
// ii. Using mapPartitionsWithIndex return content of each partition along with partition index and apply a function, 
// that increments the value of each element by 1, and returns an array.

import org.apache.spark.{SparkConf, SparkContext}

object RDDConstruction {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("RDDConstruction").setMaster("local")
    val sc = new SparkContext(conf)
    
    val data = Array(11, 34, 45, 67, 3, 4, 90)
    val rdd = sc.parallelize(data, 3)
    
    rdd.mapPartitionsWithIndex { case (index, iter) => 
      Iterator(s"Partition: $index, values: ${iter.toList}")
    }.collect().foreach(println)
    
    val incrementedRDD = rdd.mapPartitionsWithIndex { case (_, iter) => 
      iter.map(_ + 1)
    }
    
    incrementedRDD.collect().foreach(println)
  }
}


/*name := "RDDConstruction"
version := "1.0"
scalaVersion := "2.12.10"

libraryDependencies += "org.apache.spark" %% "spark-core" % "3.1.2"
*/
