package money

abstract class Money(protected val amount: Int) {

    companion object {

        fun dollar(amount: Int): Money {
            return Dollar(amount)
        }

        fun franc(amount: Int): Money {
            return Franc(amount)
        }
    }

    abstract fun times(multiplier: Int): Money

    override fun equals(other: Any?): Boolean {
        val money = other as Money
        return amount == money.amount
                && javaClass == other.javaClass
    }
}