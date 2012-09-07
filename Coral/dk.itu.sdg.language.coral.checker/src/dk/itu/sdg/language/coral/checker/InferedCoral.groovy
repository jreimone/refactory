package dk.itu.sdg.language.coral.checker

class InferedCoral {

	def languages = [:]
	def Set fixedRelations = [] as Set
	def Set stringTransformRelations = [] as Set
	
	def void addLanguageTypes(String language, String languageType) {
		
		if(languages.getAt(language) == null) {
			def languageTypes = [] as Set
			languageTypes.add(languageType)
			languages.putAt(language, languageTypes)
		} else {
			languages.getAt(language).add(languageType)
		}
	}
}
