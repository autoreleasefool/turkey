package ca.josephroque.turkey.fivepin

import ca.josephroque.turkey.ScoreCardInput
import ca.josephroque.turkey.util.Game

/**
 * Represents the state of a score card for a game of five-pin bowling.
 *
 * @param input the input to calculate the score card
 * @param lastValidFrameIndex the index of the last frame which has been bowled
 * @param accruingScore the score which is being calculated
 */
internal data class FivePinScoreCardState(
	val input: ScoreCardInput,
	var lastValidFrameIndex: Int,
	var accruingScore: Int,
) {

	/**
	 * Update the score with a penalty.
	 */
	internal fun applyPenalty() {
		accruingScore -= Game.FOUL_PENALTY
	}

	/**
	 * Returns the score for the frame, if it has been bowled, or null otherwise. Applies penalties,
	 * but will not return a negative score.
	 */
	internal fun displayScoreForFrame(frameIndex: Int): Int? = if (frameIndex <= lastValidFrameIndex) {
		maxOf(accruingScore, 0)
	} else {
		null
	}
}
