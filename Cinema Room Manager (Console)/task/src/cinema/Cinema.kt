package cinema

fun main() {

    println("Enter the number of rows:")
    val rows = readln().toInt()
    println("Enter the number of seats in each row:")
    val sits = readln().toInt()
    val room = Array(sits) { CharArray(rows) { 'S' } }
    printCinema(sits, rows, room)
    viewPrice(sits, rows, room)

}
fun viewPrice (rows: Int, sits: Int, room: Array<CharArray>){
    println("Enter a row number:")
    val numrow = readln().toInt()
    println("Enter a seat number in that row:")
    val numsit = readln().toInt()

    when {
        rows * sits < 60 -> {
            println("Ticket price: $10")
            room[numrow-1][numsit-1] = 'B'
            printCinema(sits, rows, room)
            //println("Total income:")
            //println("$${rows * sits *10}")
        }
        rows%2 == 0 -> {
            if (numrow * numsit <= rows/2 * sits){
                println("Ticket price: $8")
                room[numrow-1][numsit-1] = 'B'
                printCinema(sits, rows, room)

            }else {
                println("Ticket price: $10")
                room[numrow][numsit] = 'B'
                printCinema(sits, rows, room)
            }
            //println("$${((rows/2) * sits * 10) + (rows/2) * sits * 8}")
        }
        else -> {
            if (numrow * numsit <= rows/2 * sits){
                println("Ticket price: $8")
                room[numrow-1][numsit-1] = 'B'
                printCinema(sits, rows, room)
            } else {
                println("Ticket price: $10")
                room[numrow][numsit] = 'B'
                printCinema(sits, rows, room)
            }
            //println("Total income:")
            //println("$${((rows/2) * sits * 10) + ((rows/2 + 1) * sits * 8)}")
        }
    }
}


fun printCinema(rows: Int, sits: Int, room: Array<CharArray>) {
    val sitsLen = sits.toString().length + 1
    val rowsLen = rows.toString().length + 1 // Размер расстояния между элементами сетки
    println("Cinema:")
    print("".padStart(rowsLen))
    for (i in 1..rows) {
        print(i.toString().padStart(sitsLen))
    }
    println()

    for (row in 1..rows) {
        print(row.toString().padStart(rowsLen))
        for (sit in 1..sits) {
            print(room[row - 1][sit - 1].toString().padStart(sitsLen))
        }
        println()
    }
}

