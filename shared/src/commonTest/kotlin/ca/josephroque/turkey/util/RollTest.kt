package ca.josephroque.turkey.util

import util.Roll
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class RollTest {

	@Test
	fun `test isLastRoll returns true for 2`() {
		assertTrue(Roll.isLastRoll(2))
	}

	@Test
	fun `test isLastRoll returns false for all other values`() {
		for (i in 0 until 2) {
			assertFalse(Roll.isLastRoll(i))
		}
	}
}