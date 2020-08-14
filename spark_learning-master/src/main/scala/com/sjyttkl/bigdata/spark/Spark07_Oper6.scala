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
object Spark07_Oper6 {
  def main(args: Array[String]): Unit = {
    var config: SparkConf = new SparkConf().setMaster("local[*]").setAppName("WordCount")

    //创建Spark上下文对象
    var sc: SparkContext = new SparkContext(config)
    // 生成数据，并按指定规则进行分组
    // 分组后的数据，形成对偶元组（k-v),k表示分组的key , value表示分组的集合
    var listRDD: RDD[Int] = sc.makeRDD( 1 to 16) // 这里的to是包含16的，until是不包含16的

    var groupbyRDD: RDD[(Int, Iterable[Int])] = listRDD.groupBy(i => i % 2)

    groupbyRDD.collect().foreach(println)
  }
}
