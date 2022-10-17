import com.sanketika.metrics.MetricsGenerator
import org.apache.spark.sql.SparkSession
import org.scalatest._

class MetricsTest extends FlatSpec with Matchers {
  val spark = SparkSession.builder
    .master("local[*]")
    .getOrCreate()
  val testData = spark.read.json("/home/stpl/IdeaProjects/spark-metrics-datacomputation/src/main/resources/Telemetry.json")
  val generator = new MetricsGenerator

  "MetricsTest" should "total number of DistinctChannel" in {
   val data =  generator.distinctChannel(testData)

    assert(data.count() == 4)
  }


  it should "compute progress" in  {
    val report = generator.readFile(spark: SparkSession)
    report
  }


}



