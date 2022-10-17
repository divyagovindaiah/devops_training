package com.sanketika.metrics
import org.apache.spark.sql.{DataFrame, Encoders, SparkSession}


class MetricsGenerator {


  def readFile(spark: SparkSession): Unit = {
      val schema = Encoders.product[Telemetry].schema
      val dataset = spark.read.schema(schema).option("inferSchema", "true").json("/home/stpl/IdeaProjects/spark-metrics-datacomputation/src/main/resources/Telemetry.json")
      dataset.show()
      distinctChannel(dataset)
   // getContentProgress(List[Telemetry])

    }

    /**
     * it can group the channels are distinct
     * @param dataset : contains List of telemetry objects
     * @return find out the number of disctinctchannel
     */

    def distinctChannel(dataset: DataFrame): DataFrame = {
      val distinctChannel = dataset.groupBy("context.channel").count()
      distinctChannel.show()
      distinctChannel.write.format("json").save("src/main/resources/Data.json")
      distinctChannel
    }


  /**
   * This function can check the progress of content is 100.0 or not
   * Then returns number of content completed by a user
   *
   * @param result   : List of Telemetry Objects
   * @param progress : compare the progress value
   * @param userId   : get the count by specific userId
   * @return: returns count of completed content by a user
   */
  /*def countCompleted(result: List[Telemetry], progress: Double, userId: String): Int =
    result.count(x => x.progress == progress)

  /**
   * it can  group the content those are the progress 100.0
   * @param result : contains list of telemetryObjects
   * @return: count the number of completed contents
   */

  def getContentProgress(result: List[Telemetry]) = {
    val seperate = result.filter(x => x.eid == "END")
    val finalRes = seperate.groupBy(record => (record.actor.id)).map { f =>
      f._1 -> countCompleted(f._2, 100, f._1)
    }
    finalRes

  }*/


}
