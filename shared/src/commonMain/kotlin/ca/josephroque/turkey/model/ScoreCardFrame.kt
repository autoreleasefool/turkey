package ca.josephroque.turkey.model

import ca.josephroque.turkey.util.Frame

/**
 * Represents a frame in a game of bowling.
 *
 * @param index the index of the frame
 * @param rolls the rolls made in the frame
 * @param score the score of the frame, if it has been calculated, or null if the game has
 * not been bowled up to this frame.
 */
data class ScoreCardFrame(val index: Int, val rolls: List<ScoreCardRoll>, val score: Int?) {
	/** Display score of the frame. */
	val display: String?
		get() = score?.toString()

	/**
	 * Returns true if the frame is the last frame in a game.
	 */
	fun isLastFrame(): Boolean = Frame.isLastFrame(index)

	/**
	 * Returns true if the frame is the first frame in a game.
	 */
	fun isFirstFrame(): Boolean = index == 0
}

/**
 * Returns the score of the game, if it has been calculated, or null if the game has not been bowled.
 */
fun List<ScoreCardFrame>.gameScore(): Int? = reversed().firstNotNullOfOrNull { it.score }
