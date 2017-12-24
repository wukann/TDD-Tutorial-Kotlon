package money

class Dollar(var amount: Int) {

    fun times(multiplier: Int): Dollar {
        return Dollar(amount * multiplier)
    }

    override fun equals(other: Any?): Boolean {
        val target = other as Dollar
        return amount == target.amount
    }
}