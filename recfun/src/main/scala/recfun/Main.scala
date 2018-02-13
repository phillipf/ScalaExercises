package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {

      def iter(c: Int,  r: Int, prev: Int = c - 1,accumulator: Int = 0): Int = c match {
        case 0 => 1
        case r => 1
        case _ => iter(prev, r - 1, accumulator + 1)
      }

      iter(c,r)
    }
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = ???
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = ???
  }
