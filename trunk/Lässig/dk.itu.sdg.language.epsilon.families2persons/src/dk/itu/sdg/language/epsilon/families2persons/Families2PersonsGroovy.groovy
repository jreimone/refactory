package dk.itu.sdg.language.epsilon.families2persons

import java.util.ArrayList
import java.util.Collection
import java.util.HashMap
import java.util.List

import org.eclipse.xtext.xbase.lib.CollectionLiterals

import persons.Female
import persons.Male
import persons.Person
import persons.PersonsFactory
import persons.impl.PersonsFactoryImpl
import families.Family
import families.Member

class Families2PersonsGroovy {

	def private PersonsFactory factory = new PersonsFactoryImpl()
	
	public List<Person> transform(final Collection<Family> families) {
  
		List<Person> persons = new ArrayList<Person>()
		  
		families.each{f -> this.family2Persons(f)}.flatten{}
	}
	
	public List<Person> family2Persons(final Family family) {
		def persons = new ArrayList<Person>()
		def maleMembers = new ArrayList<Member>()
		maleMembers.add(family.getFather())
		maleMembers.addAll(family.getSons())
  
		def femaleMembers = new ArrayList<Member>()
		femaleMembers.add(family.getMother())
		femaleMembers.addAll(family.getDaughters())
	  
		
		persons.addAll(maleMembers.each{m -> member2Male(m)})
		persons.addAll(femaleMembers.each{m -> member2Female(m)})
		
		persons
	}
	
	def private final HashMap<ArrayList<? extends Object>,Male> maleCache = CollectionLiterals.newHashMap()
	
	public Male member2Male(final Member member) {
		def final cacheKey = CollectionLiterals.newArrayList(member)
		def final Male male
		synchronized (maleCache) {
			if (maleCache.containsKey(cacheKey)) {
				return maleCache.get(cacheKey)
			}
			male = this.factory.createMale()
			maleCache.put(cacheKey, male)
		}
	
		def Family family = ((Family) member.eContainer())
		male.setFullName(member.getFirstName() + " " + family.getLastName())
		  
		male
	}
	
	def private final HashMap<ArrayList<? extends Object>,Female> femaleCache = CollectionLiterals.newHashMap()

	public Female member2Female(final Member member) {
		final ArrayList<?> cacheKey = CollectionLiterals.newArrayList(member)
		final Female f
		synchronized (femaleCache) {
			if (femaleCache.containsKey(cacheKey)) {
				return femaleCache.get(cacheKey)
			}
			f = this.factory.createFemale()
			femaleCache.put(cacheKey, f)
		}

		def Family family = ((Family) member.eContainer())
		f.setFullName(member.getFirstName() + " " + family.getLastName())
		f
	}
}
