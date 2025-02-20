package ca.josephroque.turkey

import ca.josephroque.turkey.model.ScoreCardFrame

interface ScoreCard {
	suspend fun calculateScore(input: ScoreCardInput): List<ScoreCardFrame>
}