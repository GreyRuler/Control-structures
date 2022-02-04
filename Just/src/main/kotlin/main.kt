fun main() {
    agoToText((0..3600).random())
    agoToText((3601..86400).random())
    agoToText(24 * 60 * 60 + 1)
    agoToText(24 * 60 * 60 * 2 + 1)
    agoToText(24 * 60 * 60 * 3 + 1)
}

fun agoToText(second: Int) {
    when (second) {
        in 0..60 -> println("только что")
        in 61..60 * 60 -> convertStrForMinute(convertToMinute(second))
        in 60 * 60 + 1..24 * 60 * 60 -> convertStrForClock(convertToClock(second))
        in 24 * 60 * 60 + 1..24 * 60 * 60 * 2 -> println("сегодня")
        in 24 * 60 * 60 * 2 + 1..24 * 60 * 60 * 3 -> println("вчера")
        else -> println("давно")
    }
}

fun convertStrForMinute(minute: Int) {
    if (minute in 11..20) {
        println("$minute минут назад")
    } else {
        when (minute%10) {
            0 -> println("$minute минут назад")
            1 -> println("$minute минуту назад")
            in 2..4 -> println("$minute минуты назад")
            in 5..9 -> println("$minute минут назад")
        }
    }
}

fun convertStrForClock(clock: Int) {
    if (clock in 11..20) {
        println("$clock часов назад")
    } else {
        when (clock%10) {
            0 -> println("$clock часов назад")
            1 -> println("$clock час назад")
            in 2..4 -> println("$clock часа назад")
            in 5..9 -> println("$clock часов назад")
        }
    }
}

fun convertToMinute(second: Int): Int {
    return (second/60)
}

fun convertToClock(second: Int): Int {
    return (second/3600)
}