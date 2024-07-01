// Question 21:
// Consider the Employee table with the fields as (EmpID, Dept, EmpDesg). Design the Spark program to partition the table using Dept and construct the hashed partition of 4.

import org.apache.spark.{HashPartitioner, SparkConf, SparkContext}

object EmployeePartition {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("EmployeePartition").setMaster("local")
    val sc = new SparkContext(conf)
    
    val data = Array(("E1", "HR", "Manager"), ("E2", "IT", "Developer"), ("E3", "HR", "Recruiter"), 
                     ("E4", "Finance", "Analyst"), ("E5", "IT", "Tester"))
    
    val rdd = sc.parallelize(data)
    val partitionedRDD = rdd.partitionBy(new HashPartitioner(4))
    
    partitionedRDD.mapPartitionsWithIndex { case (index, iter) => 
      Iterator(s"Partition: $index, values: ${iter.toList}") 
    }.collect().foreach(println)
  }
}

/*name := "EmployeePartition"
version := "1.0"
scalaVersion := "2.12.10"

libraryDependencies += "org.apache.spark" %% "spark-core" % "3.1.2"
*/
