package ca.josephroque.turkey.fivepin

import ca.josephroque.turkey.ScoreCardInput
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class FivePinScoreCardStateTest {

	@Test
	fun `test applyPenalty reduces score by penalty amount`() {
		val state = FivePinScoreCardState(
			input = ScoreCardInput(rolls = emptyList()),
			lastValidFrameIndex = 0,
			accruingScore = 10,
		)

		state.applyPenalty()

		assertEquals(-5, state.accruingScore)
	}

	@Test
	fun `test applyPenalty multiple times reduces score multiple times`() {
		val state = FivePinScoreCardState(
			input = ScoreCardInput(rolls = emptyList()),
			lastValidFrameIndex = 0,
			accruingScore = 10,
		)

		state.applyPenalty()
		state.applyPenalty()

		assertEquals(-20, state.accruingScore)
	}

	@Test
	fun `test displayScoreForFrame returns score`() {
		val state = FivePinScoreCardState(
			input = ScoreCardInput(rolls = emptyList()),
			lastValidFrameIndex = 0,
			accruingScore = 10,
		)

		assertEquals(10, state.displayScoreForFrame(0))
	}

	@Test
	fun `test displayScoreForFrame returns null if frame has not been bowled`() {
		val state = FivePinScoreCardState(
			input = ScoreCardInput(rolls = emptyList()),
			lastValidFrameIndex = 0,
			accruingScore = 10,
		)

		assertNull(state.displayScoreForFrame(1))
	}

	@Test
	fun `test displayScoreForFrame returns 0 if frame has been bowled and score is negative`() {
		val state = FivePinScoreCardState(
			input = ScoreCardInput(rolls = emptyList()),
			lastValidFrameIndex = 0,
			accruingScore = -10,
		)

		assertEquals(0, state.displayScoreForFrame(0))
	}
}