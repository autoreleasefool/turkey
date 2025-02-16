package ca.josephroque.turkey.util

import util.Frame
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class FrameTest {

	@Test
	fun `test number of rolls is 3`() {
		assertTrue(Frame.NUMBER_OF_ROLLS == 3)
	}

	@Test
	fun `test RollIndices include all values from 0 to 2`() {
		assertEquals(Frame.RollIndices.toSet(), setOf(0, 1, 2))
	}

	@Test
	fun `test isLastFrame returns true for 9`() {
		assertTrue(Frame.isLastFrame(9))
	}

	@Test
	fun `test isLastFrame returns false for all other values`() {
		for (i in 0 until 9) {
			assertFalse(Frame.isLastFrame(i))
		}
	}
}