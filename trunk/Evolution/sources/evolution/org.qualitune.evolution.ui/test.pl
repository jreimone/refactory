explicit(platform__resource_emftexttest_pl0_importp1_2_pl0extended____block__body__statements_0__right__obligatory__obligatory,http___www_emftext_org_language_pl0___identreference_ident,emftexttest_pl0_p1_pl0____block__constants_1).
':-'(uri(platform__resource_emftexttest_pl0_importp1_2_pl0extended____block__body__statements_0__right__obligatory__obligatory,'platform:/resource/EMFTextTest/pl0/importP1_2.pl0extended#//@block/@body/@statements.0/@right/@obligatory/@obligatory'),!).
':-'(uri(http___www_emftext_org_language_pl0___identreference_ident,'http://www.emftext.org/language/pl0#//IdentReference/ident'),!).
':-'(uri(emftexttest_pl0_p1_pl0____block__constants_1,'/EMFTextTest/pl0/p1.pl0#//@block/@constants.1'),!).
explicit(platform__resource_emftexttest_pl0_importp1_2_pl0extended____block__body__statements_0__right__obligatory__obligatory,http___www_emftext_org_language_pl0extended___externalidentreference_referenceddeclaration,emftexttest_pl0_p1_pl0____block__constants_1).
':-'(uri(platform__resource_emftexttest_pl0_importp1_2_pl0extended____block__body__statements_0__right__obligatory__obligatory,'platform:/resource/EMFTextTest/pl0/importP1_2.pl0extended#//@block/@body/@statements.0/@right/@obligatory/@obligatory'),!).
':-'(uri(http___www_emftext_org_language_pl0extended___externalidentreference_referenceddeclaration,'http://www.emftext.org/language/pl0extended#//ExternalIdentReference/referencedDeclaration'),!).
':-'(uri(emftexttest_pl0_p1_pl0____block__constants_1,'/EMFTextTest/pl0/p1.pl0#//@block/@constants.1'),!).
explicit(platform__resource_emftexttest_pl0_importp1_2_pl0extended____block__body__statements_1__right__obligatory__obligatory,http___www_emftext_org_language_pl0___identreference_ident,emftexttest_pl0_p1_pl0____block__constants_0).
':-'(uri(platform__resource_emftexttest_pl0_importp1_2_pl0extended____block__body__statements_1__right__obligatory__obligatory,'platform:/resource/EMFTextTest/pl0/importP1_2.pl0extended#//@block/@body/@statements.1/@right/@obligatory/@obligatory'),!).
':-'(uri(http___www_emftext_org_language_pl0___identreference_ident,'http://www.emftext.org/language/pl0#//IdentReference/ident'),!).
':-'(uri(emftexttest_pl0_p1_pl0____block__constants_0,'/EMFTextTest/pl0/p1.pl0#//@block/@constants.0'),!).
explicit(platform__resource_emftexttest_pl0_importp1_2_pl0extended____block__body__statements_1__right__obligatory__obligatory,http___www_emftext_org_language_pl0extended___externalidentreference_referenceddeclaration,emftexttest_pl0_p1_pl0____block__constants_0).
':-'(uri(platform__resource_emftexttest_pl0_importp1_2_pl0extended____block__body__statements_1__right__obligatory__obligatory,'platform:/resource/EMFTextTest/pl0/importP1_2.pl0extended#//@block/@body/@statements.1/@right/@obligatory/@obligatory'),!).
':-'(uri(http___www_emftext_org_language_pl0extended___externalidentreference_referenceddeclaration,'http://www.emftext.org/language/pl0extended#//ExternalIdentReference/referencedDeclaration'),!).
':-'(uri(emftexttest_pl0_p1_pl0____block__constants_0,'/EMFTextTest/pl0/p1.pl0#//@block/@constants.0'),!).
explicit(platform__resource_emftexttest_pl0_importp1_2_pl0extended____imports_0,http___www_emftext_org_language_pl0extended___import_programreference,emftexttest_pl0_p1_pl0__).
':-'(uri(platform__resource_emftexttest_pl0_importp1_2_pl0extended____imports_0,'platform:/resource/EMFTextTest/pl0/importP1_2.pl0extended#//@imports.0'),!).
':-'(uri(http___www_emftext_org_language_pl0extended___import_programreference,'http://www.emftext.org/language/pl0extended#//Import/programReference'),!).
':-'(uri(emftexttest_pl0_p1_pl0__,'/EMFTextTest/pl0/p1.pl0#/'),!).

elementtoresourcemapping(platform__resource_emftexttest_pl0_importp1_2_pl0extended____imports_0,platform__resource_emftexttest_pl0_importp1_2_pl0extended) :- !.
uri(platform__resource_emftexttest_pl0_importp1_2_pl0extended,'platform:/resource/EMFTextTest/pl0/importP1_2.pl0extended') :- !.


implicit(SourceModel,TargetElement,Reference,TargetElementUri) :- elementtomodelmapping(SourceElement,SourceModel), explicit(TargetElement,Reference,SourceElement), uri(TargetElement,TargetElementUri), uri(SourceElement,_), uri(Reference,_).
implicit(SourceElement,TargetElement,Reference,TargetElementUri) :- explicit(TargetElement,Reference,SourceElement), uri(TargetElement,TargetElementUri), uri(SourceElement,_), uri(Reference,_).

m(3).
m(2).
m(1).
d(X,Y,Z) :- m(X),m(Y);m(Z).