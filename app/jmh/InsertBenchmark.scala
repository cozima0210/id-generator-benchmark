package jmh

import java.util.concurrent.TimeUnit

import models.{IdGenerator, Test1, Test2}
import org.openjdk.jmh.annotations._
import scalikejdbc.config.DBs

@State(Scope.Thread)
class InsertBenchmark {

  val idGenerator = IdGenerator()

  @Setup
  def setup(): Unit = {
    DBs.setupAll()
  }

  @TearDown
  def tearDown(): Unit = {
    DBs.closeAll()
  }

  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput, Mode.AverageTime))
  @OutputTimeUnit(TimeUnit.MILLISECONDS)
  def insertTest1Benchmark(): Unit = {
    Test1.create("hoge")
  }

  @Benchmark()
  @BenchmarkMode(Array(Mode.Throughput, Mode.AverageTime))
  @OutputTimeUnit(TimeUnit.MILLISECONDS)
  def insertTest2Benchmark(): Unit = {
    Test2.create("hoge")(idGenerator)
  }

}
