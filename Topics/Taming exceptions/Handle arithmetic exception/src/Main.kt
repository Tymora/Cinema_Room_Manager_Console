fun main() {
    val x = readln().toInt()
    val y = readln().toInt()
    try {
        println(x / y)
    } catch (e: ArithmeticException) {
        println("Division by zero, please fix the second argument!")
    }
}