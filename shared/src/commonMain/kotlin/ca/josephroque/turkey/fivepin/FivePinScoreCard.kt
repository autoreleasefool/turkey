package ca.josephroque.turkey.fivepin

import ca.josephroque.turkey.ScoreCard
import ca.josephroque.turkey.ScoreCardInput
import ca.josephroque.turkey.model.Pin
import ca.josephroque.turkey.model.ScoreCardFrame
import ca.josephroque.turkey.model.ScoreCardRoll
import ca.josephroque.turkey.model.arePinsCleared
import ca.josephroque.turkey.util.Frame
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class FivePinScoreCard(
	private val coroutineContext: CoroutineContext
) : ScoreCard {
	override suspend fun calculateScore(input: ScoreCardInput): List<ScoreCardFrame> = withContext(coroutineContext) {
		calculateScoreInternal(input)
	}

	private fun calculateScoreInternal(input: ScoreCardInput): List<ScoreCardFrame> {
		val steps: MutableList<ScoreCardFrame> = mutableListOf()
//		val state = generateStateFromInput(input)

		return emptyList()
	}

	private fun generateStateFromInput(input: ScoreCardInput): FivePinScoreCardState {
		// We consider frames with rolls to be valid
		val lastValidFrameIndex = input.rolls.indexOfLast { it.isNotEmpty() }

		// Frames from input may be invalid, so we need to generate a list of valid frames
		val stateRolls = mutableListOf<List<ScoreCardInput.Roll>>()

		for ((index, frameRolls) in input.rolls.withIndex()) {
			val frameIndex = frameRolls.firstOrNull()?.frameIndex ?: index

			// Must be at least 1 roll or we skip the frame
			if (frameRolls.isEmpty()) {
				// Insert empty rolls for missing frames that should be valid
				addMissingRollsForValidFrames(stateRolls, frameIndex, lastValidFrameIndex)

				continue
			}

			val stateFrameRolls = mutableListOf<ScoreCardInput.Roll>()
			val pinsDowned = mutableSetOf<Pin>()

			for (rollIndex in frameRolls.indices) {
				val roll = frameRolls[rollIndex]
				pinsDowned += roll.pinsDowned

				stateFrameRolls.add(
					ScoreCardInput.Roll(
						frameIndex = frameIndex,
						rollIndex = rollIndex,
						pinsDowned = roll.pinsDowned,
						didFoul = roll.didFoul
					)
				)

				// Ignore any rolls after 5 pins are down
				if (pinsDowned.size == 5 && !Frame.isLastFrame(frameIndex)) {
					break
				}
			}

			if (
				frameIndex < lastValidFrameIndex &&
				frameRolls.size < Frame.NUMBER_OF_ROLLS &&
				!pinsDowned.arePinsCleared()
			) {
				// Insert empty rolls for any unrecorded
				stateFrameRolls.addAll(
					Frame.rollIndicesAfter(frameRolls.lastIndex).map {
						ScoreCardRoll()
					}
				)
			}
		}

		return FivePinScoreCardState(
			input = ScoreCardInput(rolls = stateRolls),
			lastValidFrameIndex = lastValidFrameIndex,
			accruingScore = 0,
		)
	}

	private fun addMissingRollsForValidFrames(
		stateRolls: MutableList<List<ScoreCardInput.Roll>>,
		frameIndex: Int,
		lastValidFrameIndex: Int
	) {
		if (frameIndex < lastValidFrameIndex) {
			stateRolls.add(
				Frame.RollIndices.map {
					ScoreCardInput.Roll(
						frameIndex = frameIndex,
						rollIndex = it,
						pinsDowned = emptySet(),
						didFoul = false
					)
				}
			)
		}
	}
}