package cinema

var current: Int = 0
var purTicket = 0
fun main() {
    println("Enter the number of rows:")
    val rows = readln().toInt()
    println("Enter the number of seats in each row:")
    val sits = readln().toInt()
    val room = Array(sits) { CharArray(rows) { 'S' } }
    while (true) {
        println(
            """
            1. Show the seats
            2. Buy a ticket
            3. Statistics
            0. Exit
        """.trimIndent()
        )
        when (readln().toInt()) {
            1 -> printCinema(rows, sits, room)
            2 -> viewPrice(rows, sits, room)
            3 -> statistics(rows, sits)
            0 -> break
        }
    }
}

fun viewPrice(rows: Int, sits: Int, room: Array<CharArray>) {
    println("Enter a row number:")
    val numrow = readln().toInt()
    println("Enter a seat number in that row:")
    val numsit = readln().toInt()
    try {
        when {
            rows * sits < 60 -> {
                if (room[numsit - 1][numrow - 1] == 'B') {
                    println("That ticket has already been purchased!")
                    viewPrice(rows, sits, room)
                } else {
                    println("Ticket price: $10")
                    current += 10
                    purTicket += 1
                    room[numsit - 1][numrow - 1] = 'B'
                }
            }
            rows % 2 == 0 -> {
                if (numrow <= rows / 2) {
                    if (room[numsit - 1][numrow - 1] == 'B') {
                        println("That ticket has already been purchased!")
                        viewPrice(rows, sits, room)
                    } else {
                        println("Ticket price: $10")
                        current += 10
                        purTicket += 1
                        room[numsit - 1][numrow - 1] = 'B'
                    }
                } else {
                    if (room[numsit - 1][numrow - 1] == 'B') {
                        println("That ticket has already been purchased!")
                        viewPrice(rows, sits, room)
                    } else {
                        println("Ticket price: $8")
                        current += 8
                        purTicket += 1
                        room[numsit - 1][numrow - 1] = 'B'
                    }
                }
            }
            else -> {
                if (numrow <= rows / 2) {
                    if (room[numsit - 1][numrow - 1] == 'B') {
                        println("That ticket has already been purchased!")
                        viewPrice(rows, sits, room)
                    } else {
                        println("Ticket price: $10")
                        current += 10
                        purTicket += 1
                        room[numsit - 1][numrow - 1] = 'B'
                    }
                } else {
                    if (room[numsit - 1][numrow - 1] == 'B') {
                        println("That ticket has already been purchased!")
                        viewPrice(rows, sits, room)
                    } else {
                        println("Ticket price: $8")
                        current += 8
                        purTicket += 1
                        room[numsit - 1][numrow - 1] = 'B'
                    }
                }
            }
        }
    } catch (e: Exception) {
        println("Wrong input!")
    }
}

fun printCinema(rows: Int, sits: Int, room: Array<CharArray>) {
    val sitsLen = sits.toString().length + 1
    val rowsLen = rows.toString().length + 1 // Размер расстояния между элементами сетки
    println("Cinema:")
    print("".padStart(rowsLen))
    for (i in 1..sits) {
        print(i.toString().padStart(sitsLen))
    }
    println()
    for (row in 1..rows) {
        print(row.toString().padStart(rowsLen))
        for (sit in 1..sits) {
            print(room[sit - 1][row - 1].toString().padStart(sitsLen))
        }
        println()
    }
}

fun statistics(rows: Int, sits: Int) {
    val total: Int = when {
        rows * sits < 60 -> rows * sits * 10
        rows % 2 == 0 -> ((rows / 2) * sits * 10) + (rows / 2) * sits * 8
        else -> ((rows / 2) * sits * 10) + ((rows / 2 + 1) * sits * 8)
    }
    val perc: Double = (purTicket.toDouble() / (rows.toDouble() * sits.toDouble())) * 100
    val formatPerc = "%.2f".format(perc)
    println(
        """
        Number of purchased tickets: $purTicket
        Percentage: $formatPerc%
        Current income: $${current} 
        Total income: $${total}
    """.trimIndent()
    )
}