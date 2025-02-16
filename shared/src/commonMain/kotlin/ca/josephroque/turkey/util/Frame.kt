package ca.josephroque.turkey.util

object Frame {
	/** Number of rolls in a single frame. */
	const val NUMBER_OF_ROLLS = 3
	/** Indices of rolls in a frame. */
	val RollIndices = 0..<NUMBER_OF_ROLLS

	/**
	 * Returns true if the index represents the last frame in a game.
	 *
	 * @param index the index of the frame
	 */
	fun isLastFrame(index: Int): Boolean = index == Game.NUMBER_OF_FRAMES - 1
}