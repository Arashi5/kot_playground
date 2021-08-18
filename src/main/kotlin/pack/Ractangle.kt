package pack

import java.util.*


class Ractangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        get() = height == width
}

fun createRandomRectangle(): Ractangle {
    val rand = Random()
    return Ractangle(rand.nextInt(), rand.nextInt())
}