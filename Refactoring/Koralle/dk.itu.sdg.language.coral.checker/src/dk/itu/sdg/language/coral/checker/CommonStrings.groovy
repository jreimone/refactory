package dk.itu.sdg.language.coral.checker

class CommonStrings extends HashSet {
	
	CommonStrings() {
		super()
	}
	
	public boolean add(CommonString element) {
		
		def shorterCommonString = this.containsCommonString(element)
		if (!shorterCommonString) {
			super.add(element)
		} else {
			this.remove(shorterCommonString)
			super.add(element)
		}
	}
	
	public containsCommonString(CommonString element) {
		for (el in this) {
			if (el.commonString.startsWith(element.commonString)) {
				return el
			} else if (element.commonString.startsWith(el.commonString)) {
				return el
			}
		}
		return false
	}
	
	public String toString() {
		
		def result = ""
		for(element in this) {
			result = result + element.toString() + "\n"
		}
		return result
	}
}
