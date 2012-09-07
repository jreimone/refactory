package dk.itu.sdg.language.coral.resource.coral.util 

import dk.itu.sdg.language.coral.DSRelation
import dk.itu.sdg.language.coral.DSRelationDirected
import dk.itu.sdg.language.coral.FixedRelation
import dk.itu.sdg.language.coral.FixedRelationDirected
import dk.itu.sdg.language.coral.FreeRelation
import dk.itu.sdg.language.coral.FreeRelationDirected
import dk.itu.sdg.language.coral.Relation
import dk.itu.sdg.language.coral.StringTransformRelation
import dk.itu.sdg.language.coral.StringTransformRelationDirected
import dk.itu.sdg.language.coral.checker.VisualCoralRelation
import dk.itu.sdg.language.coral.checker.handlers.Check



class CoralInterpreter extends AbstractCoralInterpreter<VisualCoralRelation, Object> {
	
	def Check checker = new Check()
	
	public VisualCoralRelation interprete_dk_itu_sdg_language_coral_Relation(Relation relation, Object context) {
		
		checker.checkRelation(relation)
		return null;
	}
}