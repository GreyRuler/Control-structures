const val TYPE_MASTERCARD = "mastercard"
const val TYPE_MAESTRO = "maestro"
const val TYPE_VISA = "visa"
const val TYPE_MIR = "mir"
const val TYPE_VKPAY = "vk_pay"
const val LIMIT = 7_500_000
const val FIXED_COMMISSION = 2_000
const val PERCENT_FOR_MASTERCARD_AND_MAESTRO = 0.006
const val PERCENT_FOR_VISA_AND_MIR = 0.0075
const val MINIMUM_COMISSION = 3500

fun main() {
    println(tax(conversionCurrency(76_000), TYPE_MASTERCARD))
    println(tax(conversionCurrency(75_000), TYPE_MAESTRO))
    println(tax(conversionCurrency(150_000), TYPE_VISA))
    println(tax(conversionCurrency(4_000), TYPE_MIR))
    println(tax(conversionCurrency(5_000), TYPE_VKPAY))
}

fun tax(amount: Int, type: String = TYPE_VKPAY, earlyAmount: Int = 0) = when (type) {
    TYPE_MASTERCARD, TYPE_MAESTRO -> taxMastercardMaestro(amount)
    TYPE_VISA, TYPE_MIR -> taxVisaMir(amount)
    TYPE_VKPAY -> 0
    else -> error("К сожелению, мы не поддерживаем данный тип карты")
}

fun taxMastercardMaestro(amount: Int) = when (amount) {
    in 0..LIMIT -> 0
    else -> (amount * PERCENT_FOR_MASTERCARD_AND_MAESTRO + FIXED_COMMISSION).toInt()
}

fun taxVisaMir(amount: Int): Int {
    val tax = (amount * PERCENT_FOR_VISA_AND_MIR).toInt()
    return if (tax < MINIMUM_COMISSION) MINIMUM_COMISSION else tax
}

fun conversionCurrency(amount: Int) = amount * 100