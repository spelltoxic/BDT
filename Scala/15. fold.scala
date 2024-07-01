/*15. Analyze the application of fold() and aggregate() functions in Spark by considering a scenario 
where all the items in a collection are updated by a count of 100. Evaluate the efficiency, 
performance, and suitability of both.*/

import org.apache.spark.sql.SparkSession
object FoldAggregateExample {
 def main(args: Array[String]): Unit = {
 val spark = SparkSession.builder()
 .appName("Fold vs Aggregate Example")
 .master("local[*]")
 .getOrCreate()
 
 val sc = spark.sparkContext
 val data = sc.parallelize(1 to 1000000)
 // Using fold
 val foldedResult = data.fold(0)((acc, value) => acc + value + 100)
 // Using aggregate
 val aggregatedResult = data.aggregate(0)(
 (acc, value) => acc + value + 100, 
 (acc1, acc2) => acc1 + acc2
 )
 println(s"Fold result: $foldedResult")
 println(s"Aggregate result: $aggregatedResult")
 spark.stop()
 }
}
