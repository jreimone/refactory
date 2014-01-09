% implicit dependencies through inverse references
implicit(SourceModel,TargetElement,Reference,SourceElementUri,TargetElementUri) :-
        elementtoresourcemapping(SourceElement,SourceModel),
        inverseReference(SourceElement,TargetElement,Reference,SourceElementUri,TargetElementUri).
        
implicit(SourceElement,TargetModel,Reference,SourceElementUri,TargetElementUri) :-
        elementtoresourcemapping(TargetElement,TargetModel),
        inverseReference(SourceElement,TargetElement,Reference,SourceElementUri,TargetElementUri).

implicit(SourceElement,TargetElement,Reference,SourceElementUri,TargetElementUri) :-
        inverseReference(SourceElement,TargetElement,Reference,SourceElementUri,TargetElementUri).

% all inverse references from the target model element 'Source' to target elements 'Target'
inverseReference(SourceElement,TargetElement,Reference,SourceElementUri,TargetElementUri) :-
        explicit(TargetElement,Reference,SourceElement),
        uri(TargetElement,TargetElementUri),
        uri(SourceElement,SourceElementUri),
        uri(Reference,_).