package util

object Game {
	/** Number of frames in a game of bowling. */
	const val NUMBER_OF_FRAMES = 10
	/** Indices of frames in a game of bowling. */
	val FrameIndices = 0..<NUMBER_OF_FRAMES

	/** Score penalty for invoking a foul. */
	const val FOUL_PENALTY = 15

	/** Maximum score achievable in a game of bowling. */
	const val MAX_SCORE = 450
}