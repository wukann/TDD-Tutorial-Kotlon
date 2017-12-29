package money

abstract class Money(protected val amount: Int, private val mCurrency: String) {

    companion object {

        fun dollar(amount: Int): Money {
            return Dollar(amount, "USD")
        }

        fun franc(amount: Int): Money {
            return Franc(amount, "CHF")
        }
    }

    val currency: String
        get() = mCurrency

    abstract fun times(multiplier: Int): Money

    override fun equals(other: Any?): Boolean {
        val money = other as Money
        return amount == money.amount
                && javaClass == other.javaClass
    }
}