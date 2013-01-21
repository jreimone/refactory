package dk.itu.sdg.language.epsilon.families2persons;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

import persons.Female;
import persons.Male;
import persons.Person;
import persons.PersonsFactory;
import persons.impl.PersonsFactoryImpl;

import com.google.common.collect.Iterables;

import families.Family;
import families.Member;

public class Families2PersonsJava {
	private PersonsFactory factory = new PersonsFactoryImpl();
		  
	public List<Person> transform(final Collection<Family> families) {
		
		List<Person> persons = new ArrayList<Person>();
		
		for (Family family : families) {
			persons.addAll(family2Persons(family));
		}

	    return persons;
	}
		  
	public List<Person> family2Persons(final Family family) {
		ArrayList<Person> persons = new ArrayList<Person>();
		ArrayList<Member> maleMembers = new ArrayList<Member>();
		maleMembers.add(family.getFather());
		maleMembers.addAll(family.getSons());
		
		ArrayList<Member> femaleMembers = new ArrayList<Member>();
		femaleMembers.add(family.getMother());
		femaleMembers.addAll(family.getDaughters());
		    
		for (Member male : maleMembers) {
			persons.add(this.member2Male(male));
		}

		for (Member female : femaleMembers) {
			persons.add(this.member2Female(female));
		}
		
		return persons;
	}
		  
	private final HashMap<ArrayList<? extends Object>,Male> maleCache = CollectionLiterals.newHashMap();		  
		  
	public Male member2Male(final Member member) {
		final ArrayList<?> cacheKey = CollectionLiterals.newArrayList(member);
		final Male male;
		synchronized (maleCache) {
			if (maleCache.containsKey(cacheKey)) {
				return maleCache.get(cacheKey);
			}
			male = this.factory.createMale();
			maleCache.put(cacheKey, male);
		}

		Family family = ((Family) member.eContainer());
		male.setFullName(member.getFirstName() + " " + family.getLastName());
		    
		return male;
	}
		  
	private final HashMap<ArrayList<? extends Object>,Female> femaleCache = CollectionLiterals.newHashMap();

	public Female member2Female(final Member member) {
		final ArrayList<?> cacheKey = CollectionLiterals.newArrayList(member);
		final Female f;
		synchronized (femaleCache) {
			if (femaleCache.containsKey(cacheKey)) {
				return femaleCache.get(cacheKey);
			}
			f = this.factory.createFemale();
			femaleCache.put(cacheKey, f);
		}

		Family family = ((Family) member.eContainer());
		f.setFullName(member.getFirstName() + " " + family.getLastName());
		return f;
	}
}
