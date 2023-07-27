package cinema

fun main() {

    println("Enter the number of rows:")
    val rows = readln().toInt()
    println("Enter the number of seats in each row:")
    val sits = readln().toInt()

    val room = Array(sits) { CharArray(rows) { 'S' } }
    println("Cinema:")

    print("  ")
    for (i in 1..rows) {
        print(i.toString().replace(",", "") + " ")
    }
    println()

    for (row in room) {

        println((room.indices+1).toString().replace(",", "").replace("[", "").replace("]", "") + " " + row.contentToString().replace(",", "").replace("[", "").replace("]", ""))

        println()
    }


//print(a.toString().replace(",", "") + " ")
//    when {
//        rows * sits < 60 -> {
//            println("Total income:")
//            println("$${rows * sits *10}")
//        }
//        rows%2 == 0 -> {
//            println("Total income:")
//            println("$${((rows/2) * sits * 10) + (rows/2) * sits * 8}")
//        }
//        else -> {
//            println("Total income:")
//            println("$${((rows/2) * sits * 10) + ((rows/2 + 1) * sits * 8)}")
//        }
//    }
//    printCinema(room)
//    println("Enter a row number:")
//    val numrow = readln().toInt()
//    println("Enter a seat number in that row:")
//    val numsit = readln().toInt()
//    when(numrow) {
//        1 -> ar()
//        2 -> empt()
//        3 -> 123
//        4 -> 123
//        5 -> 123
//        6 -> 123
//        7 -> 123
//
//    }
//    println("Ticket price: $10")
}

fun printCinema(room: MutableList<Char>) {
    val string = "  1 2 3 4 5 6 7 8"
    println(" Cinema:")
    for (a in room.indices) {
        if (a == 0) print("  ")
        print((room.indices + 1) + " ")
    }
    println()
    for (i in room) {
        print((room.indices + 1) + " ")
        for (j in room) {
            print(room)
        }
        println()
    }

//
//        ${"1 " + room.slice(0..7).joinToString().replace(",", "")}
//        ${"2 " + room.slice(8..15).joinToString().replace(",", "")}
//        ${"3 " + room.slice(16..23).joinToString().replace(",", "")}
//        ${"4 " + room.slice(24..31).joinToString().replace(",", "")}
//        ${"5 " + room.slice(32..39).joinToString().replace(",", "")}
//        ${"6 " + room.slice(40..47).joinToString().replace(",", "")}
//        ${"7 " + room.slice(48..55).joinToString().replace(",", "")}


}

