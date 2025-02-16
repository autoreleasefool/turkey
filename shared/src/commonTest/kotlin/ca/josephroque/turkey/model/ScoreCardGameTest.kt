package ca.josephroque.turkey.model

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class ScoreCardGameTest {

	@Test
	fun `test gameScore is null when no frames`() {
		val game = ScoreCardGame(emptyList())

		assertNull(game.gameScore)
	}

	@Test
	fun `test gameScore is null when no frames have scores`() {
		val game = ScoreCardGame(listOf(ScoreCardFrame(0, emptyList(), null)))

		assertNull(game.gameScore)
	}

	@Test
	fun `test gameScore is score when frame has score`() {
		val game = ScoreCardGame(listOf(ScoreCardFrame(0, emptyList(), 123)))

		assertEquals(game.gameScore, 123)
	}

	@Test
	fun `test gameScore is score of the last frame`() {
		val game = ScoreCardGame(listOf(
			ScoreCardFrame(0, emptyList(), 10),
			ScoreCardFrame(1, emptyList(), 20),
			ScoreCardFrame(2, emptyList(), 30),
			ScoreCardFrame(3, emptyList(), null),
		))

		assertEquals(game.gameScore, 30)
	}
}