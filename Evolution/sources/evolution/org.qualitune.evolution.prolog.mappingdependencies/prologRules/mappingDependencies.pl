implicit(SourceModel,TargetElement,_,SourceElementUri,TargetElementUri) :- 
	elementtoresourcemapping(SourceElement,SourceModel),
	implicit(SourceElement,TargetElement,Reference,SourceElementUri,TargetElementUri).

% used to define the implicit reference in cases where models are mapped with an explicit mapping model
implicit(SourceElement,TargetElement,_,SourceElementUri,TargetElementUri) :- 
	explicit(MappingElementLeft,_,SourceElement),
	explicit(MappingElementRight,_,TargetElement),
	elementtoresourcemapping(MappingElementLeft,MappingModel),
	elementtoresourcemapping(MappingElementRight,MappingModel),
	uri(TargetElement,TargetElementUri),
	uri(SourceElement,SourceElementUri),
	uri(MappingModel,MappingModelUri),
	!.