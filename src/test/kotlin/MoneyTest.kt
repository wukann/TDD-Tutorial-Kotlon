package money

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*


class MoneyTest {

    @Test
    fun testMultiplication() {
        val five = Dollar(5)
        val product = five.times(2)
        assertEquals(10, product.amount)
        val product2 = five.times(3)
        assertEquals(15, product2.amount)
    }

    @Test
    fun testEquality() {
        assertTrue(Dollar(5) == Dollar(5))
        assertFalse(Dollar(5) == Dollar(6))
    }
}