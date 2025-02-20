package ca.josephroque.turkey.util

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
		assertEquals(setOf(0, 1, 2), Frame.RollIndices.toSet())
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

	@Test
	fun `test rollIndicesAfter returns correct range`() {
		assertEquals(1..2, Frame.rollIndicesAfter(0))
		assertEquals(2..2, Frame.rollIndicesAfter(1))
		assertEquals(IntRange.EMPTY, Frame.rollIndicesAfter(2))
	}

	@Test
	fun `test rollIndicesAfter returns empty range for invalid input`() {
		assertEquals(IntRange.EMPTY, Frame.rollIndicesAfter(-1))
		assertEquals(IntRange.EMPTY, Frame.rollIndicesAfter(3))
	}
}