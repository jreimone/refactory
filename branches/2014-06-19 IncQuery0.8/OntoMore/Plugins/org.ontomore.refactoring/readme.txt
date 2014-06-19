This Plugin (org.ontoref.refactoring) defines the rolemappings
from the OWL metamodel to the generic refactorings from Refactory.

Rename
	RenameElement (provided)
	RenameOntology

Split/Amalgamate Disjoint Classes
	--> not yet implemented
	
Convert min 1 To some
	--> problems with expressiveness of refspec
	
Duplicate Class
	--> problems with expressiveness of refspec
	a copy for a whole sub-tree is needed

Create Enumerated Class
	--> possible only for one individual so far

Convert primitive/defined class
	--> problems with expressiveness of refspec

Add Covering axiom
	--> problems with expressiveness of refspec

Create Closure Axiom
	--> not yet implemented

Move Axiom To Other Class
	--> rewritten to pull-up-refactoring because of the mandatory reference
	from source to target container.
	 Still an error, maybe because of several possible superclasses.
	 (This case must be implemented!)

Extract To New Class
	Extract to new super class
	Extract to new defined class
	--> Can't be constrained to only superclass or equivalentclass-descriptions as input
		because of Refactory-limitations (The user don't has to select exactly the element 
		to refactor, but with this, refactorings turn up also when the shouldn't).
		
Create Value Partition
	--> not yet implemented

Create Individual To Class
	--> Should be extended to support the creation of several individuals.

Move Element
	--> doesn't get in all cases the right index.

Convert DataProperty to ObjectProperty
	--> not yet implemented
		
Pull Up Data Property
	--> Provided, rewritten, still not working
	(This case must be implemented!)