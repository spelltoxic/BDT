// Question 27:
// Illustrate the application of combineByKey to combine all the values of the same key in the following collection.
// (("coffee",2),("cappuccino",5),("tea",3),("coffee",10),("cappuccino",15))

import org.apache.spark.{SparkConf, SparkContext}

object CombineByKeyExample {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("CombineByKeyExample").setMaster("local")
    val sc = new SparkContext(conf)
    
    val data = Array(("coffee", 2), ("cappuccino", 5), ("tea", 3), ("coffee", 10), ("cappuccino", 15))
    val rdd = sc.parallelize(data)
    
    val combinedRDD = rdd.combineByKey(
      (value: Int) => value,
      (acc: Int, value: Int) => acc + value,
      (acc1: Int, acc2: Int) => acc1 + acc2
    )
    
    combinedRDD.collect().foreach(println)
  }
}


/*name := "CombineByKeyExample"
version := "1.0"
scalaVersion := "2.12.10"

libraryDependencies += "org.apache.spark" %% "spark-core" % "3.1.2"
*/
