package ca.josephroque.turkey.model

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ScoreCardRollTest {

	@Test
	fun `test isLastRoll returns true when roll is last roll`() {
		val roll = ScoreCardRoll(2, "2", didFoul = false, isMarkValue = false)

		assertTrue(roll.isLastRoll())
	}

	@Test
	fun `test isLastRoll returns false when roll is not last roll`() {
		val roll = ScoreCardRoll(0, "2", didFoul = false, isMarkValue = false)

		assertFalse(roll.isLastRoll())
	}

	@Test
	fun `test isFirstRoll returns true when roll is first roll`() {
		val roll = ScoreCardRoll(0, "2", didFoul = false, isMarkValue = false)

		assertTrue(roll.isFirstRoll())
	}

	@Test
	fun `test isFirstRoll returns false when roll is not first roll`() {
		val roll = ScoreCardRoll(2, "2", didFoul = false, isMarkValue = false)

		assertFalse(roll.isFirstRoll())
	}
}