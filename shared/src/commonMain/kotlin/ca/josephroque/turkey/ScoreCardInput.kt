package ca.josephroque.turkey

import ca.josephroque.turkey.model.Pin
import ca.josephroque.turkey.model.arePinsCleared
import ca.josephroque.turkey.model.pinCount

/**
 * Input value to calculate a score card.
 */
data class ScoreCardInput(val rolls: List<List<Roll>>) {

	/**
	 * Represents a roll in a game of bowling.
	 *
	 * @param frameIndex the index of the frame in which the roll was made
	 * @param rollIndex the index of the roll within the frame
	 * @param pinsDowned the pins which were downed
	 * @param didFoul whether the roll was a foul
	 */
	data class Roll(
		val frameIndex: Int,
		val rollIndex: Int,
		val pinsDowned: Set<Pin>,
		val didFoul: Boolean,
	)
}

private fun List<ScoreCardInput.Roll>.allPinsDowned() =
	fold(setOf<Pin>()) { acc, roll -> acc + roll.pinsDowned }

internal fun List<ScoreCardInput.Roll>.pinCount() = allPinsDowned().pinCount()
internal fun List<ScoreCardInput.Roll>.arePinsCleared() = allPinsDowned().arePinsCleared()
