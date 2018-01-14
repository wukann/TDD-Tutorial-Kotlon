package money

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test


class MoneyTest {

    @Test
    fun testMultiplication() {
        val five = Money.dollar(5)
        assertThat(Money.dollar(10), `is`(five.times(2)))
        assertThat(Money.dollar(15), `is`(five.times(3)))
    }

    @Test
    fun testEquality() {
        assertThat(Money.dollar(5) == Money.dollar(5), `is`(true))
        assertThat(Money.dollar(5) == Money.dollar(6), `is`(false))

        assertThat(Money.dollar(5) == Money.franc(5), `is`(false))
    }

    @Test
    fun testCurrency() {
        assertThat(Money.dollar(1).currency, `is`("USD"))
        assertThat(Money.franc(1).currency, `is`("CHF"))
    }

    @Test
    fun testSimpleAddition() {
        val five = Money.dollar(5)
        val sum = five.plus(five)
        val bank = Bank()
        val reduced = bank.reduce(sum, "USD")
        assertThat(reduced, `is`(Money.dollar(10)))
    }

    @Test
    fun testPlusReturnsSum() {
        val five = Money.dollar(5)
        val result = five.plus(five)
        val sum = result as Sum
        assertThat(sum.augend, `is`(five))
        assertThat(sum.addend, `is`(five))
    }

    @Test
    fun testReduceSum() {
        val sum = Sum(Money.dollar(3), Money.dollar(4)) as Expression
        val bank = Bank()
        val result = bank.reduce(sum, "USD")
        assertThat(result, `is`(Money.dollar(7)))
    }

    @Test
    fun testReduceMoney() {
        val bank = Bank()
        val result = bank.reduce(Money.dollar(1), "USD")
        assertThat(result, `is`(Money.dollar(1)))
    }

    @Test
    fun testReduceMoneyDifferentCurrency() {
        val bank = Bank()
        bank.addRate("CHF", "USD", 2)
        val result = bank.reduce(Money.franc(2), "USD")
        assertThat(result, `is`(Money.dollar(1)))
    }

    @Test
    fun testIdentifyRate() {
        assertThat(Bank().rate("USD", "USD"), `is`(1))
    }

}