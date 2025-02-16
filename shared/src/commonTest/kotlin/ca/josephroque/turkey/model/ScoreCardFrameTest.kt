package ca.josephroque.turkey.model

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNull
import kotlin.test.assertTrue

class ScoreCardFrameTest {

	@Test
	fun `test display is null when score is null`() {
		val frame = ScoreCardFrame(0, emptyList(), null)

		assertNull(frame.display)
	}

	@Test
	fun `test display is score when score is not null`() {
		val frame = ScoreCardFrame(0, emptyList(), 0)

		assertEquals(frame.display, "0")
	}

	@Test
	fun `test display is score when score is not null and has rolls`() {
		val frame = ScoreCardFrame(0, listOf(ScoreCardRoll(0, "2", didFoul = false, isMarkValue = false)), 0)

		assertEquals(frame.display, "0")
	}

	@Test
	fun `test isLastFrame returns true when frame is last frame`() {
		val frame = ScoreCardFrame(9, emptyList(), 0)

		assertTrue(frame.isLastFrame())
	}

	@Test
	fun `test isLastFrame returns false when frame is not last frame`() {
		val frame = ScoreCardFrame(0, emptyList(), 0)

		assertFalse(frame.isLastFrame())
	}

	@Test
	fun `test isFirstFrame returns true when frame is first frame`() {
		val frame = ScoreCardFrame(0, emptyList(), 0)

		assertTrue(frame.isFirstFrame())
	}

	@Test
	fun `test isFirstFrame returns false when frame is not first frame`() {
		val frame = ScoreCardFrame(9, emptyList(), 0)

		assertFalse(frame.isFirstFrame())
	}

	@Test
	fun `test gameScore is null when no frames`() {
		val gameScore = emptyList<ScoreCardFrame>().gameScore()

		assertNull(gameScore)
	}

	@Test
	fun `test gameScore is null when no frames have scores`() {
		val gameScore = listOf(ScoreCardFrame(0, emptyList(), null)).gameScore()

		assertNull(gameScore)
	}

	@Test
	fun `test gameScore is score when frame has score`() {
		val gameScore = listOf(ScoreCardFrame(0, emptyList(), 123)).gameScore()

		assertEquals(gameScore, 123)
	}

	@Test
	fun `test gameScore is score of the last frame with a score`() {
		val gameScore = listOf(
			ScoreCardFrame(0, emptyList(), 10),
			ScoreCardFrame(1, emptyList(), 20),
			ScoreCardFrame(2, emptyList(), 30),
			ScoreCardFrame(3, emptyList(), null),
		).gameScore()

		assertEquals(gameScore, 30)
	}
}