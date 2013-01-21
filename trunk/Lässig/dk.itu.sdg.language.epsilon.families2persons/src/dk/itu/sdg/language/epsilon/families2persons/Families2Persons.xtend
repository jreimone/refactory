package dk.itu.sdg.language.epsilon.families2persons

import families.Family
import families.Member
import java.util.ArrayList
import java.util.Collection
import persons.Female
import persons.Male
import persons.Person
import persons.PersonsFactory
import persons.impl.PersonsFactoryImpl

class Families2Persons {
		
	var PersonsFactory factory = new PersonsFactoryImpl()
	
	def public Iterable<Person> transform(Collection<Family> families) {
		families.map(f|f.family2Persons()).flatten().toList()
	}
	
	def public Iterable<Person> family2Persons(Family family) {
				
		var persons = new ArrayList<Person>()
		
		var maleMembers = new ArrayList<Member>()
		maleMembers += family.father
		maleMembers += family.sons
		
		var femaleMembers = new ArrayList<Member>()
		femaleMembers += family.mother
		femaleMembers += family.daughters
		
	
		persons += maleMembers.map(m|m.member2Male())		
		persons += femaleMembers.map(f|f.member2Female())
		
		return persons
	}
	 
	
	def Male create male: factory.createMale() member2Male(Member member) {
		var Family family = member.eContainer as Family
		male.fullName = member.firstName + " " + family.lastName
	}
	
	def Female create female: factory.createFemale() member2Female(Member member) {
		var Family family = member.eContainer as Family
		female.fullName = member.firstName + " " + family.lastName
	}
}