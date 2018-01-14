package money

class Sum(val augend: Expression, val addend: Expression) : Expression {
    override fun plus(added: Expression): Expression {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun reduce(bank: Bank, to: String): Money {
        val amount = augend.reduce(bank, to).amount + addend.reduce(bank, to).amount
        return Money(amount, to)
    }
}