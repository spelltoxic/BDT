// Question 20:
// Develop the spark code to find the average of marks using the combineByKey() operation.

import org.apache.spark.{SparkConf, SparkContext}

object AverageMarks {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("AverageMarks").setMaster("local")
    val sc = new SparkContext(conf)
    
    val data = Array(("Joe", "Maths", 83), ("Joe", "Physics", 74), ("Joe", "Chemistry", 91), 
                     ("Joe", "Biology", 82), ("Nik", "Maths", 69), ("Nik", "Physics", 62), 
                     ("Nik", "Chemistry", 97), ("Nik", "Biology", 80))
    
    val rdd = sc.parallelize(data)
    
    val marksRDD = rdd.map { case (name, subject, marks) => (name, marks) }
    
    val combinedMarks = marksRDD.combineByKey(
      (marks: Int) => (marks, 1),
      (acc: (Int, Int), marks: Int) => (acc._1 + marks, acc._2 + 1),
      (acc1: (Int, Int), acc2: (Int, Int)) => (acc1._1 + acc2._1, acc1._2 + acc2._2)
    )
    
    val averageMarks = combinedMarks.mapValues { case (totalMarks, count) => totalMarks.toDouble / count }
    
    averageMarks.collect().foreach(println)
  }
}

/*name := "AverageMarks"
version := "1.0"
scalaVersion := "2.12.10"

libraryDependencies += "org.apache.spark" %% "spark-core" % "3.1.2"
*/
