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
object Spark06_Oper5 {
  def main(args: Array[String]): Unit = {
    var config: SparkConf = new SparkConf().setMaster("local[*]").setAppName("WordCount")

    // 创建Spark上下文对象
    var sc: SparkContext = new SparkContext(config)
    //这里的to是包含16的，until是不包含16的, 后面的4是确定分区数
    var listRDD: RDD[Int] = sc.makeRDD( 1 to 16,4)

    // 将一个分区的数据，放到数组中
    var glomRDD: RDD[Array[Int]] = listRDD.glom()

//    glomRDD.collect().foreach(println)
    glomRDD.collect().foreach(array => {
      println(array.mkString(","))
    })
  }
}
