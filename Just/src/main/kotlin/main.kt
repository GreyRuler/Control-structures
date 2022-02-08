const val MINUTE = 60
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR
const val TWO_DAYS = 2 * DAY
const val THREE_DAYS = 3 * DAY

fun main() {
    agoToText(1)
    agoToText((0..3600).random())
    agoToText((3601..86400).random())
    agoToText(24 * 60 * 60 + 1)
    agoToText(24 * 60 * 60 * 2 + 1)
    agoToText(24 * 60 * 60 * 3 + 1)
}

fun agoToText(seconds: Int) {
    when {
        seconds > THREE_DAYS -> println("давно")
        seconds > TWO_DAYS -> println("вчера")
        seconds > DAY -> println("сегодня")
        seconds > HOUR -> println(timeToText(convertToHour(seconds), false))
        seconds > MINUTE -> println(timeToText(convertToMinute(seconds), true))
        else -> println("только что")
    }
}

fun timeToText(time: Int, type: Boolean): String {
    /* Параметр type подразумевает выбор единиц времени
     * Для минут передаём true
     * Для часов передаём false
     */
    return if (time % 100 in 11..20) {
        if (type) "$time минут назад" else "$time часов назад"
    } else {
        when (time % 10) {
            1 -> if (type) "$time минуту назад" else "$time час назад"
            in 2..4 -> if (type) "$time минуты назад" else "$time часа назад"
            else -> if (type) "$time минут назад" else "$time часов назад"
        }
    }
}

fun convertToMinute(seconds: Int): Int {
    return seconds / 60
}

fun convertToHour(seconds: Int): Int {
    return seconds / 3600
}