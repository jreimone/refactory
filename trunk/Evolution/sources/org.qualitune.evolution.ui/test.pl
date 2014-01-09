implicitModelDependency(SourceModel,TargetModel,SourceUri,TargetUri) :-
        elementtoresourcemapping(TargetElement,TargetModel),
        implicit(SourceModel,TargetElement,_,_,_),
        uri(SourceModel,SourceUri),
        uri(TargetModel,TargetUri).

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


explicit(platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping____mappings_0, http___www_emftext_org_language_rolemapping___rolemapping_mappedrolemodel, platform__resource_org_emftext_refactoring_renamex_rolemodel_renamex_rolestext__).
uri(platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping____mappings_0, 'platform:/resource/org.emftext.language.pl0.refactoring/rolemappings/renamings.rolemapping#//@mappings.0').
uri(http___www_emftext_org_language_rolemapping___rolemapping_mappedrolemodel, 'http://www.emftext.org/language/rolemapping#//RoleMapping/mappedRoleModel').
uri(platform__resource_org_emftext_refactoring_renamex_rolemodel_renamex_rolestext__, 'platform:/resource/org.emftext.refactoring.renameX/rolemodel/RenameX.rolestext#/').
elementtoresourcemapping(platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping____mappings_0, platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping).
elementtoresourcemapping(platform__resource_org_emftext_refactoring_renamex_rolemodel_renamex_rolestext__, platform__resource_org_emftext_refactoring_renamex_rolemodel_renamex_rolestext).
uri(platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping, 'platform:/resource/org.emftext.language.pl0.refactoring/rolemappings/renamings.rolemapping').
uri(platform__resource_org_emftext_refactoring_renamex_rolemodel_renamex_rolestext, 'platform:/resource/org.emftext.refactoring.renameX/rolemodel/RenameX.rolestext').


explicit(platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping____mappings_0__roletometaelement_0, http___www_emftext_org_language_rolemapping___concretemapping_role, platform__resource_org_emftext_refactoring_renamex_rolemodel_renamex_rolestext____roles_name__nameable__).
uri(platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping____mappings_0__roletometaelement_0, 'platform:/resource/org.emftext.language.pl0.refactoring/rolemappings/renamings.rolemapping#//@mappings.0/@roleToMetaelement.0').
uri(http___www_emftext_org_language_rolemapping___concretemapping_role, 'http://www.emftext.org/language/rolemapping#//ConcreteMapping/role').
uri(platform__resource_org_emftext_refactoring_renamex_rolemodel_renamex_rolestext____roles_name__nameable__, 'platform:/resource/org.emftext.refactoring.renameX/rolemodel/RenameX.rolestext#//@roles[name=같캮ameable같�]').
elementtoresourcemapping(platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping____mappings_0__roletometaelement_0, platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping).
elementtoresourcemapping(platform__resource_org_emftext_refactoring_renamex_rolemodel_renamex_rolestext____roles_name__nameable__, platform__resource_org_emftext_refactoring_renamex_rolemodel_renamex_rolestext).
uri(platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping, 'platform:/resource/org.emftext.language.pl0.refactoring/rolemappings/renamings.rolemapping').
uri(platform__resource_org_emftext_refactoring_renamex_rolemodel_renamex_rolestext, 'platform:/resource/org.emftext.refactoring.renameX/rolemodel/RenameX.rolestext').


explicit(platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping____mappings_0__roletometaelement_0, http___www_emftext_org_language_rolemapping___concretemapping_metaclass, http___www_emftext_org_language_pl0___proceduredeclaration).
uri(platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping____mappings_0__roletometaelement_0, 'platform:/resource/org.emftext.language.pl0.refactoring/rolemappings/renamings.rolemapping#//@mappings.0/@roleToMetaelement.0').
uri(http___www_emftext_org_language_rolemapping___concretemapping_metaclass, 'http://www.emftext.org/language/rolemapping#//ConcreteMapping/metaclass').
uri(http___www_emftext_org_language_pl0___proceduredeclaration, 'http://www.emftext.org/language/pl0#//ProcedureDeclaration').
elementtoresourcemapping(platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping____mappings_0__roletometaelement_0, platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping).
elementtoresourcemapping(http___www_emftext_org_language_pl0___proceduredeclaration, http___www_emftext_org_language_pl0).
uri(platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping, 'platform:/resource/org.emftext.language.pl0.refactoring/rolemappings/renamings.rolemapping').
uri(http___www_emftext_org_language_pl0, 'http://www.emftext.org/language/pl0').


explicit(platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping____mappings_0__roletometaelement_0__attributemappings_0, http___www_emftext_org_language_rolemapping___attributemapping_roleattribute, platform__resource_org_emftext_refactoring_renamex_rolemodel_renamex_rolestext____roles_name__nameable____attributes_0).
uri(platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping____mappings_0__roletometaelement_0__attributemappings_0, 'platform:/resource/org.emftext.language.pl0.refactoring/rolemappings/renamings.rolemapping#//@mappings.0/@roleToMetaelement.0/@attributeMappings.0').
uri(http___www_emftext_org_language_rolemapping___attributemapping_roleattribute, 'http://www.emftext.org/language/rolemapping#//AttributeMapping/roleAttribute').
uri(platform__resource_org_emftext_refactoring_renamex_rolemodel_renamex_rolestext____roles_name__nameable____attributes_0, 'platform:/resource/org.emftext.refactoring.renameX/rolemodel/RenameX.rolestext#//@roles[name=같캮ameable같�]/@attributes.0').
elementtoresourcemapping(platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping____mappings_0__roletometaelement_0__attributemappings_0, platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping).
elementtoresourcemapping(platform__resource_org_emftext_refactoring_renamex_rolemodel_renamex_rolestext____roles_name__nameable____attributes_0, platform__resource_org_emftext_refactoring_renamex_rolemodel_renamex_rolestext).
uri(platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping, 'platform:/resource/org.emftext.language.pl0.refactoring/rolemappings/renamings.rolemapping').
uri(platform__resource_org_emftext_refactoring_renamex_rolemodel_renamex_rolestext, 'platform:/resource/org.emftext.refactoring.renameX/rolemodel/RenameX.rolestext').


explicit(platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping____mappings_0__roletometaelement_0__attributemappings_0, http___www_emftext_org_language_rolemapping___attributemapping_classattribute, http___www_emftext_org_language_pl0___proceduredeclaration_name).
uri(platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping____mappings_0__roletometaelement_0__attributemappings_0, 'platform:/resource/org.emftext.language.pl0.refactoring/rolemappings/renamings.rolemapping#//@mappings.0/@roleToMetaelement.0/@attributeMappings.0').
uri(http___www_emftext_org_language_rolemapping___attributemapping_classattribute, 'http://www.emftext.org/language/rolemapping#//AttributeMapping/classAttribute').
uri(http___www_emftext_org_language_pl0___proceduredeclaration_name, 'http://www.emftext.org/language/pl0#//ProcedureDeclaration/name').
elementtoresourcemapping(platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping____mappings_0__roletometaelement_0__attributemappings_0, platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping).
elementtoresourcemapping(http___www_emftext_org_language_pl0___proceduredeclaration_name, http___www_emftext_org_language_pl0).
uri(platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping, 'platform:/resource/org.emftext.language.pl0.refactoring/rolemappings/renamings.rolemapping').
uri(http___www_emftext_org_language_pl0, 'http://www.emftext.org/language/pl0').


explicit(platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping____mappings_1, http___www_emftext_org_language_rolemapping___rolemapping_mappedrolemodel, platform__plugin_org_emftext_refactoring_renamex_rolemodel_renamex_rolestext__).
uri(platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping____mappings_1, 'platform:/resource/org.emftext.language.pl0.refactoring/rolemappings/renamings.rolemapping#//@mappings.1').
uri(http___www_emftext_org_language_rolemapping___rolemapping_mappedrolemodel, 'http://www.emftext.org/language/rolemapping#//RoleMapping/mappedRoleModel').
uri(platform__plugin_org_emftext_refactoring_renamex_rolemodel_renamex_rolestext__, 'platform:/plugin/org.emftext.refactoring.renameX/rolemodel/RenameX.rolestext#/').
elementtoresourcemapping(platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping____mappings_1, platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping).
elementtoresourcemapping(platform__plugin_org_emftext_refactoring_renamex_rolemodel_renamex_rolestext__, platform__plugin_org_emftext_refactoring_renamex_rolemodel_renamex_rolestext).
uri(platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping, 'platform:/resource/org.emftext.language.pl0.refactoring/rolemappings/renamings.rolemapping').
uri(platform__plugin_org_emftext_refactoring_renamex_rolemodel_renamex_rolestext, 'platform:/plugin/org.emftext.refactoring.renameX/rolemodel/RenameX.rolestext').


explicit(platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping____mappings_1__roletometaelement_0, http___www_emftext_org_language_rolemapping___concretemapping_role, platform__plugin_org_emftext_refactoring_renamex_rolemodel_renamex_rolestext____roles_name__nameable__).
uri(platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping____mappings_1__roletometaelement_0, 'platform:/resource/org.emftext.language.pl0.refactoring/rolemappings/renamings.rolemapping#//@mappings.1/@roleToMetaelement.0').
uri(http___www_emftext_org_language_rolemapping___concretemapping_role, 'http://www.emftext.org/language/rolemapping#//ConcreteMapping/role').
uri(platform__plugin_org_emftext_refactoring_renamex_rolemodel_renamex_rolestext____roles_name__nameable__, 'platform:/plugin/org.emftext.refactoring.renameX/rolemodel/RenameX.rolestext#//@roles[name=같캮ameable같�]').
elementtoresourcemapping(platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping____mappings_1__roletometaelement_0, platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping).
elementtoresourcemapping(platform__plugin_org_emftext_refactoring_renamex_rolemodel_renamex_rolestext____roles_name__nameable__, platform__plugin_org_emftext_refactoring_renamex_rolemodel_renamex_rolestext).
uri(platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping, 'platform:/resource/org.emftext.language.pl0.refactoring/rolemappings/renamings.rolemapping').
uri(platform__plugin_org_emftext_refactoring_renamex_rolemodel_renamex_rolestext, 'platform:/plugin/org.emftext.refactoring.renameX/rolemodel/RenameX.rolestext').


explicit(platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping____mappings_1__roletometaelement_0, http___www_emftext_org_language_rolemapping___concretemapping_metaclass, http___www_emftext_org_language_pl0___declaration).
uri(platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping____mappings_1__roletometaelement_0, 'platform:/resource/org.emftext.language.pl0.refactoring/rolemappings/renamings.rolemapping#//@mappings.1/@roleToMetaelement.0').
uri(http___www_emftext_org_language_rolemapping___concretemapping_metaclass, 'http://www.emftext.org/language/rolemapping#//ConcreteMapping/metaclass').
uri(http___www_emftext_org_language_pl0___declaration, 'http://www.emftext.org/language/pl0#//Declaration').
elementtoresourcemapping(platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping____mappings_1__roletometaelement_0, platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping).
elementtoresourcemapping(http___www_emftext_org_language_pl0___declaration, http___www_emftext_org_language_pl0).
uri(platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping, 'platform:/resource/org.emftext.language.pl0.refactoring/rolemappings/renamings.rolemapping').
uri(http___www_emftext_org_language_pl0, 'http://www.emftext.org/language/pl0').


explicit(platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping____mappings_1__roletometaelement_0__attributemappings_0, http___www_emftext_org_language_rolemapping___attributemapping_roleattribute, platform__plugin_org_emftext_refactoring_renamex_rolemodel_renamex_rolestext____roles_name__nameable____attributes_0).
uri(platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping____mappings_1__roletometaelement_0__attributemappings_0, 'platform:/resource/org.emftext.language.pl0.refactoring/rolemappings/renamings.rolemapping#//@mappings.1/@roleToMetaelement.0/@attributeMappings.0').
uri(http___www_emftext_org_language_rolemapping___attributemapping_roleattribute, 'http://www.emftext.org/language/rolemapping#//AttributeMapping/roleAttribute').
uri(platform__plugin_org_emftext_refactoring_renamex_rolemodel_renamex_rolestext____roles_name__nameable____attributes_0, 'platform:/plugin/org.emftext.refactoring.renameX/rolemodel/RenameX.rolestext#//@roles[name=같캮ameable같�]/@attributes.0').
elementtoresourcemapping(platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping____mappings_1__roletometaelement_0__attributemappings_0, platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping).
elementtoresourcemapping(platform__plugin_org_emftext_refactoring_renamex_rolemodel_renamex_rolestext____roles_name__nameable____attributes_0, platform__plugin_org_emftext_refactoring_renamex_rolemodel_renamex_rolestext).
uri(platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping, 'platform:/resource/org.emftext.language.pl0.refactoring/rolemappings/renamings.rolemapping').
uri(platform__plugin_org_emftext_refactoring_renamex_rolemodel_renamex_rolestext, 'platform:/plugin/org.emftext.refactoring.renameX/rolemodel/RenameX.rolestext').


explicit(platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping____mappings_1__roletometaelement_0__attributemappings_0, http___www_emftext_org_language_rolemapping___attributemapping_classattribute, http___www_emftext_org_language_pl0___declaration_name).
uri(platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping____mappings_1__roletometaelement_0__attributemappings_0, 'platform:/resource/org.emftext.language.pl0.refactoring/rolemappings/renamings.rolemapping#//@mappings.1/@roleToMetaelement.0/@attributeMappings.0').
uri(http___www_emftext_org_language_rolemapping___attributemapping_classattribute, 'http://www.emftext.org/language/rolemapping#//AttributeMapping/classAttribute').
uri(http___www_emftext_org_language_pl0___declaration_name, 'http://www.emftext.org/language/pl0#//Declaration/name').
elementtoresourcemapping(platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping____mappings_1__roletometaelement_0__attributemappings_0, platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping).
elementtoresourcemapping(http___www_emftext_org_language_pl0___declaration_name, http___www_emftext_org_language_pl0).
uri(platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping, 'platform:/resource/org.emftext.language.pl0.refactoring/rolemappings/renamings.rolemapping').
uri(http___www_emftext_org_language_pl0, 'http://www.emftext.org/language/pl0').


explicit(platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping____mappings_2, http___www_emftext_org_language_rolemapping___rolemapping_mappedrolemodel, platform__plugin_org_emftext_refactoring_renamex_rolemodel_renamex_rolestext__).
uri(platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping____mappings_2, 'platform:/resource/org.emftext.language.pl0.refactoring/rolemappings/renamings.rolemapping#//@mappings.2').
uri(http___www_emftext_org_language_rolemapping___rolemapping_mappedrolemodel, 'http://www.emftext.org/language/rolemapping#//RoleMapping/mappedRoleModel').
uri(platform__plugin_org_emftext_refactoring_renamex_rolemodel_renamex_rolestext__, 'platform:/plugin/org.emftext.refactoring.renameX/rolemodel/RenameX.rolestext#/').
elementtoresourcemapping(platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping____mappings_2, platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping).
elementtoresourcemapping(platform__plugin_org_emftext_refactoring_renamex_rolemodel_renamex_rolestext__, platform__plugin_org_emftext_refactoring_renamex_rolemodel_renamex_rolestext).
uri(platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping, 'platform:/resource/org.emftext.language.pl0.refactoring/rolemappings/renamings.rolemapping').
uri(platform__plugin_org_emftext_refactoring_renamex_rolemodel_renamex_rolestext, 'platform:/plugin/org.emftext.refactoring.renameX/rolemodel/RenameX.rolestext').


explicit(platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping____mappings_2__roletometaelement_0, http___www_emftext_org_language_rolemapping___concretemapping_role, platform__plugin_org_emftext_refactoring_renamex_rolemodel_renamex_rolestext____roles_name__nameable__).
uri(platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping____mappings_2__roletometaelement_0, 'platform:/resource/org.emftext.language.pl0.refactoring/rolemappings/renamings.rolemapping#//@mappings.2/@roleToMetaelement.0').
uri(http___www_emftext_org_language_rolemapping___concretemapping_role, 'http://www.emftext.org/language/rolemapping#//ConcreteMapping/role').
uri(platform__plugin_org_emftext_refactoring_renamex_rolemodel_renamex_rolestext____roles_name__nameable__, 'platform:/plugin/org.emftext.refactoring.renameX/rolemodel/RenameX.rolestext#//@roles[name=같캮ameable같�]').
elementtoresourcemapping(platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping____mappings_2__roletometaelement_0, platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping).
elementtoresourcemapping(platform__plugin_org_emftext_refactoring_renamex_rolemodel_renamex_rolestext____roles_name__nameable__, platform__plugin_org_emftext_refactoring_renamex_rolemodel_renamex_rolestext).
uri(platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping, 'platform:/resource/org.emftext.language.pl0.refactoring/rolemappings/renamings.rolemapping').
uri(platform__plugin_org_emftext_refactoring_renamex_rolemodel_renamex_rolestext, 'platform:/plugin/org.emftext.refactoring.renameX/rolemodel/RenameX.rolestext').


explicit(platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping____mappings_2__roletometaelement_0, http___www_emftext_org_language_rolemapping___concretemapping_metaclass, http___www_emftext_org_language_pl0___program).
uri(platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping____mappings_2__roletometaelement_0, 'platform:/resource/org.emftext.language.pl0.refactoring/rolemappings/renamings.rolemapping#//@mappings.2/@roleToMetaelement.0').
uri(http___www_emftext_org_language_rolemapping___concretemapping_metaclass, 'http://www.emftext.org/language/rolemapping#//ConcreteMapping/metaclass').
uri(http___www_emftext_org_language_pl0___program, 'http://www.emftext.org/language/pl0#//Program').
elementtoresourcemapping(platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping____mappings_2__roletometaelement_0, platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping).
elementtoresourcemapping(http___www_emftext_org_language_pl0___program, http___www_emftext_org_language_pl0).
uri(platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping, 'platform:/resource/org.emftext.language.pl0.refactoring/rolemappings/renamings.rolemapping').
uri(http___www_emftext_org_language_pl0, 'http://www.emftext.org/language/pl0').


explicit(platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping____mappings_2__roletometaelement_0__attributemappings_0, http___www_emftext_org_language_rolemapping___attributemapping_roleattribute, platform__plugin_org_emftext_refactoring_renamex_rolemodel_renamex_rolestext____roles_name__nameable____attributes_0).
uri(platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping____mappings_2__roletometaelement_0__attributemappings_0, 'platform:/resource/org.emftext.language.pl0.refactoring/rolemappings/renamings.rolemapping#//@mappings.2/@roleToMetaelement.0/@attributeMappings.0').
uri(http___www_emftext_org_language_rolemapping___attributemapping_roleattribute, 'http://www.emftext.org/language/rolemapping#//AttributeMapping/roleAttribute').
uri(platform__plugin_org_emftext_refactoring_renamex_rolemodel_renamex_rolestext____roles_name__nameable____attributes_0, 'platform:/plugin/org.emftext.refactoring.renameX/rolemodel/RenameX.rolestext#//@roles[name=같캮ameable같�]/@attributes.0').
elementtoresourcemapping(platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping____mappings_2__roletometaelement_0__attributemappings_0, platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping).
elementtoresourcemapping(platform__plugin_org_emftext_refactoring_renamex_rolemodel_renamex_rolestext____roles_name__nameable____attributes_0, platform__plugin_org_emftext_refactoring_renamex_rolemodel_renamex_rolestext).
uri(platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping, 'platform:/resource/org.emftext.language.pl0.refactoring/rolemappings/renamings.rolemapping').
uri(platform__plugin_org_emftext_refactoring_renamex_rolemodel_renamex_rolestext, 'platform:/plugin/org.emftext.refactoring.renameX/rolemodel/RenameX.rolestext').


explicit(platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping____mappings_2__roletometaelement_0__attributemappings_0, http___www_emftext_org_language_rolemapping___attributemapping_classattribute, http___www_emftext_org_language_pl0___program_name).
uri(platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping____mappings_2__roletometaelement_0__attributemappings_0, 'platform:/resource/org.emftext.language.pl0.refactoring/rolemappings/renamings.rolemapping#//@mappings.2/@roleToMetaelement.0/@attributeMappings.0').
uri(http___www_emftext_org_language_rolemapping___attributemapping_classattribute, 'http://www.emftext.org/language/rolemapping#//AttributeMapping/classAttribute').
uri(http___www_emftext_org_language_pl0___program_name, 'http://www.emftext.org/language/pl0#//Program/name').
elementtoresourcemapping(platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping____mappings_2__roletometaelement_0__attributemappings_0, platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping).
elementtoresourcemapping(http___www_emftext_org_language_pl0___program_name, http___www_emftext_org_language_pl0).
uri(platform__resource_org_emftext_language_pl0_refactoring_rolemappings_renamings_rolemapping, 'platform:/resource/org.emftext.language.pl0.refactoring/rolemappings/renamings.rolemapping').
uri(http___www_emftext_org_language_pl0, 'http://www.emftext.org/language/pl0').