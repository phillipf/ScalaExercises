import sun.awt.geom.AreaOp.IntOp

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

def square(x: Double) = x * x

square(2)

"Hello, " ++ "Scala!"

"Hello, Scala!".size

1.to(10)

"Hello, Scala!".toUpperCase

(0 to 10).contains(10)

!true

def factorial(input: Double): Double =
  if (input == 1 || input == 2) input
  else input * factorial(input - 1)

factorial(3)

def odd_even(n: Int): Int =
  if(n % 2 == 0) 3
  else 2

def ears(n: Int): Int =
  if(n == 0) 0
  else odd_even(n) + ears(n - 1)

ears(2)

def triangle(n: Int): Int =
  if(n == 0) 0
  else n + triangle(n - 1)

triangle(3)

def fib(n: Int): Int =
  if(n == 0) 0
  else if(n == 1) 1
  else fib(n - 1) + fib(n - 2)

fib(8)

def fib_tail(n: Int): Int = {

  /*iter(n, 0) + iter1(n, 0)*/
  @tailrec
  def iter(n: Int, prev: Int = 0, next: Int = 1): Int =
    if(n == 0) prev
    else if(n == 1) next
    else iter(n - 1, next, (next + prev))

  /*def iter2(n: Int, result: Int): Int =
    if(n <= 0) 0
    else if(n == 1) result + 1
    else iter(n - 1, result)*/

  iter(n)

}

fib_tail(4)

