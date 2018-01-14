package money

class Bank {

    private val rates: HashMap<Pair, Int> = HashMap()

    fun reduce(source: Expression, to: String): Money {

        return source.reduce(this, to)
    }

    fun addRate(from: String, to: String, rate: Int) {
        rates.put(Pair(from, to), rate)
    }

    fun rate(from: String, to: String): Int {
        if (from == to) return 1
        return rates.getOrDefault(Pair(from, to), 0)
    }
}