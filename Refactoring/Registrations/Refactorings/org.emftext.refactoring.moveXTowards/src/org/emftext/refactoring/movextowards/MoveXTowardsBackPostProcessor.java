package org.emftext.refactoring.movextowards;

public class MoveXTowardsBackPostProcessor extends AbstractMoveXTowardsPostProcessor {
	@Override
	protected int determineNewIndex(int index, int numberOfElements) {
		if (index < numberOfElements - 1) {
			return index + 1;
		}

		return index;
	}
}
