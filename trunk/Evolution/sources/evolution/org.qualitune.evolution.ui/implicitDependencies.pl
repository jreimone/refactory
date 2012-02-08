% all implicit references from the model 'Source' to target elements 'Target'
implicit(SourceModel,TargetElement,Reference,SourceElementUri,TargetElementUri) :- elementtoresourcemapping(SourceElement,SourceModel), implicit(SourceElement,TargetElement,Reference,SourceElementUri,TargetElementUri).
% all implicit references from the target model element 'Source' to target elements 'Target'
implicit(SourceElement,TargetElement,Reference,SourceElementUri,TargetElementUri) :- explicit(TargetElement,Reference,SourceElement), uri(TargetElement,TargetElementUri), uri(SourceElement,SourceElementUri), uri(Reference,_),!.

explicit(platform__resource_emftexttest_pl0_importp1_pl0extended____block__body__statements_0__right__obligatory__obligatory, http___www_emftext_org_language_pl0___identreference_ident, platform__resource_emftexttest_pl0_p1_pl0____block__constants_1).
uri(platform__resource_emftexttest_pl0_importp1_pl0extended____block__body__statements_0__right__obligatory__obligatory, 'platform:/resource/EMFTextTest/pl0/importP1.pl0extended#//@block/@body/@statements.0/@right/@obligatory/@obligatory') :- !.
uri(http___www_emftext_org_language_pl0___identreference_ident, 'http://www.emftext.org/language/pl0#//IdentReference/ident') :- !.
uri(platform__resource_emftexttest_pl0_p1_pl0____block__constants_1, 'platform:/resource/EMFTextTest/pl0/p1.pl0#//@block/@constants.1') :- !.
elementtoresourcemapping(platform__resource_emftexttest_pl0_importp1_pl0extended____block__body__statements_0__right__obligatory__obligatory, platform__resource_emftexttest_pl0_importp1_pl0extended).
elementtoresourcemapping(platform__resource_emftexttest_pl0_p1_pl0____block__constants_1, platform__resource_emftexttest_pl0_p1_pl0).
uri(platform__resource_emftexttest_pl0_importp1_pl0extended, 'platform:/resource/EMFTextTest/pl0/importP1.pl0extended') :- !.
uri(platform__resource_emftexttest_pl0_p1_pl0, 'platform:/resource/EMFTextTest/pl0/p1.pl0') :- !.

explicit(platform__resource_emftexttest_pl0_importp1_pl0extended____block__body__statements_0__right__obligatory__obligatory, http___www_emftext_org_language_pl0extended___externalidentreference_referenceddeclaration, platform__resource_emftexttest_pl0_p1_pl0____block__constants_1).
uri(platform__resource_emftexttest_pl0_importp1_pl0extended____block__body__statements_0__right__obligatory__obligatory, 'platform:/resource/EMFTextTest/pl0/importP1.pl0extended#//@block/@body/@statements.0/@right/@obligatory/@obligatory') :- !.
uri(http___www_emftext_org_language_pl0extended___externalidentreference_referenceddeclaration, 'http://www.emftext.org/language/pl0extended#//ExternalIdentReference/referencedDeclaration') :- !.
uri(platform__resource_emftexttest_pl0_p1_pl0____block__constants_1, 'platform:/resource/EMFTextTest/pl0/p1.pl0#//@block/@constants.1') :- !.
elementtoresourcemapping(platform__resource_emftexttest_pl0_importp1_pl0extended____block__body__statements_0__right__obligatory__obligatory, platform__resource_emftexttest_pl0_importp1_pl0extended).
elementtoresourcemapping(platform__resource_emftexttest_pl0_p1_pl0____block__constants_1, platform__resource_emftexttest_pl0_p1_pl0).
uri(platform__resource_emftexttest_pl0_importp1_pl0extended, 'platform:/resource/EMFTextTest/pl0/importP1.pl0extended') :- !.
uri(platform__resource_emftexttest_pl0_p1_pl0, 'platform:/resource/EMFTextTest/pl0/p1.pl0') :- !.

explicit(platform__resource_emftexttest_pl0_importp1_pl0extended____block__body__statements_1__right__obligatory__obligatory, http___www_emftext_org_language_pl0___identreference_ident, platform__resource_emftexttest_pl0_p1_pl0____block__constants_0).
uri(platform__resource_emftexttest_pl0_importp1_pl0extended____block__body__statements_1__right__obligatory__obligatory, 'platform:/resource/EMFTextTest/pl0/importP1.pl0extended#//@block/@body/@statements.1/@right/@obligatory/@obligatory') :- !.
uri(http___www_emftext_org_language_pl0___identreference_ident, 'http://www.emftext.org/language/pl0#//IdentReference/ident') :- !.
uri(platform__resource_emftexttest_pl0_p1_pl0____block__constants_0, 'platform:/resource/EMFTextTest/pl0/p1.pl0#//@block/@constants.0') :- !.
elementtoresourcemapping(platform__resource_emftexttest_pl0_importp1_pl0extended____block__body__statements_1__right__obligatory__obligatory, platform__resource_emftexttest_pl0_importp1_pl0extended).
elementtoresourcemapping(platform__resource_emftexttest_pl0_p1_pl0____block__constants_0, platform__resource_emftexttest_pl0_p1_pl0).
uri(platform__resource_emftexttest_pl0_importp1_pl0extended, 'platform:/resource/EMFTextTest/pl0/importP1.pl0extended') :- !.
uri(platform__resource_emftexttest_pl0_p1_pl0, 'platform:/resource/EMFTextTest/pl0/p1.pl0') :- !.

explicit(platform__resource_emftexttest_pl0_importp1_pl0extended____block__body__statements_1__right__obligatory__obligatory, http___www_emftext_org_language_pl0extended___externalidentreference_referenceddeclaration, platform__resource_emftexttest_pl0_p1_pl0____block__constants_0).
uri(platform__resource_emftexttest_pl0_importp1_pl0extended____block__body__statements_1__right__obligatory__obligatory, 'platform:/resource/EMFTextTest/pl0/importP1.pl0extended#//@block/@body/@statements.1/@right/@obligatory/@obligatory') :- !.
uri(http___www_emftext_org_language_pl0extended___externalidentreference_referenceddeclaration, 'http://www.emftext.org/language/pl0extended#//ExternalIdentReference/referencedDeclaration') :- !.
uri(platform__resource_emftexttest_pl0_p1_pl0____block__constants_0, 'platform:/resource/EMFTextTest/pl0/p1.pl0#//@block/@constants.0') :- !.
elementtoresourcemapping(platform__resource_emftexttest_pl0_importp1_pl0extended____block__body__statements_1__right__obligatory__obligatory, platform__resource_emftexttest_pl0_importp1_pl0extended).
elementtoresourcemapping(platform__resource_emftexttest_pl0_p1_pl0____block__constants_0, platform__resource_emftexttest_pl0_p1_pl0).
uri(platform__resource_emftexttest_pl0_importp1_pl0extended, 'platform:/resource/EMFTextTest/pl0/importP1.pl0extended') :- !.
uri(platform__resource_emftexttest_pl0_p1_pl0, 'platform:/resource/EMFTextTest/pl0/p1.pl0') :- !.

explicit(platform__resource_emftexttest_pl0_importp1_pl0extended____imports_0, http___www_emftext_org_language_pl0extended___import_programreference, platform__resource_emftexttest_pl0_p1_pl0__).
uri(platform__resource_emftexttest_pl0_importp1_pl0extended____imports_0, 'platform:/resource/EMFTextTest/pl0/importP1.pl0extended#//@imports.0') :- !.
uri(http___www_emftext_org_language_pl0extended___import_programreference, 'http://www.emftext.org/language/pl0extended#//Import/programReference') :- !.
uri(platform__resource_emftexttest_pl0_p1_pl0__, 'platform:/resource/EMFTextTest/pl0/p1.pl0#/') :- !.
elementtoresourcemapping(platform__resource_emftexttest_pl0_importp1_pl0extended____imports_0, platform__resource_emftexttest_pl0_importp1_pl0extended).
elementtoresourcemapping(platform__resource_emftexttest_pl0_p1_pl0__, platform__resource_emftexttest_pl0_p1_pl0).
uri(platform__resource_emftexttest_pl0_importp1_pl0extended, 'platform:/resource/EMFTextTest/pl0/importP1.pl0extended') :- !.
uri(platform__resource_emftexttest_pl0_p1_pl0, 'platform:/resource/EMFTextTest/pl0/p1.pl0') :- !.












