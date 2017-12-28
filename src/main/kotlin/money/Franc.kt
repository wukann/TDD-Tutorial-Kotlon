package money

class Franc(private val amount: Int) {

    fun times(multiplier: Int): Franc {
        return Franc(amount * multiplier)
    }

    override fun equals(other: Any?): Boolean {
        val target = other as Franc
        return target.amount == amount
    }
}