package ca.josephroque.turkey.model

data class ScoreCardGame(val frames: List<ScoreCardFrame>) {
	val gameScore: Int?
		get() = frames.gameScore()
}
