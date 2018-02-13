import scala.collection.parallel._

object sumSegment {

  def sumSegment(a: Array[Int], p: Double, s: Int, t: Int): Int = {

    def iter(p: Double, b: Array[Int] = a.slice(s, t - 1), accumulator: Int = 0): Int = b match {
      case Array() => accumulator
      case yhead => iter(p, yhead.tail, scala.math.pow(yhead.head, p).toInt)
    }

    iter(p)
  }

  def pNorm(a: Array[Int], p: Double): Int = {

    scala.math.pow(sumSegment(a, p, 0, a.length), 1/p).toInt

  }

  def pNormTwoPart(a: Array[Int], p: Double): Int = {
    val m = a.length/2
    val (sum1,sum2) =
    (sumSegment(a, p, 0, m),
     sumSegment(a, p, m, a.length))
    scala.math.pow(sum1 + sum2, 1/p).toInt
  }

  def startThread(a: Array[Int], p: Double, s: Int, f: Int) = {
    val t = new Thread {
      override def run() {
        sumSegment(a, p, s, f)
      }
    }
    t.start()
    t
  }

  /*def power(x: Int, p: Double): Int = math.exp(p * math.log(scala.math.abs(x))).toInt

  def sumSegment2(a: Array[Int], p: Double, s: Int, t: Int): Int = {
    var i= s; var sum: Int = 0
    while (i < t) {
      sum= sum + power(a(i), p)
      i= i + 1
    }
    sum
  }


  def pNormTwoPart(a: Array[Int], p: Double): Int = {
    val m = a.length / 2
    val (sum1, sum2) = parallel(sumSegment2(a, p, 0, m),
      sumSegment2(a, p, m, a.length))
    power(sum1 + sum2, 1/p) }*/


  def pNormOnePart(a: Array[Int], p: Double) = {
    val m = a.length/2
    //val sum1 = startThread(a, p, 0, m)
    //val sum2 = startThread(a, p, m, a.length)

    //println(sum1)
    //println(sum2)
    val (sum1, sum2) = (sumSegment(a, p, 0, m),
                        sumSegment(a, p, m, a.length))
    
    scala.math.pow(sum1 + sum2, 1/p).toInt

    //scala.math.pow(sum1 + sum2, 1/p).toInt
  }


  def main(args: Array[String]): Unit = {

    //println(sumSegment(Array(1,2,3), 2, 0, 2))
    //println(pNorm(Array(1,2,3), 2))
    pNormOnePart(Array(2, 2, 2, 2), 2)

  }

}
