package ca.josephroque.turkey.model

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

fun Pin.Companion.headPin(): Set<Pin> = setOf(Pin.HEAD_PIN)
fun Pin.Companion.headPin2(): Set<Pin> = setOf(Pin.HEAD_PIN, Pin.LEFT_TWO_PIN)
fun Pin.Companion.ace(): Set<Pin> = setOf(Pin.HEAD_PIN, Pin.LEFT_THREE_PIN, Pin.RIGHT_THREE_PIN)
fun Pin.Companion.leftTap(): Set<Pin> = setOf(Pin.LEFT_THREE_PIN, Pin.HEAD_PIN, Pin.RIGHT_THREE_PIN, Pin.RIGHT_TWO_PIN)
fun Pin.Companion.rightTap(): Set<Pin> = setOf(Pin.LEFT_TWO_PIN, Pin.LEFT_THREE_PIN, Pin.HEAD_PIN, Pin.RIGHT_THREE_PIN)
fun Pin.Companion.tap(): Set<Pin> = leftTap()
fun Pin.Companion.leftChop(): Set<Pin> = setOf(Pin.HEAD_PIN, Pin.LEFT_TWO_PIN, Pin.LEFT_THREE_PIN)
fun Pin.Companion.rightChop(): Set<Pin> = setOf(Pin.HEAD_PIN, Pin.RIGHT_TWO_PIN, Pin.RIGHT_THREE_PIN)
fun Pin.Companion.chop(): Set<Pin> = leftChop()
fun Pin.Companion.leftSplit(): Set<Pin> = setOf(Pin.HEAD_PIN, Pin.LEFT_THREE_PIN)
fun Pin.Companion.leftSplitWithBonus(): Set<Pin> = setOf(Pin.HEAD_PIN, Pin.LEFT_THREE_PIN, Pin.RIGHT_TWO_PIN)
fun Pin.Companion.rightSplit(): Set<Pin> = setOf(Pin.HEAD_PIN, Pin.RIGHT_THREE_PIN)
fun Pin.Companion.rightSplitWithBonus(): Set<Pin> = setOf(Pin.HEAD_PIN, Pin.RIGHT_THREE_PIN, Pin.LEFT_TWO_PIN)
fun Pin.Companion.split(): Set<Pin> = leftSplit()
fun Pin.Companion.splitWithBonus(): Set<Pin> = leftSplitWithBonus()
fun Pin.Companion.hitLeftOfMiddle(): Set<Pin> = setOf(Pin.LEFT_TWO_PIN, Pin.LEFT_THREE_PIN)
fun Pin.Companion.hitRightOfMiddle(): Set<Pin> = setOf(Pin.RIGHT_TWO_PIN, Pin.RIGHT_THREE_PIN)
fun Pin.Companion.middleHit(): Set<Pin> = setOf(Pin.HEAD_PIN)
fun Pin.Companion.leftTwelve(): Set<Pin> = setOf(Pin.LEFT_TWO_PIN, Pin.LEFT_THREE_PIN, Pin.HEAD_PIN, Pin.RIGHT_TWO_PIN)
fun Pin.Companion.rightTwelve(): Set<Pin> = setOf(Pin.LEFT_TWO_PIN, Pin.HEAD_PIN, Pin.RIGHT_TWO_PIN, Pin.RIGHT_THREE_PIN)
fun Pin.Companion.twelve(): Set<Pin> = leftTwelve()
fun Pin.Companion.leftFive(): Set<Pin> = setOf(Pin.LEFT_TWO_PIN, Pin.LEFT_THREE_PIN)
fun Pin.Companion.rightFive(): Set<Pin> = setOf(Pin.RIGHT_TWO_PIN, Pin.RIGHT_THREE_PIN)
fun Pin.Companion.five(): Set<Pin> = leftFive()
fun Pin.Companion.leftThree(): Set<Pin> = setOf(Pin.LEFT_THREE_PIN)
fun Pin.Companion.rightThree(): Set<Pin> = setOf(Pin.RIGHT_THREE_PIN)
fun Pin.Companion.three(): Set<Pin> = leftThree()

class PinTest {

	@Test
	fun `test isHeadPin returns true when only headpin is down`() {
		val pins = setOf(Pin.HEAD_PIN)

		assertTrue(pins.isHeadPin())
	}

	@Test
	fun `test isHeadPin returns false when headpin is not down`() {
		for (pin in Pin.fullDeck().filter { it != Pin.HEAD_PIN }) {
			val pins = setOf(pin)

			assertFalse(pins.isHeadPin())
		}
	}

	@Test
	fun `test isHeadPin returns false when more than one pin is down`() {
		for (pin in Pin.fullDeck().filter { it != Pin.HEAD_PIN }) {
			val pins = setOf(pin, Pin.HEAD_PIN)

			assertFalse(pins.isHeadPin())
		}
	}

	@Test
	fun `test headPin is headPin`() {
		assertTrue(Pin.headPin().isHeadPin())
	}

	@Test
	fun `test isHeadPin2 returns true when headpin and one 2-pin is down`() {
		for (pin in listOf(Pin.LEFT_TWO_PIN, Pin.RIGHT_TWO_PIN)) {
			val pins = setOf(Pin.HEAD_PIN, pin)

			assertTrue(pins.isHeadPin2())
		}
	}

	@Test
	fun `test isHeadPin2 returns false when headpin is not down`() {
		for (pin in Pin.fullDeck().filter { it != Pin.HEAD_PIN }) {
			val pins = setOf(pin, Pin.LEFT_TWO_PIN)

			assertFalse(pins.isHeadPin2())
		}
	}

	@Test
	fun `test isHeadPin2 returns false when more than one 2-pin is down`() {
		val pins = setOf(Pin.HEAD_PIN, Pin.LEFT_TWO_PIN, Pin.RIGHT_TWO_PIN)

		assertFalse(pins.isHeadPin2())
	}

	@Test
	fun `test headPin2 is headPin2`() {
		assertTrue(Pin.headPin2().isHeadPin2())
	}

	@Test
	fun `test isAce returns true when headpin and 3-pins are down`() {
		val pins = setOf(Pin.HEAD_PIN, Pin.LEFT_THREE_PIN, Pin.RIGHT_THREE_PIN)

		assertTrue(pins.isAce())
	}

	@Test
	fun `test isAce returns false when headpin is not down`() {
		val pins = setOf(Pin.LEFT_THREE_PIN, Pin.RIGHT_THREE_PIN)

		assertFalse(pins.isAce())
	}

	@Test
	fun `test isAce returns false when 3-pins are not down`() {
		val pins = setOf(Pin.HEAD_PIN, Pin.LEFT_TWO_PIN, Pin.RIGHT_TWO_PIN)

		assertFalse(pins.isAce())
	}

	@Test
	fun `test ace is ace`() {
		assertTrue(Pin.ace().isAce())
	}

	@Test
	fun `test isLeftTap returns true when all pins are down except left 2-pin`() {
		val pins = setOf(Pin.LEFT_THREE_PIN, Pin.HEAD_PIN, Pin.RIGHT_THREE_PIN, Pin.RIGHT_TWO_PIN)

		assertTrue(pins.isLeftTap())
	}

	@Test
	fun `test isLeftTap returns false when left 2-pin is down`() {
		val pins = setOf(Pin.LEFT_TWO_PIN, Pin.LEFT_THREE_PIN, Pin.HEAD_PIN, Pin.RIGHT_THREE_PIN)

		assertFalse(pins.isLeftTap())
	}

	@Test
	fun `test leftTap is leftTap`() {
		assertTrue(Pin.leftTap().isLeftTap())
	}

	@Test
	fun `test isRightTap returns true when all pins are down except right 2-pin`() {
		val pins = setOf(Pin.LEFT_TWO_PIN, Pin.LEFT_THREE_PIN, Pin.HEAD_PIN, Pin.RIGHT_THREE_PIN)

		assertTrue(pins.isRightTap())
	}

	@Test
	fun `test isRightTap returns false when right 2-pin is down`() {
		val pins = setOf(Pin.LEFT_TWO_PIN, Pin.LEFT_THREE_PIN, Pin.HEAD_PIN, Pin.RIGHT_TWO_PIN)

		assertFalse(pins.isRightTap())
	}

	@Test
	fun `test rightTap is rightTap`() {
		assertTrue(Pin.rightTap().isRightTap())
	}

	@Test
	fun `test isTap returns true when left or right tap`() {
		val leftTap = setOf(Pin.LEFT_THREE_PIN, Pin.HEAD_PIN, Pin.RIGHT_THREE_PIN, Pin.RIGHT_TWO_PIN)
		val rightTap = setOf(Pin.LEFT_TWO_PIN, Pin.LEFT_THREE_PIN, Pin.HEAD_PIN, Pin.RIGHT_THREE_PIN)

		assertTrue(leftTap.isTap())
		assertTrue(rightTap.isTap())
	}

	@Test
	fun `test isTap returns false when not left or right tap`() {
		val pins = setOf(Pin.LEFT_TWO_PIN, Pin.LEFT_THREE_PIN, Pin.HEAD_PIN, Pin.RIGHT_TWO_PIN)

		assertFalse(pins.isTap())
	}

	@Test
	fun `test tap is tap`() {
		assertTrue(Pin.tap().isTap())
	}

	@Test
	fun `test isLeftChop returns true when headpin and left 2-pin and left 3-pin are down`() {
		val pins = setOf(Pin.HEAD_PIN, Pin.LEFT_TWO_PIN, Pin.LEFT_THREE_PIN)

		assertTrue(pins.isLeftChop())
	}

	@Test
	fun `test isLeftChop returns false when headpin is not down`() {
		val pins = setOf(Pin.LEFT_TWO_PIN, Pin.LEFT_THREE_PIN)

		assertFalse(pins.isLeftChop())
	}

	@Test
	fun `test isLeftChop returns false when left 2-pin is not down`() {
		val pins = setOf(Pin.HEAD_PIN, Pin.LEFT_THREE_PIN)

		assertFalse(pins.isLeftChop())
	}

	@Test
	fun `test isLeftChop returns false when left 3-pin is not down`() {
		val pins = setOf(Pin.HEAD_PIN, Pin.LEFT_TWO_PIN)

		assertFalse(pins.isLeftChop())
	}

	@Test
	fun `test isLeftChop returns false when more pins are down`() {
		val pins = setOf(Pin.HEAD_PIN, Pin.LEFT_TWO_PIN, Pin.LEFT_THREE_PIN, Pin.RIGHT_TWO_PIN)

		assertFalse(pins.isLeftChop())
	}

	@Test
	fun `test leftChop is leftChop`() {
		assertTrue(Pin.leftChop().isLeftChop())
	}

	@Test
	fun `test isRightChop returns true when headpin and right 2-pin and right 3-pin are down`() {
		val pins = setOf(Pin.HEAD_PIN, Pin.RIGHT_TWO_PIN, Pin.RIGHT_THREE_PIN)

		assertTrue(pins.isRightChop())
	}

	@Test
	fun `test isRightChop returns false when headpin is not down`() {
		val pins = setOf(Pin.RIGHT_TWO_PIN, Pin.RIGHT_THREE_PIN)

		assertFalse(pins.isRightChop())
	}

	@Test
	fun `test isRightChop returns false when right 2-pin is not down`() {
		val pins = setOf(Pin.HEAD_PIN, Pin.RIGHT_THREE_PIN)

		assertFalse(pins.isRightChop())
	}

	@Test
	fun `test isRightChop returns false when right 3-pin is not down`() {
		val pins = setOf(Pin.HEAD_PIN, Pin.RIGHT_TWO_PIN)

		assertFalse(pins.isRightChop())
	}

	@Test
	fun `test isRightChop returns false when more pins are down`() {
		val pins = setOf(Pin.HEAD_PIN, Pin.RIGHT_TWO_PIN, Pin.RIGHT_THREE_PIN, Pin.LEFT_TWO_PIN)

		assertFalse(pins.isRightChop())
	}

	@Test
	fun `test rightChop is rightChop`() {
		assertTrue(Pin.rightChop().isRightChop())
	}

	@Test
	fun `test isChop returns true when left or right chop`() {
		val leftChop = setOf(Pin.HEAD_PIN, Pin.LEFT_TWO_PIN, Pin.LEFT_THREE_PIN)
		val rightChop = setOf(Pin.HEAD_PIN, Pin.RIGHT_TWO_PIN, Pin.RIGHT_THREE_PIN)

		assertTrue(leftChop.isChop())
		assertTrue(rightChop.isChop())
	}

	@Test
	fun `test isChop returns false when not left or right chop`() {
		val pins = setOf(Pin.HEAD_PIN, Pin.LEFT_TWO_PIN, Pin.RIGHT_TWO_PIN)

		assertFalse(pins.isChop())
	}

	@Test
	fun `test chop is chop`() {
		assertTrue(Pin.chop().isChop())
	}

	@Test
	fun `test isLeftSplit returns true when headpin and left 3-pin are down`() {
		val pins = setOf(Pin.HEAD_PIN, Pin.LEFT_THREE_PIN)

		assertTrue(pins.isLeftSplit())
	}

	@Test
	fun `test isLeftSplit returns false when headpin is not down`() {
		val pins = setOf(Pin.LEFT_THREE_PIN)

		assertFalse(pins.isLeftSplit())
	}

	@Test
	fun `test isLeftSplit returns false when left 3-pin is not down`() {
		val pins = setOf(Pin.HEAD_PIN, Pin.LEFT_TWO_PIN)

		assertFalse(pins.isLeftSplit())
	}

	@Test
	fun `test isLeftSplit returns false when more pins are down`() {
		val pins = setOf(Pin.HEAD_PIN, Pin.LEFT_THREE_PIN, Pin.RIGHT_TWO_PIN)

		assertFalse(pins.isLeftSplit())
	}

	@Test
	fun `test leftSplit is leftSplit`() {
		assertTrue(Pin.leftSplit().isLeftSplit())
	}

	@Test
	fun `test isLeftSplitWithBonus returns true when headpin and left 3-pin and right 2-pin are down`() {
		val pins = setOf(Pin.HEAD_PIN, Pin.LEFT_THREE_PIN, Pin.RIGHT_TWO_PIN)

		assertTrue(pins.isLeftSplitWithBonus())
	}

	@Test
	fun `test isLeftSplitWithBonus returns false when headpin is not down`() {
		val pins = setOf(Pin.LEFT_THREE_PIN, Pin.RIGHT_TWO_PIN)

		assertFalse(pins.isLeftSplitWithBonus())
	}

	@Test
	fun `test isLeftSplitWithBonus returns false when left 3-pin is not down`() {
		val pins = setOf(Pin.HEAD_PIN, Pin.RIGHT_TWO_PIN)

		assertFalse(pins.isLeftSplitWithBonus())
	}

	@Test
	fun `test isLeftSplitWithBonus returns false when right 2-pin is not down`() {
		val pins = setOf(Pin.HEAD_PIN, Pin.LEFT_THREE_PIN)

		assertFalse(pins.isLeftSplitWithBonus())
	}

	@Test
	fun `test isLeftSplitWithBonus returns false when more pins are down`() {
		val pins = setOf(Pin.HEAD_PIN, Pin.LEFT_THREE_PIN, Pin.RIGHT_TWO_PIN, Pin.RIGHT_THREE_PIN)

		assertFalse(pins.isLeftSplitWithBonus())
	}

	@Test
	fun `test leftSplitWithBonus is leftSplitWithBonus`() {
		assertTrue(Pin.leftSplitWithBonus().isLeftSplitWithBonus())
	}

	@Test
	fun `test isRightSplit returns true when headpin and right 3-pin are down`() {
		val pins = setOf(Pin.HEAD_PIN, Pin.RIGHT_THREE_PIN)

		assertTrue(pins.isRightSplit())
	}

	@Test
	fun `test isRightSplit returns false when headpin is not down`() {
		val pins = setOf(Pin.RIGHT_THREE_PIN)

		assertFalse(pins.isRightSplit())
	}

	@Test
	fun `test isRightSplit returns false when right 3-pin is not down`() {
		val pins = setOf(Pin.HEAD_PIN, Pin.RIGHT_TWO_PIN)

		assertFalse(pins.isRightSplit())
	}

	@Test
	fun `test isRightSplit returns false when more pins are down`() {
		val pins = setOf(Pin.HEAD_PIN, Pin.RIGHT_THREE_PIN, Pin.LEFT_TWO_PIN)

		assertFalse(pins.isRightSplit())
	}

	@Test
	fun `test rightSplit is rightSplit`() {
		assertTrue(Pin.rightSplit().isRightSplit())
	}

	@Test
	fun `test isRightSplitWithBonus returns true when headpin and right 3-pin and left 2-pin are down`() {
		val pins = setOf(Pin.HEAD_PIN, Pin.RIGHT_THREE_PIN, Pin.LEFT_TWO_PIN)

		assertTrue(pins.isRightSplitWithBonus())
	}

	@Test
	fun `test isRightSplitWithBonus returns false when headpin is not down`() {
		val pins = setOf(Pin.RIGHT_THREE_PIN, Pin.LEFT_TWO_PIN)

		assertFalse(pins.isRightSplitWithBonus())
	}

	@Test
	fun `test isRightSplitWithBonus returns false when right 3-pin is not down`() {
		val pins = setOf(Pin.HEAD_PIN, Pin.LEFT_TWO_PIN)

		assertFalse(pins.isRightSplitWithBonus())
	}

	@Test
	fun `test isRightSplitWithBonus returns false when left 2-pin is not down`() {
		val pins = setOf(Pin.HEAD_PIN, Pin.RIGHT_THREE_PIN)

		assertFalse(pins.isRightSplitWithBonus())
	}

	@Test
	fun `test isRightSplitWithBonus returns false when more pins are down`() {
		val pins = setOf(Pin.HEAD_PIN, Pin.RIGHT_THREE_PIN, Pin.LEFT_TWO_PIN, Pin.LEFT_THREE_PIN)

		assertFalse(pins.isRightSplitWithBonus())
	}

	@Test
	fun `test rightSplitWithBonus is rightSplitWithBonus`() {
		assertTrue(Pin.rightSplitWithBonus().isRightSplitWithBonus())
	}

	@Test
	fun `test isSplit returns true when left or right split`() {
		val leftSplit = setOf(Pin.HEAD_PIN, Pin.LEFT_THREE_PIN)
		val rightSplit = setOf(Pin.HEAD_PIN, Pin.RIGHT_THREE_PIN)

		assertTrue(leftSplit.isSplit())
		assertTrue(rightSplit.isSplit())
	}

	@Test
	fun `test isSplit returns false when not left or right split`() {
		val pins = setOf(Pin.HEAD_PIN, Pin.LEFT_THREE_PIN, Pin.RIGHT_TWO_PIN)

		assertFalse(pins.isSplit())
	}

	@Test
	fun `test split is split`() {
		assertTrue(Pin.split().isSplit())
	}

	@Test
	fun `test isSplitWithBonus returns true when left or right split with bonus`() {
		val leftSplit = setOf(Pin.HEAD_PIN, Pin.LEFT_THREE_PIN, Pin.RIGHT_TWO_PIN)
		val rightSplit = setOf(Pin.HEAD_PIN, Pin.RIGHT_THREE_PIN, Pin.LEFT_TWO_PIN)

		assertTrue(leftSplit.isSplitWithBonus())
		assertTrue(rightSplit.isSplitWithBonus())
	}

	@Test
	fun `test isSplitWithBonus returns false when not left or right split with bonus`() {
		val pins = setOf(Pin.HEAD_PIN, Pin.LEFT_THREE_PIN, Pin.RIGHT_TWO_PIN, Pin.RIGHT_THREE_PIN)

		assertFalse(pins.isSplitWithBonus())
	}

	@Test
	fun `test splitWithBonus is splitWithBonus`() {
		assertTrue(Pin.splitWithBonus().isSplitWithBonus())
	}

	@Test
	fun `test isHitLeftOfMiddle returns true when left 2-pin or left 3-pin is down`() {
		val leftTwoPin = setOf(Pin.LEFT_TWO_PIN)
		val leftThreePin = setOf(Pin.LEFT_THREE_PIN)
		val leftPins = setOf(Pin.LEFT_TWO_PIN, Pin.LEFT_THREE_PIN)

		assertTrue(leftTwoPin.isHitLeftOfMiddle())
		assertTrue(leftThreePin.isHitLeftOfMiddle())
		assertTrue(leftPins.isHitLeftOfMiddle())
	}

	@Test
	fun `test isHitLeftOfMiddle returns false when headpin or right 3-pin is down`() {
		val headPin = setOf(Pin.HEAD_PIN)
		val rightThreePin = setOf(Pin.RIGHT_THREE_PIN)
		val leftPinsWithHeadPin = setOf(Pin.LEFT_TWO_PIN, Pin.LEFT_THREE_PIN, Pin.HEAD_PIN)

		assertFalse(headPin.isHitLeftOfMiddle())
		assertFalse(rightThreePin.isHitLeftOfMiddle())
		assertFalse(leftPinsWithHeadPin.isHitLeftOfMiddle())
	}

	@Test
	fun `test hitLeftOfMiddle is hitLeftOfMiddle`() {
		assertTrue(Pin.hitLeftOfMiddle().isHitLeftOfMiddle())
	}

	@Test
	fun `test isHitRightOfMiddle returns true when right 2-pin or right 3-pin is down`() {
		val rightTwoPin = setOf(Pin.RIGHT_TWO_PIN)
		val rightThreePin = setOf(Pin.RIGHT_THREE_PIN)
		val rightPins = setOf(Pin.RIGHT_TWO_PIN, Pin.RIGHT_THREE_PIN)

		assertTrue(rightTwoPin.isHitRightOfMiddle())
		assertTrue(rightThreePin.isHitRightOfMiddle())
		assertTrue(rightPins.isHitRightOfMiddle())
	}

	@Test
	fun `test isHitRightOfMiddle returns false when headpin or left 3-pin is down`() {
		val headPin = setOf(Pin.HEAD_PIN)
		val leftThreePin = setOf(Pin.LEFT_THREE_PIN)
		val rightPinsWithHeadPin = setOf(Pin.RIGHT_TWO_PIN, Pin.RIGHT_THREE_PIN, Pin.HEAD_PIN)

		assertFalse(headPin.isHitRightOfMiddle())
		assertFalse(leftThreePin.isHitRightOfMiddle())
		assertFalse(rightPinsWithHeadPin.isHitRightOfMiddle())
	}

	@Test
	fun `test hitRightOfMiddle is hitRightOfMiddle`() {
		assertTrue(Pin.hitRightOfMiddle().isHitRightOfMiddle())
	}

	@Test
	fun `test isMiddleHit returns true when headpin is down`() {
		val headPin = setOf(Pin.HEAD_PIN)
		val allPins = Pin.fullDeck()
		val leftChop = setOf(Pin.HEAD_PIN, Pin.LEFT_TWO_PIN, Pin.LEFT_THREE_PIN)

		assertTrue(headPin.isMiddleHit())
		assertTrue(allPins.isMiddleHit())
		assertTrue(leftChop.isMiddleHit())
	}

	@Test
	fun `test isMiddleHit returns false when headpin is not down`() {
		val rightTwoPin = setOf(Pin.RIGHT_TWO_PIN)
		val rightThreePin = setOf(Pin.RIGHT_THREE_PIN)
		val rightPins = setOf(Pin.RIGHT_TWO_PIN, Pin.RIGHT_THREE_PIN)

		assertFalse(rightTwoPin.isMiddleHit())
		assertFalse(rightThreePin.isMiddleHit())
		assertFalse(rightPins.isMiddleHit())
	}

	@Test
	fun `test middleHit is middleHit`() {
		assertTrue(Pin.middleHit().isMiddleHit())
	}

	@Test
	fun `test isLeftTwelve returns true when all pins are down except right 3-pin`() {
		val pins = setOf(Pin.LEFT_TWO_PIN, Pin.LEFT_THREE_PIN, Pin.HEAD_PIN, Pin.RIGHT_TWO_PIN)

		assertTrue(pins.isLeftTwelve())
	}

	@Test
	fun `test isLeftTwelve returns false when right 3-pin is down`() {
		val pins = setOf(Pin.LEFT_TWO_PIN, Pin.LEFT_THREE_PIN, Pin.HEAD_PIN, Pin.RIGHT_THREE_PIN)

		assertFalse(pins.isLeftTwelve())
	}

	@Test
	fun `test leftTwelve is leftTwelve`() {
		assertTrue(Pin.leftTwelve().isLeftTwelve())
	}

	@Test
	fun `test isRightTwelve returns true when all pins are down except left 3-pin`() {
		val pins = setOf(Pin.LEFT_TWO_PIN, Pin.HEAD_PIN, Pin.RIGHT_TWO_PIN, Pin.RIGHT_THREE_PIN)

		assertTrue(pins.isRightTwelve())
	}

	@Test
	fun `test isRightTwelve returns false when left 3-pin is down`() {
		val pins = setOf(Pin.LEFT_THREE_PIN, Pin.HEAD_PIN, Pin.RIGHT_TWO_PIN, Pin.RIGHT_THREE_PIN)

		assertFalse(pins.isRightTwelve())
	}

	@Test
	fun `test rightTwelve is rightTwelve`() {
		assertTrue(Pin.rightTwelve().isRightTwelve())
	}

	@Test
	fun `test isTwelve returns true when left or right twelve`() {
		val leftTwelve = setOf(Pin.LEFT_TWO_PIN, Pin.LEFT_THREE_PIN, Pin.HEAD_PIN, Pin.RIGHT_TWO_PIN)
		val rightTwelve = setOf(Pin.LEFT_TWO_PIN, Pin.HEAD_PIN, Pin.RIGHT_TWO_PIN, Pin.RIGHT_THREE_PIN)

		assertTrue(leftTwelve.isTwelve())
		assertTrue(rightTwelve.isTwelve())
	}

	@Test
	fun `test isTwelve returns false when not left or right twelve`() {
		val pins = setOf(Pin.LEFT_TWO_PIN, Pin.LEFT_THREE_PIN, Pin.HEAD_PIN, Pin.RIGHT_TWO_PIN, Pin.RIGHT_THREE_PIN)

		assertFalse(pins.isTwelve())
	}

	@Test
	fun `test twelve is twelve`() {
		assertTrue(Pin.twelve().isTwelve())
	}

	@Test
	fun `test isLeftFive returns true when left 2-pin and left 3-pin are down`() {
		val pins = setOf(Pin.LEFT_TWO_PIN, Pin.LEFT_THREE_PIN)

		assertTrue(pins.isLeftFive())
	}

	@Test
	fun `test isLeftFive returns false when left 2-pin is not down`() {
		val pins = setOf(Pin.LEFT_THREE_PIN)

		assertFalse(pins.isLeftFive())
	}

	@Test
	fun `test isLeftFive returns false when left 3-pin is not down`() {
		val pins = setOf(Pin.LEFT_TWO_PIN)

		assertFalse(pins.isLeftFive())
	}

	@Test
	fun `test isLeftFive returns false when more pins are down`() {
		val pins = setOf(Pin.LEFT_TWO_PIN, Pin.LEFT_THREE_PIN, Pin.HEAD_PIN)

		assertFalse(pins.isLeftFive())
	}

	@Test
	fun `test leftFive is leftFive`() {
		assertTrue(Pin.leftFive().isLeftFive())
	}

	@Test
	fun `test isRightFive returns true when right 2-pin and right 3-pin are down`() {
		val pins = setOf(Pin.RIGHT_TWO_PIN, Pin.RIGHT_THREE_PIN)

		assertTrue(pins.isRightFive())
	}

	@Test
	fun `test isRightFive returns false when right 2-pin is not down`() {
		val pins = setOf(Pin.RIGHT_THREE_PIN)

		assertFalse(pins.isRightFive())
	}

	@Test
	fun `test isRightFive returns false when right 3-pin is not down`() {
		val pins = setOf(Pin.RIGHT_TWO_PIN)

		assertFalse(pins.isRightFive())
	}

	@Test
	fun `test isRightFive returns false when more pins are down`() {
		val pins = setOf(Pin.RIGHT_TWO_PIN, Pin.RIGHT_THREE_PIN, Pin.HEAD_PIN)

		assertFalse(pins.isRightFive())
	}

	@Test
	fun `test rightFive is rightFive`() {
		assertTrue(Pin.rightFive().isRightFive())
	}

	@Test
	fun `test isFive returns true when left or right five`() {
		val leftFive = setOf(Pin.LEFT_TWO_PIN, Pin.LEFT_THREE_PIN)
		val rightFive = setOf(Pin.RIGHT_TWO_PIN, Pin.RIGHT_THREE_PIN)

		assertTrue(leftFive.isFive())
		assertTrue(rightFive.isFive())
	}

	@Test
	fun `test isFive returns false when not left or right five`() {
		val pins = setOf(Pin.LEFT_TWO_PIN, Pin.LEFT_THREE_PIN, Pin.HEAD_PIN, Pin.RIGHT_TWO_PIN, Pin.RIGHT_THREE_PIN)

		assertFalse(pins.isFive())
	}

	@Test
	fun `test five is five`() {
		assertTrue(Pin.five().isFive())
	}

	@Test
	fun `test isLeftThree returns true when only left 3-pin is down`() {
		val pins = setOf(Pin.LEFT_THREE_PIN)

		assertTrue(pins.isLeftThree())
	}

	@Test
	fun `test isLeftThree returns false when left 3-pin is not down`() {
		val pins = setOf(Pin.LEFT_TWO_PIN)

		assertFalse(pins.isLeftThree())
	}

	@Test
	fun `test isLeftThree returns false when more pins are down`() {
		val pins = setOf(Pin.LEFT_TWO_PIN, Pin.LEFT_THREE_PIN)

		assertFalse(pins.isLeftThree())
	}

	@Test
	fun `test leftThree is leftThree`() {
		assertTrue(Pin.leftThree().isLeftThree())
	}

	@Test
	fun `test isRightThree returns true when only right 3-pin is down`() {
		val pins = setOf(Pin.RIGHT_THREE_PIN)

		assertTrue(pins.isRightThree())
	}

	@Test
	fun `test isRightThree returns false when right 3-pin is not down`() {
		val pins = setOf(Pin.RIGHT_TWO_PIN)

		assertFalse(pins.isRightThree())
	}

	@Test
	fun `test isRightThree returns false when more pins are down`() {
		val pins = setOf(Pin.RIGHT_TWO_PIN, Pin.RIGHT_THREE_PIN)

		assertFalse(pins.isRightThree())
	}

	@Test
	fun `test rightThree is rightThree`() {
		assertTrue(Pin.rightThree().isRightThree())
	}

	@Test
	fun `test isThree returns true when left or right three`() {
		val leftThree = setOf(Pin.LEFT_THREE_PIN)
		val rightThree = setOf(Pin.RIGHT_THREE_PIN)

		assertTrue(leftThree.isThree())
		assertTrue(rightThree.isThree())
	}

	@Test
	fun `test isThree returns false when not left or right three`() {
		val pins = setOf(Pin.LEFT_TWO_PIN, Pin.LEFT_THREE_PIN, Pin.HEAD_PIN, Pin.RIGHT_TWO_PIN, Pin.RIGHT_THREE_PIN)

		assertFalse(pins.isThree())
	}

	@Test
	fun `test three is three`() {
		assertTrue(Pin.three().isThree())
	}

	@Test
	fun `test arePinsCleared returns true when all pins are down`() {
		val pins = Pin.fullDeck()

		assertTrue(pins.arePinsCleared())
	}

	@Test
	fun `test arePinsCleared returns false when not all pins are down`() {
		for (pin in Pin.fullDeck()) {
			val pins = Pin.fullDeck() - pin

			assertFalse(pins.arePinsCleared())
		}
	}

	@Test
	fun `test displayAt returns symbol if rollIndex is 0`() {
		val headPin = Pin.headPin()
		assertEquals("HP", headPin.displayAt(0))

		val headPin2 = Pin.headPin2()
		assertEquals("H2", headPin2.displayAt(0))

		val split = Pin.split()
		assertEquals("HS", split.displayAt(0))

		val splitWithBonus = Pin.splitWithBonus()
		assertEquals("10", splitWithBonus.displayAt(0))

		val chop = Pin.chop()
		assertEquals("C/O", chop.displayAt(0))

		val ace = Pin.ace()
		assertEquals("A", ace.displayAt(0))

		val leftTap = Pin.leftTap()
		assertEquals("L", leftTap.displayAt(0))

		val rightTap = Pin.rightTap()
		assertEquals("R", rightTap.displayAt(0))

		val strike = Pin.fullDeck()
		assertEquals("X", strike.displayAt(0))
	}

	@Test
	fun `test displayAt returns symbol for spare`() {
		val pins = Pin.fullDeck()
		assertEquals("/", pins.displayAt(1))
	}

	@Test
	fun `test displayAt returns numeric value for cleared`() {
		val pins = Pin.fullDeck()
		assertEquals("15", pins.displayAt(2))
	}

	@Test
	fun `test displayAt returns numeric value for other rolls`() {
		val headPin = Pin.headPin()
		assertEquals("5", headPin.displayAt(1))
		assertEquals("5", headPin.displayAt(2))

		val headPin2 = Pin.headPin2()
		assertEquals("7", headPin2.displayAt(1))
		assertEquals("7", headPin2.displayAt(2))

		val split = Pin.split()
		assertEquals("8", split.displayAt(1))
		assertEquals("8", split.displayAt(2))

		val splitWithBonus = Pin.splitWithBonus()
		assertEquals("10", splitWithBonus.displayAt(1))
		assertEquals("10", splitWithBonus.displayAt(2))

		val chop = Pin.chop()
		assertEquals("10", chop.displayAt(1))
		assertEquals("10", chop.displayAt(2))

		val ace = Pin.ace()
		assertEquals("11", ace.displayAt(1))
		assertEquals("11", ace.displayAt(2))

		val leftTap = Pin.leftTap()
		assertEquals("13", leftTap.displayAt(1))
		assertEquals("13", leftTap.displayAt(2))

		val rightTap = Pin.rightTap()
		assertEquals("13", rightTap.displayAt(1))
		assertEquals("13", rightTap.displayAt(2))

		val fullDeck = Pin.fullDeck()
		assertEquals("15", fullDeck.displayAt(2))
	}

	@Test
	fun `test displayAt returns value for none`() {
		val pins = emptySet<Pin>()
		assertEquals("-", pins.displayAt(0))
		assertEquals("-", pins.displayAt(1))
		assertEquals("-", pins.displayAt(2))
	}
}