// Question 18:
// Write the Spark Code to print the top 10 tweeters.
// A dataset with the 8198 reduced tweets, reduced-tweets.json will be provided.

import org.apache.spark.{SparkConf, SparkContext}
import org.json4s._
import org.json4s.jackson.JsonMethods._

object TopTweeters {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("TopTweeters").setMaster("local")
    val sc = new SparkContext(conf)
    
    val tweets = sc.textFile("reduced-tweets.json")
    
    implicit val formats: DefaultFormats.type = DefaultFormats
    val users = tweets.map { tweet =>
      val json = parse(tweet)
      (json \ "user").extract[String]
    }
    
    val userCounts = users.map(user => (user, 1)).reduceByKey(_ + _)
    val top10Tweeters = userCounts.takeOrdered(10)(Ordering[Int].reverse.on(_._2))
    
    top10Tweeters.foreach { case (user, count) => println(s"$user: $count tweets") }
  }
}


/*name := "TopTweeters"
version := "1.0"
scalaVersion := "2.12.10"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "3.1.2",
  "org.json4s" %% "json4s-jackson" % "3.6.11"
)
*/
