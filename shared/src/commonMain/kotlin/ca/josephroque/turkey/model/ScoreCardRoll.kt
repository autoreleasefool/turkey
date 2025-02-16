package ca.josephroque.turkey.model

import util.Roll

/**
 * Represents a roll in a frame.
 *
 * @param index the index of the roll within the frame
 * @param display the display value of the roll
 * @param didFoul whether the roll was a foul
 * @param isMarkValue whether the value comes from a earlier mark in the frame. True when an
 * earlier roll is a strike or a spare and this roll is only used to display the value earned
 * from a later roll in the subsequent frame.
 */
data class ScoreCardRoll(
	val index: Int,
	val display: String?,
	val didFoul: Boolean,
	val isMarkValue: Boolean,
) {

	/** Returns true when the roll is the last roll in the frame. */
	fun isLastRoll(): Boolean = Roll.isLastRoll(index)

	/** Returns true when the roll is the first roll in the frame. */
	fun isFirstRoll(): Boolean = index == 0
}
