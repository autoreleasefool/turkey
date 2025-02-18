package ca.josephroque.turkey.fivepin

import ca.josephroque.turkey.ScoreCardInput
import ca.josephroque.turkey.model.Pin
import ca.josephroque.turkey.model.ScoreCardFrame
import ca.josephroque.turkey.model.ScoreCardRoll
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

@ExperimentalCoroutinesApi
class FivePinScoreCardTest {

	@Test
	fun `test calculateScore returns correct score for simple game`() = runTest {
		val input = ScoreCardInput(
		  rolls = listOf(
				listOf(
					ScoreCardInput.Roll(
						frameIndex = 0,
						rollIndex = 0,
						didFoul = false,
						pinsDowned = Pin.fullDeck(),
					)
				)
			)
		)

		val scoreCard = FivePinScoreCard(coroutineContext = UnconfinedTestDispatcher())
		val result = scoreCard.calculateScore(input)

		assertEquals(
			listOf(
				ScoreCardFrame(
					index = 0,
					rolls = listOf(
						ScoreCardRoll(index = 0, didFoul = false, display = "X", isMarkValue = false),
						ScoreCardRoll(index = 1, didFoul = false, display = null, isMarkValue = false),
						ScoreCardRoll(index = 2, didFoul = false, display = null, isMarkValue = false)
					),
					score = 15,
				),
				incompleteFrame(1),
				incompleteFrame(2),
				incompleteFrame(3),
				incompleteFrame(4),
				incompleteFrame(5),
				incompleteFrame(6),
				incompleteFrame(7),
				incompleteFrame(8),
				incompleteFrame(9),
			),
			result
		)
	}

	private fun incompleteFrame(frameIndex: Int): ScoreCardFrame = ScoreCardFrame(
		index = frameIndex,
		rolls = listOf(
			ScoreCardRoll(index = 0, didFoul = false, display = null, isMarkValue = false),
			ScoreCardRoll(index = 1, didFoul = false, display = null, isMarkValue = false),
			ScoreCardRoll(index = 2, didFoul = false, display = null, isMarkValue = false)
		),
		score = null,
	)
}