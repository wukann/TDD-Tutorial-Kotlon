package money

class Money(val amount: Int, private val mCurrency: String): Expression {

    companion object {

        fun dollar(amount: Int): Money {
            return Money(amount, "USD")
        }

        fun franc(amount: Int): Money {
            return Money(amount, "CHF")
        }
    }

    val currency: String
        get() = mCurrency

    fun times(multiplier: Int): Expression {
        return Money(amount * multiplier, currency)
    }

    override fun plus(added: Expression): Expression {
        return Sum(this, added)
    }

    override fun reduce(bank: Bank, to: String): Money {
        val rate = bank.rate(currency, to)
        return Money(amount / rate, to)
    }

    override fun equals(other: Any?): Boolean {
        val money = other as Money
        return amount == money.amount
                && currency == money.currency
    }

    override fun toString(): String {
        return "$amount $currency"
    }
}