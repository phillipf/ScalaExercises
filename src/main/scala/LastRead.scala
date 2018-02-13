package DigitalMetering

import java.io.File

import com.github.tototoshi.csv._


import scala.annotation.tailrec

object LastRead {

  val LastRead = List(2592, 3456, 3582)

  val reader = CSVReader.open(new File("N:/DigitalMetering/RDM/Church St DMA latest data 21st Nov.csv"))

  def sum(Reads: List[Int]): Int = {

    @tailrec
    def sumAccumulator(Reads: List[Int], accumulator: Int = 0): Int = Reads match {
      case Nil => accumulator
      case x :: tail => sumAccumulator(tail, x + accumulator)
    }

    sumAccumulator(Reads)

  }

  def ToInt(Read: String): Int = Read match {

    case "" => 0
    case _ => Read.toInt

  }

  def csvSum(df: List[Map[String,String]]): Int = {

    @tailrec
    def sumAccumulator(Reads: List[Map[String,String]], accumulator: Int = 0): Int = Reads match {
      case Nil => accumulator
      case x :: tail => sumAccumulator(tail, ToInt(x("LAST_READ")) + accumulator)
    }

    sumAccumulator(df)

  }

  /*def LastReadbyID(df: List[Map[String,String]]): List[String] = {

    //var ID = new ListBuffer[String]()
    @tailrec
    def LastReadAccumulator(df: List[Map[String,String]], acc: List[String]): List[String] = df match {

      case Nil => acc
      case x :: tail =>
        val ID = x("LAST_READ")
        LastReadAccumulator(tail, ID :: acc)

    }

    val result = df match {
      case first :: second :: _ => LastReadAccumulator(first, List())
      case _ => Nil
    }

    LastReadAccumulator(df, List())
  }*/

  def main(args: Array[String]): Unit = {

    printf("Total consumption: %s\n", sum(LastRead))
    printf("Average consumption: %s\n", sum(LastRead)/LastRead.length)

    printf("Total consumption: %s\n", csvSum(reader.allWithHeaders()))
    //println(LastReadbyID(reader.allWithHeaders()))
    /*println(getValues(reader.allWithHeaders()))*/

  }

}
