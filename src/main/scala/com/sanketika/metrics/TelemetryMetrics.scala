package com.sanketika.metrics
import org.apache.spark.sql

object TelemetryMetrics{
  // $COVERAGE-OFF$

  implicit val classname ="com.sanketika.metrics.TelemetryMetrics"

  def main(args: Array[String]): Unit = {
    val SparkSession = sql.SparkSession.builder().config("spark.master", "local[*]").getOrCreate()
    val generator = new MetricsGenerator
    generator.readFile(SparkSession)

  }


  // $COVERAGE-ON$

}
