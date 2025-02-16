package ca.josephroque.turkey.model

/**
 * Represents a pin in a game of bowling.
 */
enum class Pin(val pinCount: Int) {
	LEFT_TWO_PIN(2),
	LEFT_THREE_PIN(3),
	HEAD_PIN(5),
	RIGHT_THREE_PIN(3),
	RIGHT_TWO_PIN(2),
	;

	companion object {
		/** A set of all pins. */
		fun fullDeck(): Set<Pin> = entries.toSet()
	}
}

/** Total value of pins in the set. */
fun Set<Pin>.pinCount(): Int = sumOf(Pin::pinCount)

/** Returns true if the set represents a head pin. */
fun Set<Pin>.isHeadPin(): Boolean = size == 1 && contains(Pin.HEAD_PIN)
/** Returns true if the set represents a head pin with a bonus 2-pin. */
fun Set<Pin>.isHeadPin2(): Boolean = pinCount() == 7 && contains(Pin.HEAD_PIN)

/** Returns true if the set represents an ace. */
fun Set<Pin>.isAce(): Boolean = pinCount() == 11

/** Returns true if the set represents a left tap. */
fun Set<Pin>.isLeftTap(): Boolean = size == 4 && !contains(Pin.LEFT_TWO_PIN)
/** Returns true if the set represents a right tap. */
fun Set<Pin>.isRightTap(): Boolean = size == 4 && !contains(Pin.RIGHT_TWO_PIN)
/** Returns true if the set represents either a left tap or a right tap. */
fun Set<Pin>.isTap(): Boolean = isLeftTap() || isRightTap()

/** Returns true if the set represents a left chop. */
fun Set<Pin>.isLeftChop(): Boolean = size == 3 && contains(Pin.HEAD_PIN) && contains(Pin.LEFT_TWO_PIN) && contains(Pin.LEFT_THREE_PIN)
/** Returns true if the set represents a right chop. */
fun Set<Pin>.isRightChop(): Boolean = size == 3 && contains(Pin.HEAD_PIN) && contains(Pin.RIGHT_TWO_PIN) && contains(Pin.RIGHT_THREE_PIN)
/** Returns true if the set represents either a left chop or a right chop. */
fun Set<Pin>.isChop(): Boolean = isLeftChop() || isRightChop()

/** Returns true if the set represents a left split. */
fun Set<Pin>.isLeftSplit(): Boolean = size == 2 && contains(Pin.HEAD_PIN) && contains(Pin.LEFT_THREE_PIN)
/** Returns true if the set represents a left split with a bonus 2-pin on the opposite side. */
fun Set<Pin>.isLeftSplitWithBonus(): Boolean = size == 3 && contains(Pin.HEAD_PIN) && contains(Pin.LEFT_THREE_PIN) && contains(Pin.RIGHT_TWO_PIN)
/** Returns true if the set represents a right split. */
fun Set<Pin>.isRightSplit(): Boolean = size == 2 && contains(Pin.HEAD_PIN) && contains(Pin.RIGHT_THREE_PIN)
/** Returns true if the set represents a right split with a bonus 2-pin on the opposite side. */
fun Set<Pin>.isRightSplitWithBonus(): Boolean = size == 3 && contains(Pin.HEAD_PIN) && contains(Pin.RIGHT_THREE_PIN) && contains(Pin.LEFT_TWO_PIN)
/** Returns true if the set represents either a left split or a right split. */
fun Set<Pin>.isSplit(): Boolean = isLeftSplit() || isRightSplit()
/** Returns true if the set represents either a left split with a bonus 2-pin or a right split with a bonus 2-pin. */
fun Set<Pin>.isSplitWithBonus(): Boolean = isLeftSplitWithBonus() || isRightSplitWithBonus()

/** Returns true if the set has primarily pins on the left of the head pin. */
fun Set<Pin>.isHitLeftOfMiddle(): Boolean = !contains(Pin.HEAD_PIN) && !contains(Pin.RIGHT_THREE_PIN) && (contains(Pin.LEFT_TWO_PIN) || contains(Pin.LEFT_THREE_PIN))
/** Returns true if the set has primarily pins on the right of the head pin. */
fun Set<Pin>.isHitRightOfMiddle(): Boolean = !contains(Pin.HEAD_PIN) && !contains(Pin.LEFT_THREE_PIN) && (contains(Pin.RIGHT_TWO_PIN) || contains(Pin.RIGHT_THREE_PIN))
/** Returns true if the set includes the head pin. */
fun Set<Pin>.isMiddleHit(): Boolean = contains(Pin.HEAD_PIN)

/** Returns true if the value of the set is twelve, and does not include the right 3-pin. */
fun Set<Pin>.isLeftTwelve(): Boolean = size == 4 && !contains(Pin.RIGHT_THREE_PIN)
/** Returns true if the value of the set is twelve and does not include the left 3-pin. */
fun Set<Pin>.isRightTwelve(): Boolean = size == 4 && !contains(Pin.LEFT_THREE_PIN)
/** Returns true if the value of the set is twelve. */
fun Set<Pin>.isTwelve(): Boolean = isLeftTwelve() || isRightTwelve()

/** Returns true if the set contains the left 2-pin and the left 3-pin. */
fun Set<Pin>.isLeftFive(): Boolean = size == 2 && contains(Pin.LEFT_TWO_PIN) && contains(Pin.LEFT_THREE_PIN)
/** Returns true if the set contains the right 2-pin and the right 3-pin. */
fun Set<Pin>.isRightFive(): Boolean = size == 2 && contains(Pin.RIGHT_TWO_PIN) && contains(Pin.RIGHT_THREE_PIN)
/** Returns true if the value of the set is five, without the head pin. */
fun Set<Pin>.isFive(): Boolean = isLeftFive() || isRightFive()

/** Returns true if the set is only the left 3-pin. */
fun Set<Pin>.isLeftThree(): Boolean = size == 1 && contains(Pin.LEFT_THREE_PIN)
/** Returns true if the set is only the right 3-pin. */
fun Set<Pin>.isRightThree(): Boolean = size == 1 && contains(Pin.RIGHT_THREE_PIN)
/** Returns true if the value of the set is three. */
fun Set<Pin>.isThree(): Boolean = isLeftThree() || isRightThree()

/** Returns true if the set is all 5 pins. */
fun Set<Pin>.arePinsCleared(): Boolean = size == 5

/**
 * Returns a display value for the given set of pins.
 * Depending on the rollIndex, the value may be an appropriate symbol, such as 'X' for a strike,
 * ore the numeric value of the pins downed.
 *
 * @param rollIndex the index of the roll in the frame
 */
fun Set<Pin>.displayAt(rollIndex: Int): String {
	val outcome: RollOutcome
	when {
		isHeadPin() -> outcome = RollOutcome.HEAD_PIN
		isHeadPin2() -> outcome = RollOutcome.HEAD_PIN_2
		isSplit() -> outcome = RollOutcome.SPLIT
		isSplitWithBonus() -> outcome = RollOutcome.SPLIT_WITH_BONUS
		isChop() -> outcome = RollOutcome.CHOP_OFF
		isAce() -> outcome = RollOutcome.ACE
		isLeftTap() -> outcome = RollOutcome.LEFT
		isRightTap() -> outcome = RollOutcome.RIGHT
		arePinsCleared() -> outcome = when (rollIndex) {
			0 -> RollOutcome.STRIKE
			1 -> RollOutcome.SPARE
			else -> RollOutcome.CLEARED
		}
		else -> outcome = RollOutcome.NONE
	}

	return if (outcome == RollOutcome.NONE) {
		val pinCount = this.pinCount()
		if (pinCount == 0) outcome.display else pinCount.toString()
	} else {
		if (rollIndex == 0) outcome.display else outcome.numericDisplay
	}
}

private enum class RollOutcome(val display: String, val numericDisplay: String) {
	STRIKE("X", "X"),
	SPARE("/", "/"),
	LEFT("L", "13"),
	RIGHT("R", "13"),
	ACE("A", "11"),
	CHOP_OFF("C/O", "10"),
	SPLIT("HS", "8"),
	SPLIT_WITH_BONUS("10", "10"),
	HEAD_PIN("HP", "5"),
	HEAD_PIN_2("H2", "7"),
	CLEARED("15", "15"),
	NONE("-", "-"),
}
