package dk.itu.sdg.language.epsilon.oo2db

import db.DB.Column
import db.DB.DBFactory
import db.DB.Database
import db.DB.ForeignKey
import db.DB.Table
import db.DB.impl.DBFactoryImpl
import oo.OO.Attribute
import oo.OO.Class
import oo.OO.Classifier
import oo.OO.Datatype
import oo.OO.Package
import oo.OO.Reference

class OO2DB {
	
	var DBFactory factory = new DBFactoryImpl()
	var Database db

	def Database create db: factory.createDatabase() transform(Package p) {
		var classes = p.eAllContents.toIterable.filter(typeof(Class))
		this.db = db
		
		for (c : classes) {
			db.contents += c.class2Table()
		}
	}

	def Table create t: factory.createTable() class2Table(oo.OO.Class c) {
		
		t.name = c.name
		t.database = db
		
		var pk = factory.createColumn()
		pk.name = c.name.primaryKeyName()
		pk.type = "INT"
		t.columns += pk
		t.primaryKeys += pk
		
		if (c.getExtends() != null) {
			
			var fk = factory.createForeignKey()
			var childFkCol = factory.createColumn()
			var Column parentFkCol
			var Table parentTable
			
			parentTable = c.getExtends().class2Table()
			parentFkCol = parentTable.primaryKeys.get(0)
			
			childFkCol.name = parentFkCol.name
			childFkCol.type = "INT"
			childFkCol.table = t
		
			fk.database = db
			fk.parent = parentFkCol
			fk.child = childFkCol
			fk.name = c.name + "Extends" + c.getExtends().name;
		}
		
		var attributes = c.features.filter(typeof(Attribute))
		for (a : attributes) {
			t.columns += a.singleValuedAttribute2Column()
			a.multiValuedAttribute2Table()			
		}
		
		var references = c.features.filter(typeof(Reference))
		for (r : references) {
			r.reference2ForeignKey()
		}
	}
	
	def String  primaryKeyName(String name) {
		name.toFirstLower() + "Id"	
	}
	 
	// Transforms a single-valued attribute
	// to a column
	def Column create c: factory.createColumn() singleValuedAttribute2Column(oo.OO.Attribute a) {
		
		if(!a.isMany) {
			c.name = a.name
			c.table = a.owner.class2Table()
			c.type = a.type.name.toDbType()
		}
	}
	
	def String toDbType(String typeName) {
		//modification of the original transformation
		// we moved the mapping transformation from a model to this method
	
		var String dbType = switch (typeName) {
			case "String" : "NVARCHAR"
			case "Integer" : "INT"
			case "Boolean" : "BIT"
			case "Real" : "NUMBER"
			default : "NVARCHAR"
		};
		
		return dbType
	}
	
	// Transforms a multi-valued attribute
	// to a table where its values are stored
	// and a foreign key 
	def Table create t: factory.createTable() multiValuedAttribute2Table(Attribute a) {
		if(a.isMany) {
			// The table that stores the values 
			// has an "id" column and a "value" column
			t.name = a.valuesTableName()
			t.database = db
			
			var pkCol = factory.createColumn()
			pkCol.name = "id"
			pkCol.table = t
			pkCol.type = "INT"
			t.primaryKeys += pkCol
			var valueCol = factory.createColumn()
			valueCol.name = "value"
			valueCol.table = t
			valueCol.type = a.type.name.toDbType()
			t.columns += valueCol
			
			// Another column is added into the table
			// to link with the "id" column of the 
			// values table
			var fkCol = factory.createColumn()
			fkCol.name = a.name + "Id"
			var owner = a.owner.class2Table()
			fkCol.table = owner
			fkCol.type = "INT"
			owner.columns += fkCol
			
			
			// The foreign key that connects
			// the two columns is defined
			var fk = factory.createForeignKey()
			fk.parent = pkCol
			fk.child = fkCol
			fk.database = db
		}
	}
	
	def String valuesTableName(Attribute a) {
		return a.owner.name + "_" + a.name.toFirstUpper() + "Values"
	}
	
	// Transforms a reference into a foreign key
	def ForeignKey create fk : factory.createForeignKey() reference2ForeignKey(Reference r) {
	
		var fkCol = factory.createColumn()
		
		fkCol.table = r.type.classifier2Table()
		fkCol.name = r.name + "Id"
		fkCol.type = "INT"
		
		fk.database = db
		fk.parent = r.owner.class2Table().primaryKeys.get(0)
		fk.child = fkCol	
		fk.name = r.name
	}
	
	def Table create t: factory.createTable() datatype2Table(Datatype d) {
		println("CONVERTING Datatype")
	}
	
	def Table classifier2Table(Classifier c) {
		
		//Das muss besser gehen -> check dispatch!!!
		if(c instanceof Class) {
			var d = c as Class
			return d.class2Table()
		} else if(c instanceof Datatype) {
			var d = c as Datatype
			return d.datatype2Table()
		}
	}
}