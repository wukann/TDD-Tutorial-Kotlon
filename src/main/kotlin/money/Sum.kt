package money

class Sum(val augend: Expression, val addend: Expression) : Expression {
    override fun plus(added: Expression): Expression {
        return Sum(this, added)
    }

    override fun reduce(bank: Bank, to: String): Money {
        val amount = augend.reduce(bank, to).amount + addend.reduce(bank, to).amount
        return Money(amount, to)
    }
}