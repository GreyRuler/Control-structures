const val CATEGORY_ONE = "mastercard_maestro"
const val CATEGORY_TWO = "visa_mir"

fun main() {
    println(tax(CATEGORY_ONE, conversionCurrency(76_000)))
    println(tax(CATEGORY_ONE, conversionCurrency(75_000)))
    println(tax(CATEGORY_ONE, conversionCurrency(150_000)))
    println(tax(CATEGORY_TWO, conversionCurrency(4_000)))
    println(tax(CATEGORY_TWO, conversionCurrency(5_000)))
}

fun tax(type: String, amount: Double, earlyAmount: Double = 0.00) = when (type) {
    CATEGORY_ONE -> taxCategoryOne(amount)
    CATEGORY_TWO -> taxCategoryTwo(amount)
    else -> 0.00
}

fun taxCategoryOne(amount: Double) = when (amount) {
    in 0.00..7_500_000.00 -> 0.00
    else -> amount*0.006 + 2_000.0
}


fun taxCategoryTwo(amount: Double): Double {
    val tax = amount*0.0075
    return if (tax<3500.00) 3500.00 else tax
}

fun conversionCurrency(amount: Int) = amount*100.00