% all implicit references from the model 'Source' to target elements 'Target'
implicit(SourceModel,TargetElement,Reference,SourceElementUri,TargetElementUri) :- 
	elementtoresourcemapping(SourceElement,SourceModel), 
	implicit(SourceElement,TargetElement,Reference,SourceElementUri,TargetElementUri).

% all implicit references from the target model element 'Source' to target elements 'Target'
implicit(SourceElement,TargetElement,Reference,SourceElementUri,TargetElementUri) :- 
	explicit(TargetElement,Reference,SourceElement), 
	uri(TargetElement,TargetElementUri), 
	uri(SourceElement,SourceElementUri), 
	uri(Reference,_),!.