package pack

enum class Color(
    val r: Int, val g: Int, val b: Int
) {
    Red(255,0,0),
    Orange(255,165,0),
    Green(0,255,0),
    Yellow(255,255,0),
    Blue(0,0,255);

    fun rgb() = (r * 256 + g) * 256 + b
}