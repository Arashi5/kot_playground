import pack.Color
import pack.Color.*
import pack.createRandomRectangle
import java.lang.IllegalArgumentException
import java.util.*
import strings.*

data class PersonKot(val name: String, val age: Int? = null)

fun main(args: Array<String>) {
    val persons = listOf(PersonKot("Alice"), PersonKot("Bob", age = 29))
    val oldest = persons.maxByOrNull { it.age ?: 0 }
    var i: Int
    val s = "string"
    {
        val i: Int
        i = 1
    }
    i = 2
    var iVar: Int = 1
    fun max(a: Int, b: Int) = if (a > b) a else "b"
    iVar = 2
    println(iVar)

    val lang = arrayListOf<String>("java")
    lang.add("php")
    val rect = Rectangle(41, 43)
    val rect2 = Rectangle(41, 41)
    println(rect.isSquare)
    println(rect2.isSquare)

    var result1 = createRandomRectangle()
    println(result1.isSquare)
    println(getMnemonic(Yellow))

    println(mix(Yellow, Red))
    try {
        mix(Yellow, Green)
    } catch (e: Exception) {
        println(e.message)
    }
    println(mixOptimized(Yellow, Red))

    println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))
    println(evalKotlinEdition(Sum(Sum(Num(1), Num(2)), Num(4))))

    /**
     *  диапазон
     */
    val oneTotTen = 1..10
    println("=============================")
    for (i in 1..100) {
        println(fizzBuzz(i))
    }
    println("=============================")

    for (i in 100 downTo 1 step 2) {
        println(fizzBuzz(i))
    }

    //словарь
    val binaryReps = TreeMap<Char, String>()
    for (c in 'A'..'F') {
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary
    }

    for ((letter, binary) in binaryReps) {
        println("$letter = $binary")
    }

    //срез
    val list = arrayListOf(10, 11, 12)
    for ((index, element) in list.withIndex()) {
        println("$index: $element")
    }

    val set = hashSetOf(1, 7, 53)
    val map = hashMapOf(1 to "one", 7 to "seven")
    println(joinToString(set, ";", "{", "}"))

    int.performOperation()
    int.performOperation()
    int.performOperation()
    int.reportOperationCount()
}

fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
fun isNotDigit(c: Char) = c !in '0'..'9'
fun recognize(c: Char) = when (c) {
    in '0'..'9' -> "Int"
    in 'a'..'z', in 'A'..'Z' -> "Char"
    else -> "error"
}


fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz"
    i % 3 == 0 -> "Fizz "
    i % 5 == 0 -> "Buzz "
    else -> "$i "
}

class Rectangle(private val height: Int, private val width: Int) {
    val isSquare: Boolean
        get() = height == width
}

fun getMnemonic(color: Color) =
    when (color) {
        Color.Blue -> "Синий"
        Color.Green -> "Зеленый"
        Color.Orange, Color.Yellow, Color.Red -> "Теплый"
    }

fun mix(c1: Color, c2: Color) =
    when (setOf(c1, c2)) {
        setOf(Red, Yellow) -> Orange
        setOf(Yellow, Blue) -> Green
        else -> throw Exception("error")
    }

fun mixOptimized(c1: Color, c2: Color) =
    when {
        (c1 == Yellow && c2 == Red) || (c1 == Yellow && c2 == Red) -> Orange
        else -> throw Exception("color is dirty")
    }

interface Expr

class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun eval(e: Expr): Int {
    if (e is Num) {
        val n = e as Num
        return n.value
    }
    if (e is Sum) {
        return eval(e.right) + eval(e.left)
    }
    throw  IllegalArgumentException("Unknown expression")
}

fun evalKotlinEdition(e: Expr): Int =
    when (e) {
        is Num -> e.value
        is Sum -> eval(e.right) + eval(e.left)
        else -> throw  IllegalArgumentException("Unknown expression")
    }

