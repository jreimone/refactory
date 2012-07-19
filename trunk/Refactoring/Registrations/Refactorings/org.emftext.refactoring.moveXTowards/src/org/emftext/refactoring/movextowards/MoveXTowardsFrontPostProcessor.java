package org.emftext.refactoring.movextowards;

public class MoveXTowardsFrontPostProcessor extends	AbstractMoveXTowardsPostProcessor {
	@Override
	protected int determineNewIndex(int index, int numberOfElements) {
		if (index > 0) {
			return index - 1;
		}

		return index;
	}
}
