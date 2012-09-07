package dk.itu.sdg.language.coral.checker

class CommonString {
	
	def String commonString = ""
	def Pair<Integer,Integer> positionInFileA
	def Pair<Integer,Integer> positionInFileB
	
	CommonString(String c, int i, int j, int maxLen) {
		commonString = c
		positionInFileA = new Pair<Integer,Integer>((i - maxLen + 1), (i + 1))
		positionInFileB = new Pair<Integer,Integer>((j - maxLen + 1), (j + 1))
		
	}
	
	@Override
	public String toString() {
		return commonString + "<" + positionInFileA.fst + "," + positionInFileA.snd + ">" + "<" + positionInFileB.fst + "," + positionInFileB.snd + ">"
	}
	
	@Override
	public boolean equals(Object compareObject) {
		
		if (compareObject instanceof String) {
			String compareString = (String) compareObject
			
			if (commonString.startsWith(commonString)) {
				return true
			}
		}
		return false;
	}
	
	public boolean startsWith(CommonString compareString) {
		return commonString.startsWith(compareString.commonString)
	}
	
	public boolean startsWith(String compareString) {
		return commonString.startsWith(compareString)
	}
	
}
