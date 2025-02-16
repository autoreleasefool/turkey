package ca.josephroque.turkey.util

object Roll {
	/**
	 * Returns true if the index represents the last roll in a frame.
	 *
	 * @param index the index of the roll
	 */
	fun isLastRoll(index: Int): Boolean = index == Frame.NUMBER_OF_ROLLS - 1
}