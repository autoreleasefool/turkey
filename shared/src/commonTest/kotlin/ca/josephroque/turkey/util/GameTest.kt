package ca.josephroque.turkey.util

import util.Game
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class GameTest {

	@Test
	fun `test number of frames is 10`() {
		assertTrue(Game.NUMBER_OF_FRAMES == 10)
	}

	@Test
	fun `test FrameIndices include all values from 0 to 9`() {
		assertEquals(Game.FrameIndices.toSet(), setOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9))
	}

	@Test
	fun `test foul penalty is 15`() {
		assertTrue(Game.FOUL_PENALTY == 15)
	}

	@Test
	fun `test max score is 450`() {
		assertTrue(Game.MAX_SCORE == 450)
	}
}