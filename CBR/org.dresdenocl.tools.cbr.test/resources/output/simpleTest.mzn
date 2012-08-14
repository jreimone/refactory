% Declarations (generated from the diagram/metamodel instance)

% ID_AssociationEModelElement1
par int : ID_AssociationEModelElement1 = 0;
par set of { ID_EModelElementProperty1, ID_EModelElementProperty2, ID_EModelElementProperty3, ID_EModelElementProperty4 } : ID_AssociationEModelElement1_memberEnd = { ID_EModelElementProperty4, ID_EModelElementProperty1 }
par set of { ID_EModelElementProperty1, ID_EModelElementProperty2, ID_EModelElementProperty3, ID_EModelElementProperty4 } : ID_AssociationEModelElement1_ownedEnd = { ID_EModelElementProperty4, ID_EModelElementProperty1 }
par string : ID_AssociationEModelElement1_name = "A_<directory>_<content>";
par set of { ID_ClassEModelElementInteraction1, ID_CollaborationEModelElement1, ID_ClassEModelElement1, ID_ClassEModelElement2, ID_AssociationEModelElement1, ID_ClassEModelElement3 } : ID_AssociationEModelElement1_endType = { ID_ClassEModelElement2, ID_ClassEModelElement1 }
par set of { ID_EModelElementGeneralization1, ID_EModelElementGeneralization2 } : ID_AssociationEModelElement1_generalization = {  }
par set of { ID_EModelElementProperty1, ID_EModelElementProperty2, ID_EModelElementProperty3, ID_EModelElementProperty4 } : ID_AssociationEModelElement1_attribute = {  }
par set of { ID_EModelElementProperty1, ID_EModelElementProperty2, ID_EModelElementProperty3, ID_EModelElementProperty4 } : ID_AssociationEModelElement1_navigableOwnedEnd = {  }

% ID_CallEventEModelElement1
par int : ID_CallEventEModelElement1 = 1;
par string : ID_CallEventEModelElement1_name = "CallEvent1";
par int : ID_CallEventEModelElement1_operation = ID_EModelElementOperation1;

% ID_ClassEModelElement1
par int : ID_ClassEModelElement1 = 2;
par set of { ID_EModelElementProperty1, ID_EModelElementProperty2, ID_EModelElementProperty3, ID_EModelElementProperty4 } : ID_ClassEModelElement1_role = {  }
par set of { ID_EModelElementProperty1, ID_EModelElementProperty2, ID_EModelElementProperty3, ID_EModelElementProperty4 } : ID_ClassEModelElement1_part = {  }
par set of { ID_ClassEModelElementInteraction1, ID_ClassEModelElement1, ID_ClassEModelElement2, ID_ClassEModelElement3 } : ID_ClassEModelElement1_superClass = {  }
par set of { ID_EModelElementGeneralization1, ID_EModelElementGeneralization2 } : ID_ClassEModelElement1_generalization = {  }
par set of { ID_EModelElementProperty1, ID_EModelElementProperty2, ID_EModelElementProperty3, ID_EModelElementProperty4 } : ID_ClassEModelElement1_attribute = {  }
par set of { ID_EModelElementProperty1, ID_EModelElementProperty2, ID_EModelElementProperty3, ID_EModelElementProperty4 } : ID_ClassEModelElement1_ownedAttribute = {  }
par string : ID_ClassEModelElement1_name = "Content";
par set of { ID_EModelElementOperation1, ID_EModelElementOperation3 } : ID_ClassEModelElement1_ownedOperation = {  }

% ID_ClassEModelElement2
par int : ID_ClassEModelElement2 = 3;
par set of { ID_EModelElementProperty1, ID_EModelElementProperty2, ID_EModelElementProperty3, ID_EModelElementProperty4 } : ID_ClassEModelElement2_role = {  }
par set of { ID_EModelElementProperty1, ID_EModelElementProperty2, ID_EModelElementProperty3, ID_EModelElementProperty4 } : ID_ClassEModelElement2_part = {  }
par set of { ID_ClassEModelElementInteraction1, ID_ClassEModelElement1, ID_ClassEModelElement2, ID_ClassEModelElement3 } : ID_ClassEModelElement2_superClass = { ID_ClassEModelElement1 }
par set of { ID_EModelElementGeneralization1, ID_EModelElementGeneralization2 } : ID_ClassEModelElement2_generalization = { ID_EModelElementGeneralization2 }
par set of { ID_EModelElementProperty1, ID_EModelElementProperty2, ID_EModelElementProperty3, ID_EModelElementProperty4 } : ID_ClassEModelElement2_attribute = {  }
par set of { ID_EModelElementProperty1, ID_EModelElementProperty2, ID_EModelElementProperty3, ID_EModelElementProperty4 } : ID_ClassEModelElement2_ownedAttribute = {  }
par string : ID_ClassEModelElement2_name = "Directory";
par set of { ID_EModelElementOperation1, ID_EModelElementOperation3 } : ID_ClassEModelElement2_ownedOperation = { ID_EModelElementOperation3 }

% ID_ClassEModelElement3
par int : ID_ClassEModelElement3 = 4;
par set of { ID_EModelElementProperty1, ID_EModelElementProperty2, ID_EModelElementProperty3, ID_EModelElementProperty4 } : ID_ClassEModelElement3_role = {  }
par set of { ID_EModelElementProperty1, ID_EModelElementProperty2, ID_EModelElementProperty3, ID_EModelElementProperty4 } : ID_ClassEModelElement3_part = {  }
par set of { ID_ClassEModelElementInteraction1, ID_ClassEModelElement1, ID_ClassEModelElement2, ID_ClassEModelElement3 } : ID_ClassEModelElement3_superClass = { ID_ClassEModelElement1 }
par set of { ID_EModelElementGeneralization1, ID_EModelElementGeneralization2 } : ID_ClassEModelElement3_generalization = { ID_EModelElementGeneralization1 }
par set of { ID_EModelElementProperty1, ID_EModelElementProperty2, ID_EModelElementProperty3, ID_EModelElementProperty4 } : ID_ClassEModelElement3_attribute = {  }
par set of { ID_EModelElementProperty1, ID_EModelElementProperty2, ID_EModelElementProperty3, ID_EModelElementProperty4 } : ID_ClassEModelElement3_ownedAttribute = {  }
par string : ID_ClassEModelElement3_name = "File";
par set of { ID_EModelElementOperation1, ID_EModelElementOperation3 } : ID_ClassEModelElement3_ownedOperation = { ID_EModelElementOperation1 }

% ID_ClassEModelElementInteraction1
par int : ID_ClassEModelElementInteraction1 = 5;
par set of { ID_EModelElementProperty1, ID_EModelElementProperty2, ID_EModelElementProperty3, ID_EModelElementProperty4 } : ID_ClassEModelElementInteraction1_role = { ID_EModelElementProperty2, ID_EModelElementProperty3 }
par set of { ID_EModelElementProperty1, ID_EModelElementProperty2, ID_EModelElementProperty3, ID_EModelElementProperty4 } : ID_ClassEModelElementInteraction1_part = {  }
par set of { ID_ClassEModelElementInteraction1, ID_ClassEModelElement1, ID_ClassEModelElement2, ID_ClassEModelElement3 } : ID_ClassEModelElementInteraction1_superClass = {  }
par set of { ID_EModelElementGeneralization1, ID_EModelElementGeneralization2 } : ID_ClassEModelElementInteraction1_generalization = {  }
par set of { ID_EModelElementProperty1, ID_EModelElementProperty2, ID_EModelElementProperty3, ID_EModelElementProperty4 } : ID_ClassEModelElementInteraction1_attribute = { ID_EModelElementProperty2, ID_EModelElementProperty3 }
par set of { ID_EModelElementLifeline1, ID_EModelElementLifeline2 } : ID_ClassEModelElementInteraction1_lifeline = { ID_EModelElementLifeline1, ID_EModelElementLifeline2 }
par set of { ID_EModelElementProperty1, ID_EModelElementProperty2, ID_EModelElementProperty3, ID_EModelElementProperty4 } : ID_ClassEModelElementInteraction1_ownedAttribute = { ID_EModelElementProperty2, ID_EModelElementProperty3 }
par set of { ID_EModelElementLifeline1, ID_EModelElementLifeline2 } : ID_ClassEModelElementInteraction1_covered = {  }
par set of { ID_EModelElementOperation1, ID_EModelElementOperation3 } : ID_ClassEModelElementInteraction1_ownedOperation = {  }
par set of { ID_EModelElementMessage1 } : ID_ClassEModelElementInteraction1_message = { ID_EModelElementMessage1 }

% ID_CollaborationEModelElement1
par int : ID_CollaborationEModelElement1 = 6;
par set of { ID_EModelElementProperty1, ID_EModelElementProperty2, ID_EModelElementProperty3, ID_EModelElementProperty4 } : ID_CollaborationEModelElement1_collaborationRole = {  }
par set of { ID_EModelElementProperty1, ID_EModelElementProperty2, ID_EModelElementProperty3, ID_EModelElementProperty4 } : ID_CollaborationEModelElement1_role = {  }
par set of { ID_EModelElementProperty1, ID_EModelElementProperty2, ID_EModelElementProperty3, ID_EModelElementProperty4 } : ID_CollaborationEModelElement1_part = {  }
par set of { ID_EModelElementProperty1, ID_EModelElementProperty2, ID_EModelElementProperty3, ID_EModelElementProperty4 } : ID_CollaborationEModelElement1_ownedAttribute = {  }
par set of { ID_EModelElementGeneralization1, ID_EModelElementGeneralization2 } : ID_CollaborationEModelElement1_generalization = {  }
par set of { ID_EModelElementProperty1, ID_EModelElementProperty2, ID_EModelElementProperty3, ID_EModelElementProperty4 } : ID_CollaborationEModelElement1_attribute = {  }

% ID_EModelElementGeneralization1
par int : ID_EModelElementGeneralization1 = 7;

% ID_EModelElementGeneralization2
par int : ID_EModelElementGeneralization2 = 8;

% ID_EModelElementLifeline1
par int : ID_EModelElementLifeline1 = 9;
par string : ID_EModelElementLifeline1_name = "d";
par int : ID_EModelElementLifeline1_interaction = ID_ClassEModelElementInteraction1;
par int : ID_EModelElementLifeline1_represents = ID_EModelElementProperty2;

% ID_EModelElementLifeline2
par int : ID_EModelElementLifeline2 = 10;
par string : ID_EModelElementLifeline2_name = "f";
par int : ID_EModelElementLifeline2_interaction = ID_ClassEModelElementInteraction1;
par int : ID_EModelElementLifeline2_represents = ID_EModelElementProperty3;

% ID_EModelElementMessage1
par int : ID_EModelElementMessage1 = 11;
par string : ID_EModelElementMessage1_name = "getName";
par int : ID_EModelElementMessage1_interaction = ID_ClassEModelElementInteraction1;
par int : ID_EModelElementMessage1_sendEvent = ID_EModelElementMessageOccurrenceSpecification1;
par int : ID_EModelElementMessage1_receiveEvent = ID_EModelElementMessageOccurrenceSpecification2;

% ID_EModelElementMessageOccurrenceSpecification2
par int : ID_EModelElementMessageOccurrenceSpecification2 = 12;
par string : ID_EModelElementMessageOccurrenceSpecification2_name = "MessageOccurrenceSpecification2";
par int : ID_EModelElementMessageOccurrenceSpecification2_event = ID_CallEventEModelElement1;
par int : ID_EModelElementMessageOccurrenceSpecification2_message = ID_EModelElementMessage1;
par set of { ID_EModelElementLifeline1, ID_EModelElementLifeline2 } : ID_EModelElementMessageOccurrenceSpecification2_covered = { ID_EModelElementLifeline2 }
par int : ID_EModelElementMessageOccurrenceSpecification2_enclosingInteraction = ID_ClassEModelElementInteraction1;

% ID_EModelElementMessageOccurrenceSpecification1
par int : ID_EModelElementMessageOccurrenceSpecification1 = 13;
par string : ID_EModelElementMessageOccurrenceSpecification1_name = "MessageOccurrenceSpecification1";
par int : ID_EModelElementMessageOccurrenceSpecification1_event = ID_CallEventEModelElement1;
par int : ID_EModelElementMessageOccurrenceSpecification1_message = ID_EModelElementMessage1;
par set of { ID_EModelElementLifeline1, ID_EModelElementLifeline2 } : ID_EModelElementMessageOccurrenceSpecification1_covered = { ID_EModelElementLifeline1 }
par int : ID_EModelElementMessageOccurrenceSpecification1_enclosingInteraction = ID_ClassEModelElementInteraction1;

% ID_EModelElementOperation1
par int : ID_EModelElementOperation1 = 14;
par set of { ID_EModelElementOperation1, ID_EModelElementOperation3 } : ID_EModelElementOperation1_redefinedOperation = {  }
par string : ID_EModelElementOperation1_name = "getName";
par set of { ID_ClassEModelElementInteraction1, ID_CollaborationEModelElement1, ID_ClassEModelElement1, ID_ClassEModelElement2, ID_AssociationEModelElement1, ID_ClassEModelElement3 } : ID_EModelElementOperation1_raisedException = {  }
par int : ID_EModelElementOperation1_class = ID_ClassEModelElement3;

% ID_EModelElementOperation3
par int : ID_EModelElementOperation3 = 15;
par set of { ID_EModelElementOperation1, ID_EModelElementOperation3 } : ID_EModelElementOperation3_redefinedOperation = {  }
par string : ID_EModelElementOperation3_name = "find";
par set of { ID_ClassEModelElementInteraction1, ID_CollaborationEModelElement1, ID_ClassEModelElement1, ID_ClassEModelElement2, ID_AssociationEModelElement1, ID_ClassEModelElement3 } : ID_EModelElementOperation3_raisedException = {  }
par int : ID_EModelElementOperation3_class = ID_ClassEModelElement2;

% ID_EModelElementProperty1
par int : ID_EModelElementProperty1 = 16;
par int : ID_EModelElementProperty1_type = ID_ClassEModelElement1;
par set of { ID_EModelElementProperty1, ID_EModelElementProperty2, ID_EModelElementProperty3, ID_EModelElementProperty4 } : ID_EModelElementProperty1_redefinedProperty = {  }
par string : ID_EModelElementProperty1_name = "content";
par set of { ID_EModelElementProperty1, ID_EModelElementProperty2, ID_EModelElementProperty3, ID_EModelElementProperty4 } : ID_EModelElementProperty1_subsettedProperty = {  }
par set of { ID_EModelElementProperty1, ID_EModelElementProperty2, ID_EModelElementProperty3, ID_EModelElementProperty4 } : ID_EModelElementProperty1_qualifier = {  }

% ID_EModelElementProperty3
par int : ID_EModelElementProperty3 = 17;
par int : ID_EModelElementProperty3_type = ID_ClassEModelElement3;
par set of { ID_EModelElementProperty1, ID_EModelElementProperty2, ID_EModelElementProperty3, ID_EModelElementProperty4 } : ID_EModelElementProperty3_redefinedProperty = {  }
par int : ID_EModelElementProperty3_class = ID_ClassEModelElementInteraction1;
par string : ID_EModelElementProperty3_name = "Property2";
par set of { ID_EModelElementProperty1, ID_EModelElementProperty2, ID_EModelElementProperty3, ID_EModelElementProperty4 } : ID_EModelElementProperty3_subsettedProperty = {  }
par set of { ID_EModelElementProperty1, ID_EModelElementProperty2, ID_EModelElementProperty3, ID_EModelElementProperty4 } : ID_EModelElementProperty3_qualifier = {  }

% ID_EModelElementProperty4
par int : ID_EModelElementProperty4 = 18;
par int : ID_EModelElementProperty4_type = ID_ClassEModelElement2;
par set of { ID_EModelElementProperty1, ID_EModelElementProperty2, ID_EModelElementProperty3, ID_EModelElementProperty4 } : ID_EModelElementProperty4_redefinedProperty = {  }
par string : ID_EModelElementProperty4_name = "directory";
par set of { ID_EModelElementProperty1, ID_EModelElementProperty2, ID_EModelElementProperty3, ID_EModelElementProperty4 } : ID_EModelElementProperty4_subsettedProperty = {  }
par set of { ID_EModelElementProperty1, ID_EModelElementProperty2, ID_EModelElementProperty3, ID_EModelElementProperty4 } : ID_EModelElementProperty4_qualifier = {  }

% ID_EModelElementProperty2
par int : ID_EModelElementProperty2 = 19;
par int : ID_EModelElementProperty2_type = ID_ClassEModelElement2;
par set of { ID_EModelElementProperty1, ID_EModelElementProperty2, ID_EModelElementProperty3, ID_EModelElementProperty4 } : ID_EModelElementProperty2_redefinedProperty = {  }
par int : ID_EModelElementProperty2_class = ID_ClassEModelElementInteraction1;
par string : ID_EModelElementProperty2_name = "Property1";
par set of { ID_EModelElementProperty1, ID_EModelElementProperty2, ID_EModelElementProperty3, ID_EModelElementProperty4 } : ID_EModelElementProperty2_subsettedProperty = {  }
par set of { ID_EModelElementProperty1, ID_EModelElementProperty2, ID_EModelElementProperty3, ID_EModelElementProperty4 } : ID_EModelElementProperty2_qualifier = {  }