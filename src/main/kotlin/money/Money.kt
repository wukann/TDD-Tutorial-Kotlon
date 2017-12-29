package money

class Money(private val amount: Int, private val mCurrency: String): Expression {

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

    fun times(multiplier: Int): Money {
        return Money(amount * multiplier, currency)
    }

    fun plus(added: Money): Expression {
        return Sum(this, added)
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