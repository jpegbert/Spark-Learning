package com.sjyttkl.bigdata.spark

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Create with: com.sjyttkl.bigdata.spark 
  * author: sjyttkl
  * E-mail: 695492835@qq.com
  * date: 2019/8/25 0:59 
  * version: 1.0
  * description:  
  */
object Spark11_Oper10 {
  def main(args: Array[String]): Unit = {
    var config: SparkConf = new SparkConf().setMaster("local[*]").setAppName("WordCount")

    //创建Spark上下文对象
    var sc: SparkContext = new SparkContext(config)

    var listRDD: RDD[Int] = sc.makeRDD( 1 to 16) // 这里的to是包含16的，until是不包含16的
    println("缩减分区前 = " + listRDD.partitions.size)
    //缩减分区，可以简单的理解为合并分区，没有shuffle，会把剩余的数据存储在最后
    var coalesceRDD: RDD[Int] = listRDD.coalesce(3)
    println("缩减分区后 = " + coalesceRDD.partitions.size)
//    coalesceRDD.saveAsTextFile("output")

  }
}
