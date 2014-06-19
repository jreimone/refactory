% implicit dependencies by encoding them into a mapping model
implicit(SourceModel,TargetElement,_,SourceElementUri,TargetElementUri) :-
        elementtoresourcemapping(SourceElement,SourceModel),
        mappingDependency(SourceElement,TargetElement,SourceElementUri,TargetElementUri).

% used to define the implicit reference in cases where models are mapped with an explicit mapping model
mappingDependency(SourceElement,TargetElement,SourceElementUri,TargetElementUri) :-
        elementtoresourcemapping(SourceElement,SourceModel),
        elementtoresourcemapping(TargetElement,TargetModel),
        not(SourceModel = TargetModel),
        explicit(MappingElementLeft,_,SourceElement),
        explicit(MappingElementRight,_,TargetElement),
        not(MappingElementLeft = MappingElementRight),
        elementtoresourcemapping(MappingElementLeft,MappingModel),
        elementtoresourcemapping(MappingElementRight,MappingModel),
        not(MappingModel = SourceModel),
        not(MappingModel = TargetModel),
        uri(TargetElement,TargetElementUri),
        uri(SourceElement,SourceElementUri),
        uri(MappingModel,_)
        ,write('Models:'),nl
        ,uri(SourceModel,SourceModelUri)
        ,uri(TargetModel,TargetModelUri)
        ,write(SourceModel),write('   -->   '),write(SourceModelUri),nl
        ,write(TargetModel),write('   -->   '),write(TargetModelUri),nl
        ,write('MappingModel:'),nl
        ,uri(MappingModel,MappingModelUri)
        ,write(MappingModel),write('   -->   '),write(MappingModelUri),nl
        ,write('left: '),write(MappingElementLeft),nl
        ,write('right: '),write(MappingElementRight),nl
        ,nl
        ,!.